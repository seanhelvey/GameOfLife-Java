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

    private static int[][] spaces = BEGINNING_SPACES;

    public Grid(){
        System.out.println("Grid constructed");
    }

    public static void display(){
        System.out.println("display called");
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
