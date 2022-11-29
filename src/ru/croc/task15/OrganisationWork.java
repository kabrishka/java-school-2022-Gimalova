package ru.croc.task15;

import java.util.List;

public class OrganisationWork {

    /*
    * Получить максимальное время затраченное на обработку заявки
    * */
    public static int getWorkTime(String path){
        // все отделы
        List<Department> departments = Converter.getDepartments(path);
        for(Department root : departments){
            if(root.parent.equals("-")){
                return root.getTimeOfAppProcess();
            }
        }
        return -1;
    }
}
