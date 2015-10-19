package com.game;

import com.filler.StaticCellValueFiller;
import com.generator.CellValueGenerator;
import com.generator.StaticCellValueGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

public class GameFieldWithMyGeneratorTest {

    private CellValueGenerator generator;
    public int size;

    @Before
    public void initMuyGenerator(){
        size = 4;
        generator = new CellValueGenerator() {
            private long value = 2;
            private long k = 1;
            @Override
            public long getNumber() {
                if (k == 6 || k== 7 || k == 10 || k == 11)
                    value = 4;
                else if (k > 16){
                    k = 0;
                    value = 2;
                }
                else
                    value = 2;
                k++;
                return value;
            }
        };
    }

    @Test
    public void testMyGenerator(){
        GameField gameField = new GameField(new StaticCellValueFiller(generator), size);
        //2222
        //2442
        //2442
        //2222
        for (int i = 0; i < 16; i++)
            gameField.fillEntryCell();
        String field = gameField.toString();
        Scanner sc = new Scanner(field);
        int[] fieldValues = new int[size*size];
        for (int i=0; sc.hasNextInt(); i++)
            fieldValues[i] = sc.nextInt();
        Assert.assertArrayEquals(fieldValues, new int[]{
                2, 2, 2, 2,
                2, 4, 4, 2,
                2, 4, 4, 2,
                2, 2, 2, 2
        });
    }

    @Test
    public void testFieldDirectDown(){
        GameField gameField = new GameField(new StaticCellValueFiller(generator), size);
        //2222
        //2442
        //2442
        //2222
        for (int i = 0; i < 16; i++)
            gameField.fillEntryCell();
        gameField.move(Direction.DOWN);
        String field = gameField.toString();
        //System.out.println(field);
        Scanner sc = new Scanner(field);
        int[] fieldValues = new int[size*size];
        for (int i=0; sc.hasNextInt(); i++)
            fieldValues[i] = sc.nextInt();
        Assert.assertArrayEquals(fieldValues, new int[]{
                0,0,0,0,
                0,2,2,0,
                4,8,8,4,
                4,2,2,4
        });
    }
}
