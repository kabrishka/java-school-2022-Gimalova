package ru.croc.task13;

import java.io.*;
import java.util.*;

public class Converter {
    /*
     * Конвертирует файл с фильмами в словарь
     *
     * @param path путь к файлу
     * @return films словарь id и названия фильма
     */
    public static HashMap<Integer, String> getFilms(String path) {
<<<<<<< HEAD

        HashMap<Integer, String> films = new HashMap<>();

        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = in.readLine()) != null) {;
=======
        HashMap<Integer, String> films = new HashMap<>();

        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            String line = in.readLine();
            while (line != null) {;
>>>>>>> origin/master
                Integer id = Integer.parseInt(line.substring(0, line.indexOf(',')));
                String name = line.substring(line.indexOf(',') + 1);
                films.put(id, name);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return films;
    }

    /*
     * Конвертирует файл с историей просомотров в словарь
     *
     * @param path путь к файлу
     * @return history - словарь, где ключ - id пользователя,  значение - список просмотренных фильмов
     */

    public static Map<Integer, List<Integer>> getHistory(String path) throws NumberFormatException {
<<<<<<< HEAD

        Map<Integer, List<Integer>> history = new HashMap<>();
        int userId = 0;
        try (BufferedReader r = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = r.readLine()) != null) {
=======
        Map<Integer, List<Integer>> history = new HashMap<>();
        int userId = 0;
        try (BufferedReader r = new BufferedReader(new FileReader(path))) {
            String line = r.readLine();
            while (line != null) {
>>>>>>> origin/master
                String[] films = line.split(",");

                //добавление фильма в список фильмоа
                ArrayList<Integer> listFilms = new ArrayList<>();
                for (String film : films) {
                    listFilms.add(Integer.parseInt(film));
                }

                if (films.length != 0) history.put(userId++, listFilms);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
<<<<<<< HEAD

=======
>>>>>>> origin/master
        return history;
    }
}
