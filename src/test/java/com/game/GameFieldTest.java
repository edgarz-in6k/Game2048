package com.game;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class GameFieldTest {

    private GameField gameField;

    @Before
    public void setUp() throws Exception {
        gameField = new GameField(new StaticCellValueGenerator(), 4);
    }

    @Test
    public void testToString(){
        String field = gameField.toString();
        Assert.assertEquals(field,
                        "0 0 0 0 \n" +
                        "0 0 0 0 \n" +
                        "0 0 0 0 \n" +
                        "0 0 0 0 \n");
    }

    @Test
    public void beginGameWithTwoStaticCells() {
        gameField.fillEntryCell();
        gameField.fillEntryCell();
        String field = gameField.toString();
        Assert.assertEquals(field,
                        "2 2 0 0 \n" +
                        "0 0 0 0 \n" +
                        "0 0 0 0 \n" +
                        "0 0 0 0 \n");
    }

    @Test
    public void fullGameWithStaticCells(){
        for (int i = 0; i < 16; i++)
            gameField.fillEntryCell();
        String field = gameField.toString();
        Assert.assertEquals(field,
                        "2 2 2 2 \n" +
                        "2 2 2 2 \n" +
                        "2 2 2 2 \n" +
                        "2 2 2 2 \n");
    }

    @Test
    public void testFieldOneDirectDown() {
        //2222
        //2200
        //0000
        //0000
        for (int i = 0; i < 6; i++)
            gameField.fillEntryCell();
        gameField.move(Direction.DOWN);
        String field = gameField.toString();
        Assert.assertEquals(field,
                        "0 0 0 0 \n" +
                        "0 0 0 0 \n" +
                        "0 0 0 0 \n" +
                        "4 4 2 2 \n");
    }

    @Test
    public void testFieldTwoDirectDown() {
        //2222
        //2222
        //2222
        //2200
        for (int i = 0; i < 14; i++)
            gameField.fillEntryCell();
        gameField.move(Direction.DOWN);
        String field = gameField.toString();
        Assert.assertEquals(field,
                        "0 0 0 0 \n" +
                        "0 0 0 0 \n" +
                        "0 0 2 2 \n" +
                        "8 8 4 4 \n");
    }

    @Test
    @Ignore
    public void testFieldDownNoMove(){
        //16 16 16 16
        //8888
        //4444
        //2222
        for (int i = 0; i < 14; i++)
            gameField.fillEntryCell();
        gameField.move(Direction.DOWN);
        String field = gameField.toString();
        Assert.assertEquals(field,
                        "0 0 0 0 \n" +
                        "0 0 0 0 \n" +
                        "0 0 2 2 \n" +
                        "8 8 4 4 \n");
    }
}