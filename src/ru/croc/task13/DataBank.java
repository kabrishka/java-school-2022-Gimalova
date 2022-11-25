package ru.croc.task13;

import java.util.*;

public class DataBank {
    private Map<Integer, String> films;
    private Map<Integer, List<Integer>> history;

    public DataBank(String filmsPath, String historyPath) {
        films = Converter.getFilms(filmsPath);
        history = Converter.getHistory(historyPath);
    }

    public Map<Integer, String> getFilms() {
        return films;
    }

    public Map<Integer, List<Integer>> getHistory() {
        return history;
    }
}
