package com.company;

public class Singlylinkedlist {
    private ListNode head;
    private static class ListNode{
        private ListNode next;
        private int data;
        public ListNode(int data){
            this.data=data;
            this.next=null;
        }
    }
    public  void display(){
        ListNode current = head;
        while (current!=null){
            System.out.print(current.data+"-->");
            current=current.next;
        }
        System.out.println("null");
    }
    public int length(){
        ListNode current = head;
        int count =0;
        while (current!=null){
            count++;
            current = current.next;
        }
        return count;
    }
    public void insertBegining(int value){
        ListNode node=new ListNode(value);
        node.next=head;
        head=node;
    }
    public void insertEnd(int value){
        ListNode node=new ListNode(value);
        if(head==null){
            head = node;
            return;
        }
        ListNode current = head;
        while (current.next!=null)current=current.next;
        current.next=node;
    }
    public void insert(int value,int position){
        ListNode node = new ListNode(value);
        if (position==1){
            node.next=head;
            head=node;
        }
        else {
            ListNode previous= head;
            int count =1;
            while (count<position-1){
                previous=previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next=node;
            node.next=current;
        }
    }
    public ListNode deletefirst(){
        if (head==null)return null;
        ListNode temp = head;
        head=head.next;
        temp.next=null;
        return temp;
    }
    public ListNode deleteEnd(){
        if (head==null)head=head.next;
        ListNode current = head;
        ListNode previous = null;
        while (current.next!=null){
            previous=current;
            current=current.next;
        }
        previous.next=null;
        return current;
    }
    public ListNode delete(int position){
        if (position==1){
            ListNode temp = head;
            head=head.next;
            temp.next= null;
            return temp;
        }
        ListNode previous = head;
        int count = 1;
        while (count<position-1){
            previous=previous.next;
            count++;
        }
        ListNode current = previous.next;
        previous.next=current.next;
        return current;
    }
    public boolean isSerch(int key){
        ListNode current = head;
        while (current!=null){
            if (current.data==key)return true;
            current=current.next;
        }
        return false;
    }
    public ListNode reverse(ListNode head){
        if (head==null)return head;
        ListNode current = head;
        ListNode previous = null;
        ListNode next1 = null;
        while (current!=null){
            next1=current.next;
            current.next=previous;
            previous=current;
            current=next1;
        }
        return previous;
    }
    public  void display2(ListNode head){
        ListNode current = head;
        while (current!=null){
            System.out.print(current.data+"-->");
            current=current.next;
        }
        System.out.println("null");
    }
    public ListNode middleItem(){
       if (head==null)return null;
        ListNode fastPtr=head;
        ListNode slowPtr =head;
        while (fastPtr!=null&&fastPtr.next!=null){
            slowPtr=slowPtr.next;
            fastPtr=fastPtr.next.next;

        }
        return slowPtr;
    }
    public ListNode searchEnd(int position) throws IllegalAccessException {
        if (head==null)return null;
        ListNode refPtr = head;
        ListNode mainPtr =head;
        int count = 0;
        while (count<position){
            if (refPtr==null)throw new IllegalArgumentException
                    ("is greater than size of the linked list");
            refPtr=refPtr.next;
            count++;
        }
        while (refPtr!=null){
            refPtr=refPtr.next;
            mainPtr=mainPtr.next;
        }
        return mainPtr;
    }
    public  void duplicate(){
        if (head==null)return;
        ListNode current = head;
        while (current!=null&&current.next!=null){
           if (current.data==current.next.data)current.next=current.next.next;
           else current=current.next;
        }
    }
    public ListNode insertSort(int value){
        ListNode node = new ListNode(value);
        if (head==null)return node;
        ListNode current =head;
        ListNode previous =null;
        while (current!=null && current.data > node.data){
            previous=current;
            current=current.next;
        }
        node.next=current;
        previous.next=node;
        return head;
    }
    public void removeKey(int key){
        ListNode current =head;
        ListNode previous = null;
        if (current!=null&&key==current.data){
            head=current.next;
            return;
        }
        while (current!=null&&current.data!=key){
            previous=current;
            current=current.next;
        }
        if (current==null)return;
        previous.next=current.next;
    }
    public void singlylinkedlist(){
        ListNode first = new ListNode(11);
        ListNode second2 = new ListNode(10);
        ListNode third2 =new ListNode(9);
        ListNode fourth2 = new ListNode(8);
        ListNode fifth =new ListNode(7);
        head=first;
        first.next=second2;
        second2.next=third2;
        third2.next=fourth2;
        fourth2.next=fifth;
        fifth.next=second2;
    }
    public boolean isLoop(){
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while (fastPtr!=null&&fastPtr.next!=null){
            fastPtr=fastPtr.next.next;
            slowPtr=slowPtr.next;
            if (slowPtr==fastPtr)return true;
        }
        return false;
    }
    public ListNode start(){
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while (fastPtr!=null&&fastPtr.next!=null){
            fastPtr=fastPtr.next.next;
            slowPtr=slowPtr.next;
            if (slowPtr==fastPtr) return getStart(slowPtr);
        }
        return null;
    }
    public ListNode getStart(ListNode slowPtr){
        ListNode temp =head;
        while (temp!= slowPtr){
            slowPtr=slowPtr.next;
            temp=temp.next;
        }
        return slowPtr;
    }
    public void newLinkedlist(){
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while (fastPtr!=null&&fastPtr.next!=null){
            fastPtr=fastPtr.next.next;
            slowPtr=slowPtr.next;
            if (slowPtr==fastPtr) {
                removeLoop(slowPtr);
                return;
            }
        }
    }
    public void removeLoop(ListNode slowPtr){
        ListNode temp =head;
        while (temp.next!= slowPtr.next){
            slowPtr=slowPtr.next;
            temp=temp.next;
        }
        slowPtr.next=null;
    }

public static void main(String [] args) throws IllegalAccessException {
        Singlylinkedlist ssl = new Singlylinkedlist();
        ssl.head = new ListNode(11);
        ListNode second = new ListNode(10);
        ListNode third =new ListNode(9);
        ListNode fourth = new ListNode(8);
        ssl.head.next=second;
        second.next=third;
        third.next=fourth;

        ssl.display();


        System.out.println("length of linked list: " +ssl.length());

        ssl.insertBegining(12);
        System.out.print("after inserting 12: ");
        ssl.display();
        ssl.insertEnd(7);
        System.out.print("after inserting 7: ");
        ssl.display();
        ssl.insert(0,2);
        System.out.print("after inserting 0 in position2: ");
        ssl.display();

        System.out.println("the deleted node is: "+ssl.deletefirst().data);
        System.out.print("after deleting first node: ");
        ssl.display();
        System.out.println("the deleted node is: "+ssl.deleteEnd().data);
        System.out.print("after deleting last node: ");
        ssl.display();
        System.out.println("the deleted node is: "+ssl.delete(1).data);
        System.out.print("after deleting 1st node: ");
        ssl.display();

        String result = (ssl.isSerch(7))?"7 is inclusive":"7 is exclusive";
        System.out.println(result);

        System.out.print("Before reversing: ");
        ListNode head = new ListNode(11);
        ListNode second1 = new ListNode(10);
        ListNode third1 =new ListNode(9);
        ListNode fourth1 = new ListNode(8);
        head.next=second1;
        second1.next=third1;
        third1.next=fourth1;
        ssl.display();
        System.out.print("after reversing: ");
        ListNode x = ssl.reverse(head);
        ssl.display2(x);

    System.out.print("linked list:");
    ssl.display();
    System.out.print("the middle item is: ");
    System.out.println(ssl.middleItem().data);

    System.out.print("the 2nd position from the end is: ");
    System.out.println(ssl.searchEnd(2).data);

    Singlylinkedlist sll2= new Singlylinkedlist();
    sll2.insertBegining(1);
    sll2.insertBegining(1);
    sll2.insertBegining(2);
    sll2.insertBegining(2);
    sll2.insertBegining(3);
    sll2.insertBegining(3);
    System.out.print("sorted linked list: ");
    sll2.display();
    System.out.print("After removing duplicate: ");
    sll2.duplicate();
    sll2.display();

    System.out.print("after adding 2: ");
    sll2.insertSort(2);
    sll2.display();

    System.out.print("after deleting 2: ");
    sll2.removeKey(2);
    sll2.display();

   ssl.singlylinkedlist();
    String result1 =(ssl.isLoop()?"loop present":"Loop absent");
    System.out.println(result1);

    System.out.print("The loop start At: ");
    System.out.println(ssl.start().data);

    System.out.print("After removing loop: ");
    ssl.newLinkedlist();
    ssl.display();
    }

}
