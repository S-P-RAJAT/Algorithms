package com.bridgelabz.algorithms;

import java.util.Scanner;

public class GuessNumber {
    public static Scanner scanner = new Scanner(System.in);

	public static void findNumber(int low, int high) {

        if (low == high) {
            System.out.println("Your Number is : " + low);
            return;
        }

        int middle = (low + high) / 2;
        if(low == middle) {
            System.out.println("Is your number : " + low);

        }else {
        System.out.println("Is your number between : " + low + " and " + middle);
        }
        boolean choice = scanner.nextBoolean();

        if (choice == true) {
            findNumber(low, middle);
        } else {
            findNumber(middle + 1, high);
        }
    }

    public static void main(String[] args) {

        int N = Integer.parseInt(args[0]);
        System.out.println("Think of a number between 0 and "+(N-1));
        findNumber(0, N - 1);
        scanner.close();

    }
}
