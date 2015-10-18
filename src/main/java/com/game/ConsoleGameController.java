package com.game;

import com.filler.StaticCellValueFiller;

import java.util.Scanner;

public class ConsoleGameController {

    private int size;
    private GameField field;
    private GameFieldPrinter printer;

    public ConsoleGameController(int size) {
        this.size = size;
        field = new GameField(new StaticCellValueFiller(), size);
        printer = new GameFieldPrinter();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        boolean isRun = true;
        while (isRun){
            if (sc.hasNext()){
                switch (sc.next()){
                    case "w": field.move(Direction.UP); break;
                    case "a": field.move(Direction.LEFT); break;
                    case "s": field.move(Direction.DOWN); break;
                    case "d": field.move(Direction.RIGHT); break;
                    case "e": isRun = false; break;
                }
            }
            //printer.printToStream(System.out, field);
        }
    }
}
