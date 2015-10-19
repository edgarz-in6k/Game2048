package com.game;

import java.io.PrintStream;

public class GameFieldPrinter {

    private static final String NEW_LINE = "\n";
    private static final String COLOR_SCORE = "\u001B[107m";

    public String outputANSI(GameField field) {
        String result = "";
        result += COLOR_SCORE + "Score: " + field.getScore() + LayoutCell.RESET_COLOR + NEW_LINE;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result += String.format("%s", LayoutCell.valueToColor(field.getValue(i, j)));
                result += String.format("%6s", field.getValue(i, j));
            }
            result += String.format("%s", LayoutCell.RESET_COLOR);
            result += NEW_LINE;
        }
        return result;
    }

    public void printToStream(PrintStream printStream, GameField field) {
        printStream.print(outputANSI(field));
    }
}