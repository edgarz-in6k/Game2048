package com.game;

import com.filler.StaticCellValueFiller;
import com.generator.StaticCellValueGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertArrayEquals;

public class GameFieldTestForFive {

    private int size;

    @Before
    public void init() {
        size = 5;
    }

    @Test
    public void testToString() {
        GameField gameField = new GameField(new StaticCellValueFiller(new StaticCellValueGenerator()), size);
        String field = gameField.toString();
        Assert.assertEquals(field,
                "     0     0     0     0     0\n" +
                        "     0     0     0     0     0\n" +
                        "     0     0     0     0     0\n" +
                        "     0     0     0     0     0\n" +
                        "     0     0     0     0     0\n");
    }

    @Test
    public void testFieldOneDirectDown() {
        GameField gameField = new GameField(new StaticCellValueFiller(new StaticCellValueGenerator()), size);
        //22222
        //22200
        //00000
        //00000
        //00000
        for (int i = 0; i < 8; i++)
            gameField.fillEmptyCell();
        gameField.move(Direction.DOWN);
        String field = gameField.toString();
        Scanner sc = new Scanner(field);
        int[] fieldValues = new int[size * size];
        for (int i = 0; sc.hasNextInt(); i++)
            fieldValues[i] = sc.nextInt();
        assertArrayEquals(fieldValues, new int[]{
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                4, 4, 4, 2, 2,
        });
    }

    @Test
    public void testFieldTwoDirectDown() {
        GameField gameField = new GameField(new StaticCellValueFiller(new StaticCellValueGenerator()), size);
        //22222
        //22222
        //22222
        //22222
        //22000
        for (int i = 0; i < 22; i++)
            gameField.fillEmptyCell();
        gameField.move(Direction.DOWN);
        gameField.move(Direction.DOWN);
        String field = gameField.toString();
        Scanner sc = new Scanner(field);
        int[] fieldValues = new int[size * size];
        for (int i = 0; sc.hasNextInt(); i++)
            fieldValues[i] = sc.nextInt();
        assertArrayEquals(fieldValues, new int[]{
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                2, 2, 0, 0, 0,
                8, 8, 8, 8, 8
        });
    }

    @Test
    public void testFieldOneDirectUp() {
        GameField gameField = new GameField(new StaticCellValueFiller(new StaticCellValueGenerator()), size);
        //22222
        //22200
        //00000
        //00000
        //00000
        for (int i = 0; i < 8; i++)
            gameField.fillEmptyCell();
        gameField.move(Direction.UP);
        String field = gameField.toString();
        Scanner sc = new Scanner(field);
        int[] fieldValues = new int[size * size];
        for (int i = 0; sc.hasNextInt(); i++)
            fieldValues[i] = sc.nextInt();
        assertArrayEquals(fieldValues, new int[]{
                4, 4, 4, 2, 2,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
        });
    }

    @Test
    public void testFieldTwoDirectUp() {
        GameField gameField = new GameField(new StaticCellValueFiller(new StaticCellValueGenerator()), size);
        //22222
        //22222
        //22222
        //22222
        //22000
        for (int i = 0; i < 22; i++)
            gameField.fillEmptyCell();
        gameField.move(Direction.UP);
        gameField.move(Direction.UP);
        String field = gameField.toString();
        Scanner sc = new Scanner(field);
        int[] fieldValues = new int[size * size];
        for (int i = 0; sc.hasNextInt(); i++)
            fieldValues[i] = sc.nextInt();
        assertArrayEquals(fieldValues, new int[]{
                8, 8, 8, 8, 8,
                2, 2, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0
        });
    }

    @Test
    public void testFieldOneDirectRight() {
        GameField gameField = new GameField(new StaticCellValueFiller(new StaticCellValueGenerator()), size);
        //22222
        //22200
        //00000
        //00000
        //00000
        for (int i = 0; i < 8; i++)
            gameField.fillEmptyCell();
        gameField.move(Direction.RIGHT);
        String field = gameField.toString();
        Scanner sc = new Scanner(field);
        int[] fieldValues = new int[size * size];
        for (int i = 0; sc.hasNextInt(); i++)
            fieldValues[i] = sc.nextInt();
        assertArrayEquals(fieldValues, new int[]{
                0, 0, 2, 4, 4,
                0, 0, 0, 2, 4,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0
        });
    }

    @Test
    public void testFieldTwoDirectRight() {
        GameField gameField = new GameField(new StaticCellValueFiller(new StaticCellValueGenerator()), size);
        //22222
        //22222
        //22222
        //22222
        //22200
        for (int i = 0; i < 23; i++)
            gameField.fillEmptyCell();
        gameField.move(Direction.RIGHT);
        gameField.move(Direction.RIGHT);
        String field = gameField.toString();
        Scanner sc = new Scanner(field);
        int[] fieldValues = new int[size * size];
        for (int i = 0; sc.hasNextInt(); i++)
            fieldValues[i] = sc.nextInt();
        assertArrayEquals(fieldValues, new int[]{
                0, 0, 0, 2, 8,
                0, 0, 0, 2, 8,
                0, 0, 0, 2, 8,
                0, 0, 0, 2, 8,
                0, 0, 0, 2, 4
        });
    }

    @Test
    public void testFieldOneDirectLeft() {
        GameField gameField = new GameField(new StaticCellValueFiller(new StaticCellValueGenerator()), size);
        //22222
        //22200
        //00000
        //00000
        //00000
        for (int i = 0; i < 8; i++)
            gameField.fillEmptyCell();
        gameField.move(Direction.LEFT);
        String field = gameField.toString();
        Scanner sc = new Scanner(field);
        int[] fieldValues = new int[size * size];
        for (int i = 0; sc.hasNextInt(); i++)
            fieldValues[i] = sc.nextInt();
        assertArrayEquals(fieldValues, new int[]{
                4, 4, 2, 0, 0,
                4, 2, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0
        });
    }

    @Test
    public void testFieldTwoDirectLeft() {
        GameField gameField = new GameField(new StaticCellValueFiller(new StaticCellValueGenerator()), size);
        //22222
        //22222
        //22222
        //22222
        //22200
        for (int i = 0; i < 23; i++)
            gameField.fillEmptyCell();
        gameField.move(Direction.LEFT);
        gameField.move(Direction.LEFT);
        String field = gameField.toString();
        Scanner sc = new Scanner(field);
        int[] fieldValues = new int[size * size];
        for (int i = 0; sc.hasNextInt(); i++)
            fieldValues[i] = sc.nextInt();
        assertArrayEquals(fieldValues, new int[]{
                8, 2, 0, 0, 0,
                8, 2, 0, 0, 0,
                8, 2, 0, 0, 0,
                8, 2, 0, 0, 0,
                4, 2, 0, 0, 0
        });
    }
}
