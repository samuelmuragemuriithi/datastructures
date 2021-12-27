package com.company;

import java.util.NoSuchElementException;

public class Circularlinkedlist {
    private ListNode tail;
    private int length;
    private class ListNode{
        private ListNode next;
        private int data;
        public ListNode (int data){
            this.data=data;
        }
    }
    public Circularlinkedlist(){
        this.tail=null;
        this.length=0;
    }
    public int length(){
        return length;
    }
    public boolean isEmpty(){
        return length == 0;
    }
    public void createCircularlinkedlist(){
        ListNode first= new ListNode(1);
        ListNode second= new ListNode(2);
        ListNode third= new ListNode(3);
        ListNode fourth= new ListNode(4);
        first.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=first;
        tail=fourth;

    }
    public void display(){
        if (tail==null)return;
        ListNode first=tail.next;
        while (first!=tail){
            System.out.print(first.data+"->");
            first=first.next;
        }
        System.out.println(first.data);
    }
    public void insertFirst(int value){
        ListNode temp = new ListNode(value);
        if (tail==null)tail=temp;
        else temp.next=tail.next;
        tail.next=temp;
        length++;
    }
    public void insertEnd(int value){
        ListNode temp = new ListNode(value);
        if (tail==null){
            tail=temp;
            temp.next=tail.next;
        }
        else {
            temp.next=tail.next;
            tail.next=temp;
            tail=temp;
        }

        length++;
    }
    public ListNode deletFirst(){
        if (isEmpty())throw new NoSuchElementException();
        ListNode head = tail.next;
        if (head==tail)tail=null;
        else tail.next=head.next;
        head.next=null;
        length--;
        return head;
    }
    public static void main(String[]args){
        Circularlinkedlist cll=new Circularlinkedlist();
        cll.createCircularlinkedlist();
        cll.display();

        System.out.print("After adding 0 at the begining: ");
        cll.insertFirst(0);
        cll.display();

        System.out.print("After adding 5 at the End: ");
        cll.insertEnd(5);
        cll.display();

        System.out.print("the deleted node is: ");
        System.out.println( cll.deletFirst().data);
        cll.display();
    }
}
