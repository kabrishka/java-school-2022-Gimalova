package ru.croc.task56;

public class Annotation {
    private String signature;
    private Figure figure;

    Annotation(){};
    Annotation(String signature, Figure figure) {
        this.signature = signature;
        this.figure = figure;
    }

    public String getSignature() {
        return this.signature;
    }
    public Figure getFigure() {
        return this.figure;
    }

    @Override
    public String toString() {
        String info = "";
        info = figure.getPointInfo() + ": " + signature;
        return info;
    }
}
