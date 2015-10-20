package com.game;

import com.filler.StaticCellValueFiller;
import com.generator.StaticCellValueGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class GameFieldTestForTen {
    private static final int SIZE = 10;
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
                        "     0     0     0     0     0     0     0     0     0     0\n" +
                        "     0     0     0     0     0     0     0     0     0     0\n" +
                        "     0     0     0     0     0     0     0     0     0     0\n" +
                        "     0     0     0     0     0     0     0     0     0     0\n" +
                        "     0     0     0     0     0     0     0     0     0     0\n" +
                        "     0     0     0     0     0     0     0     0     0     0\n" +
                        "     0     0     0     0     0     0     0     0     0     0\n" +
                        "     0     0     0     0     0     0     0     0     0     0\n" +
                        "     0     0     0     0     0     0     0     0     0     0\n" +
                        "     0     0     0     0     0     0     0     0     0     0\n");
    }

    @Test
    public void testMoveDownNotMargeResultOfMarge() {
        //2 2 2 2 2  2 2 2 2 2
        //2 2 2 2 2  2 2 2 2 2
        //2 2 2 2 2  2 2 2 2 2
        //2 2 2 2 2  2 2 2 2 2
        //2 2 2 2 0  0 0 0 0 0

        //0 0 0 0 0  0 0 0 0 0
        //0 0 0 0 0  0 0 0 0 0
        //0 0 0 0 0  0 0 0 0 0
        //0 0 0 0 0  0 0 0 0 0
        //0 0 0 0 0  0 0 0 0 0
        fillGameField(44);
        gameField.move(Direction.DOWN);
        assertGameFieldValuesEqual(new long[]{
                0, 0, 0, 0, 0,  0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,  0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,  0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,  0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,  0, 0, 0, 0, 0,

                0, 0, 0, 0, 0,  0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,  0, 0, 0, 0, 0,
                2, 2, 2, 2, 0,  0, 0, 0, 0, 0,
                4, 4, 4, 4, 4,  4, 4, 4, 4, 4,
                4, 4, 4, 4, 4,  4, 4, 4, 4, 4,
        });
    }
}
