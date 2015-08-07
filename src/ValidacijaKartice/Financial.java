package ValidacijaKartice;
import java.util.Scanner;

public class Financial {

	// niz u koji smjestamo prefikse odredjenih kompanija
	public static final String[] prefixes = { "4", "5", "6", "37" };
	// niz sa nazivima distributera kartica
	public static final String[] banks = { "Visa", "Master Card", "Discover",
			"American Expres" };

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// korisnik unosi broj kartice
		System.out.print("\n  Enter the card number: ");
		long card = input.nextLong();

		// ispis validnosti karte
		System.out.println(isValid(card) ? "\tThe card number is valid."
				: "\tThe car number is not valid.");

		// broj kartice ubacujemo u string 
		String cardStr = card + "";

		// ako je kartica validan provjeravamo da li prefix odgovara nekom od
		// prefiksa
		if (isValid(card)) {
			for (int i = 0; i < prefixes.length; i++) {
				if (cardStr.substring(0, prefixes[i].length()).equals(
						prefixes[i])) {
					System.out.println("\tThe card belongs to: " + banks[i]
							+ ".");
				}
			}
		}

		input.close();

	}

	/** Metoda koja provjerava da li je broj kartice validan */
	public static boolean isValid(long number) {
		boolean isValid = true;
		int size = getSize(number);

		// provjeravamo duzinu broja kartice
		if (size < 13 && size > 16)
			isValid = false;

		// zbir duplih cifara na parnim mjestima i cifara na neparnim mjestima
		// mora biti djeljiv sa 10
		if ((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 != 0)
			isValid = false;

		return isValid;
	}

	/** Metoda vraca sumu brojeva na parnim pozicijama od desna na lijevo */
	public static int sumOfDoubleEvenPlace(long number) {
		String numStr = number + "";

		int sumEven = 0;

		for (int i = numStr.length() - 2; i >= 0; i -= 2) {

			int num = Character.getNumericValue(numStr.charAt(i));

			sumEven += getDigit(num);

		}

		return sumEven;
	}

	/**
	 * Ako je broj *2 < 10 metoda vraca proizvod ako je broj *2 >= 10 metoda
	 * vraca zbir cifara
	 */
	public static int getDigit(int number) {

		int result = 0;

		// Ako je broj *2 >= 10 metoda vraca zbir cifara
		if (number * 2 >= 10) {
			String twoDigitNum = number + number + "";
			result += Character.getNumericValue(twoDigitNum.charAt(0));
			result += Character.getNumericValue(twoDigitNum.charAt(1));
			return result;
		} else {
			// Ako je broj *2 < 10 metoda vraca proizvod
			number *= 2;
			return number;
		}
	}

	/** Metoda vraca sumu brojeva na neparnih mjestima */
	public static int sumOfOddPlace(long number) {
		String numStr = number + "";

		int sumOdd = 0;

		// prolazimo kroz neparne pozicije od desna na lijevo
		for (int i = numStr.length() - 1; i >= 0; i -= 2) {
			String currentChar = numStr.charAt(i) + "";
			sumOdd += Integer.parseInt(currentChar);
		}

		return sumOdd;
	}

	/** Metoda vraca true ukoliko se prefixi poklapaju */
	// metodu sam napisao ali ju nisam implementirao jer sam uradio
	// na jednostavniji nacin
	public static boolean prefixMatched(long number, int d) {

		String num = number + "";
		String prefix = d + "";

		if (prefix.equals(num.substring(0, prefix.length())))
			return true;
		else
			return false;
	}

	/** Metoda koja vraca duzinu broja */
	public static int getSize(long d) {
		String numStr = d + "";
		return numStr.length();
	}

	/** Metoda koja vraca prefiks kartice */
	// takodje napisana ali nije koristena u programu
	public static long getPrefix(long number, int k) {
		String numStr = number + "";
		String result = numStr.substring(0, k);

		return Long.parseLong(result);
	}

}
