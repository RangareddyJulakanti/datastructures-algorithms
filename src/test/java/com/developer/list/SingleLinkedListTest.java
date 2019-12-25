package com.developer.list;

import org.hamcrest.Matcher;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.results.ResultMatchers;

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

    /**
     * 1
     * 1
     * 3
     * 1
     * 2
     * 3
     * 1
     * 1
     */
    @Test
    public void findMergeNode(){

        SingleLinkedList.Node<Integer> common=new SingleLinkedList.Node<>(2,null);
        common.setNext(new SingleLinkedList.Node<>(1,null));

        SingleLinkedList<Integer> singleLinkedList1=new SingleLinkedList<>();
        singleLinkedList1.addLast(1);
        singleLinkedList1.addLast(3);
        singleLinkedList1.addLast(common);
        SingleLinkedList<Integer> singleLinkedList2=new SingleLinkedList<>();
        singleLinkedList2.addLast(  1);
        singleLinkedList2.addLast(1);
        singleLinkedList2.addLast(common);

       Integer mergeNodeData= new SingleLinkedList<Integer>().findMergeNode(singleLinkedList1.getHead(),singleLinkedList2.getHead());
       Assert.assertThat(mergeNodeData, Is.is(2));

    }

}
