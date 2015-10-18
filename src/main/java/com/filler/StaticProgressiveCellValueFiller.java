package com.filler;

import com.game.GameCell;
import com.generator.CellValueGenerator;

import java.util.List;

public class StaticProgressiveCellValueFiller implements CellValueFiller {

    private CellValueGenerator generator;
    private int size;

    public StaticProgressiveCellValueFiller(CellValueGenerator generator) {
        this.generator = generator;
    }

    @Override
    public void fillEntryCell(List<GameCell> emptyCell) {
        for (int i = 0; i < size; i++) {
            if (emptyCell.get(i).getValue() == 0){
                emptyCell.get(i).setValue(generator.getNumber());
                return;
            }
        }
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }
}
