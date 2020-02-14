package com.developer.stack;

import org.hamcrest.Matcher;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class StackTest {
    @Test
    public void testPush(){
        Stack<Integer> stack=new Stack<>(10);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        Assert.assertThat(stack.peek(), Is.is(40));
        Assert.assertThat(stack.pop(), Is.is(40));
        Assert.assertThat(stack.pop(), Is.is(30));
    }
}
