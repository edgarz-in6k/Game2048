package com.game;

import java.util.Scanner;

public class ConsoleGameController {

    private GameField field;
    private GameFieldPrinter printer;

    public ConsoleGameController(GameField field) {
        this.field = field;
        printer = new GameFieldPrinter();
    }

    public void run(){
        printer.printToStream(System.out, field);
        Scanner sc = new Scanner(System.in);
        boolean isRun = true;
        while (isRun){
            if (sc.hasNext()){
                switch (sc.next()){
                    case "w": field.move(Direction.UP); field.fillEntryCell(); break;
                    case "a": field.move(Direction.LEFT); field.fillEntryCell(); break;
                    case "s": field.move(Direction.DOWN); field.fillEntryCell(); break;
                    case "d": field.move(Direction.RIGHT); field.fillEntryCell(); break;
                    case "e": isRun = false; break;
                }
                for (int i=0; i<field.size(); i++)
                    System.out.println();
                printer.printToStream(System.out, field);
            }
        }
    }
}
