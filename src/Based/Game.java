package Based;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class for implementation of Game.
 * It is used to create players and the manager of the game
 */
public class Game {
    private int numberOfPlayers;
    private ArrayList<Player>  players;
    private Manager manager;

    /**
     * Constructor for creating a new Game.
     * @param numberOfPlayers the number of players which is given in the beginning of the game by user
     */
    public Game(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        players = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) { createPlayer(i); }
        manager = new Manager(players);
        for (int i = 0; i < players.size(); i++) {
            for (int j = 0; j < 7; j++) {
                manager.dealCard(i);
            }
        }
    }

    /**
     * Creates a new Player for the game with its unique index
     * @param index the index which is used to keep track of turns and players
     */
    private void createPlayer(int index){
        Player player = new Player(index);
        players.add(player);
    }

    /**
     * Gets the ArrayList of the Players in the game.
     *
     * @return the players which is the ArrayList of the Players in the game.
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * Gets rhe manager of the game.
     *
     * @return the manager of the game
     */
    public Manager getManager() {
        return manager;
    }
}
