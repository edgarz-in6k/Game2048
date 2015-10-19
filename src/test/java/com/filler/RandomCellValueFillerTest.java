package com.filler;

import com.game.GameField;
import com.generator.RandomCellValueGenerator;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class RandomCellValueFillerTest {
    @Test
    public void testFieldWithRandom() {
        int size = 4;
        GameField gameField = new GameField(new StaticCellValueFiller(new RandomCellValueGenerator()), size);
        for (int i = 0; i < 16; i++)
            gameField.fillEmptyCell();
        String field = gameField.toString();
        Scanner sc = new Scanner(field);
        int[] fieldValues = new int[size * size];
        for (int i = 0; i < 16; i++)
            fieldValues[i] = sc.nextInt();
        for (int i = 0; i < 16; i++) {
            assertEquals(fieldValues[i] == 2 || fieldValues[i] == 4, true);
        }
    }
}
