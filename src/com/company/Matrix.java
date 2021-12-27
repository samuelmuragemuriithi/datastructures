package com.company;

public class Matrix {
    static void search( int [][] matrix,int n,int key){
        int i = 0;
        int j = n-1;
        while (i<n&&j>=0){
            if (matrix[i][j]==key){
                System.out.println("key found in index: ["+i +"],["+j+"]");
                return;
            }
            if (matrix[i][j]>key)j--;
            else i++;
        }
        System.out.println("Key not found! ");
    }
    static void display(int [][] matrix,int col,int row){
        int i = 0, j= 0, k = 0;
        while (j<col&&k<row){
            for ( i = j;i<col;i++)System.out.print(matrix[k][i]+" ");
            k++;
            for (i=k;i<j;i++) System.out.print(matrix[i][col-1]+" ");
            col--;
            if (k<row){
                for (i=col-1;i>=j;i--) System.out.print(matrix [row-1][i]+" ");
                row--;
            }
            if (j<col){
                for (i=row-1;i>=k;i--) System.out.print(matrix [i][j]+" ");
                j++;
            }
        }
    }
    public static void main(String[]args){
       int [][] matrix = {  {10,20,30,40},
                            {15,25,35,45},
                            {27,29,37,48},
                            {32,33,39,51}
                         };
       search(matrix, matrix.length, 45);
    System.out.print("Matrix in spiral form: ");
       display(matrix, matrix.length, matrix.length);
    }
}
