package ru.croc;

import java.io.*;

public class Task8 {
    public static void main(String[] args) {
        getFileNumOfWords(args[0]);
    }

    static public void getFileNumOfWords(String path) {
        int sum = 0;
        try (BufferedReader r = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = r.readLine()) != null){
                sum += getStrNumOfWords(line);
                System.out.println(line);
            }
            System.out.println("Кол-во слов всего: " + sum);
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    /*
    * Кол-во слов в строке
    *
    * @param str - исходная строка
    * @return кол-во слов
    * */
    static public int getStrNumOfWords(String str) {
        int countWords = 0;
        int index = 0;

        boolean findSpace = false; //флаг поиска пробела

        int len = str.length();

        while(index < len) {
            if (str.charAt(index) == ' ') {  //Если нашли пробел
                if (findSpace)
                    findSpace = false;
            } else { //если нашли не пробел
                if(!findSpace)
                {
                    findSpace = true;
                    countWords++;
                }
            }
            index++;
        }
        return countWords;
    }
}
