package com.developer.list.doubly;

import org.junit.Test;

public class DoublyLinkedListTest {
    @Test
    public void  reverseDoublyLinkedList(){
        DoublyLinkedList<String> doublyLinkedList=new DoublyLinkedList<>();
        doublyLinkedList.addLast(new DoublyLinkedList.Node<>("a"));
        doublyLinkedList.addLast(new DoublyLinkedList.Node<>("b"));
        doublyLinkedList.addLast(new DoublyLinkedList.Node<>("c"));
        doublyLinkedList.addLast(new DoublyLinkedList.Node<>("d"));
        doublyLinkedList.addLast(new DoublyLinkedList.Node<>("e"));
        System.out.println(DoublyLinkedListUtils.reverseOptimal(doublyLinkedList.getHead(),null));
    }
}
