package com.test;

import com.game.GameField;
import org.junit.Assert;
import org.junit.Test;

public class TestJUnit extends GameField{
    public TestJUnit(int size) {
        super(size);
    }

    @Test
    public void testing(){
        String s = "This is test";
        Assert.assertEquals("This is test", s);
    }
}
