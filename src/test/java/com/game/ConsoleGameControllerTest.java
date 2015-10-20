package com.game;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ConsoleGameControllerTest {

    private GameFieldInterface myGameField;
    private GameFieldPrinterInterface myPrinter;
    private GameFieldScannerInterface myScanner;

    private ByteArrayOutputStream outputStream;
    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        outputStream = new ByteArrayOutputStream();
        printStream = new PrintStream(outputStream);
        myGameField = new MyGameField();
        myPrinter = new MyGameFieldPrinter();
        myScanner = new MyGameFieldScanner();
    }

    @Test
    public void testQueueCalls() {
        ConsoleGameController controller = new ConsoleGameController(myGameField, myPrinter, myScanner);
        controller.run();
        assertEquals(outputStream.toString(),
                "printToStream(GameFieldInterface field)\n" +
                "scanCommand(GameFieldInterface field)\n" +
                "indent()\n" +
                "printToStream(GameFieldInterface field)\n" +
                "hasCellWith2048()\n" +
                "printToStream(String s)\n" +
                "continueGame()\n" +
                "hasAvailableMoves()\n" +
                "printToStream(String s)\n"
        );
    }

    class MyGameField implements GameFieldInterface {

        @Override
        public boolean move(Direction direction) {
            printStream.print("NO VISIBLE move(Direction direction)\n");//!
            return false;
        }

        @Override
        public void fillEmptyCell() {
            printStream.print("NO VISIBLE fillEmptyCell()\n");//!
        }

        @Override
        public boolean hasAvailableMoves() {
            printStream.print("hasAvailableMoves()\n");
            return false;
        }

        @Override
        public boolean hasCellWith2048() {
            printStream.print("hasCellWith2048()\n");
            return true;
        }

        @Override
        public long getScore() {
            printStream.print("NO VISIBLE long getScore()\n");//!
            return 0;
        }

        @Override
        public GameCell getCell(int row, int col) {
            printStream.print("NO VISIBLE getCell(int row, int col)\n");//!
            return null;
        }
    }

    class MyGameFieldPrinter implements GameFieldPrinterInterface {

        @Override
        public void printToStream(GameFieldInterface field) {
            printStream.print("printToStream(GameFieldInterface field)\n");//2
        }

        @Override
        public void printToStream(String s) {
            printStream.print("printToStream(String s)\n");//2
        }

        @Override
        public void indent() {
            printStream.print("indent()\n");
        }
    }

    class MyGameFieldScanner implements GameFieldScannerInterface {

        @Override
        public boolean scanCommand(GameFieldInterface field) {
            printStream.print("scanCommand(GameFieldInterface field)\n");
            return true;
        }

        @Override
        public boolean continueGame() {
            printStream.print("continueGame()\n");
            return false;
        }
    }
}