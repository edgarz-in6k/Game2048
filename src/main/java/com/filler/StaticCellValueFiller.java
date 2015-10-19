package com.filler;

import com.game.GameCell;
import com.generator.CellValueGenerator;

import java.util.List;

public class StaticCellValueFiller implements CellValueFiller {

    private CellValueGenerator generator;

    public StaticCellValueFiller(CellValueGenerator generator){
       this.generator = generator;
    }

    @Override
    public void fill(List<GameCell> emptyCell) {
        emptyCell.get(0).setValue(generator.getNumber());
    }
}