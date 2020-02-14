package com.developer.stack;

import java.util.Arrays;

public class Stack<T> {
    private Object[] data;
    private int elementCount;
    private int top;
    public  Stack(int capacity){
        data=new Object[capacity];
        top=-1;
    }
    public void push(T t){
        ensureCapacity();
        data[elementCount++]=t;
        top++;
    }
    public T pop(){
       T t=peek();
       removeAt(top);
       top--;
       return t;
    }

    private void removeAt(int i) {
        if(size()>=i)
         data[i]=null;
         elementCount--;
    }

    public T peek(){
        if(data.length-1>top) {
            return (T) data[top];
        }
        else
        {
         throw new RuntimeException("");
        }
    }

    private void ensureCapacity() {
        if(data.length-1==size()){
            data= Arrays.copyOf(data,2*data.length);
        }
    }

    private int size(){
        return elementCount;
    }
}
