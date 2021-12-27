package com.company;

import java.util.Scanner;

public class suitcase {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter the number of days for the holiday: ");
        int days = scanner.nextInt();

        System.out.print("how many beach shorts have you packed: ");
        int shorts = scanner.nextInt();
        while (shorts<days){
            System.out.println("kindly add more shirts");
            System.out.print("how many beach shorts have you packed: ");
            shorts = scanner.nextInt();
        }

        System.out.print("how many beach shirts have you packed: ");
        int shirts = scanner.nextInt();
        while (shirts<days){
            System.out.println("kindly add more shirts");
            System.out.print("how many beach shorts have you packed: ");
            shirts = scanner.nextInt();
        }
        System.out.println("you have packed "+shorts+"shorts");
        System.out.println("you have packed "+shirts+"shirts");
        System.out.println("congrats!! yours suit case is set");

    }
}
