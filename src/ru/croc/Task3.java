package ru.croc;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class Task3 {
    /*
    * Поменять местами два элемента
    *
    * @param arr - исходный массив
    * @param start - позиция элемента 1
    * @param end - позиция элемента 2
    * @return измененный массив
    * */
    public static int[] simpleSwap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
        return arr;
    }

    /*
     * Перемещение минимального и максимального элементов в начало и конец массива соответсвенно
     *
     * @param arr - исходный массив
     * @return измененный массив
     * */
    public static int[] swapMinMaxValues(int[] arr) {
        int min = 0; // позиция минимального элемента
        int max = 0; // позиция максимального элемента
        for(int i = 1; i < arr.length; ++i) {
            if(arr[i] > arr[max])
                max = i;
            if(arr[i] < arr[min])
                min  = i;
        }

        /*
         * Если максимальное и минимальное значения находятся на первой и последней позицияз соотв
         * То стоит свапнуть только 1 раз, иначе у нас получится исходный массив
         */
        if(max == 0 && min == arr.length - 1) {
            simpleSwap(arr,max,min);
            return arr;
        } else if(max == 0) {
            max = min;
            simpleSwap(arr,0,min);
            simpleSwap(arr,max, arr.length - 1);
            return arr;
        } else if(min == arr.length - 1) {
            min = max;
            simpleSwap(arr,max, arr.length - 1);
            simpleSwap(arr,0,min);
            return arr;
        } else{
            simpleSwap(arr,0,min);
            System.out.print("Min changed: \n");
            printArray(arr);
            System.out.print("\n");
            simpleSwap(arr, max,arr.length - 1);
            return arr;
        }
    }

    /*
     * Форматированный вывод массива
     *
     * @param arr - исходный массив
     * */
    public static void printArray(int[] arr) {
        /*
         * StringJoiner используется для создания последовательности символов, разделенных разделителем
         * и необязательно начинающейся с предоставленного префикса и заканчивающейся предоставленным суффиксом
         */
        StringJoiner joiner = new StringJoiner(",", "[", "]");
        for (int i : arr)
            //String.valueOf(i) перевод любого типа в String
            joiner.add(String.valueOf(i));
        String result = joiner.toString();
        System.out.print(result);
    }

    public static void main(String[] args) {
        /*
         * Чтобы получить введенное число, используется метод scanner.nextInt()
         * scanner.nextInt - возвращает введенное с клавиатуры значение
         */
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine(); // исходная строка
        scanner.close();


        /*
         * преобразование массива в поток с помощью Arrays.stream ()
         * поток - это "Последовательность элементов, поддерживающих последовательные и параллельные операции агрегирования"
         * вызываем функцию mapToInt из класса Stream
         * этот метод возвращает IntStream содержащий результат операций, переданных в параметре
         * в качетве параметра передаем ссылку на метод который конвертирует в Integer
         * вызываем метод toArray из класса Внутренний поток . Этот метод преобразует IntStream в int []
         */
        int[] arr = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();

        swapMinMaxValues(arr);
        printArray(arr);
    }
}

