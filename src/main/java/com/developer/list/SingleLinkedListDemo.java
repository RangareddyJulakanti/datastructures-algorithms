package com.developer.list;

/**
 * Created by RANGAREJ on 6/9/2018.
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList<Integer> singleLinkedList=new SingleLinkedList<>();
        System.out.println("Start Add elements @ first always");

        singleLinkedList.addFirst(40);
        singleLinkedList.addFirst(30);
        singleLinkedList.addFirst(20);
        singleLinkedList.addFirst(10);
        System.out.println(singleLinkedList.getHead());

        System.out.println("End Add elements @ first always");

        singleLinkedList.clear();

        System.out.println("Start Add elements @ last always");

        singleLinkedList.addLast(50);
        singleLinkedList.addLast(60);
        singleLinkedList.addLast(70);
        singleLinkedList.addLast(80);
        System.out.println(singleLinkedList);

        System.out.println("End Add elements @ last always");
    }
}
