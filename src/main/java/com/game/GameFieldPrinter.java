package com.game;

import java.io.PrintStream;

public class GameFieldPrinter {
    public String outputANSI(GameField field) {
        String result = "";
        result += field.getScore();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result += String.format("%s", LayoutCell.valueToColor(field.getValue(i, j)));
                result += String.format("%6s", field.getValue(i, j));
            }
            result += String.format("%s", LayoutCell.RESET.color);
            result += "\n";
        }
        return result;
    }

    public void printToStream(PrintStream printStream, GameField field) {
        printStream.print(outputANSI(field));
    }
}
