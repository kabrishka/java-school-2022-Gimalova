package ru.croc.task13;

import ru.croc.task13.DataBank;

import java.util.*;

public class Task13 {

    public static void main(String[] args) {
        String filmPath = "/Users/karinagimalova/IdeaProjects/CROC_task_1/src/ru/croc/task13/res/films.txt";
        String historyPath = "/Users/karinagimalova/IdeaProjects/CROC_task_1/src/ru/croc/task13/res/history.txt";

        String films = "2,4";


        RecommendFilm recommendFilm = new RecommendFilm(filmPath, historyPath);
        System.out.println(recommendFilm.recommendedFilm(films));
    }

}
