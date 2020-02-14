package com.developer.queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.*;

public class QueueTest
{
    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> queue=new ArrayBlockingQueue<>(5);
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
       queue.remove();
        queue.add(50);
        queue.remove();
        queue.add(60);
        queue.add(70);
        queue.add(80);
        System.out.println(queue);

    }
}
