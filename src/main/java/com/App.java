package com;

import com.game.Direction;
import com.game.GameField;
import com.game.GameFieldPrinter;
import com.game.StaticCellValueGenerator;

public class App {
    public static void main( String[] args ) {
        int sizeField = 4;
        GameField gameField = new GameField(new StaticCellValueGenerator(), sizeField);
        gameField.fillEntryCell();
        gameField.fillEntryCell();
        //gameField.move(Direction.DOWN);
        //GameFieldPrinter gameFieldPrinter = new GameFieldPrinter();
        //gameFieldPrinter.printToStream(System.out, gameField);
        //System.out.println(gameField);
    }
}