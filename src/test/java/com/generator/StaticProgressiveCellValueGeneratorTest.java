package com.generator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StaticProgressiveCellValueGeneratorTest {
    @Test
    public void testGenerate() {
        StaticProgressiveCellValueGenerator generator = new StaticProgressiveCellValueGenerator();
        assertEquals(generator.getNumber(), 2);
        assertEquals(generator.getNumber(), 4);
        assertEquals(generator.getNumber(), 8);
        assertEquals(generator.getNumber(), 16);
        assertEquals(generator.getNumber(), 32);
        assertEquals(generator.getNumber(), 64);
        assertEquals(generator.getNumber(), 128);
        assertEquals(generator.getNumber(), 256);
        assertEquals(generator.getNumber(), 512);
        assertEquals(generator.getNumber(), 1024);
        assertEquals(generator.getNumber(), 2048);
        assertEquals(generator.getNumber(), 4096);
        assertEquals(generator.getNumber(), 8192);
        generator.refresh();
        assertEquals(generator.getNumber(), 2);
        assertEquals(generator.getNumber(), 4);
        assertEquals(generator.getNumber(), 8);
    }
}
