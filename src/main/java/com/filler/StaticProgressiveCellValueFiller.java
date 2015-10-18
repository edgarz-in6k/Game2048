package com.filler;

import com.game.GameCell;

import java.util.ArrayList;
import java.util.List;

public class StaticProgressiveCellValueFiller implements CellValueFiller {

    private List<ArrayList<GameCell>> cells;
    private int size;
    private static long val = 2;

    @Override
    public void fillEntryCell() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cells.get(i).get(j).getValue() == 0){//getValue(i, j)
                    cells.get(i).set(j, new GameCell(val)); //setValue(i, j, 2);
                    val *= 2;
                    return;
                }
            }
        }
    }

    @Override
    public void setCells(List<ArrayList<GameCell>> cells) {
        val = 2;
        this.cells = cells;
    }

    @Override
    public void setSize(int size) {
        val = 2;
        this.size = size;
    }
}
