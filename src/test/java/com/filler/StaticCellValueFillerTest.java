package com.filler;

import com.game.GameField;
import com.generator.RandomCellValueGenerator;
import com.generator.StaticCellValueGenerator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class StaticCellValueFillerTest {

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
    @Test
    public void beginGameWithTwoStaticCells() {
        fillGameField(6);
        assertArrayEquals(gameField.getArray(), new long[]{
                2, 2, 2, 2,
                2, 2, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0
        });
    }
}
