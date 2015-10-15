package com.game;

import java.io.PrintStream;

public class GameFieldPrinter {
    private GameField field;

    public GameFieldPrinter(GameField field) {
        this.field = field;
    }

    public String outputANSI() {
        String result = "";
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result += field.getValue(i, j) + " ";
            }
            result += "\n";
        }
        return result;
    }

    public void printToStream(PrintStream printStream) {
        printStream.print(outputANSI());
    }
}
