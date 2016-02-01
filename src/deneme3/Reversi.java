/*
*   Created by Recep Sivri on 30.01.2016
*   Description:
*       Reversi Class for Reversi game which contains Game functions and Game Variables.
*
 */
package deneme3;

/**
 *
 * @author Recep Sivri
 */
public class Reversi {
 
 public Cell gameCells[][];
/*
 one constructor for Reversi class sets table for game.
 */
    Reversi(Reversi Table) {
        this.SetTable();
        int i,j;
        for(i=0;i<8;++i)
        {
            for(j=0;j<8;++j)
            {
                this.gameCells[i][j].setCellCh(Table.gameCells[i][j].getCellCh());
            }
        }
    }
    /*default constructor for Reversai game*/
   Reversi() {
    }
   
   /*public void SetTable() is setter for table or prepares table for game*/
   public void SetTable()
{
    int i,j,k=0,l=0,n,t,x,y;
    x=8;
    y=8;
    String str[]={"a","b","c","d","e","f","g","h"};
    k=8;
    n=x/k;
    l=0;
    String str2="\0";
    gameCells =new Cell[8][8];
    for(i=0;i<8;++i)
        gameCells[i]=new Cell[8];
   for(j=0;j<y;++j)
    {
        for(i=0;i<x;++i)
        {
            gameCells[j][i]=new Cell();
            str2=str[i];//if size of vector is greater then index str2 contains one element.     
            if(j==3&&i==3)//center of board.
                gameCells[j][i].setCell(j+1, str2, 'O');   
            else
            if(j==3&&i==4)
                gameCells[j][i].setCell(j+1, str2, 'X');
            else
            if(j==4&&i==3)
                gameCells[j][i].setCell(j+1, str2, 'X');
            else
            if(j==4&&i==4)
                gameCells[j][i].setCell(j+1, str2, 'O');
            else
                gameCells[j][i].setCell(j+1, str2, '.');
        }
    }
}
/*
  @param x is X coordinate. 
   @param y is Y coordinate. 
   @param  playerChar represents pieces of player. 
   @param  targetChar represents pieces of computer.
   @return number of pieces which will be taken by computer or player.
   plays game one step for player and computer.
*/
public int playOneStep(int x,int y,char playerChar,char targetChar)
{   
    int count=0;
    int i=0,j=0,m=0,n=0;
    j=y;
    i=x+1;//righ
    while(i<8&&gameCells[j][i].getCellCh()==targetChar)
        ++i;
    if(i<8)
    {
        if(gameCells[j][i].getCellCh()==playerChar&&i!=x+1)
        {
            gameCells[j][x].setCellCh(playerChar);
            for(m=x;m<i;++m)
            {
                gameCells[j][m].setCellCh(playerChar);
            }
            ++count;
        }
    }
    j=y;
    i=x-1;//left
    while(i>=0&&gameCells[j][i].getCellCh()==targetChar)
        --i;
    if(i>=0)
    {
        if(gameCells[j][i].getCellCh()==playerChar&&i!=x-1)
        {
            gameCells[j][x-1].setCellCh(playerChar);
            gameCells[j][x].setCellCh(playerChar);
            for(m=i;m<x-1;++m)
            {
                gameCells[j][m].setCellCh(playerChar);
            }
            ++count;
        }
    }
    i=x;
    j=y+1;//down
    while(j<8&&gameCells[j][i].getCellCh()==targetChar)
        ++j;
    if(j<8)
    {
        if(j!=y+1&&gameCells[j][i].getCellCh()==playerChar)
        {
            gameCells[y][i].setCellCh(playerChar);
            for(m=y+1;m<j;++m)
            {
                gameCells[m][i].setCellCh(playerChar);
            }
            ++count;
        }
    }
    i=x;
    j=y-1;//up
    while(j>=0&&gameCells[j][i].getCellCh()==targetChar)
        --j;
    if(j>=0)
    {
        if(gameCells[j][i].getCellCh()==playerChar&&j!=y-1)
        {
            gameCells[y][i].setCellCh(playerChar);
            gameCells[y-1][i].setCellCh(playerChar);
            for(m=j;m<y-1;++m)
            {
               gameCells[m][i].setCellCh(playerChar);
            }
            ++count;
        }
    }
    i=x-1;
    j=y-1;//up-left
    while(j>=0&&i>=0&&gameCells[j][i].getCellCh()==targetChar)
    {
        --i;
        --j;
    }
    if(j>=0&&i>=0)
    {
        if(gameCells[j][i].getCellCh()==playerChar&&i!=x-1&&j!=y-1)
        {
            gameCells[y][x].setCellCh(playerChar);
            ++count;
            m=j;
            n=i;
            while(m<y&&n<x)
            {
                gameCells[m][n].setCellCh(playerChar);
                ++m;
                ++n;
            }
        }
    }
    i=x+1;
    j=y+1;//down-right
    while(j<8&&i<8&&gameCells[j][i].getCellCh()==targetChar)
    {
        ++i;
        ++j;
    }   
    if(j<8&&i<8)
    {
        if(gameCells[j][i].getCellCh()==playerChar&&i!=x+1&&j!=y+1)
        {
            ++count;
            gameCells[y][x].setCellCh(playerChar);
            gameCells[y+1][x+1].setCellCh(playerChar);
            m=y+1;
            n=x+1;
            while(m<j&&n<i)
            {
                gameCells[m][n].setCellCh(playerChar);
                ++m;
                ++n;
            }
        }
    }
    i=x+1;
    j=y-1;//up-right
    while(j>=0&&i<8&&gameCells[j][i].getCellCh()==targetChar)
    {   
        ++i;
        --j;
    }
    if(j>=0&&i<8)
    {
        if(gameCells[j][i].getCellCh()==playerChar&&i!=x+1&&j!=y-1)
        {   
            ++count;
            gameCells[y][x].setCellCh(playerChar);
            m=y-1;
            n=x+1;
            while(m>j&&n<i)
            {
                gameCells[m][n].setCellCh(playerChar);
                ++n;
                --m;
            }       
        }
    }
    i=x-1;
    j=y+1;//down-left
    while(j<8&&i>=0&&gameCells[j][i].getCellCh()==targetChar)
    {   
        --i;
        ++j;
    }
    if(j<8&&i>=0)
    {
        if(gameCells[j][i].getCellCh()==playerChar&&i!=x-1&&j!=y+1)
        {   
            ++count;
            gameCells[y][x].setCellCh(playerChar);
            gameCells[y+1][x-1].setCellCh(playerChar);
            m=y+1;
            n=x-1;
            while(m<j&&n>i)
            {
                gameCells[m][n].setCellCh(playerChar);
                --n;
                ++m;
            }
        }
    }
    if(count==0)
        return -1;
    return count;
} 
/*
  @param x is X coordinate. 
   @param y is Y coordinate. 
   @param  playerChar represents pieces of player. 
   @param  targetChar represents pieces of computer.
   @return number of pieces which will be taken by computer or player.
   computes most elements for computer or player.
*/
public int CountMostElement(int x,int y,char playerPiece,char targetPiece) 
{
    int count=0;
    int i,j,m,n,a,b;
    if(gameCells[y][x].getCellCh()!='.')
        return -1;
    i=x;
    j=y;
    i=x+1;
    
    
    while(i<8&&gameCells[j][i].getCellCh()==targetPiece)
        ++i;
    if(i<8)
    {
        if(gameCells[j][i].getCellCh()==playerPiece&&i!=x+1)
        {
            for(m=x+1;m<i;++m)
            {
                ++count;
            }   
        }
    }
    j=y;
    i=x-1;
    while(i>=0&&gameCells[j][i].getCellCh()==targetPiece)
        --i;
    if(i>=0)
    {
        if(gameCells[j][i].getCellCh()==playerPiece&&i!=x-1)
        {   
            for(m=i;m<x-1;++m)
            {
                ++count;
            }
        }
    }
    i=x;
    j=y+1;
    while(j<8&&gameCells[j][i].getCellCh()==targetPiece)
        ++j;
    if(j<8)
    {
        if(gameCells[j][i].getCellCh()==playerPiece&&j!=y+1)
        {
            for(m=y+1;m<j;++m)
            {
                ++count;
            }   
        }
    }
    i=x;
    j=y-1;
    while(j>=0&&gameCells[j][i].getCellCh()==targetPiece)
        --j;
    if(j>=0)
    {
        if(gameCells[j][i].getCellCh()==playerPiece&&j!=y-1)
        {   
            for(m=j;m<y-1;++m)
            {
                ++count;
            }
        }
    }
    i=x-1;
    j=y-1;
    while(j>=0&&i>=0&&gameCells[j][i].getCellCh()==targetPiece)
    {
        --i;
        --j;
    }
    if(j>=0&&i>=0)
    {
        if(gameCells[j][i].getCellCh()==playerPiece&&i!=x-1&&j!=y-1)
        {
            m=j;
            n=i;
            while(m<y-1&&n<x-1)
            {
                ++m;
                ++n;
                ++count;
            }
        }
    }
    i=x+1;
    j=y+1;
    while(j<8&&i<8&&gameCells[j][i].getCellCh()==targetPiece)
    {
        ++i;
        ++j;
    }   
    if(j<8&&i<8)
    {
        if(gameCells[j][i].getCellCh()==playerPiece&&j!=y+1&&i!=x+1)
        {
            m=y+1;
            n=x+1;
            while(m<j&&n<i)
            {
                ++count;
                ++m;
                ++n;
            }
        }
    }
    i=x+1;
    j=y-1;
    while(j>=0&&i<8&&gameCells[j][i].getCellCh()==targetPiece)
    {
        ++i;
        --j;
    }
    if(j>=0&&i<8)
    {
        if(gameCells[j][i].getCellCh()==playerPiece&&i!=x+1&&j!=y-1)
        {
            m=y-1;
            n=x+1;
            while(m>j&&n<i)
            {
                ++count;
                ++n;
                --m;
            }
        }
    }
    i=x-1;
    j=y+1;
    while(j<8&&i>=0&&gameCells[j][i].getCellCh()==targetPiece)
    {
        --i;
        ++j;
    }
    if(j<8&&i>=0)
    {
        if(gameCells[j][i].getCellCh()==playerPiece&&i!=x-1&&j!=y+1)
        {
            m=y+1;
            n=x-1;
            while(m<j&&n>i)
            {
                ++count;
                --n;
                ++m;
            }
        }
    }
    
    if(count==0)
        return -1;
    return count;
}
/*
    @return number of pieces of computer which will be taken by player if number is -64 player 
    can't play game.
*/
public int CheckPlayerStatus()
{
    int i,j,total=0,status=0;
    for(i=0;i<8;++i)
    {
        for(j=0;j<8;++j)
        {
                status=CountMostElement(j,i,'O','X');      
                if(status==-1)
                    --total;   
        }
    }
    return total;
}
/*
    @param y is y coordinate of piece  which will be choosen by computer.
    @param x is x coordinate of piece  which will be choosen by computer.
    @return max number of player piece but  if return -1 computer can't play game,game will turn player.
*/
public int checkCoordinateAndPlayByPlayer(int y,int x)
{
    int i,row=-1,high,result,status;
    high=y;
    row=x;
    if(x<0||x>=8)//checks coordinat validity.
        return -1;
    
    if(high>=8||high<0)
        return -1;
    
    status=CountMostElement(row,high,'X','O');
    if(status!=-1)
    {
        result=playOneStep(row,high,'X','O');
    }
    return status;
}
/*
    @return number of X in table.
*/
 public int returnNumberOfX()
   {
       int i;
       int j;
       int counter=0;
       for(i=0;i<8;++i)
       {
           for(j=0;j<8;++j)
           {
               if(gameCells[i][j].getCellCh()=='X')
                   ++counter;
           }
       }
       return counter;
   }
 /*
    @return number of O in table.
*/
   public int returnNumberOfO()
   {
       int i;
       int j;
       int counter=0;
       for(i=0;i<8;++i)
       {
           for(j=0;j<8;++j)
           {
               if(gameCells[i][j].getCellCh()=='O')
                   ++counter;
           }
       }
       return counter;
   } 
/*
    @return number of X taken by player if return -64 computer won't play and turn to player.
*/
public int PlayComputerOneStep()
{
    int i,j,max=0,total=0,coorX=0,coorY=0,count=0,x,y;
    
    for(i=0;i<8;++i)
    {
        for(j=0;j<8;++j)
        {
            total=CountMostElement(j,i,'O','X');
            if(total==-1)
                --count;
            if(total>max)
            {
                max=total;
                coorX=j;
                coorY=i;
            }   
        }
    }
    if(count!=-1*8*8)
    {
        x=coorX;
        y=coorY;
        playOneStep(coorX,coorY,'O','X');
    }
    return count;
}
/*
    @return number of X taken by player if return -64 computer won't play and turn to player count computer's pieces.
*/
public int CheckComputerStatus()
{
    //scans board for computer if computer can play or not.
    String alphabet[]={"a","b","c","d","e","f","g","h"};
    String str;
    int i,j,max=0,total=0,coorX=0,coorY=0,count=0;
  for(i=0;i<8;++i)
  {
    for(j=0;j<8;++j)
    {
      total=CountMostElement(j,i,'X','O');
      if(total==-1)
        --count;
    }
  }
  return count;
}
/*
    @return true if table is full else return false.
*/
public boolean isFull()
{
    if(returnNumberOfX()+returnNumberOfO()==64)
        return true;
    else
        return false;
}

}
