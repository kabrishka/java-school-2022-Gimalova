package ru.croc.task16;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Queue;
import java.util.PriorityQueue;

public class LogFile {
    private static final Queue<LogBufferedReader> queue = new PriorityQueue<>(new TimeComparator());

    /*
    * Создание очереди c приоритетом объектов LogBufferedReader, чтобы была возможность работать с полем время
    *
    * Используется очередь с приоритетом, тк в отличие от обычной очереди,
    * элементы PriorityQueue сортируются в соответствии с предоставленным Comparator
    * */
    private static void directoryWalk(Path directory) throws IOException {
        //Обход файлов в директории (+дочерних директорий)
        for(File file : Files.walk(directory)
                .filter(Files::isRegularFile)
                .filter(file -> file.getFileName().toString().matches(".+(.log|.LOG|.trace|.TRACE)"))
                .map(Path::toFile).toList()) {
            queue.add(new LogBufferedReader(file));
        }
    }

    /*
     * Запись в файл логов в порядке возрастания поля <time>
     *
     * @param directory путь к директории
     * пока очередь содержит элементы, записываем их в лог
     * дополнительнвя проверка сортировки поля <time> не требуется,
     * тк использовался PriorityQueue с предоставленным TimeComparator
     * */
    public static void joinLogs(String directory) throws IOException {
        directoryWalk(Path.of(directory));
        while (!queue.isEmpty()) {
            LogBufferedReader logFile = queue.poll();
            System.out.println(logFile.getMessage());
            if (logFile.readLine() != null) {
                queue.add(logFile);
                continue;
            }
            logFile.getBufferedReader().close();
        }
    }
}
