package ru.croc.task16;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Queue;
import java.util.PriorityQueue;

import static org.testng.Reporter.log;

public class LogFile {
    private static final Queue<LogBufferedReader> queue = new PriorityQueue<>(new TimeComparator());

    private static File createNewLogFile() throws IOException {
        //создание нового файла
        File resultFile = new File("src/ru/croc/task16/result/result.log");

        if (resultFile.createNewFile()){
            log("File is created!");
        }
        else{
            log("File already exists.");
        }
        return resultFile;
    }


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
                .filter(file -> file.getFileName().toString().endsWith(".log")
                        || file.getFileName().toString().endsWith(".trace"))
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
        File resultFile = createNewLogFile();
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(resultFile))) {
            while (!queue.isEmpty()) {
                LogBufferedReader logFile = queue.poll();
                System.out.println(logFile.getMessage());
                bw.write( logFile.getMessage() + "\n");
                if (logFile.readLine() != null) {
                    queue.add(logFile);
                    continue;
                }
                logFile.getBufferedReader().close();
            }
        }
    }
}
