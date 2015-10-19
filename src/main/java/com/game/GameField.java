package com.game;

import com.filler.CellValueFiller;

import java.util.*;

public class GameField {

    private CellValueFiller filler;
    //private List<ArrayList<GameCell>> cells;
    private List<GameCell> cells;
    private int size;
    private int score;

    public GameField(CellValueFiller filler, int size) {
        this.filler = filler;
        this.size = size;
        score = 0;
        createCells(size);
        filler.setSize(size);
    }

    public void fillEntryCell() {
        List<GameCell> emptyCell = new ArrayList<>();
        for (int row = 0; row < size; row++) {
            for (int coll = 0; coll < size; coll++) {
                if (getValue(row, coll) == 0) {
                    emptyCell.add(getCell(row, coll));
                }
            }
        }
        if (!emptyCell.isEmpty())
            filler.fillEntryCell(emptyCell);
    }

    private void createCells(int size) {
        /*cells = new ArrayList<>();
        for (int row = 0; row < size; row++) {
            cells.add(new ArrayList<>());
            for (int coll = 0; coll < size; coll++) {
                cells.get(row).add(new GameCell());
            }
        }*/
        cells = new ArrayList<>();
        for (int row = 0; row < size * size; row++)
            cells.add(new GameCell());
    }

    public boolean move(Direction direction) {
        switch (direction) {
            case UP: return up();
            case LEFT: return left();
            case RIGHT: return right();
            case DOWN: return down();
            default: return false;
        }
    }

    private static final long VALUE_NULL = 0;

    private void upsideDown() {
        for (int row = 0; row < size / 2; row++) {
            for (int coll = 0; coll < size; coll++) {
                long valueTemp = getValue(row, coll);
                setValue(row, coll, getValue(size - 1 - row, coll));
                setValue(size - 1 - row, coll, valueTemp);
            }
        }
    }

    private void clockwise() {
        List<GameCell> cellsTemp = new ArrayList<>();//size * size
        for (int row = 0; row < size * size; row++) {
            cellsTemp.add(null);
        }
        for (int coll = 0; coll < size; coll++) {
            for (int row = 0; row < size; row++) {
                cellsTemp.set(coll * size + (size - 1 - row), getCell(row, coll));
            }
        }
        cells = cellsTemp;
    }

    private void anticlockwise() {
        List<GameCell> cellsTemp = new ArrayList<>();//size * size
        for (int row = 0; row < size * size; row++) {
            cellsTemp.add(null);
        }
        for (int row = 0; row < size; row++) {
            for (int coll = 0; coll < size; coll++) {
                cellsTemp.set((size - 1 - coll) * size + row, getCell(row, coll));
            }
        }
        cells = cellsTemp;
    }

    private boolean moved;
    private boolean up() {
        moved = false;
        Queue<Long> line = new ArrayDeque<>();
        for (int coll = 0; coll < size; coll++) {

            addCellFillInQueue(line, coll);

            setNullRow(coll);

            pollQueueInRow(line, coll);

            plusCell(coll);
        }
        return moved;
    }

    private void addCellFillInQueue(Queue<Long> line, int coll) {
        for (int row = 0; row < size; row++) {
            if (getValue(row, coll) != 0)
                line.add(getValue(row, coll));
        }
    }

    private void setNullRow(int coll) {
        for (int row = 0; row < size; row++)
            setValue(row, coll, VALUE_NULL);
    }

    private void pollQueueInRow(Queue<Long> line, int coll) {
        for (int row = 0; row < size && !line.isEmpty(); row++) {
            setValue(row, coll, line.poll());
        }
    }

    private void plusCell(int coll) {
        for (int row = 0; row < size - 1; row++) {
            adding(row, coll);
        }
    }

    private void adding(int row, int coll) {
        if (getValue(row, coll) == getValue(row + 1, coll)) {
            setValue(row, coll, getValue(row + 1, coll) * 2);
            for (int k = row + 1; k < size - 1; k++) {
                setValue(k, coll, getValue(k + 1, coll));
            }
            setValue(size - 1, coll, VALUE_NULL);
            score += getValue(row, coll);
            moved = true;
        }
    }

    private boolean left() {
        clockwise();
        boolean result = up();
        anticlockwise();
        return result;
    }

    private boolean right() {
        anticlockwise();
        boolean result = up();
        clockwise();
        return result;
    }

    private boolean down() {
        upsideDown();
        boolean result = up();
        upsideDown();
        return result;
    }

    private GameCell getCell(int row, int coll) {
        //return cells.get(row).get(coll);
        return cells.get(row * size + coll);
    }

    public long getValue(int row, int coll) {
        return getCell(row, coll).getValue();
    }

    private void setValue(int row, int coll, long value) {
        //cells.get(row).set(coll, new GameCell(value));
        cells.get(row * size + coll).setValue(value);
    }

    public boolean hasAvailableMoves() {
        for (int row = 0; row < size; row++) {
            for (int coll = 0; coll < size; coll++) {
                if (isNeighborNotNull(row, coll))
                    return true;
            }
        }
        return false;
    }

    private boolean isNeighborNotNull(int i, int j) {
        for (int row = i - 1; row < i + 1; row++) {
            for (int coll = j - 1; coll < j + 1; coll++) {
                if (row == i || coll == j || (row < 0 || row >= size || coll < 0 || coll >= size))
                    continue;
                if (getValue(i, j) == getValue(row, coll))
                    return true;
            }
        }
        return false;
    }

    boolean hasCellWith2048() {
        for (GameCell gameCell : cells) {
            if (gameCell.getValue() == LayoutCell.TWO_THOUSAND_AND_FORTY_EIGHT.value)
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String result = "";
        for (int row = 0; row < size; row++) {
            for (int coll = 0; coll < size; coll++) {
                result += String.format("%6s", getValue(row, coll));//getValue(row, coll) + " ";
            }
            result += "\n";
        }
        return result;
    }

    public int size() {
        return size;
    }

    public long getScore() {
        return score;
    }
}