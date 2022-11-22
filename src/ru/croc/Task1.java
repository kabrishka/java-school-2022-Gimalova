package ru.croc;

import java.util.Scanner;

public class Task1 {
    /*
     * Статический класс Координата, содержащий значение x и y
     */
    static class  Point {
        double x;
        double y;
    }

    /*
     * Расчет площади
     *
     * @param p1 - первая координата
     * @param p2 - вторая координата
     * @param p3 - третья координата
     * @return значение площади, найденной по формуле
     */
    static double area(Point p1, Point p2, Point p3) {
        return ((p2.x - p1.x) * (p3.y - p1.y) - (p3.x - p1.x) * (p2.y - p1.y)) / 2;
    }

    public static void main(String[] args) {
        Point p1 = new Point();
        Point p2 = new Point();
        Point p3 = new Point();

        Point points[] = new Point[]{p1, p2, p3};

        //Чтобы получить введенное число, используется метод scanner.nextInt()
        //scanner.nextInt - возвращает введенное с клавиатуры значение
        Scanner scanner = new Scanner(System.in);
        try{
            for(int i = 0; i < 3; i++) {
                System.out.printf("Введите координату х вершины %d: ", i);
                points[i].x = scanner.nextDouble();
                System.out.printf("Введите координату y вершины %d: ", i);
                points[i].y = scanner.nextDouble();
            }
            scanner.close();

            //проверка на треугольник
            for(int i = 0; i < 2; i++){
                if(points[i].x == points[i+1].x && points[i].y == points[i+1].y) {
                    System.out.printf("У вас не треугольник");
                    System.exit(0);
                }
            }
            System.out.printf("Площадь треугольника: %.1f", area(p1, p2, p3));
        } catch (Exception ex){
            System.out.print(ex);
        }
    }
}