package ru.croc.task14;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public interface BlackListFilter<T> {

    /*
    * Фильтрация коллекции типа Т
    *
    * @param comments - исходные комментарии
    * @param blackList - предикат, функциональный интерфейс
    * мы можем передавать лямбда-выражения везде, где ожидается предикат
    * */
    //default к методу интерфейса позволяет добавить ему тело
    default Collection<T> filterComments(Iterable<T> comments, Predicate<T> blackList) {
        //отфильтрованная коллекция
        Collection<T> filteredComments = new ArrayList<>();

        for(T comment : comments) {
            //Оценивает этот предикат по аргументу comment
            //true - если входной аргумент соответствует предикату, в противном случае - false
            if(!blackList.test(comment)) {
                //нам нужно добавить "правильные" комментарии, поэтому они не должны проходить оценку предиката
                filteredComments.add(comment);
            }
        }
        return filteredComments;
    }
}

