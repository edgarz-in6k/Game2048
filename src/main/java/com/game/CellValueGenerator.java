package com.game;

import java.util.ArrayList;
import java.util.List;

public interface CellValueGenerator {
    void fillEntryCell();

    void setCells(List<ArrayList<GameCell>> cells);

    void setSize(int size);
}