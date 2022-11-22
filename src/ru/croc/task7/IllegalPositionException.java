package ru.croc.task7;

/*
 * Класс исключение, который выбрасывается в случае не корректности вводимых аргументов
 * */
public class IllegalPositionException extends Exception{
    private String position;
    public String getPosition() {return position;}
    IllegalPositionException(String message) {
        super(message);
    }
    IllegalPositionException(String message, String position) {
        super(message);
        this.position = position;
    }
}
