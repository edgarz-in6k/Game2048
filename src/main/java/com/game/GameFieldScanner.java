package com.game;

import java.io.InputStream;
import java.util.Scanner;

public class GameFieldScanner implements GameFieldScannerInterface{

    public static final String SYMBOL_UP = "w";
    public static final String SYMBOL_LEFT = "a";
    public static final String SYMBOL_DOWN = "s";
    public static final String SYMBOL_RIGHT = "d";
    public static final String SYMBOL_EXIT = "e";
    public static final String SYMBOL_YES = "y";
    public static final String SYMBOL_NO = "n";

    private Scanner scanner;

    public GameFieldScanner(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    @Override
    public boolean scanCommand(GameFieldInterface field) {
        boolean inCorrectInput = true;
        boolean isFillerCell = false;
        while (inCorrectInput){
            if (scanner.hasNext()){
                inCorrectInput = false;
                switch (scanner.next()){
                    case SYMBOL_UP:
                        isFillerCell = field.move(Direction.UP);
                        break;
                    case SYMBOL_LEFT:
                        isFillerCell = field.move(Direction.LEFT);
                        break;
                    case SYMBOL_DOWN:
                        isFillerCell = field.move(Direction.DOWN);
                        break;
                    case SYMBOL_RIGHT:
                        isFillerCell = field.move(Direction.RIGHT);
                        break;
                    case SYMBOL_EXIT:
                        return false;
                    default:
                        inCorrectInput = true;
                }
                if (isFillerCell)
                    field.fillEmptyCell();
            }
        }
        return true;
    }

    @Override
    public boolean continueGame() {
        while (true){
            switch (scanner.next()){
                case SYMBOL_YES: return true;
                case SYMBOL_NO: return false;
            }
        }
    }
}