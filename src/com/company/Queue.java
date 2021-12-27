package com.company;

import java.util.Arrays;

public class Queue {
    private ListNode front;
    private ListNode rear;
    private int length;
    public class ListNode{
      private int data;
      private ListNode next;
      public ListNode(int data){
          this.data=data;
          this.next=null;
      }
        private String data1;
      private ListNode next1;
        public ListNode(String data1) {
            this.data1=data1;
            this.next1=null;
        }
    }
    public Queue(){
        this.front=null;
        this.rear=null;
        this.length=0;
    }
    public int length(){
        return length;
    }
    public boolean isEmpty(){
       return length==0;
    }
    public void enqueue(int value){
        ListNode temp = new ListNode(value);
        if (isEmpty())front=temp;
        else rear.next=temp;
        rear=temp;
        length++;
    }
    public void offer(String value){
        ListNode temp = new ListNode(value);
        if (isEmpty())front=temp;
        else rear.next=temp;
        rear=temp;
        length++;
    }
    public void display(){
        ListNode current = front;
        while (current!=null){
            System.out.print(current.data+"->");
            current=current.next;
        }
        System.out.print("null");
    }
    public int deque(){
        if (isEmpty())throw  new IllegalArgumentException();
        int result = front.data;
        front=front.next;
        if (front==null)rear=null;
        length--;
        return result;
    }
    public String deque1(){
        if (isEmpty())throw  new IllegalArgumentException();
        String result = front.data1;
        front=front.next;
        if (front==null)rear=null;
        length--;
        return result;
    }
   static String [] toBinary(int n){
        String [] result =new String[n];
        Queue que =new Queue();
        que.offer("1");
       for (int i = 0; i <result.length ; i++) {
           result[i]= que.deque1();
           String n1= result[i]+"0";
           String n2=result[i]+"1";
           que.offer(n1);
           que.offer(n2);
       }
       return result;
   }
    public static void main(String[]args){
        Queue queue=new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.display();

        System.out.println();
        System.out.print("deleted item is: "+ queue.deque());
        System.out.println();
        System.out.print("new queue is: ");
        queue.display();

        System.out.println();
        System.out.print("After converting to binary");
        System.out.println();
        String[]ans= toBinary(10);
        System.out.println(Arrays.toString(ans));
    }
}
