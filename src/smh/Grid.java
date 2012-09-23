package smh;

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
