package ru.croc.task12;

import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class Filter implements BlackListFilter {
    /*
     * Фильтрация комментариев
     *
     * Приводим комментарии и элементы черного списка к одному регистру
     * Если комментарий содержит в подстроке хотя бы один элемент из блэк листа -> удаляем коммент
     * */
    public void filterComments(List<String> comments, Set<String> blackList){
        //с помощью вызова метода next() можно получить следующий элемент.
        //с помощью метода hasNext() можно узнать, есть ли следующий элемент, и не достигнут ли конец коллекции
        ListIterator<String> iterator = comments.listIterator();
        while(iterator.hasNext()){
            String comment = iterator.next().toLowerCase();
            for(String badWords : blackList){
                if(comment.contains(badWords.toLowerCase())){
                    iterator.remove();
                }
            }
        }
    }

}
