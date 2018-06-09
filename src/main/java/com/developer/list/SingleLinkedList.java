package com.developer.list;

/**
 * Created by RANGAREJ on 6/9/2018.
 */
public class SingleLinkedList<T> {
    private Node<T> head;
    private int length;
    public boolean addFirst(T data) {
        Node<T> newNode = new Node<>(data, null);
        newNode.next = head;
        head = newNode;
        length++;
        return true;
    }

    public boolean addLast(T data) {
        Node<T> newNode = new Node<>(data, null);
        if(head==null){
            head = newNode;
        }else{
            Node<T> tempNode = head;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = newNode;
        }
        length++;
        return true;
    }

    public static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "[" + "data=" + data + ", next=" + next + ']';
        }
    }

    public boolean clear() {
        head = null;
        return true;
    }

    @Override
    public String toString() {
        return "SingleLinkedList{" +
                "head=" + head +
                '}';
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
