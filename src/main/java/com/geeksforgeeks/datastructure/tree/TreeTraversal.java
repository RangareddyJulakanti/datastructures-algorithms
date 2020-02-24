package com.geeksforgeeks.datastructure.tree;

import java.util.*;
import java.util.stream.Collectors;

public class TreeTraversal<E> implements ITreeTraversal<E>{

    private List<E> list=new ArrayList<>();
    private Queue<Node<E>> q=new LinkedList<>();
    public void inOrder(Node<E> root){
        if(root==null){
            return;
        }

        inOrder(root.getLeft());
        list.add(root.getKey());
        inOrder(root.getRight());
    }
    public void preOrder(Node<E> root){
        if(root==null){
            return;
        }
        list.add(root.getKey());
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }
    public void postOrder(Node<E> root){
        if(root==null){
            return;
        }
        postOrder(root.getLeft());
        postOrder(root.getRight());
        list.add(root.getKey());
    }

    @Override
    public void levelOrder(Node<E> root) {
        if(root==null){
            return;
        }
        q.add(root);
        while(!q.isEmpty()){
            Node<E> current=q.poll();
            if(current!=null) {
                list.add(current.getKey());//System.out.println(current.getKey());
                q.add(current.getLeft());
                q.add(current.getRight());
            }
        }
        
    }

    public List<E> getList(){
        return list;
    }

    @Override
    public int sizeOfBinaryTree(Node<E> root) {
        return size(root);
    }
    @Override
    public int maxOfBinaryTree(Node<E> root) {
        return max(root);
    }

    @Override
    public int heightOfBinaryTree(Node<E> root) {
        return height(root)-1;
    }

    @Override
    public int isBalancedBinaryTree(Node<E> root) {
         return isBalanced(root);
    }

    @Override
    public int maxWidth(Node<E> root) {
        int max=0;
        if(root!=null) {
            Queue<Node<E>> q = new LinkedList<>();
            q.add(root);

            while(!q.isEmpty()){
                int count=q.size();
                max=  Math.max(max,count);
                for(int i=0;i<count;i++) {
                    Node<E> current = q.poll();
                    if(current!=null) {
                        if(current.getLeft()!=null) {
                            q.add(current.getLeft());
                        }
                        if(current.getRight()!=null) {
                            q.add(current.getRight());
                        }
                    }
                }

            }
        }
        return max;
    }

    private int isBalanced(Node<E> root){
       if(root==null){
           return 0;
       }
       int lh=height(root.getLeft());
       if(lh==-1){
           return -1;
       }
       int rh=height(root.getRight());
       if(rh==-1){
           return -1;
       }
       if(Math.abs(lh-rh)>1){
           return -1;
       }else{
           return Math.max(lh,rh)+1;
       }
    }

    private int height(Node<E> root){
        if(root==null){
            return 0;
        }
        return Math.max(height(root.getLeft()),height(root.getRight()))+1;
    }

    private int max(Node<E> root){
        if(root==null){
            return 0;
        }
        int k=Math.max(max(root.getLeft()),max(root.getRight()));
        return Math.max((Integer) root.getKey(),k);
    }
    private int size(Node<E> root){
         if(root==null){
             return 0;
         }
        return size(root.getLeft())+size(root.getRight())+1;
    }

}
