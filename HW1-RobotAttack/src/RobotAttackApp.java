import java.io.*;
import java.util.Scanner;

public class RobotAttackApp {
	public static void main(String[] args){
		
		//Objects - Robot and player
		Robot player = new Robot();
		Robot computer = new Robot();
		
		//Variables
		String L;
		String R;
		String P;		
		String userData;

		
		userData = userInput.nextLine(); 
		
		while (!player.isDisabled() && !computer.isDisabled()) {			
			System.out.println("<L>aser attack, <R>ocket attack, or <P>Power up? ");
			
			Scanner userInput = new Scanner(System.in);	
			
			if (userData.equals("L")) {
				if (player.laserAttack(computer) == true){
					System.out.println("Player hits computer with laser");
				}
				else {
					System.out.println("Player misses computer with laser");
				}
			}
			else if	(userData.equals("R")) {
					if (player.laserAttack(computer) == true){
						System.out.println("Player hits computer with Rocket");
					}
					else {
						System.out.println("Player misses computer with Rocket");
					}
			}
			else if (userData.equals("P")) {
				player.powerUp();
				System.out.println("Player powers up");
			}
			else {
				System.out.println("Must type a letter L, R, or P");
			}
			
		
		System.out.println("Player's robot is " + player.getCurrentStatus());
		System.out.println("Computer's robot is " + computer.getCurrentStatus());
		
		if (player.isDisabled()) {
			System.out.println("The computer destroyed your robot");
		}
		else if (computer.isDisabled()) {
			System.out.println("You destroyed the robot!");
		}
		}
	}
}

