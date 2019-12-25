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
    public boolean addLast(Node<E> node) {
        Node<E> newNode = node;
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

    @Override
    public E findMergeNode(Node<E> head1, Node<E> head2) {
        int l=findLength(head1);
        int m=findLength(head2);
        Node<E> temp1=head1;
        Node<E> temp2=head2;
        if(l>m){
            int d=l-m;

            for(int i=0;i<d;i++){
                temp1=temp1.next;
            }
        }else{
            int d=m-l;
            for(int i=0;i<d;i++){
                temp2=temp2.next;
            }
        }
        while(temp1!=temp2){
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return temp1.data;
    }
    private int findLength(Node<E> node){
        Node<E> temp=node;
        int i=0;
        while(temp!=null){
            i++;
            temp=temp.next;
        }
        return i;
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
