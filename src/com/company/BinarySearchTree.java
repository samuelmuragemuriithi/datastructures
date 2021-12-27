package com.company;


public class BinarySearchTree {
    private TreeNode root;
    private class TreeNode{
        private final int data;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int data){
            this.data=data;
        }
    }

    public void insert(int value){
     root = insert(root,value);
    }
    public TreeNode insert(TreeNode root,int value){
        if (root==null){
            root = new TreeNode(value);
            return root;
        }
        if (value<root.data)root.left=insert(root.left,value);
        else if (value>root.data)root.right= insert(root.right,value);
        return root;
    }
    public void inOrder(){
        inOrder(root);
    }
    public void inOrder(TreeNode root){
        if (root==null)return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public TreeNode search(int key){
       return search(root,key);
    }
    public TreeNode search(TreeNode root,int key){
    if (root==null||key==root.data)return root;
    if (key<root.data)return search(root.left, key);
        else return search(root.right, key);
    }
    public boolean isValid(long min,long max){
        return isValid( root, min, max);
    }
    public boolean isValid( TreeNode root,long min,long max){
        if (root==null)return true;
        if (root.data<=min||root.data>=max) return false;
            boolean left = isValid(root.right, min, root.data);
            if (left) {
                return isValid(root.right, root.data, max);
            }
        return false;
    }

    public static void main(String[]args){
        System.out.print("binary search tree in-order fashion: ");
        BinarySearchTree binarySearchTree=new BinarySearchTree();
        binarySearchTree.insert(5);
        binarySearchTree.insert(2);
        binarySearchTree.insert(9);
        binarySearchTree.insert(6);
        binarySearchTree.insert(4);
        binarySearchTree.inOrder();

        System.out.println();
        String result= (binarySearchTree.search(6)!=null)
                ?"key 6 is inclusive"
                :"key 6 is exclusive";
        System.out.println(result);

        long min =Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        String result1= (binarySearchTree.isValid(min,max))
                ?"binary tree validated!"
                :"binary tree is not validated!";
        System.out.println(result1);


    }
}
