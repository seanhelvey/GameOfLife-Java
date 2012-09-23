package smh;

/**
 * Created with IntelliJ IDEA.
 * User: seanhelvey
 * Date: 9/23/12
 * Time: 11:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class Game {

    private static Grid table;

    public Game(){
        System.out.println("Game constructed");
    }

    public static void playGame(){
        System.out.println("playGame called");
        table = new Grid();
        System.out.println(table.toString());
    }

}
