package com.geeksforgeeks.datastructure.queue.impl;

import com.geeksforgeeks.datastructure.queue.api.IQueue;

public class OptimalQueueImplArray<E> implements IQueue<E> {
    private E[] array;
    private int size;
    private int front;
    private int capacity;
    private int rear;
    public OptimalQueueImplArray(int capacity){
        this.array=(E[])new Object[capacity];
        this.front=-1;
        this.rear=-1;
        this.size=0;
    }

    @Override
    public void enqueue(E element) {
       if(isFull()){
           throw new UnsupportedOperationException("unable to add element due to queue is full");
       }
       rear=rear+1%capacity;
       array[rear]=element;
       size++;
    }

    /**
     * This operation will take O(1) time complexity
     * @return remove and return an element from the front of the queue
     */
    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new UnsupportedOperationException("unable to delete element due to queue is full");
        }
        E value=array[front];
        front=front+1%capacity;
        size--;
        return value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int getFront() {
        return front;
    }

    @Override
    public int getRear() {

        return rear;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean isFull() {
        return size==capacity;
    }
}
