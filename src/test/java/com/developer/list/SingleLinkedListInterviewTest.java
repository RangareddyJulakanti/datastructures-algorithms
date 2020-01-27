package com.developer.list;

import org.junit.Assert;
import org.junit.Test;

public class SingleLinkedListInterviewTest {
    @Test
    public void isPalindromOdd(){
        SingleLinkedList.Node<String> a1=new SingleLinkedList.Node<>("a",null);
        SingleLinkedList.Node<String> b1=new SingleLinkedList.Node<>("b",a1);
        SingleLinkedList.Node<String> c1=new SingleLinkedList.Node<>("c",b1);
        SingleLinkedList.Node<String> d1=new SingleLinkedList.Node<>("d",c1);
        SingleLinkedList.Node<String> c=new SingleLinkedList.Node<>("c",d1);
        SingleLinkedList.Node<String> b=new SingleLinkedList.Node<>("b",c);
        SingleLinkedList.Node<String> a=new SingleLinkedList.Node<>("a",b);
        ISingleLinkedListInterview iSLI=new SingleLinkedListInterview();
        Assert.assertTrue(iSLI.isPalindrome(a));

    }
    @Test
    public void isPalindromEven(){
        SingleLinkedList.Node<String> a1=new SingleLinkedList.Node<>("a",null);
        SingleLinkedList.Node<String> b1=new SingleLinkedList.Node<>("b",a1);
        SingleLinkedList.Node<String> c1=new SingleLinkedList.Node<>("c",b1);
        SingleLinkedList.Node<String> c=new SingleLinkedList.Node<>("c",c1);
        SingleLinkedList.Node<String> b=new SingleLinkedList.Node<>("b",c);
        SingleLinkedList.Node<String> a=new SingleLinkedList.Node<>("a",b);
        ISingleLinkedListInterview iSLI=new SingleLinkedListInterview();
        Assert.assertTrue(iSLI.isPalindrome(a));

    }
}
