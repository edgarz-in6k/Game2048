package com.game;

import com.filler.RandomCellValueFiller;
import com.filler.StaticCellValueFiller;
import com.filler.StaticProgressiveCellValueFiller;
import com.generator.RandomCellValueGenerator;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class GameFieldTest {

    @Test
    public void testToString(){
        GameField gameField = new GameField(new StaticCellValueFiller(), 4);
        String field = gameField.toString();
        Assert.assertEquals(field,
                        "    0    0    0    0\n" +
                        "    0    0    0    0\n" +
                        "    0    0    0    0\n" +
                        "    0    0    0    0\n");
    }

    @Test
    public void beginGameWithTwoStaticCells() {
        GameField gameField = new GameField(new StaticCellValueFiller(), 4);
        gameField.fillEntryCell();
        gameField.fillEntryCell();
        String field = gameField.toString();
        Assert.assertEquals(field,
                        "    2    2    0    0\n" +
                        "    0    0    0    0\n" +
                        "    0    0    0    0\n" +
                        "    0    0    0    0\n");
    }

    @Test
    public void fullGameWithStaticCells(){
        GameField gameField = new GameField(new StaticCellValueFiller(), 4);
        for (int i = 0; i < 16; i++)
            gameField.fillEntryCell();
        String field = gameField.toString();
        Assert.assertEquals(field,
                        "    2    2    2    2\n" +
                        "    2    2    2    2\n" +
                        "    2    2    2    2\n" +
                        "    2    2    2    2\n");
    }

    @Test
    public void testFieldOneDirectDown() {
        GameField gameField = new GameField(new StaticCellValueFiller(), 4);
        //2222
        //2200
        //0000
        //0000
        for (int i = 0; i < 6; i++)
            gameField.fillEntryCell();
        gameField.move(Direction.DOWN);
        String field = gameField.toString();
        Assert.assertEquals(field,
                        "    0    0    0    0\n" +
                        "    0    0    0    0\n" +
                        "    0    0    0    0\n" +
                        "    4    4    2    2\n");
    }

    @Test
    public void testFieldTwoDirectDown() {
        GameField gameField = new GameField(new StaticCellValueFiller(), 4);
        //2222
        //2222
        //2222
        //2200
        for (int i = 0; i < 14; i++)
            gameField.fillEntryCell();
        gameField.move(Direction.DOWN);
        String field = gameField.toString();
        Assert.assertEquals(field,
                        "    0    0    0    0\n" +
                        "    0    0    0    0\n" +
                        "    0    0    2    2\n" +
                        "    8    8    4    4\n");
    }

    @Test
    public void testFieldWithProgressive(){
        GameField gameField = new GameField(new StaticProgressiveCellValueFiller(), 4);
        //   2     4     8    16
        //  32    64   128   256
        // 512  1024  2048  4096
        //8192 16384 32768 65536
        for (int i = 0; i < 16; i++)
            gameField.fillEntryCell();
        gameField.move(Direction.DOWN);
        String field = gameField.toString();
        Assert.assertEquals(field,
                        "    2    4    8   16\n" +
                        "   32   64  128  256\n" +
                        "  512 1024 2048 4096\n" +
                        " 8192163843276865536\n");
    }

    @Test
    public void testFieldDownNoMove(){
        GameField gameField = new GameField(new StaticProgressiveCellValueFiller(), 4);
        //2 4 8 16
        //32 64 128 256
        //512 1024 2048 4096
        //8192 16384 32768 65536
        for (int i = 0; i < 16; i++)
            gameField.fillEntryCell();
        gameField.move(Direction.DOWN);
        String field = gameField.toString();
        Assert.assertEquals(field,
                        "    2    4    8   16\n" +
                        "   32   64  128  256\n" +
                        "  512 1024 2048 4096\n" +
                        " 8192163843276865536\n");
    }

    @Test
    @Ignore
    public void testFieldWithRandom(){
        GameField gameField = new GameField(new RandomCellValueFiller(), 4);
        //?
        //?
        //?
        //?
        for (int i = 0; i < 16; i++)
            gameField.fillEntryCell();
        String field = gameField.toString();
        Assert.assertEquals(field,
                        "    2    4    8   16\n" +
                        "   32   64  128  256\n" +
                        "  512 1024 2048 4096\n" +
                        " 8192163843276865536\n");
    }
}