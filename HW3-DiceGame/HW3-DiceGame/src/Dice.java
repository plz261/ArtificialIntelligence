import java.util.ArrayList;


public class Dice 
{
	
	//-----------------------------------------------
	//Variables
	//-----------------------------------------------
	//Instance Variables: ArrayList of Die objects.
	private ArrayList<Die> diceArray; // = new ArrayList<Die>();
			
	//-----------------------------------------------
	//Constructors
	//-----------------------------------------------
	//**Takes no parameters. Creates 2 - six sided Die objects.
	
	public Dice()
	{
		
		
		diceArray = new ArrayList<Die>();
	    diceArray.add(new Die());
	    diceArray.add(new Die());
	    
	}
	
	//**Takes an ArrayList of Die objects to use
	public Dice (ArrayList<Die> someDice)
	{
			diceArray = new ArrayList<Die>();
			
			diceArray.addAll(someDice);
	}
	
	//**Takes in one int (one for number of dice) 
		//which creates that number of six sided dice
	public Dice (int aNumDice)
	{
		
		diceArray = new ArrayList<Die>();
		for (int i = 0; i < aNumDice; i++)
			diceArray.add(new Die()); //loop through adding die objects
	}
	
	//**Takes in two int values (one for number of dice, 
			//one for the number o sides) which creates that 
			//number dice with the number of inputted sides.
	public Dice (int aNumDice, int numSides)
	{
		diceArray = new ArrayList<Die>();
		for (int i = 0; i < aNumDice; i++) //loop through adding die objects
				
			diceArray.add(new Die(numSides));
	}
	
	
	
	
	//------------------------------
	//Class Methods
	//------------------------------
	//containsDice - takes 0 parameters, and returns a String value representing all of the dice.
	public String containsDice()
	{
		String dieString = "(";
		//loop through adding die objects
		for (int i = 0; i < diceArray.size(); i++)
			dieString = dieString + diceArray.get(i).getNumOfSides() + " "; 
		
		return dieString + ")"; // returning string value
	}
	//roll - takes 0 parameters, and returns an int value that is the sum of all the dice rolled.
	public int roll()   
	   {  
		int total = 0;
		for (int i = 0; i < diceArray.size(); i++)
			total = total + diceArray.get(i).roll();
		
	        //loop through Die objects rolling each and add up the total and return it
		return total;
	   }
	
	//add - takes a Die object as an input paramater and adds it to the current dice.
	public void add(Die aDie)
	{
		diceArray.add(aDie);
	}
}
