package ru.croc.task16;

import java.util.Comparator;

public class TimeComparator implements Comparator<LogBufferedReader> {
    @Override
    public int compare(LogBufferedReader log1, LogBufferedReader log2) {
        return Long.compare(log1.getTime(), log2.getTime());
    }
}
