package com.bridgelabz.algorithms;

import java.util.Scanner;

public class InsertionSort {
	public static String[] insertionSort(String listOfWords[])
	{

		for(int index=0;index<listOfWords.length;index++)
		{
			String wordToCheck=listOfWords[index];
			int indexToCheck=index-1;

			while(indexToCheck>=0 && listOfWords[indexToCheck].compareTo(wordToCheck)>0)
			{
				listOfWords[indexToCheck+1]=listOfWords[indexToCheck];
				indexToCheck--;
			}

			listOfWords[indexToCheck+1]=wordToCheck;

		}


		return listOfWords;
	}

	public static void main(String[] args) 

	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter list of words to perform insertion sort:");
		String string=scanner.nextLine();
		String listOfWords[] = string.toLowerCase().split(" ");
		listOfWords=insertionSort(listOfWords);
		System.out.println("After insertion sort the list of words are: ");

		for(int index=0;index<listOfWords.length;index++)
		{
			System.out.print(listOfWords[index]+" ");
		}
		scanner.close();

	}
}
