package com.game;

import com.filler.StaticCellValueFiller;
import com.generator.StaticCellValueGenerator;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameFieldScannerTest {
    private static final int SIZE = 4;
    private GameField gameField;

    @Before
    public void setUp() throws Exception {
        gameField = new GameField(new StaticCellValueFiller(new StaticCellValueGenerator()), SIZE);
    }

    private void fillGameField(int count) {
        for (int i = 0; i < count; i++)
            gameField.fillEmptyCell();
    }

    private boolean runScanCommand(String commandUp){
        Direction direction = runCommand(commandUp).scanCommand();
        if (direction != Direction.NO_DIRECTION)
            gameField.move(direction);
        return direction != Direction.NO_DIRECTION;
    }

    private boolean runContinueCommand(String commandUp){
        return runCommand(commandUp).continueGame();
    }

    private GameFieldScanner runCommand(String commandUp) {
        InputStream inputStream = new ByteArrayInputStream(commandUp.getBytes());
        return new GameFieldScanner(inputStream);
    }

    @Test
    public void testCommand(){
        // init    // w       // a       // s       // d
        // 2 2 2 2 // 4 4 2 2 // 8 4(2)0 //(2)0 0 0 //(2)0 0 2
        // 2 2 0 0 //(2)0 0 0 // 2 0 0 0 // 0 0 0 0 // 0 0 0 0
        // 0 0 0 0 // 0 0 0 0 // 0 0 0 0 // 8 0 0 0 // 0 0 0 8
        // 0 0 0 0 // 0 0 0 0 // 0 0 0 0 // 2 4 2 0 // 0 2 4 2
        fillGameField(6);
        String commandUp = "w";
        String commandLeft = "a";
        String commandDown = "s";
        String commandRight = "d";
        String commandExit = "e";
        runScanCommand(commandUp);
        gameField.fillEmptyCell();
        runScanCommand(commandLeft);
        gameField.fillEmptyCell();
        runScanCommand(commandDown);
        gameField.fillEmptyCell();
        runScanCommand(commandRight);
        gameField.fillEmptyCell();
        assertArrayEquals(gameField.getArray(), new long[]{
                2, 0, 0, 2,
                0, 0, 0, 0,
                0, 0, 0, 8,
                0, 2, 4, 2
        });
        assertFalse(runScanCommand(commandExit));
    }

    @Test
    public void testContinueGame(){
        String commandYes = "y";
        String commandNo = "n";
        assertTrue(runContinueCommand(commandYes));
        assertFalse(runContinueCommand(commandNo));
    }
}