package com.game;

import com.filler.StaticCellValueFiller;
import com.generator.StaticProgressiveCellValueGenerator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameFieldPrinterTest {
    @Test
    public void testOutput() {
        GameFieldPrinter printer = new GameFieldPrinter();
        GameField gameField = new GameField(new StaticCellValueFiller(new StaticProgressiveCellValueGenerator()), 4);
        for (int i = 0; i < 16; i++) {
            gameField.fillEmptyCell();
        }
        String output = printer.outputANSI(gameField);
        assertEquals(output,
                "\u001B[107mScore: 0\u001B[0m\n" +
                        "\u001B[30m     2\u001B[35m     4\u001B[95m     8\u001B[36m    16\u001B[0m\n" +
                        "\u001B[34m    32\u001B[32m    64\u001B[33m   128\u001B[92m   256\u001B[0m\n" +
                        "\u001B[93m   512\u001B[91m  1024\u001B[31m  2048\u001B[41m  4096\u001B[0m\n" +
                        "\u001B[41m  8192\u001B[41m 16384\u001B[41m 32768\u001B[41m 65536\u001B[0m\n");
    }
}
