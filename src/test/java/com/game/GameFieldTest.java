package com.game;

import com.filler.RandomCellValueFiller;
import com.filler.StaticCellValueFiller;
import com.filler.StaticProgressiveCellValueFiller;
import com.generator.RandomCellValueGenerator;
import com.generator.StaticCellValueGenerator;
import com.generator.StaticProgressiveCellValueGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Scanner;

public class GameFieldTest {

    public int size;

    @Before
    public void init(){
        size = 4;
    }

    @Test
    public void testToString(){
        GameField gameField = new GameField(new StaticCellValueFiller(new StaticCellValueGenerator()), size);
        String field = gameField.toString();
        Assert.assertEquals(field,
                        "     0     0     0     0\n" +
                        "     0     0     0     0\n" +
                        "     0     0     0     0\n" +
                        "     0     0     0     0\n");
    }

    @Test
    public void beginGameWithTwoStaticCells() {
        GameField gameField = new GameField(new StaticCellValueFiller(new StaticCellValueGenerator()), size);
        gameField.fillEntryCell();
        gameField.fillEntryCell();
        String field = gameField.toString();
        Scanner sc = new Scanner(field);
        int[] fieldValues = new int[size*size];
        for (int i=0; sc.hasNextInt(); i++)
            fieldValues[i] = sc.nextInt();
        Assert.assertArrayEquals(fieldValues, new int[]{
                2,2,0,0,
                0,0,0,0,
                0,0,0,0,
                0,0,0,0
        });
    }

    @Test
    public void fullGameWithStaticCells(){
        GameField gameField = new GameField(new StaticCellValueFiller(new StaticCellValueGenerator()), size);
        for (int i = 0; i < 16; i++)
            gameField.fillEntryCell();
        String field = gameField.toString();
        Scanner sc = new Scanner(field);
        int[] fieldValues = new int[size*size];
        for (int i=0; sc.hasNextInt(); i++)
            fieldValues[i] = sc.nextInt();
        Assert.assertArrayEquals(fieldValues, new int[]{
                2,2,2,2,
                2,2,2,2,
                2,2,2,2,
                2,2,2,2
        });
    }

    @Test
    public void testFieldOneDirectDown() {
        GameField gameField = new GameField(new StaticCellValueFiller(new StaticCellValueGenerator()), size);
        //2222
        //2200
        //0000
        //0000
        for (int i = 0; i < 6; i++)
            gameField.fillEntryCell();
        gameField.move(Direction.DOWN);
        String field = gameField.toString();
        Scanner sc = new Scanner(field);
        int[] fieldValues = new int[size*size];
        for (int i=0; sc.hasNextInt(); i++)
            fieldValues[i] = sc.nextInt();
        Assert.assertArrayEquals(fieldValues, new int[]{
                0,0,0,0,
                0,0,0,0,
                0,0,0,0,
                4,4,2,2
        });
    }

    @Test
    public void testFieldTwoDirectDown() {
        GameField gameField = new GameField(new StaticCellValueFiller(new StaticCellValueGenerator()), size);
        //2222
        //2222
        //2222
        //2200
        for (int i = 0; i < 14; i++)
            gameField.fillEntryCell();
        gameField.move(Direction.DOWN);
        String field = gameField.toString();
        Scanner sc = new Scanner(field);
        int[] fieldValues = new int[size*size];
        for (int i=0; sc.hasNextInt(); i++)
            fieldValues[i] = sc.nextInt();
        Assert.assertArrayEquals(fieldValues, new int[]{
                0,0,0,0,
                0,0,0,0,
                0,0,2,2,
                8,8,4,4
        });
    }

    @Test
    public void testFieldOneDirectUp() {
        GameField gameField = new GameField(new StaticCellValueFiller(new StaticCellValueGenerator()), size);
        //2222
        //2200
        //0000
        //0000
        for (int i = 0; i < 6; i++)
            gameField.fillEntryCell();
        gameField.move(Direction.UP);
        String field = gameField.toString();
        Scanner sc = new Scanner(field);
        int[] fieldValues = new int[size*size];
        for (int i=0; sc.hasNextInt(); i++)
            fieldValues[i] = sc.nextInt();
        Assert.assertArrayEquals(fieldValues, new int[]{
                4,4,2,2,
                0,0,0,0,
                0,0,0,0,
                0,0,0,0
        });
    }

    @Test
    public void testFieldTwoDirectUp() {
        GameField gameField = new GameField(new StaticCellValueFiller(new StaticCellValueGenerator()), size);
        //2222
        //2222
        //2222
        //2200
        for (int i = 0; i < 14; i++)
            gameField.fillEntryCell();
        gameField.move(Direction.UP);
        String field = gameField.toString();
        Scanner sc = new Scanner(field);
        int[] fieldValues = new int[size*size];
        for (int i=0; sc.hasNextInt(); i++)
            fieldValues[i] = sc.nextInt();
        Assert.assertArrayEquals(fieldValues, new int[]{
                8,8,4,4,
                0,0,2,2,
                0,0,0,0,
                0,0,0,0
        });
    }

    @Test
    public void testFieldOneDirectRight() {
        GameField gameField = new GameField(new StaticCellValueFiller(new StaticCellValueGenerator()), size);
        //2222
        //2200
        //0000
        //0000
        for (int i = 0; i < 6; i++)
            gameField.fillEntryCell();
        gameField.move(Direction.RIGHT);
        String field = gameField.toString();
        Scanner sc = new Scanner(field);
        int[] fieldValues = new int[size*size];
        for (int i=0; sc.hasNextInt(); i++)
            fieldValues[i] = sc.nextInt();
        Assert.assertArrayEquals(fieldValues, new int[]{
                0,0,0,8,
                0,0,0,4,
                0,0,0,0,
                0,0,0,0
        });
    }

    @Test
    public void testFieldTwoDirectRight() {
        GameField gameField = new GameField(new StaticCellValueFiller(new StaticCellValueGenerator()), size);
        //2222
        //2222
        //2222
        //2200
        for (int i = 0; i < 14; i++)
            gameField.fillEntryCell();
        gameField.move(Direction.RIGHT);
        String field = gameField.toString();
        Scanner sc = new Scanner(field);
        int[] fieldValues = new int[size*size];
        for (int i=0; sc.hasNextInt(); i++)
            fieldValues[i] = sc.nextInt();
        Assert.assertArrayEquals(fieldValues, new int[]{
                0,0,0,8,
                0,0,0,8,
                0,0,0,8,
                0,0,0,4
        });
    }

    @Test
    public void testFieldOneDirectLeft() {
        GameField gameField = new GameField(new StaticCellValueFiller(new StaticCellValueGenerator()), size);
        //2222
        //2200
        //0000
        //0000
        for (int i = 0; i < 6; i++)
            gameField.fillEntryCell();
        gameField.move(Direction.LEFT);
        String field = gameField.toString();
        Scanner sc = new Scanner(field);
        int[] fieldValues = new int[size*size];
        for (int i=0; sc.hasNextInt(); i++)
            fieldValues[i] = sc.nextInt();
        Assert.assertArrayEquals(fieldValues, new int[]{
                8,0,0,0,
                4,0,0,0,
                0,0,0,0,
                0,0,0,0
        });
    }

    @Test
    public void testFieldTwoDirectLeft() {
        GameField gameField = new GameField(new StaticCellValueFiller(new StaticCellValueGenerator()), size);
        //2222
        //2222
        //2222
        //2200
        for (int i = 0; i < 14; i++)
            gameField.fillEntryCell();
        gameField.move(Direction.LEFT);
        String field = gameField.toString();
        Scanner sc = new Scanner(field);
        int[] fieldValues = new int[size*size];
        for (int i=0; sc.hasNextInt(); i++)
            fieldValues[i] = sc.nextInt();
        Assert.assertArrayEquals(fieldValues, new int[]{
                8,0,0,0,
                8,0,0,0,
                8,0,0,0,
                4,0,0,0
        });
    }

    @Test
    public void testFieldDownNoMove(){
        GameField gameField = new GameField(new StaticProgressiveCellValueFiller(new StaticProgressiveCellValueGenerator()), size);
        //2 4 8 16
        //32 64 128 256
        //512 1024 2048 4096
        //8192 16384 32768 65536
        for (int i = 0; i < 16; i++)
            gameField.fillEntryCell();
        gameField.move(Direction.DOWN);
        String field = gameField.toString();
        Scanner sc = new Scanner(field);
        int[] fieldValues = new int[size*size];
        for (int i=0; sc.hasNextInt(); i++)
            fieldValues[i] = sc.nextInt();
        Assert.assertArrayEquals(fieldValues, new int[]{
                2,4,8,16,
                32,64,128,256,
                512,1024,2048,4096,
                8192,16384,32768,65536
        });
    }

    @Test
    public void testFieldWithProgressive(){
        GameField gameField = new GameField(new StaticProgressiveCellValueFiller(new StaticProgressiveCellValueGenerator()), size);
        //   2     4     8    16
        //  32    64   128   256
        // 512  1024  2048  4096
        //8192 16384 32768 65536
        for (int i = 0; i < 16; i++)
            gameField.fillEntryCell();
        gameField.move(Direction.DOWN);
        String field = gameField.toString();
        Scanner sc = new Scanner(field);
        int[] fieldValues = new int[size*size];
        for (int i=0; sc.hasNextInt(); i++)
            fieldValues[i] = sc.nextInt();
        Assert.assertArrayEquals(fieldValues, new int[]{
                2,4,8,16,
                32,64,128,256,
                512,1024,2048,4096,
                8192,16384,32768,65536
        });
    }

    @Test
    @Ignore
    public void testFieldWithRandom(){
        GameField gameField = new GameField(new RandomCellValueFiller(new RandomCellValueGenerator()), size);
        //?
        //?
        //?
        //?
        for (int i = 0; i < 16; i++)
            gameField.fillEntryCell();
        String field = gameField.toString();
        /*Scanner sc = new Scanner(field);
        int[] fieldValues = new int[size*size];
        for (int i=0; sc.hasNextInt(); i++)
            fieldValues[i] = sc.nextInt();
        Assert.assertArrayEquals(fieldValues, new int[]{
                2,4,8,16,
                32,64,128,256,
                512,1024,2048,4096,
                8192,16384,32768,65536
        });*/
        Assert.assertEquals(field,
                        "    2    4    8   16\n" +
                        "   32   64  128  256\n" +
                        "  512 1024 2048 4096\n" +
                        " 8192163843276865536\n");
    }
}