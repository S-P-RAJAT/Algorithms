package com.bridgelabz.algorithms;

import java.util.Scanner;

public class BubbleSort {
	public static<E extends Comparable<E>> void bubbleSort(E arrayOfIntegers[],int size)
	{

		for(int index1=0;index1<size;index1++)
		{

			for(int index2=0;index2<size;index2++)
			{
				if(arrayOfIntegers[index2].compareTo(arrayOfIntegers[index1])>0)
				{
					E temp=arrayOfIntegers[index2];
					arrayOfIntegers[index2]=arrayOfIntegers[index1];
					arrayOfIntegers[index1]=temp;

				}

			}
		}



	}

	public static void main(String[] args)

	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter size of array");
		int size=scanner.nextInt();

		Integer arrayOfIntegers[]= new Integer[size];

		System.out.println("Enter :"+size+" number of elements");
		for(int index=0;index<size;index++)
		{
			arrayOfIntegers[index]=scanner.nextInt();

		}

		bubbleSort(arrayOfIntegers,size);

		System.out.println("After sorting, the integers are :");
		for(int index=0;index<size;index++)
		{
			System.out.print(arrayOfIntegers[index]+" ");
		}
		scanner.close();

	}
}
