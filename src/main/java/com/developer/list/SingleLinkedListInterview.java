package com.developer.list;

public class SingleLinkedListInterview implements ISingleLinkedListInterview{
    @Override
    public <E> boolean isPalindrome(SingleLinkedList.Node<E> head) {
        if(head.getNext()==null){
            return true;
        }
        SingleLinkedList.Node<E> p=head;
        SingleLinkedList.Node<E> q=head;
        SingleLinkedList.Node<E> s;
        while(true){
            p=p.getNext().getNext();
            if(p==null){
                s=q.getNext();
                break;
            }
           if(p.getNext()==null){
               s=q.getNext().getNext();
               break;
           }
           q=q.getNext();
        }
        q.setNext(null);
        s=reverseLinkedList(s);
        return  compare(head,s);
    }

    private <E> boolean compare(SingleLinkedList.Node<E> head, SingleLinkedList.Node<E> s) {
        while(head!=null&&s!=null){
            if(head.getData()!=s.getData()){
                break;
            }
            head=head.getNext();
            s=s.getNext();
        }
        if(head==null&&s==null){
            return true;
        }else{
            return false;
        }
    }

    private <E> SingleLinkedList.Node<E> reverseLinkedList(SingleLinkedList.Node<E> s) {
        SingleLinkedList.Node<E> temp,previous=null;
        while(s!=null){
          temp=new SingleLinkedList.Node<>(s.getData(),previous);
          previous=temp;
          s=s.getNext();
        }
        return previous;

    }
}
