package com.developer.stack;
import java.util.Arrays;
public class KStacks<T> {
    private int  top[],next[];
    private T arr[];
    private int cap,k,freeTop;
    public KStacks(int k,int cap){
         this.k=k;
         this.cap=cap;
         init();
    }
    public void init(){
        top=   new int[k];
        next= new int [cap];
        arr= (T[]) new Object[cap];
        Arrays.fill(top, -1);
        for(int i=0;i<cap-1;i++){
            next[i]=i+1;
        }
        next[cap-1]=-1;
        freeTop=0;
    }
    public void push(T data,int stackNumber){
          int i=freeTop;
          freeTop=next[i];
          next[i]=top[stackNumber];
          top[stackNumber]=i;
          arr[i]=data;
    }
    public  T pop(int stackNumber){
       int i= top[stackNumber];
       top[stackNumber]=next[i];
       next[i]=freeTop;
       freeTop=i;
       return arr[i];
    }
}
