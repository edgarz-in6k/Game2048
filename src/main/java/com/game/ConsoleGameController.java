package com.game;

import java.util.Scanner;

public class ConsoleGameController {

    public static final String NEW_LINE = "\n";
    public static final String YOU_WIN = "YOU WIN!!!" + NEW_LINE;
    public static final String CONTINUE_PLAYING = "Continue playing? (y/n)" + NEW_LINE;
    public static final String GAME_OVER = "GAME OVER!!!" + NEW_LINE;
    public static final String SYMBOL_UP = "w";
    public static final String SYMBOL_LEFT = "a";
    public static final String SYMBOL_DOWN = "s";
    public static final String SYMBOL_RIGHT = "d";
    public static final String SYMBOL_EXIT = "e";
    public static final String SYMBOL_YES = "y";
    public static final String ERROR_INCORRECT_INPUT = "ERROR: incorrect input!" + NEW_LINE;

    private GameField field;
    private GameFieldPrinter printer;
    private GameFieldScanner scanner;

    public ConsoleGameController(GameField field) {
        this.field = field;
        printer = new GameFieldPrinter();
        scanner = new GameFieldScanner();
    }

    public void run(){
        printer.printToStream(System.out, field);
        Scanner sc = scanner.scannerWithInput(System.in);
        boolean isRun = true;
        boolean inCorrectInput;
        while (isRun){
            if (sc.hasNext()){
                inCorrectInput = true;
                while (inCorrectInput){
                    inCorrectInput = false;
                    switch (sc.next()){
                        case SYMBOL_UP:
                            if (field.move(Direction.UP))
                                field.fillEmptyCell();
                            break;
                        case SYMBOL_LEFT:
                            if (field.move(Direction.LEFT))
                                field.fillEmptyCell();
                            break;
                        case SYMBOL_DOWN:
                            if (field.move(Direction.DOWN))
                                field.fillEmptyCell();
                            break;
                        case SYMBOL_RIGHT:
                            if (field.move(Direction.RIGHT))
                                field.fillEmptyCell();
                            break;
                        case SYMBOL_EXIT:
                            isRun = false;
                            break;
                        default:
                            printer.printToStream(System.out, ERROR_INCORRECT_INPUT);
                            inCorrectInput = true;
                    }
                }
                for (int i=0; i<field.size(); i++)
                    printer.printToStream(System.out, NEW_LINE);

                printer.printToStream(System.out, field);

                if (field.hasCellWith2048()){
                    printer.printToStream(System.out, YOU_WIN);
                    printer.printToStream(System.out, CONTINUE_PLAYING);
                    switch (sc.next()){
                        case SYMBOL_YES: break;
                        default: isRun = false; break;
                    }
                }
                if (!field.hasAvailableMoves()){
                    printer.printToStream(System.out, GAME_OVER);
                    isRun = false;
                }
            }
        }
    }
}