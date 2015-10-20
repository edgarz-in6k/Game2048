package com.game;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameCellTest {

    private GameCell gameCell;

    @Before
    public void setUp() throws Exception {
        gameCell = new GameCell();
    }

    @Test
    public void testDefaultConstructor() {
        assertEquals(gameCell.getValue(), 0);
    }

    @Test
    public void testConstructorWithArgument() {
        GameCell gameCell = new GameCell(5);
        assertEquals(gameCell.getValue(), 5);
    }

    @Test
    public void testSetter() {
        gameCell.setValue(9);
        assertEquals(gameCell.getValue(), 9);
    }

    @Test
    public void testIsEmpty(){
        assertTrue(gameCell.isEmpty());
    }

    @Test
    public void testEqualsCells(){
        GameCell cellOne = new GameCell(5);
        GameCell cellTwo = new GameCell(5);
        assertTrue(cellOne.equals(cellTwo));

        cellTwo.setValue(6);
        assertFalse(cellOne.equals(cellTwo));
    }
}