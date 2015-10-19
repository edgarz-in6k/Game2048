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
        String field = gameField.toString();
        Scanner sc = new Scanner(field);
        int[] fieldValues = new int[size * size];
        for (int i = 0; sc.hasNextInt(); i++)
            fieldValues[i] = sc.nextInt();
        assertArrayEquals(fieldValues, new int[]{
                2, 2, 2, 2,
                2, 2, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0
        });
    }
}
