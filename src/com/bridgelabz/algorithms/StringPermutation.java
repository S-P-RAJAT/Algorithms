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
	public static void generatePermutationsIterativeMethod(String string)
	{
		if (string == null || string.length() == 0) 
		{
			return;
		}

		List<String> partialPermutation = new ArrayList<>();

		partialPermutation.add(String.valueOf(string.charAt(0)));

		for (int index1 = 1; index1 < string.length(); index1++)
		{

			for (int index2 = partialPermutation.size() - 1; index2 >= 0 ; index2--)
			{
				String partialString = partialPermutation.remove(index2);


				for (int index3 = 0; index3 <= partialString.length(); index3++)
				{
					partialPermutation.add(partialString.substring(0, index3) + string.charAt(index1) + partialString.substring(index3));
				}
			}
		}


		arrayOfStringsFromIteration= new String[partialPermutation.size()];
		partialPermutation.toArray(arrayOfStringsFromIteration);
		//System.out.println(partialPermutation);
	}
	public static void main(String[] args) {
		String string = "abc";
		generatePermutationsRecursiveMethod(string);		
		generatePermutationsIterativeMethod(string);
		System.out.println();
	}
}
