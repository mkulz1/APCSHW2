import java.util.*;
import java.io.*;

public class TreeNode<E>{
    
    private E data;
    private TreeNode<E> left,right;
    
    public TreeNode(E value){
	data = value;
    }
    
    public TreeNode<E> getLeft(){
	return left;
    }
    public TreeNode<E> getRight(){
	return right;
    }

    public void setLeft(TreeNode<E> node){
	left = node;
    }
    public void setRight(TreeNode<E> node){
	right = node;
    }

    public String toString(){
	return "(" + data + ")";
    }

    public static void main(String[]args){
	/* 	TreeNode<Integer> hi = new TreeNode<Integer>(666);
		System.out.println(hi);
		TreeNode<Integer> yo = new TreeNode<Integer>(999);
		hi.setLeft(yo);
		System.out.println(hi.getLeft());
	*/
    }
}
