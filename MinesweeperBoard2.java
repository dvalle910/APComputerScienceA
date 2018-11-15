/**
 * Write a description of class Minesweeper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.lang.Math;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MinesweeperBoard2{

    public static void main(String[] args){
        new MinesweeperBoard2();
    }

    Cell[][] board;
    int rows;
    int columns;
    public MinesweeperBoard2(){
        this(10, 10);
    }

    public MinesweeperBoard2(int row, int column){
        //Put the constructor here.
        rows = row;
        columns = column;
        board = new Cell[rows][columns];

        //These pieces are for the GUI.
        JFrame frame = new JFrame();
        frame.add(addCells());

        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // adds bombs into the board
    public void addBombs(int bombs) throws Exception{
        //Choose a random Spot
        //Change spot to bomb
        //Repeat until all bombs in
        int bombsAdded = 0;
        while(bombsAdded != bombs){
            int ranCol = (int)(Math.random() * rows); // random [0, rows]
            int ranRow = (int)(Math.random() * columns);  // spot in board which == BOMB
            if(board[ranCol][ranRow].getValue() != 29){
                board[ranCol][ranRow].setValue(29);
                bombsAdded++;
            }
        }
    }

    public void addNums(){ // adds noombers to a Cell if it isnt a bomb for how many bombs are around it
        // will check all Cells if the Cell is a bomb, Cells next to and around Cell,
        // if nearbyCell == true, add one to counter. Return counter as Cell.setValue(counter);
        // after checking all Cell

        int counter = 0;
        for(int r = 0; r < board.length; r++){ // change to r
            for(int c = 0; c < board[0].length; c++){ // change to c
                if(!board[r][c].isBomb()){
                    //Left
                    if(c > 0){
                        if(/*broken*/ board[r-1][c].isBomb()){
                            counter++;
                        }
                    }
                    //Right
                    if(c < rows){
                        if(/*broken*/ board[r+1][c].isBomb()){
                            counter++;
                        }
                    }
                    //Top
                    if(r > 0){
                        if(/*broken*/ board[r][c-1].isBomb()){
                            counter++;
                        }
                    }
                    //Bottom
                    if(r < columns){
                        if(/*broken*/ board[r][c+1].isBomb()){
                            counter++;
                        }
                    }
                    //Top-Left
                    if(c > 0){
                        if(r > 0){
                            if(/*broken*/ board[r - 1][c - 1].isBomb()){
                                counter++;
                            }
                        }
                    }
                    //Top-Right
                    if(c < rows){
                        if(r > 0){
                            if(/*broken*/ board[r + 1][c - 1].isBomb()){
                                counter++;
                            }
                        }
                    }
                    //Bottom-left
                    if(r < columns){
                        if(c > 0){
                            if(/*broken*/ board[r - 1][c + 1].isBomb()){
                                counter++;
                            }
                        }
                    }
                    //Bottom-Right
                    if(r < columns){
                        if(c < columns){
                            if(/*broken*/ board[r + 1][c + 1].isBomb()){
                                counter++;
                            }
                        }
                    }

                    board[r][c].setValue(counter);
                    counter = 0;
                }
            }
        }
    }

    /**This method is used for testing and will be deleted if using the GUI.
     *  It is still required for all students.
     */
    public void printBoard(){
        int iAmSoDumb = 0;
        int iAmSoSmart = 0;
        for(int i = 0; i < rows; i++){
            for(int k = 0; k < columns; k++){
                if(board[iAmSoSmart][iAmSoDumb].getValue() == 29){
                    System.out.print("X ");
                }else{
                    System.out.print(board[iAmSoSmart][iAmSoDumb].getValue() + " ");
                }
                iAmSoDumb++;
            }
            iAmSoSmart++;
            iAmSoDumb = 0;
            System.out.println();
        }
    }

    public JPanel addCells(){
        /*JPanel panel = new JPanel(new GridLayout(rows,columns));
        for(int i = 0; i< rows*columns; i++){
        board[i]= new Cell();
        panel.add(board[i].getButton());
        }
        return panel; OLD LAYOUT */
        JPanel panel = new JPanel(new GridLayout(rows,columns));
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                board[row][col]= new Cell();
                panel.add(board[row][col].getButton());
            }
        }
        return panel; /*NEW LAYOUT*/
    }

}
