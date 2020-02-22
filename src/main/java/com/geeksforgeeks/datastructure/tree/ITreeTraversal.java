package com.geeksforgeeks.datastructure.tree;

import java.util.List;

public interface ITreeTraversal<E> {
    public void inOrder(Node<E> root);
    public void preOrder(Node<E> root);
    public void postOrder(Node<E> root);
    public List<E> getQ();
}
