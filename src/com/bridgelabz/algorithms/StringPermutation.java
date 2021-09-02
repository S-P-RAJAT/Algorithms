package com.bridgelabz.algorithms;

import java.util.*;

public class StringPermutation {
	static String arrayOfStringsFromRecursion[];
	static String arrayOfStringsFromIteration[];
	static int arrayIndex = 0;

	public static void permute(String s, String answer) {
		if (s.length() == 0) {
			arrayOfStringsFromRecursion[arrayIndex++] = answer;
			return;
		}

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			String left_substr = s.substring(0, i);
			String right_substr = s.substring(i + 1);
			String rest = left_substr + right_substr;
			permute(rest, answer + ch);
		}
	}

	public static void generatePermutationsRecursiveMethod(String string) {

		if (string == null || string.length() == 0) {
			return;
		}

		// to get number of permutations
		int stringLength = string.length();
		int arraySize = 1;
		for (arraySize = 1; stringLength > 1; stringLength--) {
			arraySize *= stringLength;

		}

		arrayOfStringsFromRecursion = new String[arraySize];
		permute(string, "");
	}
	 private static void swap(char[] arr, int i, int j)
	    {
	        char c = arr[i];
	        arr[i] = arr[j];
	        arr[j] = c;
	    }
	 
	    // Utility function to reverse a char array between specified indices
	    private static void reverse(char[] arr, int i, int j)
	    {
	        // do till two endpoints intersect
	        while (i < j) {
	            swap(arr, i++, j--);
	        }
	    }
	public static void generatePermutationsIterativeMethod(String string) {
		// base case
		

        if (string == null || string.length() == 0) {
            return;
        }
 
        // base case
        if (string.length() == 1) {
            System.out.print(string);
            return;
        }
        arrayIndex = 0;
		int count = 0;
		int stringLength = string.length();
		int arraySize = 1;
		for (arraySize = 1; stringLength > 1; stringLength--) {
			arraySize *= stringLength;

		}
    	arrayOfStringsFromIteration = new String[arraySize];
        // sort the string in a natural order
        char[] chars = string.toCharArray();
        Arrays.sort(chars);
 
        // get length of the string
        int n = string.length();
 
        while (true)
        {
            // print the current permutation
        	arrayOfStringsFromIteration[arrayIndex++]  = String.valueOf(chars);
        	count += 1;
            /* The following code will rearrange the string to the next
               lexicographically ordered permutation (if any) or return if
               we are already at the highest possible permutation */
 
            // Find the largest index `i` such that `chars[i-1]` is less than `chars[i]`
            int i = n - 1;
            while (chars[i-1] >= chars[i])
            {
                // if `i` is the first index of the string, we are
                // already at the last possible permutation
                // (string is sorted in reverse order)
                if (--i == 0) {
                    return;
                }
            }
 
            // find the highest index `j` to the right of index `i` such that
            // `chars[j] > chars[i-1]` (`chars[i…n-1]` is sorted in reverse order)
 
            int j = n - 1;
            while (j > i && chars[j] <= chars[i-1]) {
                j--;
            }
 
            // swap character at index `i-1` with index `j`
            swap(chars, i - 1, j);
 
            // reverse substring `chars[i…n-1]`
            reverse (chars, i, n - 1);
        }
        
    }
	
	public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

	public static boolean checkTwoArrayEquality(String arrayToBeCompared[], String arrayToBeComparedWith[]) {

		if (arrayToBeCompared.length != arrayToBeComparedWith.length)
			return false;

		Arrays.sort(arrayToBeCompared);
		Arrays.sort(arrayToBeComparedWith);

		for (int index = 0; index < arrayToBeCompared.length; index++)
			if (!arrayToBeCompared[index].equals( arrayToBeComparedWith[index]))
				return false;

		return true;
	}

	public static void main(String[] args) {
		String string = "abc";
		generatePermutationsRecursiveMethod(string);
		generatePermutationsIterativeMethod(string);
		System.out.println("Permutations from recursive process");

		for (int index = 0; index < arrayOfStringsFromRecursion.length; index++) {
			System.out.print(arrayOfStringsFromRecursion[index] + " ");
		}

		System.out.println("\nPermutations from iterative process");
		for (int index = 0; index < arrayOfStringsFromIteration.length; index++) {
			System.out.print(arrayOfStringsFromIteration[index] + " ");
		}

		if (checkTwoArrayEquality(arrayOfStringsFromRecursion, arrayOfStringsFromIteration) == true) {
			System.out.println(" \ntwo arrays are equal");
		} else {
			System.out.println("\ntwo arrays are not equal");
		}
	}
}
