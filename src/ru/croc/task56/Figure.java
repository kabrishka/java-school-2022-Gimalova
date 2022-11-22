package ru.croc.task56;

public abstract class Figure implements Movable{
    protected int x0; // x - координата левой нижней точки
    protected int y0; // y - координата левой нижней точки

    Figure(int x0, int y0) {
        this.x0 = x0;
        this.y0 = y0;
    }

    public int getX0() {
        return this.x0;
    }

    public int getY0() {
        return this.y0;
    }

    public abstract boolean containsPoint(int x, int y);
    public abstract String getPointInfo();
    @Override
    public void move(int dx, int dy) {
        String movingInfo = "";
        x0 += dx;
        y0 += dy;
        movingInfo = String.format("Измененные начальные координаты:\nX0 = %d\nY0 = %d", x0, y0);
        System.out.println(movingInfo);
    }
}
