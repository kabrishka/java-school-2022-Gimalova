package ru.croc.task13;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RecommendFilm {
    private final DataBank bank;

    public RecommendFilm(String filmPath, String historyPath) {
        this.bank = new DataBank(filmPath, historyPath);
    }

    /*
    * выбираются все пользователи, которые посмотрели
    * минимум половину фильмов пользователя, для которого формируется рекомендация
    * Из отобранных списков исключаются все, которые пользователь уже посмотрел.
    * Для оставшегося списка фильмов подсчитывается суммарное количество просмотров
    * среди всех пользователей сервиса и фильм с максимальным числом просмотров выбирается
    * как рекомендация (если таких фильмов оказалось несколько, выбирается любой из них).
    * */
    public String recommendedFilm(String userFilms) {
        //получаем список (неуппорядоченный!) всех фильмов, которые можно предложить
        List<Integer> listSuitableFilms = getGoodFilms(userFilms,bank.getHistory());
        return bank.getFilms().get(getKeyPopularFilm(listSuitableFilms));
    }

    private Integer getKeyPopularFilm(List<Integer> listSuitableFilms) {
//        Map<Integer, Integer> frequentlySeenFilms = new HashMap<>();
//
//        listSuitableFilms
//                .forEach(film -> {
//                    if(!frequentlySeenFilms.containsKey(film)){
//                        frequentlySeenFilms.put(film, Collections.frequency(listSuitableFilms, film));
//                        System.out.println("Key: " + film + " Value: " + frequentlySeenFilms.get(film));
//                    }
//                });

        Map<Integer, Long> frequentlySeenFilms = listSuitableFilms.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        Integer keyPopularFilm = frequentlySeenFilms
                .entrySet()
                .stream()
                .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
                .get()
                .getKey();

        return keyPopularFilm;
    }

    /*
    * Получение списка подходящих фильмов
    * (! важно, что список не упорядоченный,
    * это упростит поиск максимально подходящего фильма в методе getKeyPopularFilm)
    *
    * @param userFilms строка фильмов пользователя
    * @param history история просмотров других пользователей
    * */
    private List<Integer> getGoodFilms(String userFilms, Map<Integer, List<Integer>> history) {
        Set<Integer> uniqueUserFilms = Arrays.stream(userFilms.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        //нам необходимы НЕ уникальные значения, чтобы пройтись по массиву
        //и посчитать кол-во повторений и вывести рекомендацию
        List<Integer> listSuitableFilms = new ArrayList<>();


        List<Integer> keys = new ArrayList<>(history.keySet());
        //берем по id
        for (Integer key : keys) {
            int count = 0;//просмотренно одинаковых фильмов

            List<Integer> historyFilmsList = history.get(key);

            //временная переменная
            List<Integer> recommendFilms = new ArrayList<>();

            for (Integer film : historyFilmsList) {
                if (uniqueUserFilms.contains(film)) {
                    count++;
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
}
