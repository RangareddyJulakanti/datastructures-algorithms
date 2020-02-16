package com.geeksforgeeks.datastructure.queue.api;

public interface IQueue<E> {
    public void enqueue(E element);
    public E dequeue();
    public int size();
    public int getFront();
    public int getRear();
    public boolean isEmpty();
    public boolean isFull();
}
