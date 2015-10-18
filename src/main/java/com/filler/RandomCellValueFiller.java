package com.filler;

import com.game.GameCell;
import com.generator.CellValueGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomCellValueFiller implements CellValueFiller {

    private List<ArrayList<GameCell>> cells;
    private int size;

    @Override
    public void fillEntryCell() {
        Random random = new Random();
        int randomRow = random.nextInt(size);
        int randomColl = random.nextInt(size);
        while (cells.get(randomRow).get(randomColl).getValue() != 0) {
            randomRow = random.nextInt(size);
            randomColl = random.nextInt(size);
        }
        cells.get(randomRow).set(randomColl, new GameCell(twoOrFour()));
    }

    private long twoOrFour() {
        return (new Random().nextInt(2)*2+2);
    }

    @Override
    public void setCells(List<ArrayList<GameCell>> cells) {
        this.cells = cells;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }
}
