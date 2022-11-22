package ru.croc.task56;

public class Circle extends Figure {
    private int r; // r - радиус окружности

    // конструктор с обращением к конструктору класса Figure
    Circle(int x0, int y0, int r) {
        super(x0,y0);
        this.r = r;
    }
    public int getR() {
        return this.r;
    }

    public boolean containsPoint(int x, int y) {
        if(((super.x0 - x) * (super.x0 - x) + (super.y0 - y) * (super.y0 - y)) <= this.r * this.r)
            return true;
        return false;
    }

    public String getPointInfo() {
        String info = String.format("R: (%d, %d), %d", super.getX0(), super.getY0(),
                this.getR());
        return info;
    }
}
