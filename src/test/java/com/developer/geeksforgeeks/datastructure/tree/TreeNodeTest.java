package com.developer.geeksforgeeks.datastructure.tree;

import com.geeksforgeeks.datastructure.tree.Node;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class TreeNodeTest {
    @Test
    public void createTree(){
        Node<Integer> root=new Node<>(10);
        root.setLeft(new Node(20));
        root.setRight(new Node(30));
        root.getLeft().setLeft(new Node(40));
        Assert.assertThat(10, Is.is(root.getKey()));
        Assert.assertThat(40, Is.is(root.getLeft().getLeft().getKey()));
        Assert.assertThat(30, Is.is(root.getRight().getKey()));
    }
}
