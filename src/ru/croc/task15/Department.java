package ru.croc.task15;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private final String parent;
    private final String name;
    private final int time;
    private final List<Department> childDepartments;

    public Department(String name, String parent, int time) {
        this.name = name;
        this.parent = parent;
        this.time = time;
        childDepartments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getParent() {
        return parent;
    }

    public void addChildDepartment(Department child) {
        childDepartments.add(child);
    }

    /*
    * Получаем наибольшее время, затраченное на обработку заявки
    *
    * 1. Рассматриваем текущий отдел, устанавливаем время = 0
    * 2. a) у текущего отдела нет детей -> возвращаем время текущего отдела
    *    b) У текущего отдела есть дети -> циклом проходимся по каждому ребенку
    *       ребенка можно рассмотреть как текущий отдел -> п.1
    * 3. Нам нужно максимальное время затраченое отделом -> проверяем условие
    *
    * */
    public int getTimeOfAppProcess() {
        int appTime = 0; //время затраченное на обработку
        for (Department child: this.childDepartments) {
            appTime = Math.max(appTime,child.getTimeOfAppProcess());
        }
        return this.time + appTime;
    }
}
