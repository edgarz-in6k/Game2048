package com.game;

import java.io.PrintStream;

public class GameFieldPrinter {

    private PrintStream printStream;
    private static final String NEW_LINE = "\n";

    public GameFieldPrinter(PrintStream printStream) {
        this.printStream = printStream;
    }

    public String outputANSI(GameField field) {
        String result = "";
        result += LayoutCell.COLOR_SCORE + "Score: " + field.getScore() + LayoutCell.RESET_COLOR + NEW_LINE;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result += String.format("%s", LayoutCell.valueToColor(field.getCell(i, j).getValue()));
                result += String.format("%6s", field.getCell(i, j).getValue());
            }
            result += String.format("%s", LayoutCell.RESET_COLOR);
            result += NEW_LINE;
        }
        return result;
    }

    public void printToStream(GameField field) {
        printStream.print(outputANSI(field));
    }

    public void printToStream(String s) {
        printStream.print(s);
    }

    public void indent() {
        for (int i=0; i<5; i++)
            printToStream(NEW_LINE);
    }
}