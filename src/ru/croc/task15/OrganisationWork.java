package ru.croc.task15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OrganisationWork {
    private static Department root;

    /*
     * Метод перевода текстового файла в массив отделов и получения максимального времени обработки заявки
     *
     * @param path - путь до файла
     *
     * Если отдел корневой -> добавляем в список родителя
     * Если отдел не корневой -> 1. добавляем в список родительского отдела
     *                           2. добавляем в список родителя
     * */
    public static Department parseFromFile(String path) throws IOException{
        Map<String, Department> departments = new HashMap<>();

        try (BufferedReader r = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = r.readLine()) != null){
                String[] series = line.split(",");

                Department currDep = new Department(series[0],  series[1], Integer.parseInt(series[2]));
                departments.put(currDep.getName(), currDep);
                if(currDep.getParent().equals("-")) {
                    root = currDep;
                } else {
                    departments.get(currDep.getParent()).addChildDepartment(currDep);
                }
            }
        }
        return root;
    }
}
