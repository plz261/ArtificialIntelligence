import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class LoadedDieTester {


	private double sixCounter = 0;
	private Die LoadedDie = new LoadedDie(6,6,90);
	
	//You will also need to write a tester class that will test to 
	//ensure the percentages are what you would expect. 
	
	//Hint: You can use a loop to roll you LoadedDie object many 
	//times and see if the resulting percentages are good.
	@Test
	public void testPercent ()
	
	
	{

		for (int i = 0; i < 10000; i++){
			
			
			int LoadedRoll = LoadedDie.roll();
			if (LoadedRoll == 6) {
						sixCounter = sixCounter + 1;
					}

		}
		sixCounter = sixCounter / 10000;
		assertEquals(.9, sixCounter ,.05);
	}
}
