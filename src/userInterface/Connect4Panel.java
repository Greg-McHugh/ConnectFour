/*
 * Gregory McHugh
 * GR795710
 * COP 3330 Object Oriented Programming
 * University of Central Florida
 */

package userInterface;

import core.Constants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Connect4Panel extends JPanel
{
    private BoardListener boardListener;
    private RoundButton[][] buttonBoard;

    public Connect4Panel()
    {
        super();
        initComponents();
    }

    private void initComponents()
    {
        this.setLayout(new GridLayout(Constants.ROW, Constants.COL));
        this.setMinimumSize(new Dimension(500, 500));
        this.setPreferredSize(new Dimension(500, 500));
        this.setBackground(Color.BLUE);
        
        // create the board 6 rows x 7 columns
        buttonBoard = new RoundButton [Constants.ROW][Constants.COL];        
        
        boardListener = new BoardListener();
        
        
        // put client properties on the buttons so we
        // know which one it is
        for (int row = 0; row < Constants.ROW; row++)
        {			
            for (int col = 0; col < Constants.COL; col++)
            {
                // create the buttons
                buttonBoard[row][col] = new RoundButton();
                getbuttonBoard()[row][col].putClientProperty("row", row);
                getbuttonBoard()[row][col].putClientProperty("col", col);
                getbuttonBoard()[row][col].setBackground(Color.WHITE);
                getbuttonBoard()[row][col].putClientProperty("color",Color.WHITE);
                
                
                // add and action listener
                if(row == 0)
                {
                    setListener(buttonBoard[row][col], boardListener);
                }
                
                // add button to JPanel
                this.add(buttonBoard[row][col]);
                
            }
        }	
        
    }
    
    public RoundButton[][] getbuttonBoard(){
    
    return buttonBoard;
}
    
    public Connect4Panel getConnect4Panel(){
        
        return this;
    }
    
    
    private BoardListener getBoardListener()
    {
        return boardListener;
    }
    
    private void setListener(JButton inButton, ActionListener inListener)
    {
        inButton.addActionListener(inListener);
    }

    private void removeListener(JButton inButton, ActionListener inListnener)
    {
        inButton.removeActionListener(inListnener);
    }

    private class BoardListener implements ActionListener
    {	
        
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if( e.getSource() instanceof JButton) 
            {               
                // this is an explicit type cast
                JButton button = (JButton)e.getSource();
                int row = Constants.ROW - 1;
                int colClick = (int)button.getClientProperty("col");
                Color color =(Color)button.getClientProperty("color");
                
                if ((colClick < 0) ||(colClick >= Constants.COL)){
                    System.out.println("Illegal move. Try again");
                }
                else{
                    for(int i = row; i >= 0;i--){
                        if(getbuttonBoard()[i][colClick].getClientProperty("color") == Constants.EMPTY){
                            getbuttonBoard()[i][colClick].putClientProperty("color", Color.RED);
                            getbuttonBoard()[i][colClick].setBackground(Color.RED);
                            break;
                            
                            
                        }
                        else{
                            continue;
                        }
                    }
                }
            }
        }
    }    
}