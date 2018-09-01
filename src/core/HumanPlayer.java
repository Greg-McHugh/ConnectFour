/*
 * Gregory McHugh
 * GR795710
 * COP 3330 Object Oriented Programming
 * University of Central Florida
 */

package core;

public class HumanPlayer extends Player 
{
    public int getMove(Connect4State state) 
    {
        // Get a move for the user
        return 0;
    }
    
    public HumanPlayer (String name) 
    {
        super(name);
        this.setColor(Constants.HUMAN);
    }
}
