package ru.croc.task12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task12 {


    public static void main(String[] args) {
        //тест
        List<String> commments = new ArrayList<>();
        commments.add("ЯйЦа МаКороНы ОгурцЫ ");
        commments.add("Ха! Ты питонист ");
        commments.add("Твоя мама ЛАМА! (отсылка к симс 4) ");
        Set<String> blackList = new HashSet<>();
        blackList.add("питонист");
        blackList.add("ЛАМА");
        Filter filter = new Filter();
        filter.filterComments(commments , blackList);

        System.out.println(commments);
    }
}
