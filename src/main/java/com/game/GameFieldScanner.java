package com.game;

import java.io.InputStream;
import java.util.Scanner;

public class GameFieldScanner implements GameFieldScannerInterface {

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
    public Direction scanCommand() {
        while (true){
            if (scanner.hasNext()){
                switch (scanner.next()){
                    case SYMBOL_UP:
                        return Direction.UP;
                    case SYMBOL_LEFT:
                        return Direction.LEFT;
                    case SYMBOL_DOWN:
                        return Direction.DOWN;
                    case SYMBOL_RIGHT:
                        return Direction.RIGHT;
                    case SYMBOL_EXIT:
                        return Direction.NO_DIRECTION;
                }
            }
        }
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