/*
 * Gregory McHugh
 * GR795710
 * COP 3330 Object Oriented Programming
 * University of Central Florida
 */

package core;

import java.awt.Color;

public abstract class Player 
{
    private String playerName;
    private Color color;
    
    public Player (String name) 
    {
        playerName = name;
    }
    
    /**
    * @return the player's name
    */
    public String getName() 
    {
        return playerName;
    }
    
    public abstract int getMove(Connect4State state);
    
    public Color getColor(){
        return color;
    }
    
    public void setColor(Color color){
        this.color = color;
        
    }
    
}    