package com;

import com.filler.RandomCellValueFiller;
import com.game.ConsoleGameController;
import com.game.GameField;
import com.generator.RandomCellValueGenerator;

public class App {
    public static void main( String[] args ) {
        int sizeField = 4;
        GameField gameField = new GameField(new RandomCellValueFiller(new RandomCellValueGenerator()), sizeField);
        gameField.fillEntryCell();
        gameField.fillEntryCell();
        //gameField.move(Direction.DOWN);
        //GameFieldPrinter gameFieldPrinter = new GameFieldPrinter();
        //gameFieldPrinter.printToStream(System.out, gameField);
        //System.out.println(gameField);
        ConsoleGameController controller = new ConsoleGameController(gameField);
        controller.run();
    }
}

/*int k = 0;
        for (int i = 0; i<=108; i++){
            if (i == 3)
                i = 30;
            else if (i == 51)
                i = 90;
            System.out.print("\u001B[" + i + "m" + "\\u001B[" + i + "m" + "\u001B[0m");
            k++;
            if (k%10 == 0 && k != 0)
                System.out.println();
        }*/