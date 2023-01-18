package main;
import java.util.*;
import javax.swing.*;
public class PlayerPick{
private String pick;
private String pc;
private int playerPoint = 0;
private int pcPoint = 0;
public static final String choiceA = "Rock";
public static final String choiceB = "Paper";
public static final String choiceC = "Scissors";
public PlayerPick(String pick)
{
	this.pick = pick;
}

public String winner()
{
	Scanner input = new Scanner(System.in);
	Random generator = new Random(System.currentTimeMillis());
	int pcPick = generator.nextInt(3);
	switch(pcPick)
	{
		case 0: 
			pc = choiceA;
			break;
		case 1:
			pc = choiceB;
			break;
		case 2:
			pc = choiceC;
			break;
		
	}
	String pcChoice = "PC chose " + pc;
	
	if(pc.equals(choiceC) && pick.equalsIgnoreCase(choiceB))
	{
		return pcChoice + " PC WINS";
	}
	else if(pc.equals(choiceA) && pick.equalsIgnoreCase(choiceC))
	{
		return pcChoice + " PC WINS";
	}
	else if(pc.equals(choiceB) && pick.equalsIgnoreCase(choiceA))
	{
		return pcChoice + " PC WINS";
	}
	else if(pc.equalsIgnoreCase(pick))
	{
		return pcChoice + " TIE";
	}
	else
	{
		return pcChoice + " PLAYER WINS";
	}
}

public int getPCPoint(String point, int pcPoint)
{
	String winner = point;
	if (winner.contains("PC WINS"))
	{
		pcPoint ++;
		return pcPoint;
	}
	else
	{
		return pcPoint;
	}
	
}
public int getPlayerPoint(String point, int playerPoint)
{
	String winner = point;
	if (winner.contains("PLAYER WINS"))
	{
		playerPoint ++;
		return playerPoint;
	}
	else
	{
		return playerPoint;	
	}
	
}
public ImageIcon imageChoice(ImageIcon rock, ImageIcon paper, ImageIcon scissors)
{
	if (pc.equals(choiceA))
	{
		return rock;
	}
	else if (pc.equals(choiceB))
	{
		return paper;
	}
	else
	{
		return scissors;
	}
}
}
