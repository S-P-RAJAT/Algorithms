package com.bridgelabz.algorithms;

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

	public static void main(String[] args) {
		String string = "abc";
		generatePermutationsRecursiveMethod(string);
		System.out.println();
	}
}
