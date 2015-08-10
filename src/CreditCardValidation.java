import java.util.Scanner;

public class CreditCardValidation {
	/**
	 * Write a program that checks if credit card is valid. Credits card number
	 * must be between 13 and 16 digits long and start with following numbers 4
	 * for Visa cards 5 for Master cards 37 for American Express cards 6 for
	 * Discover cards We used "Luhn check" or the "Mod 10 check" to see if the
	 * cards are valid
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of your credit card:");
		long cardNumber = input.nextLong();
		if (isValid(cardNumber)
				&& (getSize(cardNumber) >= 13 && getSize(cardNumber) <= 16)
				&& prefixMatched(cardNumber)) {
			System.out.println("Card is valid");
		} else
			System.out.println("Card is invalid");
	}

	public static boolean isValid(long num) {
		// Method that check is the sum of digits is divisible by 10
		int sum = sumOfDoubleEvenPlace(num) + sumOfOddPlace(num);
		if (sum % 10 == 0) {
			return true;
		} else
			return false;
	}

	public static int sumOfDoubleEvenPlace(long num) {
		//method that adds double value of digits on even spaces(right to left)
		String nums = Long.toString(num);					//converted number to string so we can easier iterate over the digits
		int sum = 0;
		for (int i = nums.length() - 2; i >= 0; i -= 2) {
			sum += getDigit(Character.getNumericValue((nums.charAt(i))));
		}
		return sum;
	}

	public static int sumOfOddPlace(long num) {
		//method that calculates sum of digits on odd places(right to left), again converted number to string to easier iterate over digits
		String nums = Long.toString(num);
		int sum = 0;
		for (int i = nums.length() - 1; i >= 0; i -= 2) {
			sum += Character.getNumericValue(nums.charAt(i));
		}
		return sum;

	}

	public static int getDigit(int num) {
		//method that gives back double the value of digit, the new value is two digits, it returns those digits added up
		num = 2 * num;
		if (num <= 9)
			return num;
		else
			return ((num / 10) + (num % 10));
	}

	public static int getSize(long num) {
		//method that returns how many digits number have
		return Long.toString(num).length();
	}

	public static boolean prefixMatched(long num) {
		//method that checks if the prefix of the number user entered matches prefix used by companies
		String nums = Long.toString(num);
		char ch = nums.charAt(0);
		if (ch == '4' || ch == '5' || ch == '6')
			return true;
		else if (nums.substring(0, 2).equals("37"))
			return true;
		else
			return false;
	}

}
