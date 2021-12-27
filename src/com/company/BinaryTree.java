package com.company;
import java.rmi.StubNotFoundException;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class BinaryTree {
    private TreeNode root;
    private class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private int data;
        public TreeNode (int data){
            this.data=data;
        }
    }
    public void createTree(){
        TreeNode first = new TreeNode(1);
        TreeNode second =new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);
        root=first;
        first.left=second;
        first.right=third;
        second.left=fourth;
        second.right=fifth;
    }
    public void preOrder(TreeNode root){
        if (root==null)return;
        System.out.print(root.data+" ");
        preOrder( root.left);
        preOrder(root.right);
    }
    public void preOrder2(TreeNode root){
        if (root==null)return;
        Stack <TreeNode>stack =new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.print(temp.data+" ");
            if (temp.right!=null)stack.push(temp.right);
            if (temp.left!=null)stack.push(temp.left);
        }
    }
    public void inOrder(TreeNode root) {
        if (root==null)return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public void inOrder2(){
        if (root==null)return;
        Stack <TreeNode>stack=new Stack<>();
        TreeNode temp = root;
        while (!stack.isEmpty()||temp!=null){
            if (temp!=null){
                stack.push(temp);
                temp=temp.left;
            }
            else {
                temp=stack.pop();
                System.out.print(temp.data+" ");
                temp=temp.right;
            }
        }
    }
    public void postOrder(TreeNode root){
        if (root==null)return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }
    public void postorder2(){
        if (root==null)return;
        Stack <TreeNode>stack=new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty()||current!=null){
            if (current!=null){
                stack.push(current);
                current=current.left;
            }
            else {
                TreeNode temp = stack.peek().right;
                if (temp==null){
                    temp = stack.pop();
                    System.out.print(temp.data+" ");
                    while (!stack.isEmpty()&&temp==stack.peek().right){
                        temp =stack.pop();
                        System.out.print(temp.data+" ");
                    }
                }
                else {
                    current=temp;
                }
            }
        }
    }
    public void levelOrder(){
        if (root==null)return;
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            System.out.print(temp.data+" ");
            if (temp.left!=null)queue.offer(temp.left);
            if (temp.right!=null)queue.offer(temp.right);
        }
    }
    public int max(TreeNode root){
        if (root==null)return Integer.MIN_VALUE;
        int result = root.data;
        int left = max(root.left);
        int right = max(root.right);
        if (left>result)result=left;
        if (right>result)result=right;
        return result;
    }
    public static void main (String[]args){
        BinaryTree tree = new BinaryTree();
        tree.createTree();
        System.out.print("recursive pre-order traversal: ");
        tree.preOrder(tree.root);

        System.out.println();
        System.out.print("iterative pre-order traversal: ");
        tree.preOrder2(tree.root);

        System.out.println();
        System.out.print("recursive in-order traversal: ");
        tree.inOrder(tree.root);

        System.out.println();
        System.out.print("iterative in-order traversal: ");
        tree.inOrder2();

        System.out.println();
        System.out.print("recursive post-order traversal: ");
        tree.postOrder(tree.root);

        System.out.println();
        System.out.print("iterative post-order traversal: ");
        tree.postorder2();

        System.out.println();
        System.out.print("iterative level-order traversal: ");
        tree.levelOrder();

        System.out.println();
        System.out.print("The maximum value is: ");
        System.out.println(tree.max(tree.root));
    }
}
