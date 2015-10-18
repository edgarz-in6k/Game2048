package com.game;

import com.filler.CellValueFiller;

import java.util.*;

public class GameField {

    private CellValueFiller filler;
    private List<ArrayList<GameCell>> cells;
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
                if (getValue(i, j) == 0){
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
        cells = new ArrayList<>();
        for (int row = 0; row < size; row++) {
            cells.add(new ArrayList<>());
            for (int coll = 0; coll < size; coll++) {
                cells.get(row).add(new GameCell());
            }
        }
    }

    public void move(Direction direction) {
        switch (direction) {
            case UP:
                up();
                break;
            case LEFT:
                left();
                break;
            case RIGHT:
                right();
                break;
            case DOWN:
                down();
                break;
        }
    }

    private static final long VALUE_NULL = 0;

    private void up() {
        Queue<Long> line = new ArrayDeque<>();
        for (int j = 0; j < size; j++) {
            for (int i = 0; i <size; i++) {
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
                }
            }

            //plus 1 and 2 element in row
            if (getValue(0, j) == getValue(0 + 1, j)) {
                setValue(0, j, getValue(0 + 1, j) * 2);
                for (int k = 0 + 1; k < size - 1; k++) {
                    setValue(k, j, getValue(k + 1, j));
                }
                setValue(size - 1, j, VALUE_NULL);
            }
        }

        //printer.printToStream(System.out, this);
    }

    private void left() {
        Queue<Long> line = new ArrayDeque<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <size; j++) {
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
                }
            }

            //plus 1 and 2 element in row
            if (getValue(i, 0) == getValue(i, 0 + 1)) {
                setValue(i, 0, getValue(i, 0 + 1) * 2);
                for (int k = 0 + 1; k < size - 1; k++) {
                    setValue(i, k, getValue(i, k + 1));
                }
                setValue(i, size - 1, VALUE_NULL);
            }
        }

        //printer.printToStream(System.out, this);
    }

    private void right() {
        Queue<Long> line = new ArrayDeque<>();
        for (int i = 0; i < size; i++) {
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
                }
            }

            //plus 1 and 2 element in row
            if (getValue(i, size - 1) == getValue(i, size - 1 - 1)) {
                setValue(i, size - 1, getValue(i, size - 1 - 1) * 2);
                for (int k = size - 1 - 1; k >= 1; k--) {
                    setValue(i, k, getValue(i, k - 1));
                }
                setValue(i, 0, VALUE_NULL);
            }
        }

        //printer.printToStream(System.out, this);
    }

    private void down() {
        Queue<Long> line = new ArrayDeque<>();
        for (int j = 0; j < size; j++) {
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
                }
            }

            //plus 1 and 2 element in row
            if (getValue(size - 1, j) == getValue(size - 1 - 1, j)) {
                setValue(size - 1, j, getValue(size - 1 - 1, j) * 2);
                for (int k = size - 1 - 1; k >= 1; k--) {
                        setValue(k, j, getValue(k - 1, j));
                }
                setValue(0, j, VALUE_NULL);
            }
        }

        //printer.printToStream(System.out, this);
    }

    public GameCell getCell(int row, int coll) {
        return cells.get(row).get(coll);
    }

    public long getValue(int row, int coll) {
        return getCell(row, coll).getValue();
    }

    public void setCell(int row, int coll, GameCell cell) {
        cells.get(row).set(coll, cell);
    }

    public void setValue(int row, int coll, long value) {
        cells.get(row).set(coll, new GameCell(value));
    }

    boolean hasAvaliableMoves() {//
        return false;
    }

    boolean hasCellWith2048() {//
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
}
