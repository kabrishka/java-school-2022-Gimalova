package ru.croc.task17;

import ru.croc.task17.utils.Parser;

import java.io.IOException;
import java.sql.SQLException;

public class Task17 {
    public static void main(String[] args) throws SQLException, IOException {
        Parser.parseFromFile("src/ru/croc/task17/rez/myCSV.txt");
    }
}
