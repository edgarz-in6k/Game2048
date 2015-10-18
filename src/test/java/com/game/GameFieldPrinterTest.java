package com.game;

import com.filler.StaticCellValueFiller;
import com.generator.StaticCellValueGenerator;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class GameFieldPrinterTest {
    @Test
    @Ignore
    public void testOutput(){
        GameFieldPrinter printer = new GameFieldPrinter();
        GameField gameField = new GameField(new StaticCellValueFiller(new StaticCellValueGenerator()), 4);
        gameField.fillEntryCell();
        gameField.fillEntryCell();
        String output = printer.outputANSI(gameField);
        Assert.assertEquals(output,
                        "     2     2     0     0\n" +
                        "     0     0     0     0\n" +
                        "     0     0     0     0\n" +
                        "     0     0     0     0\n");
    }
}
