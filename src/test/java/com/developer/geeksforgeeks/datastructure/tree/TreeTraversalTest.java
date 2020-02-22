package com.developer.geeksforgeeks.datastructure.tree;

import com.geeksforgeeks.datastructure.tree.ITreeTraversal;
import com.geeksforgeeks.datastructure.tree.Node;
import com.geeksforgeeks.datastructure.tree.TreeTraversal;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TreeTraversalTest {
    private Node<Integer> root;
    private ITreeTraversal<Integer> treeTraversal;
    @Before
    public void init(){
        root=new Node<>(10);                     //                10
                                                      //            /        \
        root.setLeft(new Node(20));              //        20              30
        root.setRight(new Node(30));           //         /  \
        root.getLeft().setLeft(new Node(40));//       40        50
        root.getLeft().setRight(new Node(50));
        treeTraversal=new TreeTraversal<>();
    }
    @Test
    public void testInOrder(){
        treeTraversal.inOrder(root);
        List<Integer> inOrderData=treeTraversal.getQ();
        System.out.println(inOrderData);
    }
    @Test
    public void testPreOrder(){
        treeTraversal.preOrder(root);
        List<Integer> preOrderData=treeTraversal.getQ();
        System.out.println(preOrderData);
    }
    @Test
    public void testPostOrder(){
        treeTraversal.postOrder(root);
        List<Integer> postOrderData=treeTraversal.getQ();
        System.out.println(postOrderData);
        Assert.assertThat(postOrderData.get(0), Is.is(40));
        Assert.assertThat(postOrderData.get(1), Is.is(50));
        Assert.assertThat(postOrderData.get(2), Is.is(20));
        Assert.assertThat(postOrderData.get(3), Is.is(30));
        Assert.assertThat(postOrderData.get(postOrderData.size()-1), Is.is(10));
    }
}
