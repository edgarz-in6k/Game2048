package com;

import com.filler.RandomCellValueFiller;
import com.game.ConsoleGameController;
import com.game.GameField;
import com.generator.RandomCellValueGenerator;

public class App {

    public static final int FIELD_SIZE = 4;

    public static void main( String[] args ) {
        GameField gameField = new GameField(new RandomCellValueFiller(new RandomCellValueGenerator()), FIELD_SIZE);
        gameField.fillEmptyCell();
        gameField.fillEmptyCell();
        ConsoleGameController controller = new ConsoleGameController(gameField);
        controller.run();
    }

    void printColors(){
        int k = 0;
        for (int i = 0; i<=108; i++){
            if (i == 3)
                i = 30;
            else if (i == 51)
                i = 90;
            System.out.print("\u001B[" + i + "m" + "\\u001B[" + i + "m" + "\u001B[0m");
            k++;
            if (k%10 == 0 && k != 0)
                System.out.println();
        }
    }
}
//s a s d w s a d s w a d s a d w