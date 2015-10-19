package com.filler;

import com.game.GameCell;
import com.generator.CellValueGenerator;

import java.util.List;
import java.util.Random;

public class RandomCellValueFiller implements CellValueFiller {

    private CellValueGenerator generator;
    private int size;

    public RandomCellValueFiller(CellValueGenerator generator) {
        this.generator = generator;
    }

    @Override
    public void fill(List<GameCell> emptyCell) {
        Random random = new Random();
        int randomIndex = random.nextInt(emptyCell.size());
        while (emptyCell.get(randomIndex).getValue() != 0) {
            randomIndex = random.nextInt(emptyCell.size());
        }
        emptyCell.get(randomIndex).setValue(generator.getNumber());
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }
}