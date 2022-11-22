package ru.croc.task10;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class BruteForce implements Callable<String> {
    private int start;
    private int step;
    private String hashPassword;
    final int LENGTH = 7;
    final long MAX_COMBINATIONS = max();

    public BruteForce(int start, int step, String hashPassword) {
        this.start  =  start;
        this.step = step;
        this.hashPassword = hashPassword;
    }
    private long max() {
        return (long) Math.pow(26, LENGTH);
    }
    private String createPassword(Long n) {
        int[] arr = new int[LENGTH];

        for (int i = 0 ; i < LENGTH; i++){
            arr[i] = (int) (n % 26) ;
            n /= 26;
        }

        StringBuilder password = new StringBuilder();
        for (int i = 0 ; i < LENGTH; i++){
            password.append((char) ('a' + arr[i]));
        }
        return password.toString();
    }

    @Override
    public String call(){
        for (long i = start; i < MAX_COMBINATIONS; i += step){
            String password = createPassword(i);
            String hash = HashPassword.hashPassword(password);
            if(hash.equals(hashPassword))
                return password;
        }
        return null;
    }
}
