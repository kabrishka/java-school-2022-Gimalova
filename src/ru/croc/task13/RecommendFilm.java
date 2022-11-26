package ru.croc.task13;

import java.util.*;
import java.util.stream.Collectors;

public class RecommendFilm {
    private final DataBank bank;

    public RecommendFilm(String filmPath, String historyPath) {
        this.bank = new DataBank(filmPath, historyPath);
    }

    //выбираются все пользователи, которые посмотрели
    //минимум половину фильмов пользователя, для которого формируется рекомендация
    //Из отобранных списков исключаются все, которые пользователь уже посмотрел.
    //Для оставшегося списка фильмов подсчитывается суммарное количество просмотров
    //среди всех пользователей сервиса и фильм с максимальным числом просмотров выбирается
    //как рекомендация (если таких фильмов оказалось несколько, выбирается любой из них).
    public String recommendedFilm(String userFilms) {
        //получаем список (неуппорядоченный!) всех фильмов, которые можно предложить
        List<Integer> listSuitableFilms = getGoodFilms(userFilms,bank.getHistory());
        return bank.getFilms().get(getKeyPopularFilm(listSuitableFilms));
    }

    private Integer getKeyPopularFilm(List<Integer> listSuitableFilms) {
        //часто встречающиеся фильмы
        Map<Integer, Integer> frequentlySeenFilms = new HashMap<>();
        for (Integer key : listSuitableFilms) {
            if (!frequentlySeenFilms.containsKey(key)) {
                frequentlySeenFilms.put(key, 1);
            } else {
                Integer value = frequentlySeenFilms.get(key);
                frequentlySeenFilms.put(key, value + 1);
            }
        }

        return frequentlySeenFilms.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();

    }

    /*
    * Получение списка подходящих фильмов
    * (! важно, что список не упорядоченный,
    * это упростит поиск максимально подходящего фильма в методе getKeyPopularFilm)
    *
    * @param userFilms строка фильмов пользователя
    * @param history история просмотров других пользователей
    * */
    private List<Integer> getGoodFilms(String userFilms, Map<Integer, List<Integer>> history){
        //преобразование строки к массиву
        List<String> list = Arrays.asList(userFilms.split(","));
        //Конвертируем List<String> к Stream<String> с использованием List.stream().
        //Конвертируем Stream<String> к Stream<Integer> с использованием Stream.map().
        //Accumulate Stream<Integer> в List<Integer> с использованием Collectors.toList().
        //преобразование list к set , чтобы исключить повторения
        Set<Integer> uniqueUserFilms = Set.copyOf(list.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList()));

        //нам необходимы НЕ уникальные значения, чтобы пройтись по массиву
        //и посчитать кол-во повторений и вывести рекомендацию
        List<Integer> listSuitableFilms = new ArrayList<>();

        List<Integer> keys = new ArrayList<>(history.keySet());
        //берем по id
        for (Integer key : keys) {
            int count = 0;
//            //для того, чтобы не учитывать один и тот же фильм, приведем list фильмов к set
            List<Integer> historyFilmsList = history.get(key);

            //временная переменная
            List<Integer> recommendFilms = new ArrayList<>();

            Iterator<Integer> it = historyFilmsList.iterator();

            while (it.hasNext()) {
                Integer film = it.next();

                if (uniqueUserFilms.contains(film)) {
                    count++;
                    historyFilmsList = deleteItem(historyFilmsList, film); //удаление всех эелементов списка == film
                    it = historyFilmsList.iterator();//необходимо обновить итератор, тк список изменился

                } else {
                    recommendFilms.add(film);
                }
            }
            if (count >= Math.round(uniqueUserFilms.size() / 2)) {
                listSuitableFilms.addAll(recommendFilms);

            }
        }
        return listSuitableFilms;
    }

    private List<Integer> deleteItem(List<Integer> mutableArray, Integer delValue) {
        List<Integer> newArray = new ArrayList<>();
        for (Integer currValue : mutableArray) {
            if (!(currValue.compareTo(delValue) == 0)) newArray.add(currValue);
        }

        return newArray;
    }
}
