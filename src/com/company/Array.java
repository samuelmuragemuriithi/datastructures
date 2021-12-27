package com.company;

import java.util.Arrays;
import java.util.HashMap;

public class Array {
    static void print(int[]numbers){
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]+",");
        }
    }
    static  int [] returnOdd(int [] numbers){
        int count=0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i]%2!=0) count++;
        }
        int [] odd=new int[count++];
        int counter =0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i]%2!=0){
                odd[counter]=numbers[i];
                counter++;
            }
        }
        return odd;
    }
    static void reverse(int [] result){
        int start =0;
        int end = result.length-1;
        while (start<end){
            int temp = result[start];
            result[start]=result[end];
            result[end]=temp;
            start++;
            end--;
        }
    }
    static int min(int[]result){
        int min=result[0];
        for (int i = 0; i <result.length ; i++) {
            if (result[i]<min)min=result[i];
        }
        return min;
    }

    static int secondMax(int []result){
        int max=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        for (int i = 0; i < result.length; i++) {
            if (result[i]>max){
                max2=max;
                max=result[i];
            }
            else if (result[i]>max2&&max2!=max)max2=result[i];
        }
        return max2;
    }
    static void moveZeros(int [] array2){
        int j = 0;
        for (int i = 0; i < array2.length; i++) {
            if (array2[i]!=0&&array2[j]==0){
                int temp  =  array2[i];
                array2[i] = array2[j];
                array2[j] = temp;
            }
            if (array2[j]!=0)j++;
        }
    }
    static int[] resize(int [] numbers, int size){
        int [] newArray =new int[size];
        for (int i = 0; i < numbers.length; i++) {
            newArray[i]=numbers[i];
        }
        return newArray;
    }
    static boolean isParindome(String word){
        char[]charArray = word.toCharArray();
            int start = 0;
            int end = charArray.length-1;
            while (start<end) {
                if (charArray[start] != charArray[end]){
                    return false;
                }
                start++;
                end--;
            }
            return true;
    }
    static int sum(int [] numbers){
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum+=numbers[i];
        }
        return sum;
    }
    static boolean search(int [] numbers,int num){
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i]==num)return true;
        }
        return false;
    }
    static void print(int x){
        if (x%3==0&&x%5==0) System.out.println("fizzbuzz");
       else if (x%3==0) System.out.println("fizz");
       else if(x%5==0) System.out.println("buzz");
        else System.out.println("shit!");
    }
    static int product(int [] numbers){
        int sum = 1;
        for (int i = 0; i < numbers.length; i++) {
            sum*=numbers[i];
        }
        return sum;
    }
    static void removeDuplicates(int []arry){
        HashMap<Integer,Integer>HM=new HashMap<>();
        for (int i:arry){
            if (!HM.containsKey(i))HM.put(i,1);
            else HM.put(i, HM.get(i)+1);
        }
        for (int j: HM.keySet()){
            if (HM.get(j)>1) System.out.println(j);
        }
    }
    public static void main(String[]args){
        int [] numbers={28,3,2,3,32,123,3,2,32,33,3,32342,23,78};
        int [] result = returnOdd(numbers);
        System.out.println(Arrays.toString(result));

        System.out.print("After reversing: ");
        reverse(result);
        System.out.println(Arrays.toString(result));

        System.out.print("The minimum is: ");
        System.out.println(min(result));

        System.out.print("The second max is: ");
        System.out.println(secondMax(result));

        int [] array2 ={9,0,8,0,7,0,6,0,5,0,4,0};
        System.out.println(Arrays.toString(array2));
        System.out.print("After moving zeros to the end: ");
        moveZeros(array2);
        System.out.println(Arrays.toString(array2));

        System.out.println(Arrays.toString(result));
        System.out.print("After resizing the array: ");
        int [] newArray =resize(result,10);
        System.out.println(Arrays.toString(newArray));

        String word = "madam";
        String x= (isParindome(word)?"madam is parindome":"madam is not parindome");
        System.out.println(x);

        int [] number = {1,2,3,4};
        System.out.println("The sum is"+sum(number));

        String Ans= (search(numbers,2))?"2 is inclusive":"2 is not inclusive";
        System.out.println(Ans);

        System.out.print("fuzz buzz problem:");
        print(15);


        System.out.println(product(number));

        int [] arry = {3,3,3,3,3};
        removeDuplicates(arry);

    }
}
