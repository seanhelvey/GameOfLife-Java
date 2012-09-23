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

    public static final int[][] BEGINNING_SPACES =
            new int[][] {{0,0,0,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,0,0,0}};

    private static int[][] spaces;

    public Grid(){
        System.out.println("Grid constructed");
        spaces = BEGINNING_SPACES;

        //crude tests
        System.out.println(isDefined(spaces,0,4));
        System.out.println(isDefined(spaces,5,0));
        System.out.println(isAlive(spaces,1,2));
        System.out.println(isAlive(spaces,1,1));
        System.out.println(updateNeighborCount(spaces,0,0,0));
        System.out.println(updateNeighborCount(spaces,2,2,0));
        System.out.println(checkNeighbors(spaces,0,0,0));
        System.out.println(checkNeighbors(spaces,2,2,0));
        int[][] spacesCopy = new int[][] {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
        System.out.println(Arrays.deepEquals(spaces, spacesCopy));
        copyValues(spaces, spacesCopy);
        System.out.println(Arrays.deepEquals(spaces, spacesCopy));
    }

    /*

    */

    private void copyValues(int[][] table, int[][] outTable){
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                table[i][j] = outTable[i][j];
            }
        }
    }

    private int checkNeighbors(int[][] table, int row, int col, int count){
        int testRow = 0;
        int testCol = 0;

        //check above left
        testRow = row-1;
        testCol = col-1;
        count = updateNeighborCount(table, testRow, testCol, count);

        //check above
        testRow = row-1;
        testCol = col;
        count = updateNeighborCount(table, testRow, testCol, count);

        //check above right
        testRow = row-1;
        testCol = col+1;
        count = updateNeighborCount(table, testRow, testCol, count);

        //check right
        testRow = row;
        testCol = col+1;
        count = updateNeighborCount(table, testRow, testCol, count);

        //check lower right
        testRow = row+1;
        testCol = col+1;
        count = updateNeighborCount(table, testRow, testCol, count);

        //check below
        testRow = row+1;
        testCol = col;
        count = updateNeighborCount(table, testRow, testCol, count);

        //check lower left
        testRow = row+1;
        testCol = col-1;
        count = updateNeighborCount(table, testRow, testCol, count);

        //check left
        testRow = row;
        testCol = col-1;
        count = updateNeighborCount(table, testRow, testCol, count);

        return count;
    }

    private int updateNeighborCount(int[][] table, int row, int col, int count){
        if(isDefined(table, row, col) && isAlive(table, row, col)){
            count++;
        }
        return count;
    }

    private boolean isAlive(int[][] table, int row, int col){
        if(table[row][col] == 1){
            return true;
        }
        return false;
    }

    private boolean isDefined(int[][] table, int row, int col){
        if(row < 0 || col < 0){
            return false;
        }
        else if( row > table.length - 1 || col > table[0].length - 1 ){
            return false;
        }
            return true;
    }

    @Override public String toString(){
        System.out.println("toString called");
        String returnVal = "";
        for(int[] row : spaces){
            for(int num : row){
                returnVal += num;
            }
            returnVal += "\n";
        }
       return returnVal;
    }

}
