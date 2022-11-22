package ru.croc;

import java.util.Scanner;

public class Task2 {

    /*
     * Перевод в человеческий вид кол-во вводимых байт
     *
     * @param num - введенное число байт
     *
     * Создаем переменную pwr, которая покажет в какую степень необходимо возвести 1024, чтобы получить num
     * (double)num / Math.pow(1024, pwr) - число, показывающее сколько Б/КБ/МБ и тд содержит num байт
     */
    static void printHumanReadFormat(long num) {
        String str[] = new String[]{"B", "KB", "MB", "GB", "TB", "PG", "EG", "ZB", "IB"};

        int pwr = (int) (Math.log(num) / Math.log(1024));

        System.out.printf("printBytes(%d) -> \"%.1f %s\"\n", num, (double)num / Math.pow(1024, pwr), str[pwr]);
    }

    public static void main(String[] args) {
        System.out.print("Введите число байт: ");

        Scanner scanner = new Scanner(System.in);
        try{
            long num =  scanner.nextLong();
            printHumanReadFormat(num);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        scanner.close();
    }
}
