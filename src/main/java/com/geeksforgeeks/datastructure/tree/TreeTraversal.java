package com.geeksforgeeks.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeTraversal<E> implements ITreeTraversal<E>{
    private List<E> q=new ArrayList<>();
    public void inOrder(Node<E> root){
        if(root==null){
            return;
        }

        inOrder(root.getLeft());
        q.add(root.getKey());
        inOrder(root.getRight());
    }
    public void preOrder(Node<E> root){
        if(root==null){
            return;
        }
        q.add(root.getKey());
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }
    public void postOrder(Node<E> root){
        if(root==null){
            return;
        }
        postOrder(root.getLeft());
        postOrder(root.getRight());
        q.add(root.getKey());
    }
    public List<E> getQ(){
        return q;
    }

}
