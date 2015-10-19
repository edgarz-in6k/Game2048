package com.game;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameCellTest {
    @Test
    public void testDefaultConstructor() {
        GameCell gameCell = new GameCell();
        assertEquals(gameCell.getValue(), 0);
    }

    @Test
    public void testConstructorWithArgument() {
        GameCell gameCell = new GameCell(5);
        assertEquals(gameCell.getValue(), 5);
    }

    @Test
    public void testSetter() {
        GameCell gameCell = new GameCell();
        gameCell.setValue(9);
        assertEquals(gameCell.getValue(), 9);
    }
}
