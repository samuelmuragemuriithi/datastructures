package com.company;

import java.util.Arrays;

public class sortingAlgorithms {
    static int LinearSearch(int [] arr,int key){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==key)return i;
        }
        return -1;
    }
    static void bubbleSort(int []arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    static int binarySearch(int [] arr,int key){
        int start = 0;
        int end = arr.length-1;
        while (start<=end){
            int mid = (start+end)/2;
            if (arr[mid] == key)return mid;
            if (arr[mid] > key)end= mid -1;
            else start = mid+1 ;
        }
        return -1;
    }
    static int targetIndex(int [] arr, int key){
        int start = 0;
        int end = arr.length-1;
        while (start<=end){
            int mid = start+(end-start)/2;
            if(key==arr[mid])return mid;
            if (key < arr[mid])end=mid-1;
            else start =mid +1;
        }
        return start;
    }
    static void insertionSort(int [] arr){
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i-1;
            while (j>=0 && arr[j]>temp){
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=temp;
        }
    }
    public static void main (String  [] args){
        int [] arr= {9,4,3,2,3,4,5,6,6,7,8};
        int key = 10;
        System.out.println(Arrays.toString(arr));
        System.out.print(key+ " is at index: ");
        System.out.println( LinearSearch(arr,key));

        System.out.print("After bubble sort: ");
        bubbleSort(arr);
        System.out.print(Arrays.toString(arr));

        System.out.println();
        int [] arr2= {9,4,3,2,3,4,5,6,6,7,8};
        System.out.print("After insertion sort: ");
        insertionSort(arr2);
        System.out.print(Arrays.toString(arr2));

        System.out.println();
        System.out.print(key+ " is at index: ");
        System.out.println( binarySearch(arr,key));



        System.out.print(key+ " is at index/will be at index: ");
        System.out.println( targetIndex(arr,key));
    }
}

