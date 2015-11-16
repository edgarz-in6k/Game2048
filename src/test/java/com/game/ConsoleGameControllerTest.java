package com.game;

import com.filler.CellValueFiller;
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
                "fillEmptyCell()\n" +
                "fillEmptyCell()\n" +
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
            printStream.print("fillEmptyCell()\n");//!
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

        @Override
        public int getSize() {
            printStream.print("NO VISIBLEgetSize()\n");//!
            return 0;
        }

        @Override
        public CellValueFiller getFiller() {
            printStream.print("NO VISIBLE ellValueFiller getFiller()\n");//!
            return null;
        }

        @Override
        public long[] getArray() {
            printStream.print("NO VISIBLE ellValueFiller getArray()\n");//!
            return new long[0];
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
        public Direction scanCommand() {
            printStream.print("scanCommand(GameFieldInterface field)\n");
            return Direction.NO_DIRECTION;
        }

        @Override
        public boolean continueGame() {
            printStream.print("continueGame()\n");
            return false;
        }
    }
}