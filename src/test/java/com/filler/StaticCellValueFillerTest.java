package com.filler;

import com.game.GameField;
import com.generator.StaticCellValueGenerator;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertArrayEquals;

public class StaticCellValueFillerTest {
    @Test
    public void beginGameWithTwoStaticCells() {
        int size = 4;
        GameField gameField = new GameField(new StaticCellValueFiller(new StaticCellValueGenerator()), size);
        for (int i = 0; i < 6; i++) {
            gameField.fillEmptyCell();
        }
        long[] fieldValues = gameField.getArray();
        assertArrayEquals(fieldValues, new long[]{
                2, 2, 2, 2,
                2, 2, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0
        });
    }
}
