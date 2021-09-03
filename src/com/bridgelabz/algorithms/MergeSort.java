package com.bridgelabz.algorithms;

import java.util.Scanner;

public class MergeSort {
	public static  <E extends Comparable<E>> void merge(E listOfWords[],int startIndex,int middleIndex,int endIndex)
	{

		int leftSubarraySize=middleIndex-startIndex+1;
		int rightSubarraySize=endIndex-middleIndex;

		E[] leftSubArray  = (E[]) new Comparable[leftSubarraySize];
		E[] rightSubArray = (E[]) new Comparable[rightSubarraySize];

		for(int index=0;index<leftSubarraySize;index++)
		{
			leftSubArray[index]=listOfWords[index+startIndex];

		}

		for(int index=0;index<rightSubarraySize;index++)
		{
			rightSubArray[index]=listOfWords[index+middleIndex+1];

		}

		int leftIndex=0,rightIndex=0;
		int currentIndex=leftIndex;

		while(leftIndex<leftSubarraySize && rightIndex<rightSubarraySize)
		{
			if(leftSubArray[leftIndex].compareTo(rightSubArray[rightIndex])<0)
			{
				listOfWords[currentIndex]=leftSubArray[leftIndex];
				leftIndex++;

			}
			else
			{
				listOfWords[currentIndex]=rightSubArray[rightIndex];
				rightIndex++;

			}

			currentIndex++;
		}

		while(leftIndex<leftSubarraySize)
		{
			listOfWords[currentIndex]=leftSubArray[leftIndex];
			currentIndex++;
			leftIndex++;
		}

		while(rightIndex<rightSubarraySize)
		{
			listOfWords[currentIndex]=rightSubArray[rightIndex];
			currentIndex++;
			rightIndex++;
		}

	}

	public static<E extends Comparable<E>> void mergeSort(E listOfWords[],int leftIndex,int rightIndex)
	{

		if(leftIndex<rightIndex)
		{
			int middleIndex=leftIndex+(rightIndex-leftIndex)/2;
			mergeSort(listOfWords, leftIndex, middleIndex);
			mergeSort(listOfWords, middleIndex+1, rightIndex);

			merge(listOfWords,leftIndex,middleIndex,rightIndex);

		}


	}

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter list of words to perform merge sort:");

		String string=scanner.nextLine();
		String listOfWords[] = string.toLowerCase().split(" ");
		mergeSort(listOfWords,0,listOfWords.length-1);
		System.out.println("After merge sort , the words are: ");

		for(int index=0;index<listOfWords.length;index++)
		{
			System.out.print(listOfWords[index]+" ");
		}
		System.out.println("\nEnter number of elements");
		int size= scanner.nextInt();
		System.out.println("Enter 5 numbers to perform merge sort");

		Integer arrayOfNumbers[] = new Integer[size];

		for(int index=0;index<size;index++)
		{
			arrayOfNumbers[index]=scanner.nextInt();
		}

		mergeSort(arrayOfNumbers,0,arrayOfNumbers.length-1);
		System.out.println("After insertion sort , the words are: ");

		for(int index=0;index<arrayOfNumbers.length;index++)
		{
			System.out.print(arrayOfNumbers[index]+" ");
		}
		scanner.close();
	}
	
	
}
