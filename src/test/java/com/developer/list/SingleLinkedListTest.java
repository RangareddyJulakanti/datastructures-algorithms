package com.developer.list;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by RANGAREJ on 6/9/2018.
 */
public class SingleLinkedListTest {

    @Test
    public void testAddFirst(){
        SingleLinkedList<Integer> singleLinkedList=new SingleLinkedList<>();
        System.out.println("Start Add elements @ first always");
        singleLinkedList.addFirst(40);
        singleLinkedList.addFirst(30);
        singleLinkedList.addFirst(20);
        singleLinkedList.addFirst(10);
        System.out.println(singleLinkedList.getHead());
        System.out.println("End Add elements @ first always");
        Assert.assertEquals(10,singleLinkedList.getHead().getData().intValue());
    }
    @Test
    public void testAddLast(){
        SingleLinkedList<Integer> singleLinkedList=new SingleLinkedList<>();
        System.out.println("Start Add elements @ last always");
        singleLinkedList.addLast(50);
        singleLinkedList.addLast(60);
        singleLinkedList.addLast(70);
        singleLinkedList.addLast(80);
        System.out.println(singleLinkedList);
        Assert.assertEquals(50,singleLinkedList.getHead().getData().intValue());

        System.out.println("End Add elements @ last always");
    }

}
