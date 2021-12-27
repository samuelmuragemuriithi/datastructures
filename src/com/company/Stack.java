package com.company;

import javax.swing.tree.TreeNode;
import java.util.Arrays;

public class Stack {
    private ListNode top;
    private int length;
    private class ListNode{
        private ListNode next;
        private int data;
        public ListNode(int data){
            this.data=data;
        }
    }
    public Stack(){
        this.top=null;
        this.length=0;
    }
    public int length(){
        return length;
    }
    public boolean isEmpty(){
       return length==0;
    }
    public void push(int value){
        ListNode temp = new ListNode(value);
        temp.next=top;
        top=temp;
        length++;
    }

    public int pop(){
        if (isEmpty())throw new IllegalArgumentException();
        int result = top.data;
        top=top.next;
        length--;
        return result;
    }
    public int peek(){
        if (isEmpty())throw  new IllegalArgumentException();
        return top.data;
    }
    static String reverse(String word){
        Stack stack= new Stack();
        char[] charArray =  word.toCharArray();
        for (int i : charArray){
            stack.push(i);
        }
        for (int i = 0; i < charArray.length ; i++) {
            charArray[i]= (char) stack.pop();
        }
        return new String(charArray);
    }
    static int [] nextGrater(int [] arr){
        int [] result = new int [arr.length];
        Stack stack= new Stack();
        for (int i = arr.length-1; i >= 0; i--) {
            if (!stack.isEmpty()){
                while (!stack.isEmpty() && stack.peek()<=arr[i] ) stack.pop();
            }
            if (stack.isEmpty())result[i]=-1;
            else result[i]=stack.peek();
            stack.push(arr[i]);
        }
        return result;
    }
    static boolean parenthesis(String par){
        Stack  stack=new Stack();
        for (char c : par.toCharArray()) {
            if (c=='{'||c=='['||c=='(')stack.push(c);
            else {
                if(stack.isEmpty())return false;
                else {
                    char top = (char) stack.peek();
                    if (c=='}'&&top=='{'|| c==']'&&top=='['|| c==')'&&top=='(')stack.pop();
                    else return false;

                }
            }

        }
        return stack.isEmpty();
    }
    public static void main(String [] args){
       Stack stack= new Stack();
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.print("my stack: ");
        for (int i = 0; i <4 ; i++) {
            stack.peek();
            System.out.print(stack.pop()+", ");
        }

        String word = "samuel";
        System.out.println();
        System.out.println(reverse(word));

        int [] arr={4,7,3,4,8,1};
        System.out.println(Arrays.toString(nextGrater(arr)));

        String par = "{[]}";
        System.out.println(parenthesis(par));

    }
}
