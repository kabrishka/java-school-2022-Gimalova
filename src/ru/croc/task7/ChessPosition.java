package ru.croc.task7;

import java.util.ArrayList;

public class ChessPosition {
    private int x, y; // координаты точки

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // буквенное представление координаты x
    static private char[] colName = new char[]{'a','b','c','d','e','f','g','h'};

    ChessPosition(int x, int y) throws IllegalPositionException {
        if(x < 0 || x > 7 || y < 0 || y > 7) throw new IllegalPositionException("Некорректный ввод данных: ");
        this.x = x;
        this.y = y;
    }

    /*
     * Фабричный метод
     * Преобразование строки типа буква_цифра в цифра_цифра
     * */
    static ChessPosition parse(String position) throws IllegalPositionException {
        // первый элемент строки должен содержать координтау x в буквенном представлении
        char firstSymbol = position.charAt(0);

        //с 1 по конечный элемент - любое числовое представление координаты y
        int nums = Integer.parseInt(position.substring(1));

        if(nums < 1 || nums > 8) {
            throw new IllegalPositionException("Некорректный ввод данных: ", position);
        }
        int index = 0; // позиция в массиве букв, которые встречаются на шахматной доске

        for(int i = 0; i < colName.length; ++i) {
            if(firstSymbol == colName[i]) {
                index = i;
            }
        }
        return new ChessPosition(index,nums - 1);
    }

    /*
     * Проверка что конь сможет пройти послеждовательно из позиции 1 в позицию n
     *
     * @param positions - массив позиций
     *
     * checked хранит результат проверки, что конь из позиции 1 в позицию 2 может переместиться
     * */
    static void canMoveLikeKnight(ArrayList<ChessPosition> positions) throws IllegalMoveException {
        for(int i = 0; i < positions.size() - 1; ++i) {
            boolean checked;
            ChessPosition p1 = positions.get(i);
            ChessPosition p2 = positions.get(i + 1);
            checked = Math.abs(p1.getX() - p2.getX()) == 2 && Math.abs(p1.getY() - p2.getY()) == 1
                    || Math.abs(p1.getX() - p2.getX()) == 1 && Math.abs(p1.getY() - p2.getY()) == 2;
            if(checked) continue;
            else {
                String str = "Конь так не ходит " + positions.get(i - 1).toString() + " -> " +
                        positions.get(i).toString() + "\n";
                throw new IllegalMoveException(str);
            }
        }
        System.out.println("OK");
    }

    /*
     * Переопределение метода преобразования класса ChessPosition в строку
     * */
    @Override
    public String toString() {
        return colName[this.x] + String.valueOf(y + 1);
    }
}