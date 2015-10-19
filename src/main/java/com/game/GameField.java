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
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (getValue(i, j) == 0) {
                    emptyCell.add(getCell(i, j));
                }
            }
        }
        if (!emptyCell.isEmpty())
            filler.fillEntryCell(emptyCell);
    }

    private GameCell twoOrFour() {
        Random random = new Random();
        int value = random.nextInt(100);
        if (value < 90)
            return new GameCell(2);
        else
            return new GameCell(4);
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
        for (int i = 0; i < size * size; i++)
            cells.add(new GameCell());
    }

    public boolean move(Direction direction) {
        switch (direction) {
            case UP: return up();
            case LEFT: return left();
            case RIGHT: return right();
            case DOWN: return down();
        }
        return false;
    }

    private static final long VALUE_NULL = 0;

    private void upsideDown() {
        for (int i = 0; i < size / 2; i++) {
            for (int j = 0; j < size; j++) {
                long valueTemp = getValue(i, j);
                setValue(size - 1 - i, j, valueTemp);
                System.out.println(valueTemp);
            }
        }
    }

    private boolean up() {
        boolean moved = false;
        boolean direct;
        Queue<Long> line = new ArrayDeque<>();
        for (int j = 0; j < size; j++) {

            direct = false;

            for (int i = 0; i < size; i++) {
                //element in row != 0
                if (getValue(i, j) != 0)
                    line.add(getValue(i, j));
                //set 0 in row
                setValue(i, j, VALUE_NULL);
            }

            //set queue with begin
            for (int i = 0; i < size && !line.isEmpty(); i++) {
                setValue(i, j, line.poll());
            }

            //plus element
            for (int i = 0; i < size - 1; i++) {
                if (getValue(i, j) == getValue(i + 1, j)) {
                    setValue(i, j, getValue(i + 1, j) * 2);
                    for (int k = i + 1; k < size - 1; k++) {
                        setValue(k, j, getValue(k + 1, j));
                    }
                    setValue(size - 1, j, VALUE_NULL);
                    score += getValue(i, j);
                    direct = true;
                    moved = true;
                }
            }

            //plus 1 and 2 element in row
            if (!direct && getValue(0, j) == getValue(0 + 1, j)) {
                setValue(0, j, getValue(0 + 1, j) * 2);
                for (int k = 0 + 1; k < size - 1; k++) {
                    setValue(k, j, getValue(k + 1, j));
                }
                setValue(size - 1, j, VALUE_NULL);
                score += getValue(0, j);
                moved = true;
            }
        }
        return moved;
    }

    private boolean left() {
        boolean moved = false;
        boolean direct;
        Queue<Long> line = new ArrayDeque<>();
        for (int i = 0; i < size; i++) {

            direct = false;

            for (int j = 0; j < size; j++) {
                //element in row != 0
                if (getValue(i, j) != 0)
                    line.add(getValue(i, j));
                //set 0 in row
                setValue(i, j, VALUE_NULL);
            }

            //set queue with begin
            for (int j = 0; j < size && !line.isEmpty(); j++) {
                setValue(i, j, line.poll());
            }

            //plus element
            for (int j = 0; j < size - 1; j++) {
                if (getValue(i, j) == getValue(i, j + 1)) {
                    setValue(i, j, getValue(i, j + 1) * 2);
                    for (int k = j + 1; k < size - 1; k++) {
                        setValue(i, k, getValue(i, k + 1));
                    }
                    setValue(i, size - 1, VALUE_NULL);
                    score += getValue(i, j);
                    direct = true;
                    moved = true;
                }
            }

            //plus 1 and 2 element in row
            if (!direct && getValue(i, 0) == getValue(i, 0 + 1)) {
                setValue(i, 0, getValue(i, 0 + 1) * 2);
                for (int k = 0 + 1; k < size - 1; k++) {
                    setValue(i, k, getValue(i, k + 1));
                }
                setValue(i, size - 1, VALUE_NULL);
                score += getValue(i, 0);
                moved = true;
            }
        }
        return moved;
    }

    private boolean right() {
        boolean moved = false;
        boolean direct;
        Queue<Long> line = new ArrayDeque<>();
        for (int i = 0; i < size; i++) {

            direct = false;

            for (int j = size - 1; j >= 0; j--) {
                //element in row != 0
                if (getValue(i, j) != 0)
                    line.add(getValue(i, j));
                //set 0 in row
                setValue(i, j, VALUE_NULL);
            }

            //set queue with begin
            for (int j = size - 1; j >= 0 && !line.isEmpty(); j--) {
                setValue(i, j, line.poll());
            }

            //plus element
            for (int j = size - 1; j >= 1; j--) {
                if (getValue(i, j) == getValue(i, j - 1)) {
                    setValue(i, j, getValue(i, j - 1) * 2);
                    for (int k = j - 1; k >= 1; k--) {
                        setValue(i, k, getValue(i, k - 1));
                    }
                    setValue(i, 0, VALUE_NULL);
                    score += getValue(i, j);
                    direct = true;
                    moved = true;
                }
            }

            //plus 1 and 2 element in row
            if (!direct && getValue(i, size - 1) == getValue(i, size - 1 - 1)) {
                setValue(i, size - 1, getValue(i, size - 1 - 1) * 2);
                for (int k = size - 1 - 1; k >= 1; k--) {
                    setValue(i, k, getValue(i, k - 1));
                }
                setValue(i, 0, VALUE_NULL);
                score += getValue(i, size - 1);
                moved = true;
            }
        }
        return moved;
    }

    private boolean down() {
        boolean moved = false;
        boolean direct;
        Queue<Long> line = new ArrayDeque<>();
        for (int j = 0; j < size; j++) {

            direct = false;

            for (int i = size - 1; i >= 0; i--) {
                //element in row != 0
                if (getValue(i, j) != 0)
                    line.add(getValue(i, j));
                //set 0 in row
                setValue(i, j, VALUE_NULL);
            }

            //set queue with begin
            for (int i = size - 1; i >= 0 && !line.isEmpty(); i--) {
                setValue(i, j, line.poll());
            }

            //plus element
            for (int i = size - 1; i >= 1; i--) {
                if (getValue(i, j) == getValue(i - 1, j)) {
                    setValue(i, j, getValue(i - 1, j) * 2);
                    for (int k = i - 1; k >= 1; k--) {
                        setValue(k, j, getValue(k - 1, j));
                    }
                    setValue(0, j, VALUE_NULL);
                    score += getValue(i, j);
                    direct = true;
                    moved = true;
                }
            }

            //plus 1 and 2 element in row
            if (!direct && getValue(size - 1, j) == getValue(size - 1 - 1, j)) {
                setValue(size - 1, j, getValue(size - 1 - 1, j) * 2);
                for (int k = size - 1 - 1; k >= 1; k--) {
                    setValue(k, j, getValue(k - 1, j));
                }
                setValue(0, j, VALUE_NULL);
                score += getValue(size - 1, j);
                moved = true;
            }
        }
        return moved;
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

    public boolean hasAvailableMoves() {//
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (hasNeighbor(i, j))
                    return true;
            }
        }
        return false;
    }

    private boolean hasNeighbor(int i, int j) {
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

    boolean hasCellWith2048() {//
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
