package ru.croc.task7;


/*
 * Класс исключение, который выбрасывается в случае если конь не может переместиться в заданную точку
 * */
public class IllegalMoveException extends Exception {
    IllegalMoveException(String message) {
        super(message);
    }
}
