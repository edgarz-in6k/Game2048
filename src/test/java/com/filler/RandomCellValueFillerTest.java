package com.filler;

import com.game.GameField;
import com.generator.RandomCellValueGenerator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RandomCellValueFillerTest {

    private static final int SIZE = 4;
    private GameField gameField;

    @Before
    public void setUp() throws Exception {
        gameField = new GameField(new StaticCellValueFiller(new RandomCellValueGenerator()), SIZE);
    }

    private void fillGameField(int count) {
        for (int i = 0; i < count; i++)
            gameField.fillEmptyCell();
    }

    @Test
    public void testFieldWithRandom() {
        fillGameField(16);
        long[] fieldValues = gameField.getArray();
        for (int i = 0; i < 16; i++) {
            assertEquals(fieldValues[i] == 2 || fieldValues[i] == 4, true);
        }
    }
}
