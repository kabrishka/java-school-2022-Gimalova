package ru.croc.task18.exceptions;

public class MissingFieldInDb extends Exception {
    @Override
    public String toString() {
        return "Данный артикул товара отсутсвует в БД";
    }
}
