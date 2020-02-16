package com.developer.stack;

import java.util.Arrays;

 class Stack<T> {
    private T[] array;
    private int elementCount;
    private int top;
    Stack(int capacity){
        array=(T[])new Object[capacity];
        top=-1;
    }
    void push(T t){
        ensureCapacity();
        array[elementCount++]=t;
        top++;
    }
     T pop(){
       T t=peek();
       removeAt(top);
       top--;
       return t;
    }

    private void removeAt(int i) {
        if(size()>=i)
         array[i]=null;
         elementCount--;
    }

    public T peek(){
        if(top!=-1) {
            return array[top];
        }
        else
        {
         throw new RuntimeException("stack is empty");
        }
    }

    private void ensureCapacity() {
        if(top==array.length-1){
            array= Arrays.copyOf(array,2*array.length);
        }
    }

    private int size(){
        return elementCount;
    }
}
