package ru.croc.task18.exceptions;

public class FieldAlreadyExists extends Exception {
    @Override
    public String toString() {
        return "Данный артикул уже существует";
    }
}
