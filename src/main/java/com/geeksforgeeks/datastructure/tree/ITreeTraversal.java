package com.geeksforgeeks.datastructure.tree;

import java.util.List;

public interface ITreeTraversal<E> {
    public void inOrder(Node<E> root);
    public void preOrder(Node<E> root);
    public void postOrder(Node<E> root);
    public void levelOrder(Node<E> root);
    public List<E> getList();
    public int sizeOfBinaryTree(Node<E> root);
    public int maxOfBinaryTree(Node<E> root);
    public int heightOfBinaryTree(Node<E> root);
    public int isBalancedBinaryTree(Node<E> root);
    public int maxWidth(Node<E> root);
}
