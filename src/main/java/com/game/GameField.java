package com.game;

import java.util.*;

public class GameField {

    private CellValueGenerator generator;
    private List<ArrayList<GameCell>> cells;
    private int size;
    private int score;

    public GameField(CellValueGenerator generator, int size) {
        this.generator = generator;
        this.size = size;
        score = 0;
        createCells(size);
        generator.setCells(cells);
        generator.setSize(size);
    }

    public void fillEntryCell() {
        /*Random random = new Random();
        int randomRow = random.nextInt(size);
        int randomColl = random.nextInt(size);
        while (cells.get(randomRow).get(randomColl).getValue() != 0) {
            randomRow = random.nextInt(size);
            randomColl = random.nextInt(size);
        }
        setCell(randomRow, randomColl, twoOrFour());*/
        /*for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (getValue(i, j) == 0){
                    setValue(i, j, 2);
                    return;
                }
            }
        }*/
        generator.fillEntryCell();
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

    private void up() {
        System.out.println("up");

    }

    private void left() {
        System.out.println("left");
    }

    private void right() {
        System.out.println("right");
    }

    private void down() {
        //System.out.println("down");
        //List<Integer> line = new ArrayList<>();
        Queue<Integer> line = new ArrayDeque<>();
        for (int j = 0; j < size; j++) {
            for (int i = size - 1; i >= 0; i--) {
                if (getValue(i, j) != 0)
                    line.add(getValue(i, j));
            }

            for (int i = size - 1; i >= 0; i--) {
                setValue(i, j, 0);
            }

            for (int i = size - 1; i >= 0 && !line.isEmpty(); i--) {
                setValue(i, j, line.poll());
            }

            for (int i = size - 1; i >= 1; i--) {
                //System.out.println("=================== i: " + i);
                if (getValue(i, j) == getValue(i - 1, j)) {
                    for (int k = i; k >= 1; k--) {
                        if (k == i)
                            setValue(k, j, getValue(k - 1, j) * 2);
                        else
                            setValue(k, j, getValue(k - 1, j));
                    }
                    setValue(size - 4, j, 0);
                }


            }
            //System.out.println("=================== end");

            /*if (getValue(size - 1, j) == getValue(size - 2, j)) {
                for (int k = size - 1; k >= 1; k--) {
                    if (k == size - 1)
                        setValue(k, j, getValue(k - 1, j) * 2);
                    else
                        setValue(k, j, getValue(k - 1, j));
                }
                setValue(size - 4, j, 0);
            }
            if (getValue(size - 2, j) == getValue(size - 3, j)) {
                for (int k = size - 2; k >= 1; k--) {
                    if (k == size - 2)
                        setValue(k, j, getValue(k - 1, j) * 2);
                    else
                        setValue(k, j, getValue(k - 1, j));
                }
                setValue(size - 4, j, 0);
            }
            if (getValue(size - 3, j) == getValue(size - 4, j)) {
                for (int k = size - 3; k >= 1; k--) {
                    if (k == size - 3)
                        setValue(k, j, getValue(k - 1, j) * 2);
                    else
                        setValue(k, j, getValue(k - 1, j));
                }
                setValue(size - 4, j, 0);
            }*/

            if (getValue(size - 1, j) == getValue(size - 2, j)) {
                for (int k = size - 1; k >= 1; k--) {
                    if (k == size - 1)
                        setValue(k, j, getValue(k - 1, j) * 2);
                    else
                        setValue(k, j, getValue(k - 1, j));
                }
                setValue(size - 4, j, 0);
            }
        }
        //printer.printToStream(System.out, this);
    }

    public GameCell getCell(int row, int coll) {
        return cells.get(row).get(coll);
    }

    public int getValue(int row, int coll) {
        return getCell(row, coll).getValue();
    }

    public void setCell(int row, int coll, GameCell cell) {
        cells.get(row).set(coll, cell);
    }

    public void setValue(int row, int coll, int value) {
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
                result += getValue(row, coll) + " ";
            }
            result += "\n";
        }
        return result;
    }
}
