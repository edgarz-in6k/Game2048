package com.game;

import com.filler.StaticCellValueFiller;
import com.generator.CellValueGenerator;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertArrayEquals;

public class GameFieldWithMyGeneratorTest {

    private GameField gameField;
    private static final int SIZE = 4;

    @Before
    public void initMyGenerator() {
        gameField = new GameField(new StaticCellValueFiller(new CellValueGenerator() {
            private long value = 2;
            private long k = 1;

            @Override
            public long getNumber() {
                if (k == 6 || k == 7 || k == 10 || k == 11)
                    value = 4;
                else if (k > 16) {
                    k = 0;
                    value = 2;
                } else
                    value = 2;
                k++;
                return value;
            }
        }), SIZE);
    }

    private void fillGameField(int count) {
        for (int i = 0; i < count; i++)
            gameField.fillEmptyCell();
    }

    @Test
    public void testMyGenerator() {
        //2222
        //2442
        //2442
        //2222
        fillGameField(SIZE * SIZE);
        assertArrayEquals(gameField.getArray(), new long[]{
                2, 2, 2, 2,
                2, 4, 4, 2,
                2, 4, 4, 2,
                2, 2, 2, 2
        });
    }

    @Test
    public void testFieldMoveDown() {
        //2222
        //2442
        //2442
        //2222
        fillGameField(SIZE * SIZE);
        gameField.move(Direction.DOWN);
        assertArrayEquals(gameField.getArray(), new long[]{
                0, 0, 0, 0,
                0, 2, 2, 0,
                4, 8, 8, 4,
                4, 2, 2, 4
        });
    }

    @Test
    public void testFieldMoveDownDownRight() {
        //2222
        //2442
        //2442
        //2222
        fillGameField(SIZE * SIZE);
        gameField.move(Direction.DOWN);
        gameField.move(Direction.DOWN);
        gameField.move(Direction.RIGHT);
        assertArrayEquals(gameField.getArray(), new long[]{
                0, 0, 0, 0,
                0, 0, 0, 4,
                0, 0, 0, 16,
                0, 8, 4, 8
        });
    }
}
