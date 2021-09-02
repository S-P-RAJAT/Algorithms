package com.bridgelabz.algorithms;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class BinarySearch {
	
	public static <E extends Comparable<E>> void binarySearch(E[] listOfWords,int firstIndex,int lastIndex,E key ) {
		int middleIndex = (firstIndex + lastIndex) / 2;

		while (firstIndex <= lastIndex) {
			if (listOfWords[middleIndex].compareTo(key) < 0) {
				firstIndex = middleIndex + 1;
			} else if (listOfWords[middleIndex].compareTo(key) == 0) {
				System.out.println("Given word : " + key + " is found at index: " + middleIndex);
				break;
			} else {
				lastIndex = middleIndex - 1;
			}
			middleIndex = (firstIndex + lastIndex) / 2;
		}
		if (firstIndex > lastIndex) {
			System.out.println("Given word : " + key + " is not found");
		}

	}

	public static void main(String[] args) {
		System.out.println("Enter the list of words :");
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();

		System.out.println("List of words after sorting:");
		String listOfWords[] = string.toLowerCase().split(",");

		Arrays.sort(listOfWords);

		for (String word : listOfWords) {
			System.out.print(word+" ");
		}
		System.out.println("\n\nEnter the key word to search");
		String key = scanner.next();

		Arrays.sort(listOfWords);
		binarySearch(listOfWords, 0, (listOfWords.length) - 1, key);
		scanner.close();
	}
}
