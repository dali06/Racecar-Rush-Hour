//Name: Danish Ali
//Date: January 23, 2023
//Purpose: Race Car Rush Hour, ISC3U final project

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;
import javax.swing.AbstractButton;
import sun.audio.*;
import java.io.*;
import java.io.FileInputStream.*;

public class RushHourGame extends Applet implements ActionListener
{
    Panel p_card;  //to hold all of the screens
    Panel card0, card1, card2, card3, card4, card5;
    CardLayout cdLayout = new CardLayout ();
    boolean done = false;
    //grid
    int row = 6;
    int col = 6;
    JButton nextlevel;
    JLabel level;
    JButton next;


    //current Car information
    JLabel currentPic;
    int whichCar = 0;
    int curX = 2;
    int curY = 1;
    JButton a[] = new JButton [row * col];
    int number = 1;
    // inital board
    char type[] [] = {{'c', 'c', 'c', 'z', 'z', 'z'},
	    {'c', 'z', 'z', 'c', 'z', 'z'},
	    {'c', 'c', 'c', 'c', 'z', 'g'},
	    {'c', 'z', 'z', 'c', 'z', 'r'},
	    {'c', 'c', 'c', 'r', 'z', 'c'},
	    {'z', 'z', 'c', 'c', 'c', 'c'}};
    int car[] [] = {{8, 2, 2, 0, 0, 0},
	    {8, 0, 0, 9, 0, 0},
	    {8, 0, 0, 9, 0, 0},
	    {6, 0, 0, 9, 0, 0},
	    {6, 1, 1, 0, 0, 5},
	    {0, 0, 4, 4, 4, 5}};
    char slice[] [] = {{'f', 'f', 'b', 'n', 'n', 'n'},
	    {'m', 'n', 'n', 'f', 'n', 'n'},
	    {'b', 'f', 'b', 'm', 'n', 'n'},
	    {'f', 'n', 'n', 'b', 'n', 'n'},
	    {'b', 'f', 'b', 'n', 'n', 'f'},
	    {'n', 'n', 'f', 'm', 'b', 'b'}};
    // level 1 - copy of inital board
    char type1[] [] = {{'c', 'c', 'c', 'z', 'z', 'z'},
	    {'c', 'z', 'z', 'c', 'z', 'z'},
	    {'c', 'c', 'c', 'c', 'z', 'g'},
	    {'c', 'z', 'z', 'c', 'z', 'r'},
	    {'c', 'c', 'c', 'r', 'z', 'c'},
	    {'z', 'z', 'c', 'c', 'c', 'c'}};
    int car1[] [] = {{8, 2, 2, 0, 0, 0},
	    {8, 0, 0, 9, 0, 0},
	    {8, 0, 0, 9, 0, 0},
	    {6, 0, 0, 9, 0, 0},
	    {6, 1, 1, 0, 0, 5},
	    {0, 0, 4, 4, 4, 5}};
    char slice1[] [] = {{'f', 'f', 'b', 'n', 'n', 'n'},
	    {'m', 'n', 'n', 'f', 'n', 'n'},
	    {'b', 'f', 'b', 'm', 'n', 'n'},
	    {'f', 'n', 'n', 'b', 'n', 'n'},
	    {'b', 'f', 'b', 'n', 'n', 'f'},
	    {'n', 'n', 'f', 'm', 'b', 'b'}};
    // level 2
    char type2[] [] = {{'c', 'c', 'z', 'z', 'z', 'r'},
	    {'c', 'c', 'c', 'c', 'c', 'r'},
	    {'c', 'c', 'c', 'c', 'c', 'g'},
	    {'c', 'c', 'c', 'c', 'c', 'r'},
	    {'c', 'c', 'c', 'z', 'c', 'r'},
	    {'c', 'c', 'c', 'z', 'c', 'r'}};
    int car2[] [] = {{1, 1, 0, 0, 0, 0},
	    {2, 2, 5, 8, 6, 0},
	    {0, 0, 5, 8, 6, 0},
	    {4, 4, 4, 8, 9, 0},
	    {6, 1, 1, 0, 9, 0},
	    {6, 2, 2, 0, 9, 0}};
    char slice2[] [] = {{'f', 'b', 'n', 'n', 'n', 'n'},
	    {'f', 'b', 'f', 'f', 'f', 'n'},
	    {'f', 'b', 'b', 'm', 'b', 'n'},
	    {'f', 'm', 'b', 'b', 'f', 'n'},
	    {'f', 'f', 'b', 'n', 'm', 'n'},
	    {'b', 'f', 'b', 'n', 'b', 'n'}};
    // level 3
    char type3[] [] = {{'z', 'z', 'c', 'c', 'z', 'c'},
	    {'c', 'c', 'z', 'c', 'c', 'c'},
	    {'c', 'c', 'z', 'c', 'c', 'g'},
	    {'c', 'c', 'c', 'c', 'c', 'r'},
	    {'c', 'z', 'c', 'c', 'c', 'c'},
	    {'c', 'z', 'c', 'c', 'c', 'c'}};
    int car3[] [] = {{0, 0, 1, 1, 0, 5},
	    {2, 2, 0, 8, 6, 5},
	    {0, 0, 0, 8, 6, 0},
	    {4, 4, 4, 8, 9, 0},
	    {6, 0, 1, 1, 9, 5},
	    {6, 0, 2, 2, 9, 5}};
    char slice3[] [] = {{'n', 'n', 'f', 'b', 'n', 'f'},
	    {'f', 'b', 'n', 'f', 'f', 'b'},
	    {'f', 'b', 'n', 'm', 'b', 'n'},
	    {'f', 'm', 'b', 'b', 'f', 'n'},
	    {'f', 'n', 'f', 'b', 'm', 'f'},
	    {'b', 'n', 'f', 'b', 'b', 'b'}};
    //setting up the entire game-grid, displaying the screens, resizing the screens, etc        
    public void init ()
    {

	p_card = new Panel ();
	p_card.setLayout (cdLayout);
	screen1 ();
	screen2 ();
	screen3 ();
	screen4 ();
	screen5 ();
	resize (600, 720);
	setLayout (new BorderLayout ());
	add ("Center", p_card);
	//riddle at beginning
	String input = JOptionPane.showInputDialog ("Riddle me this: What 7-letter word can be spelt the same forward and backward?");
	//if their answer is "racecar", they get a positive popup message
	if (input.equalsIgnoreCase ("racecar"))

	    JOptionPane.showMessageDialog (null, "Proceed to the game!", "Great Job!", JOptionPane.INFORMATION_MESSAGE);
	//else they get a somewhat negative message
	else
	    JOptionPane.showMessageDialog (null, "Incorrect Answer. Have some shame.", "Try Again", JOptionPane.INFORMATION_MESSAGE);

    }

    public void screen1 ()
    { //opening screen is set up.
	card1 = new Panel ();
	card1.setBackground (Color.black);
	p_card.add ("1", card1);
	JLabel pic = new JLabel (createImageIcon ("racecarbackground.jpg"));
	card1.add (pic);
	JLabel title = new JLabel ("WELCOME TO THE RUSH HOUR");
	title.setForeground (Color.cyan);
	title.setFont (new Font ("Raleway", Font.BOLD, 35));
	JLabel title1 = new JLabel ("                    RACING GAME!!                   ");
	title1.setForeground (Color.cyan);
	title1.setFont (new Font ("Raleway", Font.BOLD, 40));
	JButton next = new JButton ("NEXT");
	next.setFont (new Font ("Raleway", Font.BOLD, 30));
	next.setForeground (Color.cyan);
	next.setBorderPainted (false);
	next.setBackground (new Color (0, 0, 139));
	next.setActionCommand ("s2");
	next.addActionListener (this);
	card1.add (title);
	card1.add (title1);
	card1.add (next);
    }
    public void screen2 ()
    { //2nd instructions screen is set up.
	card2 = new Panel ();
	card2.setBackground (Color.black);
	JLabel title = new JLabel (createImageIcon ("instruct1.png"));
	JButton next = new JButton ("NEXT");
	next.setFont (new Font ("Raleway", Font.BOLD, 30));
	next.setForeground (Color.cyan);
	next.setBorderPainted (false);
	next.setBackground (new Color (0, 0, 139));
	next.setActionCommand ("s3");
	next.addActionListener (this);
	card2.add (title);
	p_card.add ("2", card2);
	card2.add (next);
    }
    public void screen3 ()
    { //2nd instructions screen is set up.
	card3 = new Panel ();
	card3.setBackground (Color.black);
	JLabel title = new JLabel (createImageIcon ("instruct2.png"));
	JButton next = new JButton ("NEXT");
	next.setFont (new Font ("Raleway", Font.BOLD, 30));
	next.setForeground (Color.cyan);
	next.setBorderPainted (false);
	next.setBackground (new Color (0, 0, 139));
	next.setActionCommand ("s4");
	next.addActionListener (this);
	card3.add (title);
	p_card.add ("3", card3);
	card3.add (next);
    }
    public void screen4 ()
    { //game screen is set up.
	card4 = new Panel ();
	card4.setBackground (Color.black);
	JLabel title = new JLabel ("RACE CAR RUSH HOUR");
	title.setForeground (Color.cyan);
	title.setFont (new Font ("Raleway", Font.BOLD, 20));
	currentPic = new JLabel (createImageIcon ("little0.png"));
	JButton up = new JButton ("UP");
	up.setFont (new Font ("Raleway", Font.BOLD, 12));
	up.setBackground (new Color (0, 0, 139));
	up.setForeground (Color.cyan);
	up.setBorderPainted (false);
	up.setActionCommand ("up");
	up.addActionListener (this);
	JButton down = new JButton ("DOWN");
	down.setFont (new Font ("Raleway", Font.BOLD, 12));
	down.setForeground (Color.cyan);
	down.setBackground (new Color (0, 0, 139));
	down.setBorderPainted (false);
	down.setActionCommand ("down");
	down.addActionListener (this);
	JButton right = new JButton ("RIGHT");
	right.setFont (new Font ("Raleway", Font.BOLD, 12));
	right.setForeground (Color.cyan);
	right.setBackground (new Color (0, 0, 139));
	right.setBorderPainted (false);
	right.setActionCommand ("right");
	right.addActionListener (this);
	JButton left = new JButton ("LEFT");
	left.setFont (new Font ("Raleway", Font.BOLD, 12));
	left.setForeground (Color.cyan);
	left.setBackground (new Color (0, 0, 139));
	left.setBorderPainted (false);
	left.setActionCommand ("left");
	left.addActionListener (this);
	level = new JLabel ("        LEVEL 1");
	level.setFont (new Font ("Raleway", Font.BOLD, 25));
	level.setForeground (Color.cyan);
	level.setBackground (Color.black);
	nextlevel = new JButton ("NEXT");
	nextlevel.setFont (new Font ("Raleway", Font.BOLD, 12));
	nextlevel.setBackground (new Color (0, 0, 139));
	nextlevel.setForeground (Color.cyan);
	nextlevel.setBorderPainted (false);
	nextlevel.setActionCommand ("nextLevel");
	nextlevel.addActionListener (this);
	nextlevel.setEnabled (false);
	JButton reset = new JButton ("RESET");
	reset.setFont (new Font ("Raleway", Font.BOLD, 12));
	reset.setBackground (new Color (0, 0, 139));
	reset.setForeground (Color.cyan);
	reset.setBorderPainted (false);
	reset.setActionCommand ("Reset");
	reset.addActionListener (this);
	JButton instruct = new JButton ("INSTRUCTIONS");
	instruct.setFont (new Font ("Raleway", Font.BOLD, 12));
	instruct.setBackground (new Color (0, 0, 139));
	instruct.setForeground (Color.cyan);
	instruct.setBorderPainted (false);
	instruct.setActionCommand ("s2");
	instruct.addActionListener (this);
	//Set up grid
	Panel p = new Panel (new GridLayout (row, col));
	int move = 0;
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		//add in when you have pictures
		a [move] = new JButton (createImageIcon (type [i] [j] + "" + car [i] [j] + "" + slice [i] [j] + ".png"));
		//change to be your size
		a [move].setPreferredSize (new Dimension (90, 90));
		a [move].setBackground (Color.gray);
		a [move].addActionListener (this);
		a [move].setActionCommand ("" + move);
		p.add (a [move]);
		move++;
	    }
	}
	card4.add (title);
	card4.add (nextlevel);
	card4.add (currentPic);
	card4.add (reset);
	card4.add (level);
	card4.add (p);
	p_card.add ("4", card4);
	card4.add (up);
	card4.add (down);
	card4.add (left);
	card4.add (right);
	card4.add (instruct);
    }
    public void screen5 ()
    {
	//win screen is set up.
	card5 = new Panel ();
	card5.setBackground (Color.black);
	JLabel win = new JLabel (createImageIcon ("winscreen.png"));
	JButton quit = new JButton ("QUIT");
	quit.setFont (new Font ("Raleway", Font.BOLD, 35));
	quit.setBackground (new Color (0, 0, 139));
	quit.setForeground (Color.cyan);
	quit.setBorderPainted (false);
	quit.setActionCommand ("s6");
	quit.addActionListener (this);
	card5.add (win);
	card5.add (quit);
	p_card.add ("5", card5);
   } 
    protected static ImageIcon createImageIcon (String path)
    { //change the red to your class name
	java.net.URL imgURL = RushHourGame.class.getResource (path);
	//if imgURL is an image, display the image
	if (imgURL != null)
	{
	    return new ImageIcon (imgURL);
	}
	//print out an error if it doesn't exist
	else
	{
	    System.err.println ("Couldn't find file: " + path);
	    return null;
	}
    }
    //if exit tile isn't a car, make it into an exit tile
    public void redraw ()
    {
	if (type [2] [5] != 'c')
	    type [2] [5] = 'g';
	int move = 0;
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		a [move].setIcon (createImageIcon (type [i] [j] + "" + car [i] [j] + "" + slice [i] [j] + ".png"));
		move++;
	    }
	}
    }
    //if the user clicks the back of the car, this method is used to detect the front of the car
    public void findFront (int x, int y)
    {   //curX and curY remain the same
	if (slice [x] [y] == 'f')
	{
	    curX = x;
	    curY = y;
	}
	//2 piece car, curX's pos will remain the same and curY's pos will be one tile above the back of the car
	else if (whichCar <= 2 && slice [x] [y] == 'b')
	{
	    curX = x;
	    curY = y - 1;
	}
	//3 piece truck, curX's pos will remain the same and curY's pos will be one tile above the middle of the truck
	else if (whichCar <= 4 && slice [x] [y] == 'm')
	{
	    curX = x;
	    curY = y - 1;
	}
	//3 piece truck, curX's pos will remain the same and curY's pos will be two tiles above the back of the truck
	else if (whichCar <= 4 && slice [x] [y] == 'b')
	{
	    curX = x;
	    curY = y - 2;
	}
	//2 piece car, curY's pos will remain the same and curX's pos will be one tile left of the back of the car
	else if (whichCar <= 7 && slice [x] [y] == 'b')
	{
	    curX = x - 1;
	    curY = y;
	}
	//3 piece truck, curY's pos will remain the same and curX's pos will be one tile left of the middle of the truck
	else if (whichCar <= 9 && slice [x] [y] == 'm')
	{
	    curX = x - 1;
	    curY = y;
	}
	 //3 piece truck, curY's pos will remain the same and curX's pos will be two tiles left of  the back of the truck
	else if (whichCar <= 9 && slice [x] [y] == 'b')
	{
	    curX = x - 2;
	    curY = y;
	}
	showStatus (curX + ", " + curY);
    }
    // allows vehicles who's default position is vertical to move up
    public void moveUp ()
    {
	//default position is horizontal, can't move up
	if (whichCar <= 4)
	    showStatus ("Can't move up or down!");
	//if there is a car where the user is trying to move up, car doesnt move
	else if (curX - 1 >= 0 && slice [curX - 1] [curY] != 'n')
	    showStatus ("There is a car there!");
	//2 piece cars, go up
	else if (whichCar <= 7 && curX - 1 >= 0)
	{
	    type [curX - 1] [curY] = 'c';
	    type [curX] [curY] = 'c';
	    type [curX + 1] [curY] = 'r';
	    slice [curX - 1] [curY] = 'f';
	    slice [curX] [curY] = 'b';
	    slice [curX + 1] [curY] = 'n';
	    car [curX - 1] [curY] = whichCar;
	    car [curX] [curY] = whichCar;
	    car [curX + 1] [curY] = 0;
	    curX--;
	}
	// 3 piece trucks, go up
	else if (whichCar <= 9 && curX - 1 >= 0)
	{
	    type [curX - 1] [curY] = 'c';
	    type [curX] [curY] = 'c';
	    type [curX + 1] [curY] = 'c';
	    type [curX + 2] [curY] = 'r';
	    slice [curX - 1] [curY] = 'f';
	    slice [curX] [curY] = 'm';
	    slice [curX + 1] [curY] = 'b';
	    slice [curX + 2] [curY] = 'n';
	    car [curX - 1] [curY] = whichCar;
	    car [curX] [curY] = whichCar;
	    car [curX + 1] [curY] = whichCar;
	    car [curX + 2] [curY] = 0;
	    curX--;
	}

    }
    // allows vehicles who's default position is vertical to move down
    public void moveDown ()
    {
	//default position is horizontal, can't move down
	if (whichCar <= 4)
	    showStatus ("Can't move up or down!");
	//if there is a car where the user is trying to move down, car doesn't move
	else if (whichCar <= 7 && curX + 2 < row && slice [curX + 2] [curY] != 'n')
	    showStatus ("There is a car there!");
	//if there is a car where the user is trying to move down, truck doesn't move
	else if (whichCar > 7 && whichCar <= 9 && curX + 3 < row && slice [curX + 3] [curY] != 'n')
	    showStatus ("There is a car there!");
	//2 piece cars, go down
	else if (whichCar <= 7 && curX + 2 < row)
	{
	    type [curX] [curY] = 'r';
	    type [curX + 1] [curY] = 'c';
	    type [curX + 2] [curY] = 'c';
	    slice [curX] [curY] = 'n';
	    slice [curX + 1] [curY] = 'f';
	    slice [curX + 2] [curY] = 'b';
	    car [curX] [curY] = 0;
	    car [curX + 1] [curY] = whichCar;
	    car [curX + 2] [curY] = whichCar;
	    curX++;

	}
	//3 piece trucks, go down
	else if (whichCar <= 9 && curX + 3 < row)
	{
	    type [curX] [curY] = 'r';
	    type [curX + 1] [curY] = 'c';
	    type [curX + 2] [curY] = 'c';
	    type [curX + 3] [curY] = 'c';
	    slice [curX] [curY] = 'n';
	    slice [curX + 1] [curY] = 'f';
	    slice [curX + 2] [curY] = 'm';
	    slice [curX + 3] [curY] = 'b';
	    car [curX] [curY] = 0;
	    car [curX + 1] [curY] = whichCar;
	    car [curX + 2] [curY] = whichCar;
	    car [curX + 3] [curY] = whichCar;
	    curX++;

	}
    }
    // allows vehicles who's default position is horizontal to move left
    public void moveLeft ()
    {
	//default position is vertical, can't move left
	if (whichCar >= 5)
	    showStatus ("Can't move left or right!");
	//if there is a car where the user is trying to move left, car doesn't move
	else if (curY - 1 >= 0 && slice [curX] [curY - 1] != 'n')
	    showStatus ("There is a car there!");
	//2 piece cars, go left
	else if (whichCar <= 2 && curY - 1 >= 0)
	{
	    type [curX] [curY - 1] = 'c';
	    type [curX] [curY] = 'c';
	    type [curX] [curY + 1] = 'z';
	    slice [curX] [curY - 1] = 'f';
	    slice [curX] [curY] = 'b';
	    slice [curX] [curY + 1] = 'n';
	    car [curX] [curY - 1] = whichCar;
	    car [curX] [curY] = whichCar;
	    car [curX] [curY + 1] = 0;
	    curY--;

	}
	//3 piece trucks, go left
	else if (whichCar <= 4 && curY - 1 >= 0)
	{
	    type [curX] [curY - 1] = 'c';
	    type [curX] [curY] = 'c';
	    type [curX] [curY + 1] = 'c';
	    type [curX] [curY + 2] = 'z';
	    slice [curX] [curY - 1] = 'f';
	    slice [curX] [curY] = 'm';
	    slice [curX] [curY + 1] = 'b';
	    slice [curX] [curY + 2] = 'n';
	    car [curX] [curY - 1] = whichCar;
	    car [curX] [curY] = whichCar;
	    car [curX] [curY + 1] = whichCar;
	    car [curX] [curY + 2] = 0;
	    curY--;

	}
    }
    // allows vehicles who's default position is horizontal to move right
    public void moveRight ()
    {
	//default position is vertical, can't move right
	if (whichCar >= 5)
	    showStatus ("Can't move left or right!");
	//if there is a car where the user is trying to move right, car doesn't move
	else if (whichCar <= 2 && curY + 2 < col && slice [curX] [curY + 2] != 'n')
	    showStatus ("There is a car there!");
	//if there is a car where the user is trying to move left, truck doesn't move
	else if (whichCar > 2 && whichCar <= 4 && curY + 3 < col && slice [curX] [curY + 3] != 'n')
	    showStatus ("There is a car there!");
	//2 piece cars, go right
	else if (whichCar <= 2 && curY + 2 < col)
	{
	    type [curX] [curY] = 'z';
	    type [curX] [curY + 1] = 'c';
	    type [curX] [curY + 2] = 'c';
	    slice [curX] [curY] = 'n';
	    slice [curX] [curY + 1] = 'f';
	    slice [curX] [curY + 2] = 'b';
	    car [curX] [curY] = 0;
	    car [curX] [curY + 1] = whichCar;
	    car [curX] [curY + 2] = whichCar;
	    curY++;
	}
	// 3 piece trucks, go right
	else if (whichCar <= 4 && curY + 3 < col)
	{
	    type [curX] [curY] = 'z';
	    type [curX] [curY + 1] = 'c';
	    type [curX] [curY + 2] = 'c';
	    type [curX] [curY + 3] = 'c';
	    slice [curX] [curY] = 'n';
	    slice [curX] [curY + 1] = 'f';
	    slice [curX] [curY + 2] = 'm';
	    slice [curX] [curY + 3] = 'b';
	    car [curX] [curY] = 0;
	    car [curX] [curY + 1] = whichCar;
	    car [curX] [curY + 2] = whichCar;
	    car [curX] [curY + 3] = whichCar;
	    curY++;
	}
    }
    // telling the user they've sucessfully put the red car to the exit tile
    public void win ()
    {
	// if user get's red car onto exit tile, pop up declares they win/complete level
	if (type [2] [5] == 'c' && car [2] [5] == 0)
	{
	    nextlevel.setEnabled (true);
	    JOptionPane.showMessageDialog (null, "You got the red formula one to escape!", "Good Job!", JOptionPane.INFORMATION_MESSAGE);
	    if (number == 3)
		nextlevel.setActionCommand ("s5");
	}
	//keep nextlevel button disabled
	else
	{
	    nextlevel.setEnabled (false);
	}

    }
    //able to copy over the arrays for the levels (ints)
    public void copyOver (int a[] [], int b[] [])
    {
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		a [i] [j] = b [i] [j];
	    }
	}

    }
    //able to copy over the arrays for the levels (chars)
    public void copyOver (char a[] [], char b[] [])
    {
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		a [i] [j] = b [i] [j];
	    }
	}

    }
    //when the next button is clicked change the level
    public void next ()
    {
	number++;
	//copy in 2nd level arrays
	if (number == 2)
	{
	    level.setText ("        LEVEL 2");
	    copyOver (type, type2);
	    copyOver (car, car2);
	    copyOver (slice, slice2);
	}
	//copy in 3rd level arrays
	else if (number == 3)
	{
	    level.setText ("        LEVEL 3");
	    copyOver (type, type3);
	    copyOver (car, car3);
	    copyOver (slice, slice3);
	}
	//copy in 1st level array
	else
	{
	    level.setText ("        LEVEL 1");
	    copyOver (type, type1);
	    copyOver (car, car1);
	    copyOver (slice, slice1);
	    number = 1;
	}
	redraw ();
	whichCar = 0;
	curX = 2;
	curY = 1;
	currentPic.setIcon (createImageIcon ("little0.png"));
    }
    //reset the grid for it's particular level
    public void reset ()
    {
	//reset to default 1st level array
	if (number == 1)
	{
	    copyOver (type, type1);
	    copyOver (car, car1);
	    copyOver (slice, slice1);
	}
	//reset to default 2nd level array
	if (number == 2)
	{
	    copyOver (type, type2);
	    copyOver (car, car2);
	    copyOver (slice, slice2);
	}
	//reset to default 3rd level array
	else if (number == 3)
	{
	    copyOver (type, type3);
	    copyOver (car, car3);
	    copyOver (slice, slice3);
	}

	redraw ();
	whichCar = 0;
	curX = 2;
	curY = 1;
	currentPic.setIcon (createImageIcon ("little0.png"));
    }
    //if a button is clicked, the if statements indicate what's going to be preformed to the button
    public void actionPerformed (ActionEvent e)
    {   
	//display screen 1
	if (e.getActionCommand ().equals ("s1"))
	    cdLayout.show (p_card, "1");
	//display screen 2
	else if (e.getActionCommand ().equals ("s2"))
	    cdLayout.show (p_card, "2");
	//display screen 3
	else if (e.getActionCommand ().equals ("s3"))
	    cdLayout.show (p_card, "3");
	//display screen 4
	else if (e.getActionCommand ().equals ("s4"))
	    cdLayout.show (p_card, "4");
	//display screen 5
	else if (e.getActionCommand ().equals ("s5"))
	    cdLayout.show (p_card, "5");
	//dislay screen 6
	else if (e.getActionCommand ().equals ("s6"))
	    System.exit(0);
	//if up button clicked, move up if possible
	else if (e.getActionCommand ().equals ("up"))
	{
	    moveUp ();
	    redraw ();
	    win ();
	}
	//if down button clicked, move down if possible
	else if (e.getActionCommand ().equals ("down"))
	{
	    moveDown ();
	    redraw ();
	    win ();
	}
	//if left button clicked, move left if possible
	else if (e.getActionCommand ().equals ("left"))
	{
	    moveLeft ();
	    redraw ();
	    win ();
	}
	//if right button clicked, move right if possible
	else if (e.getActionCommand ().equals ("right"))
	{
	    moveRight ();
	    redraw ();
	    win ();
	}
	//if reset button clicked, reset board
	else if (e.getActionCommand ().equals ("Reset"))
	    reset ();
	//if next button is clicked on game screen, move on to next level
	else if (e.getActionCommand ().equals ("nextLevel"))
	    next ();
	else
	{ //code to handle the game
	    int n = Integer.parseInt (e.getActionCommand ());
	    int x = n / col;
	    int y = n % col;
	    if (type [x] [y] == 'c')
	    {
		whichCar = car [x] [y];
		findFront (x, y);
		currentPic.setIcon (createImageIcon ("little" + whichCar + ".png"));
	    }
	}
    }
}
