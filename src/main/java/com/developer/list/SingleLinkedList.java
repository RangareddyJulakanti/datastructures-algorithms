package com.developer.list;

import java.util.ArrayList;

/**
 * Created by RANGAREJ on 6/9/2018.
 */
public class SingleLinkedList<E> implements ISingleLinkedList<E>{
    private Node<E> head;
    private int length;
    public boolean addFirst(E data) {
        Node<E> newNode = new Node<>(data, null);
        newNode.next = head;
        head = newNode;
        length++;
        return true;
    }

    public boolean addLast(E data) {
        Node<E> newNode = new Node<>(data, null);
        if(head==null){
            head = newNode;
        }else{
            Node<E> tempNode = head;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = newNode;
        }
        length++;
        return true;
    }

    public static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "[" + "data=" + data + ", next=" + next + ']';
        }
    }

    public boolean clear() {
        Node<E> tempNode=head;
         while(tempNode!=null){
             tempNode=tempNode.next;
             tempNode.next=null;
         }
        return true;
    }



    @Override
    public String toString() {
        return "SingleLinkedList{" +
                "head=" + head +
                '}';
    }

    public Node<E> getHead() {
        return head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
