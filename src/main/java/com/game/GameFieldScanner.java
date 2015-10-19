package com.game;

import java.io.InputStream;
import java.util.Scanner;

public class GameFieldScanner {

    public static final String SYMBOL_UP = "w";
    public static final String SYMBOL_LEFT = "a";
    public static final String SYMBOL_DOWN = "s";
    public static final String SYMBOL_RIGHT = "d";
    public static final String SYMBOL_EXIT = "e";
    public static final String SYMBOL_YES = "y";

    private Scanner scanner;

    public GameFieldScanner(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    public boolean waitCheck(GameField field){
        boolean inCorrectInput = true;
        while (inCorrectInput){
            if (scanner.hasNext()){
                inCorrectInput = false;
                switch (scanner.next()){
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
                        return false;
                    default:
                        inCorrectInput = true;
                }
            }
        }
        return true;
    }

    public boolean waitPlaying() {
        switch (scanner.next()){
            case SYMBOL_YES: break;
            default:
                return false;
        }
        return true;
    }
}
