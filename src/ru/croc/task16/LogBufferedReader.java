package ru.croc.task16;

import java.io.*;

public class LogBufferedReader {
    private final BufferedReader br;
    private long time;
    private String message;


    public LogBufferedReader(File path) throws IOException {
        br = new BufferedReader(new FileReader(path));
        readLine();
    }

    public long getTime() {
        return time;
    }
    public String getMessage() {
        return message;
    }


    public String readLine() throws IOException {
        message = br.readLine();
        if (message != null)
            time = Integer.parseInt(message.split(" ")[0]);
        return message;
    }

}
