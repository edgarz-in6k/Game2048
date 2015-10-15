package com.game;

import java.util.Scanner;

public class ConsoleGameController {

    private int size;
    private GameField field;
    private GameFieldPrinter printer;

    public ConsoleGameController(int size) {
        this.size = size;
        field = new GameField(size);
        printer = new GameFieldPrinter(field);
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        boolean isRun = true;
        while (isRun){
            if (sc.hasNext()){
                switch (sc.next()){
                    case "w": field.up(); break;
                    case "a": field.left(); break;
                    case "s": field.down(); break;
                    case "d": field.right(); break;
                    case "e": isRun = false; break;
                }
            }
            printer.printToStream(System.out);
        }
    }
}
