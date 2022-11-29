package ru.croc.task15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Converter {
    /*
    * Метод перевода текстового файла в массив отделов
    *
    * @param path - путь до файла
    *
    * Если отдел корневой -> добавляем в список родителя
    * Если отдел не корневой -> 1. добавляем в список родительского отдела
    *                           2. добавляем в список родителя
    * */
    public static List<Department> getDepartments(String path) {
        List<Department> departments = new ArrayList<>(); //список всех отделов
        try (BufferedReader r = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = r.readLine()) != null){
                String[] series = line.split(",");

                Department currDep = new Department(series[0],  series[1], Integer.parseInt(series[2]));

                if (series[1].equals("-")) {
                    departments.add(currDep);
                } else {
                    for (Department parent : departments) {
                        if (parent.getName().equals(series[1])) {
                            parent.childDepartments.add(currDep);
                            break;
                        }
                    }
                    departments.add(currDep);
                }
            }
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        return departments;
    }
}
