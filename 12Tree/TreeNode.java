import java.util.*;
import java.io.*;

public class TreeNode<E>{

    private E data;
    private TreeNode<E> left,right;

    public TreeNode<E>(E value){
	data = value;
    }

    public TreeNode getLeft(){
	return left;
    }
    public TreeNode getRight(){
	return right;
    }

    public void setLeft(TreeNode node){
	left = node;
    }
    public void setRight(TreeNode node){
	right = node;
    }

}
