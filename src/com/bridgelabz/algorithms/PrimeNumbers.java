package com.bridgelabz.algorithms;

import java.util.ArrayList;

public class PrimeNumbers {
	
	
	public static boolean isPrime(int number) {
		boolean isPrimeNumber = true;

		if (number <= 1) {
			isPrimeNumber = false;
		} else if (number == 2) {
			isPrimeNumber = true;
		} else if (number % 2 == 0) {
			isPrimeNumber = false;
		} else {
			for (int i = 3; i <= Math.sqrt(number); i += 2) {
				if (number % i == 0) {
					isPrimeNumber = false;
					break;
				}
			}
		}
		return isPrimeNumber;
	}
	public static ArrayList<Integer> findPrimeNumbers(int lowerBound, int upperBound) {
		ArrayList<Integer> primeNumberList = new ArrayList<Integer>();
		for (int number = lowerBound; number <= upperBound; number++) {
			if(isPrime(number)) {
				primeNumberList.add(number);
			}
		}
		return primeNumberList;
	}

	public static void main(String[] args)

	{
		int lowerBound = 0;
		int upperBound = 1000;

		ArrayList<Integer> listOfPrime = findPrimeNumbers(lowerBound, upperBound);
		for (Integer primeNumber : listOfPrime) {
			System.out.print(primeNumber+" ");
		}
	}
}