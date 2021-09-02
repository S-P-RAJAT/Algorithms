package com.bridgelabz.algorithms;

import java.util.*;
import com.bridgelabz.algorithms.PrimeNumbers;

public class AnagramAndPalindrome {

	public static void checkAnagramsAndPalindrome(ArrayList<Integer> listOfPrime) {

		for (int index1 = 0; index1 < listOfPrime.size(); index1++) {
			for (int index2 = index1; index2 < listOfPrime.size(); index2++) {
				boolean isAnagram = true;
				boolean isPalindrome = true;

				String string1 = String.valueOf(listOfPrime.get(index1));

				String string2 = String.valueOf(listOfPrime.get(index2));

				if (string1.length() != string2.length()) {
					isAnagram = false;
				}

				char string1Characters[] = string1.toCharArray();
				char string2Characters[] = string2.toCharArray();

				Arrays.sort(string1Characters);
				Arrays.sort(string2Characters);

				for (int index = 0; index < string1.length(); index++) {
					if (string1Characters[index] != string2Characters[index]) {
						isAnagram = false;
					}

				}
				if (isAnagram == true && string1.equals(string2) == false) {

					System.out.println(string1 + " and " + string2 + " are anagrams for each other");

					string1 = string1.toLowerCase();

					for (int index = 0; index < string1.length() / 2; index++) {
						if (string1.charAt(index) != string1.charAt(string1.length() - index - 1)) {
							isPalindrome = false;
							break;
						}
					}
					if (isPalindrome)
						System.out.println("Given number " + string1 + " is palindrome");

					isPalindrome = true;
					string2 = string2.toLowerCase();

					for (int index = 0; index < string2.length() / 2; index++) {
						if (string2.charAt(index) != string2.charAt(string2.length() - index - 1)) {
							isPalindrome = false;
							break;
						}
					}
					if (isPalindrome)
						System.out.println("Given number " + string1 + " is palindrome");

				}

			}

		}

	}

	public static void main(String[] args)

	{
		int lowerRange = 0;
		int upperRange = 1000;

		ArrayList<Integer> listOfPrime = PrimeNumbers.findPrimeNumbers(lowerRange, upperRange);

		checkAnagramsAndPalindrome(listOfPrime);

	}

}
