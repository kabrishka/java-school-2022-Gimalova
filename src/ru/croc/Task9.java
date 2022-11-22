package ru.croc;

import java.util.Arrays;
import java.util.StringJoiner;

public class Task9 {
    public static void main(String[] args) {
        String path = "КРОК/работа/src/./../универ/../../../мемы/котики";
        System.out.println(normalizePath(path));
    }

    /*
    * Симуаляция перемещения по директориям
    *
    * @param str входная строка - относительный путь
    * @return строка "норм" заданного пути
    *
    * Создаем массив директорий
    * Если встречаем "." - мы находимся в текущей директории,
    * никуда не перемещаемся, просто удаляем этот элемент массива
    * Если встречаем ".." - перемещаемся в родительскую директорию,
    * удаляем этот элемент и предыдущий, тк мы идем по иерархии вверх
    * */
    static public String normalizePath(String str) {
        String[] arr = str.trim().split("\\/");

        for(int i = 0; i < arr.length; ++i) {
            if(arr[i].equals(".")){
                arr[i] = "";
                continue;
            }
            if(arr[i].equals("..")){ // можно было подумать, что нужно смотреть на (i-1) элемент, то он мог быть null на предыдущих этапах, поэтому используем цикл для поиска
                for(int j = i-1; j >=0 ; j--){
                    if( arr[j] != "" ){
                        if( !(arr[j].equals("..")) ) {
                            arr[j] = "";
                            arr[i] = "";
                            break;
                        }
                    }
                }
            }
        }
        return buildPath(arr);
    }
    /*
    * Преобразование массива строк к строке
    *
    * @param arr - массив строк
    * @return строка вида дир1/дир2/файл
    * */
    static public String buildPath(String[] arr) {
        StringJoiner joiner = new StringJoiner("/");
        for (String s : arr)
            if(!s.equals(""))
                //String.valueOf(i) перевод любого типа в String
                joiner.add(s);
        String result = joiner.toString();

        return result;
    }
}