package ru.croc.task7;

import java.util.ArrayList;

public class Task7 {

    public static void main(String[] args) {
        try{
            //Test 1
            ChessPosition position1 = new ChessPosition(1,1);
            System.out.printf(position1 + "\n");

            //Test 2
            ChessPosition position2 = ChessPosition.parse("b2");
            System.out.printf(position2.getX() + position2.getY() + "\n");

            //Test 3
//            String input1 = "\"g8\", \"e7\", \"e6\"";
//            ArrayList<ChessPosition> positions1 = convertToArrayOfChessPosition(input1);
//            ChessPosition.canMoveLikeKnight(positions1);

            //Test 4
            String input2 = "\"g8\", \"e7\", \"c8\"";
            ArrayList<ChessPosition> positions2 = convertToArrayOfChessPosition(input2);
            ChessPosition.canMoveLikeKnight(positions2);;

        } catch (IllegalPositionException e) {
            throw new RuntimeException(e);
        } catch (IllegalMoveException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    * Преобразование строки в массив позиций
    * */
    static ArrayList<ChessPosition> convertToArrayOfChessPosition(String input) throws IllegalPositionException{
        String[] inputArr = input.replaceAll("\"", "" ).split(", ");
        ArrayList<ChessPosition> positions = new ArrayList<>();
        for(String position : inputArr) {
            positions.add(ChessPosition.parse(position));
        }
        return positions;
    }
}
