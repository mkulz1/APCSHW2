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
	return "(" + (String)data + ")";
    }

    public static void main(String[]args){
	/*	TreeNode<String> hi = new TreeNode<String>("hello");
		System.out.println(hi);
		TreeNode<String> yo = new TreeNode<String>("sup");
		hi.setLeft(yo);
		System.out.println(hi.getLeft());*/
    }
}
