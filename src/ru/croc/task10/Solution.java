package ru.croc.task10;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Solution {
    public static String calculatePassword(int threadsNumber , String initialHash)
            throws ExecutionException, InterruptedException {

        String password = "";

        //Получаем ExecutorService утилитного класса Executors
        ExecutorService pool = Executors.newFixedThreadPool(threadsNumber);

        //создаем список с Future, которые ассоциированы с Callable
        List<Future<String>> list = new ArrayList<>();

        for (int i = 0; i < threadsNumber; i++) {
            list.add(pool.submit(new BruteForce(i,threadsNumber,initialHash)));
        }

        for (Future<String> l : list) {
            if (l.get() != null) {
                password = l.get();
                break;
            }
        }
        pool.shutdownNow();

        return password;
    }

}

