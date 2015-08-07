package Klase;
public class Bonus {

	/** Igra Craps brojanje pobjeda */

	public static void main(String[] args) {

		int winCount = 0;

		for (int i = 0; i < 10000; i++) {
			// varijable kojima simuliramo bacanje kocke
			int kocka1 = 1 + (int) (Math.random() * 6);
			int kocka2 = 1 + (int) (Math.random() * 6);

			int sum = kocka1 + kocka2;

			int point;


			// ako je suma 2, 3 ili 12 korisnik gubi
			if (sum == 2 || sum == 3 || sum == 12);
				

			// ako je suma 7 ili 11 korisnik pobjedjuje
			else if (sum == 7 || sum == 11) {
				winCount++;
			}
			// ako suma nije ni jedan od gore navedenih brojeva
			// igra se nastavlja dok korisnik ne baci 7 ili point
			else {
				point = sum;

				do {
					// ponovno bacanje kocke
					kocka1 = 1 + (int) (Math.random() * 6);
					kocka2 = 1 + (int) (Math.random() * 6);
					sum = kocka1 + kocka2;

				} while (sum != 7 && sum != point);

				if (sum == 7);

				else {
					winCount++;
				}
			}
		}
		
		System.out.println("The game ran 10000 times, and you won " + winCount + " times.");

	}

}
