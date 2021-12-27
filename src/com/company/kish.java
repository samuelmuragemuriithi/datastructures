package com.company;

import java.util.Scanner;

public class kish {
    public static void main(String[] args) {
        System.out.println("enter your heights in cm");
        Scanner scanner= new Scanner(System.in);
        System.out.print("height1: ");
        int height1 = scanner.nextInt();
        System.out.print("height2: ");
        int height2 = scanner.nextInt();
        System.out.print("height3: ");
        int height3 = scanner.nextInt();

        int [] heights ={height1,height2,height3};
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            if(heights[i]>max)max=heights[i];
        }
        System.out.println("the tallest person is  :"+ max+"cm");
    }
}
