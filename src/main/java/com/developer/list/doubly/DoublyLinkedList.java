package com.developer.list.doubly;

import com.developer.list.SingleLinkedList;

public class DoublyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;


    public Node<E> getHead() {
        return head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public void setTail(Node<E> tail) {
        this.tail = tail;
    }

    public void addLast(Node<E> newNode) {
     if(head==null&&tail==null){
        head=newNode;
        tail=newNode;
        return;
     }
     tail.next=newNode;
     newNode.prev=tail;
     tail=newNode;
    }

    public static class Node<E> {

        private Node<E> prev;
        private E data;
        private Node<E> next;
        public Node(E data) {
            this.data = data;
        }
        public Node(Node<E> prev, E data, Node<E> next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
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

        public void addLast(Node<E> newNode) {

        }
    }
}
