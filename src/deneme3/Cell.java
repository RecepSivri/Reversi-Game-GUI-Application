/*
*   Created by Recep Sivri on 30.01.2016
*   Description:
*    Cell Class for Reversi game Cell Class Contains x,y coordinate and variable which this coordinates 
*    value and some need functions.
*
 */
package deneme3;

/**
 *
 * @author Recep Sivri
 */
public class Cell {
 
    int y;// Y coordinate.
    String x;//X coordinate.
    char ch;//content of Y and Y coordinates.
    /*
    setter for Cell class with no parameter.
    */
    public void setCell(){
        y=0;
        x="";       
    }
    /*
     @param int Y is y coordinate and sets Cell class.
    */
    public void setCell(int Y)
    {
        y=Y;
        x="";
        ch='.';
    }
    /*
     @param int Y is y coordinate and X is x coordinate and sets Cell class.
    */
    public void setCell(int Y,String X)
    {
        y=Y;
        x=X;
        ch='.';
    }
    /*
     @param int Y is y coordinate and X is x coordinate,pch is a value in x and y corrdinate and sets Cell class.
    */
    public void setCell(int Y,String X,char pch)
    {
        y=Y;
        x=X;
        ch=pch;
    }
    /*
    @return String which is x coordinate
    getter for X coordinate.
    */
    public String getCellX() {return x;}
    /*
    @return int which is y coordinate
    getter for y coordinate.
    */
    public int getCellY() {return y;}
    /*
    @return char which is pch coordinate
    getter for pch which is a value in coordinates.
    */
    public char getCellCh(){return ch;} 
    /*
    @param char which is pch coordinate
    setter for pch which is a value in coordinates.
    */
    public void setCellCh(char pch){ ch=pch;}
}
 

