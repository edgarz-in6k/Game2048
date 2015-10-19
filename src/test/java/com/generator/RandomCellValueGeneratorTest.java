package com.generator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RandomCellValueGeneratorTest {
    @Test
    public void testFieldWithRandom() {
        CellValueGenerator generator = new RandomCellValueGenerator();
        long number = generator.getNumber();
        assertEquals(number == 2 || number == 4, true);
        number = generator.getNumber();
        assertEquals(number == 2 || number == 4, true);
        number = generator.getNumber();
        assertEquals(number == 2 || number == 4, true);
        number = generator.getNumber();
        assertEquals(number == 2 || number == 4, true);
        number = generator.getNumber();
        assertEquals(number == 2 || number == 4, true);
    }
}
