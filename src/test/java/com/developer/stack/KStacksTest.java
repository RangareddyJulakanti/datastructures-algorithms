package com.developer.stack;

public class KStacksTest {
    public static void main(String[] args) {
        KStacks<Integer> kStacks=new KStacks<>(3,6);
        kStacks.push(10,0);
        kStacks.push(20,1);
        kStacks.push(30,0);
        kStacks.push(40,1);
        kStacks.push(50,0);
        kStacks.push(60,2);

    }
}
