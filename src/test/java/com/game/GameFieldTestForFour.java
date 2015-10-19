package com.game;

import com.filler.StaticCellValueFiller;
import com.generator.StaticCellValueGenerator;
import com.generator.StaticProgressiveCellValueGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameFieldTestForFour {

    private static final int SIZE = 4;
    private GameField gameField;

    @Before
    public void setUp() throws Exception {
        gameField = new GameField(new StaticCellValueFiller(new StaticCellValueGenerator()), SIZE);
    }

    private void createProgressiveGameField() {
        gameField = new GameField(new StaticCellValueFiller(new StaticProgressiveCellValueGenerator()), SIZE);
        fillGameField(16);
    }

    private void assertGameFieldValuesEqual(int[] actuals) {
        String field = gameField.toString();
        Scanner sc = new Scanner(field);
        int[] fieldValues = new int[SIZE * SIZE];
        for (int i = 0; sc.hasNextInt(); i++)
            fieldValues[i] = sc.nextInt();
        assertArrayEquals(fieldValues, actuals);
    }

    private void fillGameField(int count) {
        for (int i = 0; i < count; i++)
            gameField.fillEmptyCell();
    }

    @Test
    public void testToString() {
        Assert.assertEquals(gameField.toString(),
                "     0     0     0     0\n" +
                        "     0     0     0     0\n" +
                        "     0     0     0     0\n" +
                        "     0     0     0     0\n");
    }

    @Test
    public void testMoveDownOneTime() {
        // 2 2 2 2
        // 2 2 0 0
        // 0 0 0 0
        // 0 0 0 0
        fillGameField(6);
        gameField.move(Direction.DOWN);
        assertGameFieldValuesEqual(new int[]{
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0,
                4, 4, 2, 2
        });
    }

    @Test
    public void testNotMargeResultOfMarge() {
        // 2 2 2 2
        // 2 2 2 2
        // 2 2 2 2
        // 2 2 0 0
        fillGameField(14);
        gameField.move(Direction.DOWN);
        assertGameFieldValuesEqual(new int[]{
                0, 0, 0, 0,
                0, 0, 0, 0,
                4, 4, 2, 2,
                4, 4, 4, 4
        });
    }

    @Test
    public void testMoveUpOneTime() {
        //2222
        //2200
        //0000
        //0000
        fillGameField(6);
        gameField.move(Direction.UP);
        assertGameFieldValuesEqual(new int[]{
                4, 4, 2, 2,
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0
        });
    }

    @Test
    public void testFieldTwoDirectUp() {
        //2222
        //2222
        //2222
        //2200
        fillGameField(14);
        gameField.move(Direction.UP);
        gameField.move(Direction.UP);
        assertGameFieldValuesEqual(new int[]{
                8, 8, 4, 4,
                0, 0, 2, 2,
                0, 0, 0, 0,
                0, 0, 0, 0
        });
    }

    @Test
    public void testFieldOneDirectRight() {
        //2222
        //2200
        //0000
        //0000
        fillGameField(6);
        gameField.move(Direction.RIGHT);
        assertGameFieldValuesEqual(new int[]{
                0, 0, 4, 4,
                0, 0, 0, 4,
                0, 0, 0, 0,
                0, 0, 0, 0
        });
    }

    @Test
    public void testFieldTwoDirectRight() {
        //2222
        //2222
        //2222
        //2200
        fillGameField(14);
        gameField.move(Direction.RIGHT);
        gameField.move(Direction.RIGHT);
        assertGameFieldValuesEqual(new int[]{
                0, 0, 0, 8,
                0, 0, 0, 8,
                0, 0, 0, 8,
                0, 0, 0, 4
        });
    }

    @Test
    public void testFieldOneDirectLeft() {
        //2222
        //2200
        //0000
        //0000
        fillGameField(6);
        gameField.move(Direction.LEFT);
        assertGameFieldValuesEqual(new int[]{
                4, 4, 0, 0,
                4, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0
        });
    }

    @Test
    public void testFieldTwoDirectLeft() {
        //2222
        //2222
        //2222
        //2200
        fillGameField(14);
        gameField.move(Direction.LEFT);
        gameField.move(Direction.LEFT);
        assertGameFieldValuesEqual(new int[]{
                8, 0, 0, 0,
                8, 0, 0, 0,
                8, 0, 0, 0,
                4, 0, 0, 0
        });
    }

    @Test
    public void testFieldWithProgressive() {
        createProgressiveGameField();
        //   2     4     8    16
        //  32    64   128   256
        // 512  1024  2048  4096
        //8192 16384 32768 65536
        assertGameFieldValuesEqual(new int[]{
                2, 4, 8, 16,
                32, 64, 128, 256,
                512, 1024, 2048, 4096,
                8192, 16384, 32768, 65536
        });
    }

    @Test
    public void testFieldDownNoMove() {
        createProgressiveGameField();
        //2 4 8 16
        //32 64 128 256
        //512 1024 2048 4096
        //8192 16384 32768 65536
        gameField.move(Direction.DOWN);
        assertGameFieldValuesEqual(new int[]{
                2, 4, 8, 16,
                32, 64, 128, 256,
                512, 1024, 2048, 4096,
                8192, 16384, 32768, 65536
        });
    }

    @Test
    public void testHasNoAvailableMoves() {
        createProgressiveGameField();
        //2 4 8 16
        //32 64 128 256
        //512 1024 2048 4096
        //8192 16384 32768 65536
        assertFalse(gameField.hasAvailableMoves());
    }

    @Test
    public void testHasAvailableMoves() {
        //2222
        //2222
        //2222
        //2200
        fillGameField(14);
        assertTrue(gameField.hasAvailableMoves());
    }

    @Test
    public void testHasCellWith2048() {
        createProgressiveGameField();
        //2 4 8 16
        //32 64 128 256
        //512 1024 2048 4096
        //8192 16384 32768 65536
        assertTrue(gameField.hasCellWith2048());
    }

    @Test
    public void testDoesNotHaveCellWith2048() {
        //2222
        //2222
        //2222
        //2200
        fillGameField(14);
        assertFalse(gameField.hasCellWith2048());
    }
}