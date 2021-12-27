package com.company;

import java.util.Scanner;

public class mary {
    public static void main(String[] args) {
        System.out.println("choose from the shapes:");
        System.out.println("if circle press 1,if rectangle press 2,if sphere press 3");
        Scanner scanner= new Scanner(System.in);
        int shape = scanner.nextInt();
        if (shape==1){
            System.out.println("enter radius:");
           final double pie = 3.14;
            int radius = scanner.nextInt();

            double area = pie*radius*radius;
            System.out.println("Your area is:"+area);
        }

        if(shape==2){
            System.out.println("enter length");
            int length = scanner.nextInt();
            System.out.println("enter width");
            int width = scanner.nextInt();

            int rectangle= length*width;
            System.out.println("Your area is: "+rectangle);
        }
        if(shape==3){
            System.out.println("enter radius: ");
            int radius = scanner.nextInt();
            final double pie = 3.14;
            double fraction = 1.333;
            double volume = fraction*pie*radius*radius*radius;

            System.out.println("volume is"+ volume);
        }

    }
}
