package com.game;

import com.filler.StaticCellValueFiller;
import com.generator.StaticCellValueGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class GameFieldTestForFive {

    private static final int SIZE = 5;
    private GameField gameField;

    @Before
    public void setUp() throws Exception {
        gameField = new GameField(new StaticCellValueFiller(new StaticCellValueGenerator()), SIZE);
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
        GameField gameField = new GameField(new StaticCellValueFiller(new StaticCellValueGenerator()), SIZE);
        String field = gameField.toString();
        Assert.assertEquals(field,
                        "     0     0     0     0     0\n" +
                        "     0     0     0     0     0\n" +
                        "     0     0     0     0     0\n" +
                        "     0     0     0     0     0\n" +
                        "     0     0     0     0     0\n");
    }

    @Test
    public void testMoveDownOneTime() {
        //2 2 2 2 2
        //2 2 2 0 0
        //0 0 0 0 0
        //0 0 0 0 0
        //0 0 0 0 0
        fillGameField(8);
        gameField.move(Direction.DOWN);
        assertGameFieldValuesEqual(new long[]{
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                4, 4, 4, 2, 2,
        });
    }

    @Test
    public void testMoveDownNotMargeResultOfMarge() {
        // 2 2 2 2 2
        // 2 2 2 2 2
        // 2 2 2 2 2
        // 2 2 2 2 2
        // 2 2 0 0 0
        fillGameField(22);
        gameField.move(Direction.DOWN);
        assertGameFieldValuesEqual(new long[]{
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                2, 2, 0, 0, 0,
                4, 4, 4, 4, 4,
                4, 4, 4, 4, 4
        });
    }

    @Test
    public void testMoveUpOneTime() {
        // 2 2 2 2 2
        // 2 2 2 0 0
        // 0 0 0 0 0
        // 0 0 0 0 0
        // 0 0 0 0 0
        fillGameField(8);
        gameField.move(Direction.UP);
        assertGameFieldValuesEqual(new long[]{
                4, 4, 4, 2, 2,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
        });
    }

    @Test
    public void testMoveUpNotMargeResultOfMarge() {
        // 2 2 2 2 2
        // 2 2 2 2 2
        // 2 2 2 2 2
        // 2 2 2 2 2
        // 2 2 0 0 0
        fillGameField(22);
        gameField.move(Direction.UP);
        assertGameFieldValuesEqual(new long[]{
                4, 4, 4, 4, 4,
                4, 4, 4, 4, 4,
                2, 2, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0
        });
    }

    @Test
    public void testMoveRightOneTime() {
        // 2 2 2 2 2
        // 2 2 2 0 0
        // 0 0 0 0 0
        // 0 0 0 0 0
        // 0 0 0 0 0
        fillGameField(8);
        gameField.move(Direction.RIGHT);
        assertGameFieldValuesEqual(new long[]{
                0, 0, 2, 4, 4,
                0, 0, 0, 2, 4,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0
        });
    }

    @Test
    public void testMoveRightNotMargeResultOfMarge() {
        // 2 2 2 2 2
        // 2 2 2 2 2
        // 2 2 2 2 2
        // 2 2 2 2 2
        // 2 2 2 0 0
        fillGameField(23);
        gameField.move(Direction.RIGHT);
        gameField.move(Direction.RIGHT);
        assertGameFieldValuesEqual(new long[]{
                0, 0, 0, 2, 8,
                0, 0, 0, 2, 8,
                0, 0, 0, 2, 8,
                0, 0, 0, 2, 8,
                0, 0, 0, 2, 4
        });
    }

    @Test
    public void testMoveLeftOneTime() {
        // 2 2 2 2 2
        // 2 2 2 0 0
        // 0 0 0 0 0
        // 0 0 0 0 0
        // 0 0 0 0 0
        fillGameField(8);
        gameField.move(Direction.LEFT);
        assertGameFieldValuesEqual(new long[]{
                4, 4, 2, 0, 0,
                4, 2, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0
        });
    }

    @Test
    public void testMoveLeftNotMargeResultOfMarge() {
        // 2 2 2 2 2
        // 2 2 2 2 2
        // 2 2 2 2 2
        // 2 2 2 2 2
        // 2 2 2 0 0
        fillGameField(23);
        gameField.move(Direction.LEFT);
        assertGameFieldValuesEqual(new long[]{
                4, 4, 2, 0, 0,
                4, 4, 2, 0, 0,
                4, 4, 2, 0, 0,
                4, 4, 2, 0, 0,
                4, 2, 0, 0, 0
        });
    }
}