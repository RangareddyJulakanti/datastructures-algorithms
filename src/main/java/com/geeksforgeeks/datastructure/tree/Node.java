package com.geeksforgeeks.datastructure.tree;

public class Node<E> {
   private final E key;
   private  Node<E> left;
   private Node<E> right;
   public Node(E key){
        this.key=key;
    }
   public Node(Node<E> left,E key,Node<E> right){
        this.left=left;
        this.key=key;
        this.right=right;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }

    public E getKey() {
        return key;
    }

    public Node<E> getLeft() {
        return left;
    }

    public Node<E> getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "{" +
                  key +
                '}';
    }
}
