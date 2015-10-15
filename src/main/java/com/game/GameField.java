package com.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameField {
    private List<ArrayList<GameCell>> cells;
    private int size;
    private int score;

    public GameField(int size) {
        this.size = size;
        score = 0;
        createCells(size);
        fillEntryCell();
        fillEntryCell();
    }

    public void fillEntryCell() {
        Random random = new Random();
        int randomRow = random.nextInt(size);
        int randomColl = random.nextInt(size);
        while (cells.get(randomRow).get(randomColl).getValue() != 0) {
            randomRow = random.nextInt(size);
            randomColl = random.nextInt(size);
        }
        setCell(randomRow, randomColl, twoOrFour());
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
        for (int row=0; row<size; row++){
            cells.add(new ArrayList<GameCell>());
            for (int coll = 0; coll < size; coll++) {
                cells.get(row).add(new GameCell());
            }
        }
    }

    public int[] getArrayField(){
        int[] result = new int[size*size];
        for (int row = 0; row < size; row++) {
            for (int coll = 0; coll < size; coll++) {
                result[row*size+coll] = cells.get(row).get(coll).getValue();
            }
        }
        return result;
    }

    public void move(Direction direction){
        switch (direction){
            case UP: up(); break;
            case LEFT: left(); break;
            case RIGHT: right(); break;
            case DOWN: down(); break;
        }
    }

    public void up() {
        System.out.println("up");
    }

    public void left() {
        System.out.println("left");
    }

    public void right() {
        System.out.println("right");
    }

    public void down() {
        System.out.println("down");
    }

    public GameCell getCell(int row, int coll) {
        return cells.get(row).get(coll);
    }

    public int getValue(int row, int coll) {
        return getCell(row, coll).getValue();
    }

    public void setCell(int row, int coll, GameCell cell){
        cells.get(row).set(coll, cell);
    }

    public void setValue(int row, int coll, int value){
        cells.get(row).set(coll, new GameCell(value));
    }

    boolean hasAvaliableMoves(){//
        return false;
    }

    boolean hasCellWith2048(){//
        return false;
    }
}
