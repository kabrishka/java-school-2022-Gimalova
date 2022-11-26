package ru.croc.task14;

import java.util.*;
import java.util.function.Predicate;

public class Task14 {
    public static void main(String[] args) {
        //тест 1
        Set<Integer> testComments1 = new HashSet<>(List.of(55, 66, 77, 88));
        BlackListFilter<Integer> integerBlackListFilter = new BlackListFilter<>() {
            @Override
            public Collection<Integer> filterComments(Iterable<Integer> comments, Predicate<Integer> blackList) {
                return BlackListFilter.super.filterComments(comments, blackList);
            }
        };
        Set<Integer> resultTets1 = new HashSet<>((integerBlackListFilter
                .filterComments(testComments1 , (value -> value % 2 == 0))).stream().toList());
        System.out.println(resultTets1);

        //тест 2
        List<String> testComments2 = Arrays.asList("ЯйЦа МаКороНы ОгурцЫ ",
                "Ха! Ты питонист ",
                "Твоя мама ЛАМА! (отсылка к симс 4) ");
        BlackListFilter <String> stringBlackListFilter = new BlackListFilter<>() {
            @Override
            public Collection<String> filterComments(Iterable<String> comments, Predicate<String> blackList) {
                return BlackListFilter.super.filterComments(comments, blackList);
            }
        };
        List<String> resultTets2 = (ArrayList)stringBlackListFilter
                .filterComments(testComments2 , (str -> str.contains("ЛАМА")));
        System.out.println(resultTets2);
    }
}
