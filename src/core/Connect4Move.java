/*
 * Gregory McHugh
 * GR795710
 * COP 3330 Object Oriented Programming
 * University of Central Florida
 */

package core;

public class Connect4Move 
{
    private int value; // Game value of this move
    private int move; // Number of pit to be emptied

    public Connect4Move(int value, int move)
    {
        this.value = value;
        this.move = move;
    }    

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }
}
