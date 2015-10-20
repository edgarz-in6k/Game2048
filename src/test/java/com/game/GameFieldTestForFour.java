package com.game;

import com.filler.StaticCellValueFiller;
import com.generator.StaticCellValueGenerator;
import com.generator.StaticProgressiveCellValueGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        fillGameField(SIZE * SIZE);
    }

    private void assertGameFieldValuesEqual(long[] actuals) {
        assertArrayEquals(gameField.getArray(), actuals);
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
        assertGameFieldValuesEqual(new long[]{
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0,
                4, 4, 2, 2
        });
    }

    @Test
    public void testMoveDownNotMargeResultOfMarge() {
        // 2 2 2 2
        // 2 2 2 2
        // 2 2 2 2
        // 2 2 0 0
        fillGameField(14);
        gameField.move(Direction.DOWN);
        assertGameFieldValuesEqual(new long[]{
                0, 0, 0, 0,
                0, 0, 0, 0,
                4, 4, 2, 2,
                4, 4, 4, 4
        });
    }

    @Test
    public void testMoveUpOneTime() {
        // 2 2 2 2
        // 2 2 0 0
        // 0 0 0 0
        // 0 0 0 0
        fillGameField(6);
        gameField.move(Direction.UP);
        assertGameFieldValuesEqual(new long[]{
                4, 4, 2, 2,
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0
        });
    }

    @Test
    public void testMoveUpNotMargeResultOfMarge() {
        // 2 2 2 2
        // 2 2 2 2
        // 2 2 2 2
        // 2 2 0 0
        fillGameField(14);
        gameField.move(Direction.UP);
        gameField.move(Direction.UP);
        assertGameFieldValuesEqual(new long[]{
                8, 8, 4, 4,
                0, 0, 2, 2,
                0, 0, 0, 0,
                0, 0, 0, 0
        });
    }

    @Test
    public void testMoveRightOneTime() {
        // 2 2 2 2
        // 2 2 0 0
        // 0 0 0 0
        // 0 0 0 0
        fillGameField(6);
        gameField.move(Direction.RIGHT);
        assertGameFieldValuesEqual(new long[]{
                0, 0, 4, 4,
                0, 0, 0, 4,
                0, 0, 0, 0,
                0, 0, 0, 0
        });
    }

    @Test
    public void testMoveRightNotMargeResultOfMarge() {
        //2222
        //2222
        //2222
        //2200
        fillGameField(14);
        gameField.move(Direction.RIGHT);
        gameField.move(Direction.RIGHT);
        assertGameFieldValuesEqual(new long[]{
                0, 0, 0, 8,
                0, 0, 0, 8,
                0, 0, 0, 8,
                0, 0, 0, 4
        });
    }

    @Test
    public void testMoveLeftOneTime() {
        // 2 2 2 2
        // 2 2 0 0
        // 0 0 0 0
        // 0 0 0 0
        fillGameField(6);
        gameField.move(Direction.LEFT);
        assertGameFieldValuesEqual(new long[]{
                4, 4, 0, 0,
                4, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0
        });
    }

    @Test
    public void testMoveLeftNotMargeResultOfMarge() {
        // 2 2 2 2
        // 2 2 2 2
        // 2 2 2 2
        // 2 2 0 0
        fillGameField(14);
        gameField.move(Direction.LEFT);
        gameField.move(Direction.LEFT);
        assertGameFieldValuesEqual(new long[]{
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
        assertGameFieldValuesEqual(new long[]{
                2, 4, 8, 16,
                32, 64, 128, 256,
                512, 1024, 2048, 4096,
                8192, 16384, 32768, 65536
        });
    }

    @Test
    public void testFieldDownNoMove() {
        createProgressiveGameField();
        //   2     4     8    16
        //  32    64   128   256
        // 512  1024  2048  4096
        //8192 16384 32768 65536
        gameField.move(Direction.DOWN);
        assertGameFieldValuesEqual(new long[]{
                2, 4, 8, 16,
                32, 64, 128, 256,
                512, 1024, 2048, 4096,
                8192, 16384, 32768, 65536
        });
    }

    @Test
    public void testHasNoAvailableMoves() {
        createProgressiveGameField();
        //   2     4     8    16
        //  32    64   128   256
        // 512  1024  2048  4096
        //8192 16384 32768 65536
        assertFalse(gameField.hasAvailableMoves());
    }

    @Test
    public void testHasAvailableMoves() {
        // 2 2 2 2
        // 2 2 2 2
        // 2 2 2 2
        // 2 2 2 0
        fillGameField(15);
        assertTrue(gameField.hasAvailableMoves());
    }

    @Test
    public void testHasCellWith2048() {
        createProgressiveGameField();
        //   2     4     8    16
        //  32    64   128   256
        // 512  1024  2048  4096
        //8192 16384 32768 65536
        assertTrue(gameField.hasCellWith2048());
    }

    @Test
    public void testDoesNotHaveCellWith2048() {
        // 2 2 2 2
        // 2 2 2 2
        // 2 2 2 2
        // 2 2 0 0
        fillGameField(14);
        assertFalse(gameField.hasCellWith2048());
    }
}