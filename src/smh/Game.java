package smh;

/**
 * Created with IntelliJ IDEA.
 * User: seanhelvey
 * Date: 9/23/12
 * Time: 11:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class Game {

    private static Grid grid;

    public Game(){
        setGrid(new Grid());
    }

    private Grid getGrid(){
        return grid;
    }

    private void setGrid(Grid newGrid){
        grid = newGrid;
    }

    public void playGame(){
        System.out.println(getGrid().toString());
        getGrid().evolve();
        System.out.println(getGrid().toString());
        getGrid().evolve();
        System.out.println(getGrid().toString());
    }



}
