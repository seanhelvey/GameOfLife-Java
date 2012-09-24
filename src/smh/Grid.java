package smh;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: seanhelvey
 * Date: 9/23/12
 * Time: 11:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class Grid {

    private static final int[][] BEGINNING_SPACES =
            new int[][] {{0,0,0,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,0,0,0}};

    private static int[][] spaces;
    private static int[][] outSpaces;

    public Grid(){
        //setSpaces(BEGINNING_SPACES);
        setSpaces(BEGINNING_SPACES);
        setOutSpaces(new int[][] {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}});

        //crude tests
        System.out.println(isDefined(0,4) + " true");
        System.out.println(isDefined(5,0) + " false");
        System.out.println(isAlive(1,2) + " true");
        System.out.println(isAlive(1,1) + " false");
        System.out.println(determineCellLife(0, 0) + " false");
        System.out.println(determineCellLife(2, 2) + " true");
        System.out.println(updateNeighborCount(0,0,0) + " 0");
        System.out.println(updateNeighborCount(2,2,0) + " 1");
        System.out.println(checkNeighbors(0,0) + " 0");
        System.out.println(checkNeighbors(2,2) + " 2");
        int[][] spacesCopy = new int[][] {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
        System.out.println(Arrays.deepEquals(getSpaces(), spacesCopy) + " false");
        copyValues(spacesCopy, getSpaces());
        System.out.println(Arrays.deepEquals(getSpaces(), spacesCopy) + " true");
        int[][] spacesTest = new int[][] {{0,0,0,0,0},{0,0,0,0,0},{0,1,1,1,0},{0,0,0,0,0},{0,0,0,0,0}};
        System.out.println(Arrays.deepEquals(getSpaces(), spacesTest) + " false");
        evolve();
        System.out.println(Arrays.deepEquals(getSpaces(), spacesTest) + " true");
    }

    private int[][] getSpaces(){
        return spaces;
    }

    private void setSpaces(int[][] newSpaces){
        spaces = newSpaces;
    }

    private int[][] getOutSpaces(){
        return outSpaces;
    }

    private void setOutSpaces(int[][] newOutSpaces){
        outSpaces = newOutSpaces;
    }

    public void evolve(){
        for (int i = 0; i < getSpaces().length; i++) {
            for (int j = 0; j < getSpaces()[0].length; j++) {
                if(determineCellLife(i, j)){
                    getOutSpaces()[i][j] = 1;
                }
                else{
                    getOutSpaces()[i][j] = 0;
                }
            }
        }
        copyValues(getSpaces(), getOutSpaces());
    }

    private void copyValues(int[][] table, int[][] outTable){
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                table[i][j] = outTable[i][j];
            }
        }
    }

    private int checkNeighbors(int row, int col){
        int testRow;
        int testCol;
        int count = 0;

        //check above left
        testRow = row-1;
        testCol = col-1;
        count = updateNeighborCount(testRow, testCol, count);

        //check above
        testRow = row-1;
        testCol = col;
        count = updateNeighborCount(testRow, testCol, count);

        //check above right
        testRow = row-1;
        testCol = col+1;
        count = updateNeighborCount(testRow, testCol, count);

        //check right
        testRow = row;
        testCol = col+1;
        count = updateNeighborCount(testRow, testCol, count);

        //check lower right
        testRow = row+1;
        testCol = col+1;
        count = updateNeighborCount(testRow, testCol, count);

        //check below
        testRow = row+1;
        testCol = col;
        count = updateNeighborCount(testRow, testCol, count);

        //check lower left
        testRow = row+1;
        testCol = col-1;
        count = updateNeighborCount(testRow, testCol, count);

        //check left
        testRow = row;
        testCol = col-1;
        count = updateNeighborCount(testRow, testCol, count);

        return count;
    }

    private int updateNeighborCount(int row, int col, int count){
        if(isDefined(row, col) && isAlive(row, col)){
            count++;
        }
        return count;
    }

    private boolean determineCellLife(int i, int j){
        int currentValue = getSpaces()[i][j];
        int numNeighbors = checkNeighbors(i, j);

        //under population
        if(currentValue == 1 && numNeighbors < 2){
            return false;
        }
        //survival
        else if(currentValue == 1 && (numNeighbors == 2 || numNeighbors == 3)){
            return true;
        }
        //overcrowding
        else if(currentValue == 1 && numNeighbors > 3){
            return false;
        }
        //reproduction
        else if(currentValue == 0 && numNeighbors == 3){
            return true;
        }
        return false;
    }

    private boolean isAlive(int row, int col){
        if(getSpaces()[row][col] == 1){
            return true;
        }
        return false;
    }

    private boolean isDefined(int row, int col){
        if(row < 0 || col < 0){
            return false;
        }
        else if( row > getSpaces().length - 1 || col > getSpaces()[0].length - 1 ){
            return false;
        }
            return true;
    }

    @Override public String toString(){
        System.out.println("toString called");
        String returnVal = "";
        for(int[] row : getSpaces()){
            for(int num : row){
                returnVal += num;
            }
            returnVal += "\n";
        }
       return returnVal;
    }

}
