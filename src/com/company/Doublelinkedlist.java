package com.company;

import java.util.NoSuchElementException;

public class Doublelinkedlist {
    private ListNode head;
    private ListNode tail;
    private int length;

    private class ListNode{
        private ListNode previous;
        private ListNode next;
        private int data;
        public ListNode(int data){
            this.data=data;
        }
    }
    public Doublelinkedlist(){
        this.head=null;
        this.tail=null;
        this.length=0;
    }
    public boolean isEmpty(){
        return length==0;
    }
    public int length(){
        return length;
    }
    public  void displayForward(){
        ListNode temp = head;
        while (temp!=null){
            System.out.print(temp.data+"-->");
            temp=temp.next;
        }
        System.out.print("null");
    }
    public  void displayBackward(){
        ListNode temp = tail;
        if (tail==null)return;
        while (temp!=null){
            System.out.print(temp.data+"-->");
            temp=temp.previous;
        }
        System.out.print("null");
    }
    public void insertFirst(int value){
        ListNode node = new ListNode(value);
        if (isEmpty())tail=node;
        else head.previous=node;
        node.next=head;
        head=node;
        length++;
    }
    public void  insertLast(int value){
        ListNode node = new ListNode(value);
        if(isEmpty())head=node;
        else{
            tail.next=node;
            node.previous=tail;
        }
        tail=node;
        length++;
    }
    public ListNode deleteFirst(){
        if (isEmpty())throw new NoSuchElementException();
        if (head==null)tail=null;
        else head.next.previous=null;
        ListNode temp = head;
        head=temp.next;
        temp.next=null;
        return temp;
    }
    public ListNode deleteEnd(){
        if (isEmpty())throw new NoSuchElementException();
        if (head==tail)head=null;
        else tail.previous.next=null;
        ListNode temp = tail;
        tail=tail.previous;
        tail.previous=null;
        return temp;
    }
    public static void main(String[]args){
    Doublelinkedlist dll=new Doublelinkedlist();
    dll.insertFirst(1);
    dll.insertFirst(2);
    dll.insertFirst(3);
    dll.insertFirst(4);
    dll.insertLast(0);
    dll.insertLast(-1);

        System.out.print("print backward: ");
    dll.displayBackward();
        System.out.println();
        System.out.print("print forward: ");
    dll.displayForward();

        System.out.println();
        System.out.print("The deleted node is:");
        System.out.print(dll.deleteFirst().data);
        System.out.println();
        System.out.print("new linked list: ");
        dll.displayForward();

        System.out.println();
        System.out.print("The deleted node is:");
        System.out.print(dll.deleteEnd().data);
        System.out.println();
        System.out.print("new linked list: ");
        dll.displayForward();
    }
}

