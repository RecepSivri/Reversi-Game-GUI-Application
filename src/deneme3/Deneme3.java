/*
*   Created by Recep Sivri on 30.01.2016
*   Description:
*       Deneme3  Class for Reversi game which contains gui and game play functions.
*
 */
package deneme3;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Recep Sivri
 */

public class Deneme3 {

    /*Static variables for  elements of GUI */
   static JFrame frame;/*Main Panel */
   static JPanel panel;/*Panel of Game*/
   static ReversiButton button64[];/*Reversi Game Table which contains 64 buttons.*/
   static JLabel labelX[];/*label for x coordinate*/
   static JLabel labelY[];/*label for y coordinate*/
   static Font myfont;/*Font for Labels.*/
   static JLabel Alphabet[];/*Label for representing Alphabet a to h.*/
   static String Letters[]={"a","b","c","d","e","f","g","h"};/*Alphabet*/
   static Reversi  Table;/*reversi Game Object*/
   static int high;/*high for table*/
   static int row;/*row for table*/
   static JLabel firstNumberX;/*represnts Number of X for each step of game*/
   static JLabel firstNumberY;/*represnts Number of O for each step of game*/
   static JButton Restart;/*Restar button*/
   static JButton back;/*back button*/
   static JButton Load;/*Load button*/
   static JButton Save;/*Save button*/
   static ArrayList<Reversi> List=new ArrayList<Reversi>();/*Array List for reversi Game  for back button.*/
   static int counter=0;/*counter for back button*/
   /*set Game Function sets table of game and plays game for computer and for player.*/
   public void SetGame()
   {
       int i,j,k=0,l=60,m=55,n=0,o=75,y=0,z=0;
       
        Table =new Reversi();/*Creates reversi object*/
        Table.SetTable();/*Creates standart reversi table.*/
        j=50;/*sets coordinate.*/
        labelY = new JLabel[8];/*Creates Labels for Y coordinate.*/
        button64=new ReversiButton[64];/*Creates Button array for table*/
        Alphabet =new JLabel[8];/*Creates Alphabet Label for table for x coordinate.*/
        
        for(n=0;n<8;++n)/*stting table.*/
        {
            Alphabet[n]=new JLabel(Letters[n]);
            Alphabet[n].setFont(new Font("Arial", Font.BOLD, 35));
            Alphabet[n].setSize(40, 50);
            Alphabet[n].setOpaque(true);
            Alphabet[n].setForeground(Color.yellow);
            Alphabet[n].setBackground(Color.blue);
            Alphabet[n].setLocation(o, 0);
            Alphabet[n].setLayout(null);  
            panel.add(Alphabet[n]);
            o=o+45+5;
        }
        for(i=0;i<8;++i)
        {
            labelY[i]=new JLabel(i+1+".");
            labelY[i].setFont(new Font("Arial", Font.BOLD, 35));
            labelY[i].setSize(40, 60);
            labelY[i].setOpaque(true);
            labelY[i].setForeground(Color.yellow);
            labelY[i].setBackground(Color.blue);
            labelY[i].setLocation(20, j);
            labelY[i].setLayout(null);  
            panel.add(labelY[i]);
            j=j+45+5;
                for(k=0;k<8;++k)
                {
                    if(Table.gameCells[i][k].getCellCh()=='.')
                        button64[i*8+k]=new ReversiButton("");
                    else
                    {
                        button64[i*8+k]=new ReversiButton(Table.gameCells[i][k].getCellCh()+"");
                        if(Table.gameCells[i][k].getCellCh()=='X')
                        {
                            button64[i*8+k].setBackground(Color.orange);
                        }
                        else
                        if(Table.gameCells[i][k].getCellCh()=='O')
                        {
                            button64[i*8+k].setBackground(Color.CYAN);
                        }
                    }
                    button64[i*8+k].setSize(50,50);
                    button64[i*8+k].setLocation(l, m);
                    button64[i*8+k].setVisible(true);
                    
                    button64[i*8+k].addActionListener(new Action());
                    panel.add(button64[i*8+k]);
                    l=l+50+1; 
                }
                
                m=m+45+6;
                l=60;
        }
        frame.add(panel);
        frame.repaint();
   
   }
         
    public static void main(String[] args) {
        
        int i,j,k=0,l=60,m=0,n=0,o=75,y=0,z=0;
        JLabel counterX=new JLabel("Player:");
        JLabel counterY=new JLabel("Computer:");
        JLabel Designer=new JLabel("Designed by Recep Sivri.");
        JLabel Advice=new JLabel("for advice recep.sivri.eskipazar@gmail.com");
        Restart=new JButton("Restart");
        firstNumberX=new JLabel("2");
        firstNumberY=new JLabel("2");
        Deneme3 obj = new Deneme3();
        frame=new JFrame("Reversi");
        frame.setSize(750,530);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
        panel= new JPanel();
        panel.setSize(750,530);
        panel.setLocation(0, 0);
        panel.setLayout(null);
        panel.setBackground(Color.BLUE);
        counterX.setSize(120,50);
        counterX.setLocation(500,200);
        counterX.setFont(new Font("Arial", Font.BOLD, 35));
        counterX.setOpaque(true);
        counterX.setForeground(Color.yellow);
        counterX.setBackground(Color.blue);
        counterY.setSize(175,50);
        counterY.setLocation(500,250);
        counterY.setFont(new Font("Arial", Font.BOLD, 35));
        counterY.setOpaque(true);
        counterY.setForeground(Color.yellow);
        counterY.setBackground(Color.blue);
        firstNumberX.setSize(50,50);
        firstNumberX.setLocation(623,200);
        firstNumberX.setFont(new Font("Arial", Font.BOLD, 35));
        firstNumberX.setOpaque(true);
        firstNumberX.setForeground(Color.green);
        firstNumberX.setBackground(Color.blue);
        firstNumberY.setSize(50,50);
        firstNumberY.setLocation(680,250);
        firstNumberY.setFont(new Font("Arial", Font.BOLD, 35));
        firstNumberY.setOpaque(true);
        firstNumberY.setForeground(Color.green);
        firstNumberY.setBackground(Color.blue);
        Designer.setSize(150,16);
        Designer.setLocation(600,465);
        Designer.setFont(new Font("Arial", Font.BOLD, 12));
        Designer.setOpaque(true);
        Designer.setForeground(Color.black);
        Designer.setBackground(Color.blue);
        Advice.setSize(260,16);
        Advice.setLocation(490,480);
        Advice.setFont(new Font("Arial", Font.BOLD, 12));
        Advice.setOpaque(true);
        Advice.setForeground(Color.black);
        Advice.setBackground(Color.blue);
        Restart.setSize(80,55);
        Restart.setLocation(520,50);
        Restart.addActionListener(new Action());
        back=new JButton("<");
        back.setSize(80,55);
        back.setLocation(520,105);
        back.addActionListener(new Action());
        Load=new JButton("Load");
        Load.setSize(80,55);
        Load.setLocation(600,105);
        Load.addActionListener(new Action());
        Save=new JButton("Save");
        Save.setSize(80,55);
        Save.setLocation(600,50);
        Save.addActionListener(new Action());
        panel.add(Save);
        panel.add(Load);
        panel.add(back);
        panel.add(Restart);
        panel.add(Designer);
        panel.add(Advice);
        panel.add(counterX);
        panel.add(counterY);
        panel.add(firstNumberX);
        panel.add(firstNumberY);
        obj.SetGame();
    }    
    static class Action implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) { /*Action Listener for All of buttons in the Game*/
             int i,high,row,k,l,m,n,status,p,j,status2 = 0,status3=0;
             String Str[]={"a","b","c","d","e","f","g","h"};
             if(e.getSource()==Load)/*For Load Game.*/
             {
                 JFileChooser load = new JFileChooser();
                 JTextField filename = new JTextField();
                 JTextField dir = new JTextField();
                 ArrayList<Character> clist = new ArrayList<Character>();
                 char [] table = new char[72];
                 char ch;
                 int value=load.showOpenDialog(Deneme3.Load);
                 if (value == JFileChooser.APPROVE_OPTION) {
                    File file = load.getSelectedFile();
                    FileReader fr = null; 
                     try {
                         fr = new FileReader(file);
                     } catch (FileNotFoundException ex) {
                         Logger.getLogger(Deneme3.class.getName()).log(Level.SEVERE, null, ex);
                     }
                    
                     try {
                         fr.read(table); // reads the content to the array
                     } catch (IOException ex) {
                         Logger.getLogger(Deneme3.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     for(i=0;i<72;++i)
                     {
                         if(table[i]!='\n')
                            clist.add(table[i]);
                     }
                     for(i=0;i<8;++i)
                     {
                         for(j=0;j<8;++j)
                             Table.gameCells[i][j].setCellCh(clist.get(i*8+j));
                     }
                     for(m=0;m<8;++m)
                 {
                    for(n=0;n<8;++n)
                    {
                       if(Table.gameCells[m][n].getCellCh()=='.')
                       {
                                button64[m*8+n].setText("");
                                button64[m*8+n].setBackground(new JButton().getBackground());
                                        
                       }    
                            else
                            {
                             button64[m*8+n].setText(Table.gameCells[m][n].getCellCh()+"");
                             if(Table.gameCells[m][n].getCellCh()=='X')
                            {
                                button64[m*8+n].setBackground(Color.orange);
                            }
                            else
                            if(Table.gameCells[m][n].getCellCh()=='O')
                            {
                                button64[m*8+n].setBackground(Color.CYAN);
                            }
                            } 
                        }
                    }
                    firstNumberX.setText(""+Table.returnNumberOfX());
                    firstNumberY.setText(""+Table.returnNumberOfO());
                     try {
                         fr.close();
                     } catch (IOException ex) {
                         Logger.getLogger(Deneme3.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
             }
             if(e.getSource()==Save)/*For Save Game.*/
             {
                 char[][] table = new char[8][8];
                 JFileChooser save = new JFileChooser();
                 JTextField filename = new JTextField();
                 JTextField dir = new JTextField();
                 String str="\0";
                 int value=save.showSaveDialog(Deneme3.Save);
                 if (value == JFileChooser.APPROVE_OPTION) {
                     try {
                         filename.setText(save.getSelectedFile().getName());
                         dir.setText(save.getCurrentDirectory().toString());
                         System.out.print(dir.getText());
                         
                         File GameFile=new File(dir.getText()+"\\"+filename.getText()+".txt");
                         try {
                             
                             GameFile.createNewFile();
                         } catch (IOException ex) {
                             Logger.getLogger(Deneme3.class.getName()).log(Level.SEVERE, null, ex);
                         }
                         
                         FileWriter writer = null;
                         try {
                             writer = new FileWriter(GameFile);
                         } catch (IOException ex) {
                             Logger.getLogger(Deneme3.class.getName()).log(Level.SEVERE, null, ex);
                         }
                         for(i=0;i<8;++i)
                         {
                             for(j=0;j<8;++j)
                             {
                                 table[i][j]=Table.gameCells[i][j].getCellCh();
                             }  
                         }
                         for(i=0;i<8;++i)
                         {
                            str=String.valueOf(table[i]);
                            writer.write(str+"\n");
                             str="\0"; 
                         }
                         writer.flush();
                         writer.close();    
                     } catch (IOException ex) {
                         Logger.getLogger(Deneme3.class.getName()).log(Level.SEVERE, null, ex);
                     }
                }
                 
             }
             if(e.getSource()==back)/*For back Game.*/
             {
                 ++counter;
                 if(List.size()-(counter)>=0)
                 {
                 for(m=0;m<8;++m)
                 {
                    for(n=0;n<8;++n)
                    {
                        Table.gameCells[m][n].setCellCh(List.get(List.size()-(counter)).gameCells[m][n].getCellCh());
                    }
                 }
                }
                else
                 {
                     List.clear();
                     counter=0;
                 }
                 System.out.println("size:"+List.size());
                 for(p=0;p<List.size();++p)
                 {
                 for(m=0;m<8;++m)
                 {
                    for(n=0;n<8;++n)
                    {
                        System.out.print(List.get(p).gameCells[m][n].getCellCh());
                    }
                    System.out.println();
                 }  
                 System.out.println();
                 }
                 for(m=0;m<8;++m)
                 {
                    for(n=0;n<8;++n)
                    {
                       if(Table.gameCells[m][n].getCellCh()=='.')
                       {
                                button64[m*8+n].setText("");
                                button64[m*8+n].setBackground(new JButton().getBackground());
                                        
                       }    
                            else
                            {
                             button64[m*8+n].setText(Table.gameCells[m][n].getCellCh()+"");
                             if(Table.gameCells[m][n].getCellCh()=='X')
                            {
                                button64[m*8+n].setBackground(Color.orange);
                            }
                            else
                            if(Table.gameCells[m][n].getCellCh()=='O')
                            {
                                button64[m*8+n].setBackground(Color.CYAN);
                            }
                            } 
                        }
                    }
                    firstNumberX.setText(""+Table.returnNumberOfX());
                    firstNumberY.setText(""+Table.returnNumberOfO());
                 
             }
             if(e.getSource()==Restart)/*For Restart Game.*/
             {
                 Table.SetTable();
                 for(m=0;m<8;++m)
                 {
                    for(n=0;n<8;++n)
                    {
                       if(Table.gameCells[m][n].getCellCh()=='.')
                       {
                                button64[m*8+n].setText("");
                                button64[m*8+n].setBackground(new JButton().getBackground());
                                        
                       }    
                            else
                            {
                             button64[m*8+n].setText(Table.gameCells[m][n].getCellCh()+"");
                             if(Table.gameCells[m][n].getCellCh()=='X')
                            {
                                button64[m*8+n].setBackground(Color.orange);
                            }
                            else
                            if(Table.gameCells[m][n].getCellCh()=='O')
                            {
                                button64[m*8+n].setBackground(Color.CYAN);
                            }
                            } 
                        }
                    }
                    firstNumberX.setText(""+Table.returnNumberOfX());
                    firstNumberY.setText(""+Table.returnNumberOfO());
             }
             for(i=0;i<64;++i)
             {
                 if(e.getSource()==button64[i])/*For button in Table.*/
                 {
                     if(i==0)
                     {
                         row=0;
                         high=0;
                     }
                     else
                     {
                        row =i%8;
                        high=i/8;
                     }
                     List.add(new Reversi(Table));
                     status=Table.checkCoordinateAndPlayByPlayer(high,row);
                     if(status!=-1)
                     {
                     for(m=0;m<8;++m)
                     {
                        for(n=0;n<8;++n)
                        {
                            if(Table.gameCells[m][n].getCellCh()=='.')
                                button64[m*8+n].setText("");
                            else
                            {
                             button64[m*8+n].setText(Table.gameCells[m][n].getCellCh()+"");
                             if(Table.gameCells[m][n].getCellCh()=='X')
                            {
                                button64[m*8+n].setBackground(Color.orange);
                            }
                            else
                            if(Table.gameCells[m][n].getCellCh()=='O')
                            {
                                button64[m*8+n].setBackground(Color.CYAN);
                            }
                            }
                        }
                     } 
                     List.add(new Reversi(Table));
                     status2=playComputer();        
                     List.add(new Reversi(Table));
                        firstNumberX.setText(""+Table.returnNumberOfX());
                        firstNumberY.setText(""+Table.returnNumberOfO());
                     }
                     System.out.print("player:"+Table.CheckPlayerStatus()+" computer:"+Table.CheckComputerStatus()+"\n");
                     if(Table.returnNumberOfO()==0||Table.returnNumberOfX()==0||Table.returnNumberOfO()+Table.returnNumberOfX()==64||Table.CheckComputerStatus()==-64&&status==-1)
                     {
                         if(Table.returnNumberOfO()>Table.returnNumberOfX())
                             JOptionPane.showMessageDialog(panel, "Computer(O) Win!","Game Status",JOptionPane.PLAIN_MESSAGE);
                         else
                          if(Table.returnNumberOfO()<Table.returnNumberOfX())
                             JOptionPane.showMessageDialog(panel, "Player(X) Win congratulations! ","Game Status",JOptionPane.PLAIN_MESSAGE);
                         else
                          if(Table.returnNumberOfO()==Table.returnNumberOfX())
                             JOptionPane.showMessageDialog(panel, "DrawGame! ","Game Status",JOptionPane.PLAIN_MESSAGE);
                     }
                     status2=0;
                     
                 }
             }
        }
        int playComputer()/*Plays for computer one step.*/
        {
                       
                     firstNumberX.setText(""+Table.returnNumberOfX());
                    int m,n,status=0;
                    status=Table.PlayComputerOneStep();
                     for(m=0;m<8;++m)
                     {
                        for(n=0;n<8;++n)
                        {
                            if(Table.gameCells[m][n].getCellCh()=='.')
                                button64[m*8+n].setText("");
                            else
                            {
                             button64[m*8+n].setText(Table.gameCells[m][n].getCellCh()+"");
                             if(Table.gameCells[m][n].getCellCh()=='X')
                            {
                                button64[m*8+n].setBackground(Color.orange);
                            }
                            else
                            if(Table.gameCells[m][n].getCellCh()=='O')
                            {
                                button64[m*8+n].setBackground(Color.CYAN);
                            }
                            }  
                        } 
                     }
                     try {
                        Thread.sleep(500);
                        } catch (InterruptedException ignored) {}  
                     return status;
        }
    } 
    class ReversiButton extends JButton {
    JPanel panel2 = new JPanel(); 

    ReversiButton() {
    }
    ReversiButton(String str) {
        super(str);
    }
}
}
