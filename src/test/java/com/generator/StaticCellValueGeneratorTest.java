package com.generator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StaticCellValueGeneratorTest {
    @Test
    public void testGenerate() {
        CellValueGenerator generator = new StaticCellValueGenerator();
        assertEquals(generator.getNumber(), 2);
        assertEquals(generator.getNumber(), 2);
        assertEquals(generator.getNumber(), 2);
        assertEquals(generator.getNumber(), 2);
        assertEquals(generator.getNumber(), 2);
    }
}
