import java.util.Random;

public class LoadedDie extends Die
{

	protected int numSides;
	protected int loadedVal;
	protected double loadedPercent;
	protected Random ranNumGenerator;
	
	public LoadedDie()
	{
		//Create additional instance variables as necessary to store the 
		//"loaded" value, and the percentage that value should be rolled.
		
		loadedVal = 6;
		loadedPercent = 0.9;
	}

//	public LoadedDie()
//	{
//		//A default constructor that creates a a six sided die that is loaded 90% to the value 6.
//        numSides = 6;
//        myRandomNumGenerator = new Random();
//	
//	}
	
	public LoadedDie(int aNumSides, int aLoadValue, double aLoadPercent)
	{
		numSides = aNumSides;
		loadedVal = aLoadValue;
		loadedPercent = aLoadPercent;
		
		
		//An additional constructor that takes in the number of sides, the 
		//loaded value and the percentage.
		
	}

	public int roll()
	{
		Random ranNumGenerator = new Random();
		int result = ranNumGenerator.nextInt(100);
		int newRoll = super.roll();
		if(result < loadedPercent) {
			return loadedVal;
		}
		else{
			while(newRoll == loadedVal)
				newRoll = super.roll();
		}
		return newRoll;
		
	//Override the roll() method and ensure that the probability to get 
	//the loaded value is the loaded percentage, and all the other values 
	//are distributed equally after that.
		
	}

}
