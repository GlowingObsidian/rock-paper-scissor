/*

Old school rock, paper and scissor game with true dedicated random choice generator
Written by Shreyan Dey.
Copyright 2018 AUDE labs.
All rights reserved.
v1.5
Compiled on 23/3/2018

*/ 

import java.util.Scanner;

class rps
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of turns you want to play: ");
		int n = sc.nextInt();
		System.out.println();
		System.out.println("Enter r for rock, s for scissor and p for paper");
		System.out.println();
		game_start(n);
		
	}
    
    //game starts here
    static void game_start(int n)
    {

    	Scanner sc = new Scanner(System.in);
    	char c1;
    	char c2;
    	int p1 = 0;
    	int p2 = 0;

    	for(int i = 1; i<=n; i++)
    	{
    		System.out.print("Enter your choice: ");
    		c1= sc.next().charAt(0);
    		c2=computer_choice();
    		//-----------------------------------------------------------------
    		switch(c2)
    		{
    		case 'r':
    		System.out.println("Computer: Rock");
    		break;

    		case 'p':
    		System.out.println("Computer: Paper");
    		break;

    		case 's':
    		System.out.println("Computer: Scissor");
    		break;
    	    }
    		//------------------------------------------------------------------
    		int ch = check(c1,c2);

    		if(ch == 1)
    		{
    			p1 += 1;
    		}
    		else if(ch == 0)
    		{
    			p2 += 1;
    		}
    		else if(ch == -1)
    		{

    		}
    		System.out.println();
    		//--------------------------------------------------------------------
    	}
    	result(p1,p2);
    }

    //A random choice generator for computer's throws
	static char computer_choice()
    {
	    char c;
	    int x = ((int)(Math.random()*10)) % 3;
	    if(x == 1)
	    {
		    c = 'r';
	    }
	    else if(x == 2)
	    {
		    c = 'p';
	    }
	    else
	    {
		    c = 's';
	    }
	    return c;
    }

    //Check the combination to determine points for either side
    static int check(char c1,char c2)
    {
    	int side = -1;
    	if(c1 == c2)
    		{
    			System.out.println("Same throw! so no points.");
    			side = -1;

    		}
    		//------------------------------------------------------------------
    		else if(c1 == 'r' && c2 == 'p')
    		{
    			System.out.println("Computer's paper was too big for your rock!");
    			side = 0;
    		}
    		else if(c1 == 'p' && c2 == 'r')
    		{
    			System.out.println("A pen is mightier than a sword. Your paper blocked computer's rock!");
    			side = 1;
    		}
    		//-------------------------------------------------------------------
    		else if(c1 == 'p' && c2 == 's')
    		{
    			System.out.println("As we know paper can't stand against scissors!");
    			side = 0;
    		}
    		else if(c1 == 's' && c2 == 'p')
    		{
    			System.out.println("Nice throw ! Your scissors pierced through the paper.");
    			side = 1;
    		}
            //---------------------------------------------------------------------
    		else if(c1 == 's' && c2 == 'r' )
    		{
    			System.out.println("Rock is way too hard for scissors!");
    			side = 0;
    		}
    		else if(c1 == 'r' && c2 == 's')
    		{
    			System.out.println("Your rock broke computer's scissors!!");
    			side = 1;
    		}
    		return side;
    }
    //compute who has won
    static void result(int p1,int p2)
    {
    	System.out.println("Points");
    	System.out.println("Player: "+p1);
    	System.out.println("Computer: "+p2);
    	if(p1 > p2)
    	{
    		System.out.println("Woohoo! you won!");
    	}
    	else if(p2 > p1)
    	{
    		System.out.println("Sorry but computer won. Better luck next time!");
    	}
    	else if(p2 == p1)
    	{
    		System.out.println("Its a tie!");
    	}
    }
}