package com.akezhanmussa.impl;

import com.akezhanmussa.adt.Deque;
import com.akezhanmussa.adt.Queue;

/**
 * Created by talgat on 18.02.18.
 */
public class LinkedListDeque<T> implements Deque<T> {

    private DoublyLinkedNode<T> front;
    private DoublyLinkedNode<T> back;
    private int size;

    public LinkedListDeque() {
        this.front = null;
        this.back = null;
        this.size = 0;
    }

    @Override
    public void pushToFront(T value) {

        if (size == 0){
            front = new DoublyLinkedNode(value);
            front.setNext(null);
            front.setPrevious(null);
            back = front;
        } else {
            DoublyLinkedNode<T> newLinkedNode = new DoublyLinkedNode(value);
            newLinkedNode.setNext(front);
            front.setPrevious(newLinkedNode);
            front = newLinkedNode;
        }

        size ++;
    }

    @Override
    public void pushToBack(T value) {

        if (size == 0){
            front = new DoublyLinkedNode(value);
            front.setNext(null);
            front.setPrevious(null);
            back = front;
        } else if (size == 1){
            DoublyLinkedNode<T> newItem = new DoublyLinkedNode(value);
            back = newItem;
            front.setNext(back);
            front.setPrevious(null);
            back.setPrevious(front);
            back.setNext(null);
        } else {
            DoublyLinkedNode<T> newItem = new DoublyLinkedNode(value);
            back.setNext(newItem);
            newItem.setPrevious(back);
            back = newItem;
            back.setNext(null);
        }

        size ++;
    }

    @Override
    public T popFromFront() throws Exception {

        DoublyLinkedNode<T> oldFront = front;

        if (size == 0){
            throw new Exception("Deque is empty!!!");
        } else if (size == 1){

            front = null;
            back = null;

        } else {

            DoublyLinkedNode<T> newFront = front.getNext();

            newFront.setPrevious(null);

            front = newFront;
        }

        size --;

        return  oldFront.getValue();
    }

    @Override
    public T popFromBack() throws Exception {
        T result = back.getValue();
        if (size == 0){
            throw  new Exception("Deque is empty !!!");
        } else if (size == 1){
            back = null;
            front = null;

        } else {

            DoublyLinkedNode<T> newBack = back.getPrevious();
            newBack.setNext(null);

            back = newBack;
        }

        size --;

        return result;

    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void clear() {
        this.front = null;
        this.back = null;
        this.size = 0;
    }

    public String toString(){
        String result = "front[";

        if (size != 0){

            DoublyLinkedNode<T> actualFront = front;

            for(int i = 0; i<size; i++){
                result += actualFront.getValue() + " ";
                actualFront = actualFront.getNext();
            }
        }

        result += "]back";

        return result;
    }
}
