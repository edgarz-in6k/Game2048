package com.game;

import com.filler.StaticCellValueFiller;
import com.generator.StaticProgressiveCellValueGenerator;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class GameFieldPrinterTest {

    private static final int SIZE = 4;
    private GameField gameField;

    @Before
    public void setUp() throws Exception {
        gameField = new GameField(new StaticCellValueFiller(new StaticProgressiveCellValueGenerator()), SIZE);
    }

    private void fillGameField(int n) {
        for (int i = 0; i < n; i++) {
            gameField.fillEmptyCell();
        }
    }

    @Test
    public void testPrintStreamGameField() {
        fillGameField(SIZE * SIZE);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        GameFieldPrinter printer = new GameFieldPrinter(printStream);
        printer.printToStream(gameField);
        assertEquals(baos.toString(),
                "\u001B[107mScore: 0\u001B[0m\n" +
                "\u001B[40m     2\u001B[100m     4\u001B[104m     8\u001B[44m    16\u001B[0m\n" +
                "\u001B[106m    32\u001B[46m    64\u001B[43m   128\u001B[103m   256\u001B[0m\n" +
                "\u001B[105m   512\u001B[101m  1024\u001B[41m  2048\u001B[42m  4096\u001B[0m\n" +
                "\u001B[42m  8192\u001B[42m 16384\u001B[42m 32768\u001B[42m 65536\u001B[0m\n");
    }

    @Test
    public void testPrintStreamString() {
        fillGameField(SIZE * SIZE);
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteStream);
        GameFieldPrinter printer = new GameFieldPrinter(printStream);
        printer.printToStream("Data");
        assertEquals(byteStream.toString(), "Data");
    }
}
