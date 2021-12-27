package com.company;

import java.util.Arrays;

public class MaxPQ {
    private Integer [] heap;
    private  int n;
    public MaxPQ(int capacity){
         heap=new Integer[capacity+1];
         n= 0;
    }
    public boolean isEmpty(){
        return n==0;
    }
    public int size(){
        return n;
    }
    public void insert(int value){
        if (n==heap.length-1)resize(2*heap.length);
        n++;
        heap[n]=value;
        swim(n);
    }
    private void  resize(int capacity){
        Integer[]newArr=new Integer[capacity];
        for (int i = 0; i <heap.length ; i++) {
            newArr[i]=heap[i];
        }
        heap=newArr;
    }
    private void swim(int k){
        while (k>1&&heap[ k/2]<heap[ k]){
            int temp = heap[k];
            heap[k] = heap[k/2];
            heap[k/2] = temp;
            k=k/2;
        }
    }
    public void display(){
        System.out.print("[");
        for (int i = 1; i <= n ; i++) {
            System.out.print(heap[i]+" ");
        }
        System.out.print("]");
    }
    public int deleteMax(){
        int max = heap[1];
        n--;
        swap(1,n);
        sink(1);
        heap[n+1]=null;
        if (n<(heap.length-1)/4)resize(heap.length/2);
        return max;
    }
    public void swap(int a,int b){
       int temp = heap[a];
       heap[a] = heap[b];
       heap[b] = temp;
    }
    public void sink(int k){
        while (n>2*k){
            int j= 2*k;
            if (n>j&&heap[j]<heap[j+1])j++;
            if (heap[k]>heap[j])break;
            swap(k,j);
            k=j;
        }
    }
    public static void main(String[]args){
        MaxPQ maxPQ= new MaxPQ(3);
        maxPQ.insert(4);
        maxPQ.insert(5);
        maxPQ.insert(2);
        maxPQ.insert(6);
        maxPQ.insert(1);
        maxPQ.insert(3);
        System.out.println(maxPQ.size() );
        maxPQ.display();

        System.out.println();
        System.out.println(maxPQ.deleteMax());
        maxPQ.display();
    }
}
