package com.game;

import com.filler.CellValueFiller;

import java.util.*;
import java.util.stream.Collectors;

public class GameField implements GameFieldInterface {

    private static final String NEW_LINE = "\n";
    private static final long VALUE_NULL = 0;

    private CellValueFiller filler;
    private List<GameCell> cells;
    private int size;
    private int score;

    public GameField(CellValueFiller filler, int size) {
        this.filler = filler;
        this.size = size;
        this.score = 0;
        createCells(size);
    }

    @Override
    public void fillEmptyCell() {
        filler.fill(
                cells.stream().filter(GameCell::isEmpty).collect(Collectors.toList())
        );
    }

    private void createCells(int size) {
        cells = new ArrayList<>();
        for (int i = 0; i < size * size; i++)
            cells.add(new GameCell());
    }

    @Override
    public boolean move(Direction direction) {
        switch (direction) {
            case UP:
                return up();
            case LEFT:
                return left();
            case RIGHT:
                return right();
            case DOWN:
                return down();
            default:
                throw new UnsupportedOperationException();
        }
    }

    private void upsideDownField() {
        for (int row = 0; row < size / 2; row++) {
            for (int col = 0; col < size; col++) {
                long valueTemp = getCell(row, col).getValue();
                getCell(row, col).setValue(getCell(size - 1 - row, col).getValue());
                getCell(size - 1 - row, col).setValue(valueTemp);
            }
        }
    }

    private void clockwiseRotateField() {
        List<GameCell> cellsTemp = new ArrayList<>();//size * size
        for (int row = 0; row < size * size; row++) {
            cellsTemp.add(null);
        }
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                cellsTemp.set(col * size + (size - 1 - row), getCell(row, col));
            }
        }
        cells = cellsTemp;
    }

    private void anticlockwiseRotateField() {
        List<GameCell> cellsTemp = new ArrayList<>();//size * size
        for (int row = 0; row < size * size; row++) {
            cellsTemp.add(null);
        }
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                cellsTemp.set((size - 1 - col) * size + row, getCell(row, col));
            }
        }
        cells = cellsTemp;
    }

    private boolean moved;

    private boolean up() {
        moved = false;
        Queue<Long> line = new ArrayDeque<>();
        for (int col = 0; col < size; col++) {

            addCellFillInQueue(line, col);

            cleanColumn(col);

            pollQueueInColumn(line, col);

            plusCell(col);
        }
        return moved;
    }

    private void addCellFillInQueue(Queue<Long> line, int col) {
        int countLastNUll = 0;
        for (int row = 0; row < size; row++) {
            GameCell cell = getCell(row, col);
            if (!cell.isEmpty())
                line.add(cell.getValue());
        }
        for (int row = size - 1; row >= 0; row--) {
            if (getCell(row, col).isEmpty())
                countLastNUll++;
            else
                break;
        }
        //System.out.println(line.size() + " " + countLastNUll + " " + size);
        if (!(line.size() + countLastNUll == size))
            moved = true;
    }

    private void cleanColumn(int col) {
        for (int row = 0; row < size; row++)
            getCell(row, col).setValue(VALUE_NULL);
    }

    private void pollQueueInColumn(Queue<Long> line, int col) {
        for (int row = 0; row < size && !line.isEmpty(); row++) {
            getCell(row, col).setValue(line.poll());
        }
    }

    private void plusCell(int col) {
        for (int row = 0; row < size - 1; row++) {
            adding(row, col);
        }
    }

    private void adding(int row, int col) {
        GameCell cell = getCell(row, col);
        GameCell cell1 = getCell(row + 1, col);
        if (cell.getValue() == cell1.getValue()) {
            cell.setValue(cell1.getValue() * 2);
            for (int k = row + 1; k < size - 1; k++) {
                getCell(k, col).setValue(getCell(k + 1, col).getValue());
            }
            getCell(size - 1, col).setValue(VALUE_NULL);
            score += cell.getValue();
            moved = true;
        }
    }

    private boolean left() {
        clockwiseRotateField();
        boolean result = up();
        anticlockwiseRotateField();
        return result;
    }

    private boolean right() {
        anticlockwiseRotateField();
        boolean result = up();
        clockwiseRotateField();
        return result;
    }

    private boolean down() {
        upsideDownField();
        boolean result = up();
        upsideDownField();
        return result;
    }

    @Override
    public boolean hasAvailableMoves() {
        return hasNullCell() || hasNeighborSame();
    }

    private boolean hasNullCell() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (getCell(row, col).isEmpty())
                    return true;
            }
        }
        return false;
    }

    private boolean hasNeighborSame() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if  (isUpNeighborSame(row, col) ||
                        isLeftNeighborSame(row, col) ||
                        isRightNeighborSame(row, col) ||
                        isDownNeighborSame(row, col))
                    return true;
            }
        }
        return false;
    }

    private boolean isUpNeighborSame(int row, int col) {
        //System.out.println("hasNeighborSame (row + 1 < size): ");
        return ((row + 1 < size) && (getCell(row + 1, col).equals(getCell(row, col))));
    }

    private boolean isRightNeighborSame(int row, int col) {
        return (col + 1 < size) && getCell(row, col + 1).equals(getCell(row, col));
    }

    private boolean isLeftNeighborSame(int row, int col) {
        return (col - 1 >= 0) && getCell(row, col - 1).equals(getCell(row, col));
    }

    private boolean isDownNeighborSame(int row, int col) {
        return (row - 1 >= 0) && getCell(row - 1, col).equals(getCell(row, col));
    }

    @Override
    public boolean hasCellWith2048() {
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
            for (int col = 0; col < size; col++) {
                result += String.format("%6s", getCell(row, col).getValue());
            }
            result += NEW_LINE;
        }
        return result;
    }

    public GameCell getCell(int row, int col) {
        return cells.get(row * size + col);
    }

    public long getScore() {
        return score;
    }

    public long[] getArray() {
        long[] array = new long[size * size];
        for (int i = 0; i < array.length; i++) {
            array[i] = getCell(i / size, i % size).getValue();
        }
        return array;
    }

    public void setArray(long[] array){
        for (int i = 0; i < size * size; i++) {
            getCell(i / size, i % size).setValue(array[i]);
        }
    }
}