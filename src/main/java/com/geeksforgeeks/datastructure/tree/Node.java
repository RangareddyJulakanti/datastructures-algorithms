package com.geeksforgeeks.datastructure.tree;

public class Node<E> {
   private final E key;
   private  Node left;
   private Node right;
   public Node(E key){
        this.key=key;
    }
   public Node(Node left,E key,Node right){
        this.left=left;
        this.key=key;
        this.right=right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public E getKey() {
        return key;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}
