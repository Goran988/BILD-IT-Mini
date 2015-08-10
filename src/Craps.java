public class Craps {
	/**
	 * Craps is a popular dice game played in casinos. Write a program to play a
	 * variation of the game, as follows: Roll two dice. Each die has six faces
	 * representing values 1, 2, …, and 6, respectively. Check the sum of the
	 * two dice. If the sum is 2, 3, or 12 (called craps), you lose; if the sum
	 * is 7 or 11 (called natural), you win; if the sum is another value (i.e.,
	 * 4, 5, 6, 8, 9, or 10), a point is established. Continue to roll the dice
	 * until either a 7 or the same point value is rolled. If 7 is rolled, you
	 * lose. Otherwise, you win.
	 * 
	 */
	public static void main(String[] args) {
		int diceA = (int) (Math.random() * 6 + 1);					//we start with two randomed numbers in the range of 1-6 that simultes dice rolls
		int diceB = (int) (Math.random() * 6 + 1);
		int sum = diceA + diceB;	
		int point = 0;
		if (sum == 2 || sum == 3 || sum == 12) {					//depending of the sum of our numbers we printout if the player won or lost
			System.out.println("You rolled " + diceA + "+" + diceB + "=" + sum);
			System.out.println("You lose.");
		} else if (sum == 7 || sum == 11) {
			System.out.println("You rolled " + diceA + "+" + diceB + "=" + sum);
			System.out.println("You win.");
		} else if (sum == 4 || sum == 5 || sum == 6 || sum == 8 || sum == 9		//in case user didn't won/lost and game isn't over yet we procide with new rolls
				|| sum == 10) {
			point = sum;														//and we  keep previous sum as "point" value
			System.out.println("You rolled " + diceA + "+" + diceB
					+ " point is " + sum);

			diceA = (int) (Math.random() * 6 + 1);
			diceB = (int) (Math.random() * 6 + 1);
			sum = diceA + diceB;
			if (point == sum) {													//if the new sum is equal to previous one user won, otherwise user lost
				System.out.println("You rolled " + diceA + "+" + diceB);
				System.out.println("You win");
			} else {
				System.out.println("You rolled " + diceA + "+" + diceB);
				System.out.println("You lose.");
			}
		}
	}

}
