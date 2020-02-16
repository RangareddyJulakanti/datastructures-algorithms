package com.geeksforgeeks.datastructure.queue.impl;

import com.geeksforgeeks.datastructure.queue.api.IQueue;

public class QueueImplArray<E> implements IQueue<E> {
    private int size;
    private int capacity;
    private E[] array;
    public QueueImplArray(int capacity){
        this.array=(E[])new Object[capacity];
        this.size=0;
        this.capacity=capacity;
    }

    /**
     * This adds an element at the back of queue
     * @param element
     */
    @Override
    public void enqueue(E element) {
      if(isFull()){
        throw new UnsupportedOperationException("Unable to add element due to queue is full");
      }
      array[size++]=element;
    }

    /**
     * This removes an element from the front of the queue
     * @return removed element
     * Time complexity of this operation is O(n)
     */
    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new UnsupportedOperationException("Unable to delete element due to queue is empty");
        }
        E data=array[0];
        for(int i=0;i<size;i++){
           array[i]=array[i+1];
        }
        size--;
        return data;
    }

    /**
     *
     * @return size of the elements present in queue
     */
    @Override
    public int size() {
        return size;
    }

    /**
     *
     * @return front index of the queue which is always pointing to 0 if its not empty else -1
     */

    @Override
    public int getFront() {
        if (isEmpty()){
            return -1;
        }else{
            return 0;
        }
    }

    @Override
    public int getRear() {
        if(isEmpty()){
            return -1;
        }else{
            return size-1;
        }
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
