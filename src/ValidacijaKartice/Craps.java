package ValidacijaKartice;
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
	 */

	public static void main(String[] args) {

		// varijable kojima simuliramo bacanje kocke
		int kocka1 = 1 + (int) (Math.random() * 6);
		int kocka2 = 1 + (int) (Math.random() * 6);

		int sum = kocka1 + kocka2;

		int point;

		// printanje bacenih brojeva
		System.out.println("You rolled " + kocka1 + " + " + kocka2 + " = "
				+ sum);

		// ako je suma 2, 3 ili 12 korisnik gubi
		if (sum == 2 || sum == 3 || sum == 12)
			System.out.println("You lose");

		// ako je suma 7 ili 11 korisnik pobjedjuje
		else if (sum == 7 || sum == 11)
			System.out.println("You win");
		// ako suma nije ni jedan od gore navedenih brojeva
		// igra se nastavlja dok korisnik ne baci 7 ili point
		else {
			point = sum;
			System.out.println("point is " + point);

			do {
				// ponovno bacanje kocke
				kocka1 = 1 + (int) (Math.random() * 6);
				kocka2 = 1 + (int) (Math.random() * 6);
				sum = kocka1 + kocka2;

				// printanje bacenih brojeva
				System.out.println("You rolled " + kocka1 + " + " + kocka2
						+ " = " + sum);

			} while (sum != 7 && sum != point);

			if (sum == 7)
				System.out.println("You lose");
			else
				System.out.println("You won");

		}
	}

}
