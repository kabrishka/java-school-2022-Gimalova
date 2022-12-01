package ru.croc.task13;

public class Task13 {

    public static void main(String[] args) {
        String filmPath = "src/ru/croc/task13/res/films.txt";
        String historyPath = "src/ru/croc/task13/res/history.txt";

        String films = "2,4";


        RecommendFilm recommendFilm = new RecommendFilm(filmPath, historyPath);
        System.out.println(recommendFilm.recommendedFilm(films));
    }

}
