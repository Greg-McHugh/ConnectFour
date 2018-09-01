/*
 * Gregory McHugh
 * GR795710
 * COP 3330 Object Oriented Programming
 * University of Central Florida
 */

package connectfour;

import core.AiPlayer;
import core.Connect4Game;
import core.Constants;
import core.HumanPlayer;
import core.Player;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import userInterface.Connect4Ui;

public class ConnectFour 
{
    private static ArrayList<Player> players; 
    private static Connect4Ui frame;

    public static void main(String[] args) 
    {
        makePlayers();
        
        frame = new Connect4Ui(getPlayers());
        
        play();

    }
    /*
    * Constructs a Connect 4 player. If the name contains "Computer" it
    * constructs a computer player; else a human player
    */
    public static void makePlayers() 
    {
        // instantiate the players object
        players = new ArrayList<Player>();
        
        // get human player name
        String name = JOptionPane.showInputDialog("Enter your name");
        // instantiate the human player
        Player humanPlayer = new HumanPlayer(name);
        
        // instantiate the computer player
        // default value for now
        int depth = 0;

        Player aiPlayer = new AiPlayer("Computer", depth);
        
        // add players to ArrayList
        players.add(humanPlayer);
        players.add(aiPlayer);
    }  
    
    private static void play(){
        Player currentPlayer = players.get(Constants.TWO);
        Connect4Game state = new Connect4Game(0,players,frame.getBoardPanel().getbuttonBoard());
        
        while (!state.gameIsOver()){
            if (currentPlayer == players.get(Constants.ONE)){
                currentPlayer = players.get(Constants.TWO);
                JOptionPane.showMessageDialog(null,"Computer, your turn");
                int move = state.getPlayerToMove().getMove(state);
                state.makeMove(move);
            }
            
            else{
                currentPlayer = players.get(Constants.ONE);
                JOptionPane.showMessageDialog(null,"Player, your turn");
                
                try{
                    Thread.sleep(2000);
                    
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
                
                
            }
        }
        if(!state.isFull()){
            JOptionPane.showMessageDialog(null, "It is a draw");
        }
        else{
            String won=players.get(1-state.getPlayerNum()).getName();
            JOptionPane.showMessageDialog(null, won + " has won the game");
        }
    }
    
    public static ArrayList getPlayers(){
        return players;
    }
}