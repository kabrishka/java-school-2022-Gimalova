package ru.croc.task56;

public class Rectangle extends Figure {
    private int x; // x - координата правой верхней точки
    private int y; // y - координата правой верхней точки

    // конструктор с обращением к конструктору класса Figure
    Rectangle(int x0, int y0, int x, int y) {
        super(x0,y0);
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean containsPoint(int x, int y) {
        if(super.x0 <= x && super.y0 <= y && this.x >= x && this.y >= y)
            return true;

        return false;
    }

    public String getPointInfo() {
        String info = String.format("R: (%d, %d), (%d, %d)", super.getX0(), super.getY0(),
                this.getX(), this.getY());
        return info;
    }

    public void move(int dx, int dy) {
        String movingInfo = "";
        super.move(dx,dy);
        this.x += dx;
        this.y += dy;
        movingInfo = String.format("Измененные конечные координаты:\nX = %d\nY = %d", x, y);
        System.out.println(movingInfo);
    }
}
