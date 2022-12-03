package ru.croc.task16;

import java.io.*;

public class LogBufferedReader {
    private final BufferedReader bufferedReader;
    private long time;
    private String message;


    public LogBufferedReader(File path) throws IOException {
        this.bufferedReader = new BufferedReader(new FileReader(path));
        readLine();
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public long getTime() {
        return time;
    }
    public String getMessage() {
        return message;
    }


    public String readLine() throws IOException {
        message = this.bufferedReader.readLine();
        if (message != null)
            time = Long.parseLong(message.split(" ")[0]);
        return message;
    }

}
