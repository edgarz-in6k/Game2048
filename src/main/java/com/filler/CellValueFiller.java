package com.filler;

import com.game.GameCell;

import java.util.ArrayList;
import java.util.List;

public interface CellValueFiller {
    void fillEntryCell();

    void setCells(List<ArrayList<GameCell>> cells);

    void setSize(int size);
}