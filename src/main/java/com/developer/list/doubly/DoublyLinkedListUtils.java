package com.developer.list.doubly;
public class DoublyLinkedListUtils {
    public static  <E> DoublyLinkedList.Node<E> reverseList(DoublyLinkedList.Node<E> head){
       if(head==null || head.getNext()==null){
           return head;
       }
        DoublyLinkedList.Node<E> current=head;
        DoublyLinkedList.Node<E> temp=head;
       while(current!=null){
           temp=current.getPrev();
           current.setPrev(current.getNext());
           current.setNext(temp);
           current=current.getPrev();
       }
       head=temp.getPrev();
       return head;
    }
    public static  <E> DoublyLinkedList.Node<E> reverse(DoublyLinkedList.Node<E> head){
        if(head==null || head.getNext()==null){
            return head;
        }
        DoublyLinkedList.Node<E> rest=reverse(head.getNext());//e //d //c //b //a
        head.getNext().setNext(head);//d->e->d  //c->d->c //b->c->b //a->b->a
        head.setNext(null);//d->null //c->null //b->null//a->null
        return rest;//d //c //b //a
    }
    public static  <E> DoublyLinkedList.Node<E> reverseOptimal(DoublyLinkedList.Node<E> curr,DoublyLinkedList.Node<E> prev){
        if(curr==null){
            return prev;
        }
        DoublyLinkedList.Node<E> next=curr.getNext();//a->b //b->c  //c->d //d->e//e->null//null=null then return e
        curr.setNext(prev);//a->null //b->a //c->b //d->c //e->d
        return reverseOptimal(next,curr);//b,a //c,b //d,c //e,d//null,e
    }
}
