package com.developer.list;

/**
 * Created by RANGAREJ on 6/9/2018.
 */
public interface ISingleLinkedList<E>{
    /**
     * clear all links
     */
    public boolean clear();

    /**
     * Add each element before head
     * @param data
     * @return
     */
    public boolean addFirst(E data);

    /**
     * Add element at last to the list
     * @param data
     * @return
     */
    public boolean addLast(E data);
}
