import java.util.ArrayList;

//
//Finally, you will write a DieGame class that will manage the 
//game activities by playing a round, getting the user's roll, 
//getting the computer's roll and determining if the user is a winner. 
//
//After the user selects High or Low, you will 
//need to reinstantiate the Die and Dice objects accordingly 
//to get the results to skew in the computer's favor.


public class DiceGame {

	
	// Player and Computer Variables
	private Dice player = new Dice();
	private Dice computer = new Dice();
	private int playerResult = 0;
	private int computerResult = 0;
	private String guess;
	
	//Constructors
	public DiceGame()
	{
		Dice player = new Dice();
		Dice computer = new Dice();
		//Default constructor creates an instance of the DieGame and is ready to be used to play the game.	
	}
	
	
	//Methods
	
	public void playRound(java.lang.String playerGuess)
	{	
		//Play a round of the game where the player's and computer's dice are rolled and stored in the game object.
		//Parameters:	playerGuess - - Whether the player has called "LOW" or "HIGH".
		
		ArrayList<Die> low = new ArrayList <Die>();
			low.add(new LoadedDie (6,1,.9));
			low.add(new Die());
	
		ArrayList<Die> high = new ArrayList <Die>();
			high.add(new LoadedDie (6,6,.9));
			high.add(new Die()); //Die());
		
			if (playerGuess == "LOW") { 
				player = new Dice(low);
				computer = new Dice(high);
				
			}
			if (playerGuess == "High") {
				computer = new Dice(low);
				player = new Dice(high);
			}
			
			playerResult = player.roll();
			computerResult = computer.roll();
			guess = playerGuess;
	}
	
	
	public int getPlayerRoll()
	{
		//Returns the value of the player's last roll.
		//Returns: 	What the player last rolled.
		return playerResult;
	}
	
	public int getComputerRoll()
	{
		//Returns the value of the computer's last roll.
		//Returns: What the computer last rolled.	
		return computerResult;
	}

	
	public boolean isWinner()
	{
		//Returns a true if the player's roll beats the computer's roll based on the last round's guess of High or low.
		//Returns:True if the player won, otherwise false.
		if ((guess == "LOW") && (playerResult < computerResult))
		{
			return true;
		}
		else if ((guess == "LOW") && (playerResult > computerResult))
		{
			return false;
		}
		else if ((guess == "HIGH") && (playerResult > computerResult))
		{
			return true;
		}
		else if ((guess == "HIGH") && (playerResult < computerResult))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}
