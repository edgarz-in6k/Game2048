package com.game;

import java.util.Scanner;

public class ConsoleGameController {

    public static final String YOU_WIN = "YOU WIN!!!";
    public static final String CONTINUE_PLAYING = "Continue playing? (y/n)";
    public static final String GAME_OVER = "GAME OVER!!!";
    public static final String SYMBOL_UP = "w";
    public static final String SYMBOL_LEFT = "a";
    public static final String SYMBOL_DOWN = "s";
    public static final String SYMBOL_RIGHT = "d";
    public static final String SYMBOL_EXIT = "e";
    public static final String SYMBOL_YES = "y";

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
                    case SYMBOL_UP:
                        if (field.move(Direction.UP))
                            field.fillEntryCell();
                        break;
                    case SYMBOL_LEFT:
                        if (field.move(Direction.LEFT))
                            field.fillEntryCell();
                        break;
                    case SYMBOL_DOWN:
                        if (field.move(Direction.DOWN))
                            field.fillEntryCell();
                        break;
                    case SYMBOL_RIGHT:
                        if (field.move(Direction.RIGHT))
                            field.fillEntryCell();
                        break;
                    case SYMBOL_EXIT:
                        isRun = false;
                        break;
                }
                for (int i=0; i<field.size(); i++)
                    System.out.println();

                printer.printToStream(System.out, field);

                if (field.hasCellWith2048()){
                    System.out.println(YOU_WIN);
                    System.out.println(CONTINUE_PLAYING);
                    switch (sc.next()){
                        case SYMBOL_YES: break;
                        default: isRun = false; break;
                    }
                }
                if (!field.hasAvailableMoves()){
                    System.out.println(GAME_OVER);
                    isRun = false;
                }
            }
        }
    }
}