package ru.bounegru.logic;

import ru.bounegru.constants.Constants;

import java.util.ArrayList;
import java.util.List;

public class FieldOfGrid {
    private static final FieldOfGrid instance = new FieldOfGrid();
    private List<Integer> occupiedCellsCoordinates = new ArrayList<>();
    private int[][] grid;

    public List<Integer> getOccupiedCellsCoordinates() {
        return occupiedCellsCoordinates;
    }

    private FieldOfGrid() {
        grid = new int[Constants.ROW][Constants.COLUMN];
    }

    public static FieldOfGrid getInstance() {
        return instance;
    }

    //    mark == 1 - obj with collision
    //    mark == 2 - obj w/o collision
    public void markingCell(int y, int x, int mark) {
        grid[y][x] = mark;
        if (mark == 1) {
            occupiedCellsCoordinates.add(y);
            occupiedCellsCoordinates.add(x);
        }

    }

    public boolean isEmpty(int y, int x) {
        return grid[y][x] == 0;
    }

}
