package com.company;

import java.util.Collection;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

class ArrayStack<TElement> implements Collection{
    private Object[] stack;
    private int capacity;
    private int index;

    ArrayStack(int capacity){
        stack = new Object[capacity];
        this.capacity = capacity;
        index = 0;
    }

    private void duplicateCapacity(){
        Object[] newStack = new Object[capacity * 2];
        for(int i = 0; i < index; i++){
            newStack[i] = stack[i];
        }
        stack = newStack;
    }

    void push(TElement tElement) {
        if(index == capacity) duplicateCapacity();
        stack[index++] = tElement;
    }

    TElement pop() throws StackOverflow {
        if(index == 0) throw new StackOverflow("Stack is empty");
        TElement t = (TElement) stack[--index];
        stack[index] = null;
        return t;
    }


    @Override
    public int size() {
        return index;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator iterator() {
        return new Iterator<TElement>(this);
    }

    @Override
    public void clear() {
        for(int i = 0; i < index; i++){
            stack[i] = null;
            index = 0;
        }
    }

    @Override
    public boolean contains(Object o) {
        for(int i = 0; i < index; i++){
            if(stack[i].equals(o)) return true;
        }
        return false;
    }


    @Override
    public boolean containsAll(Collection c) {
        for(Object o : c){
            if(!contains(o)) return false;
        }
        return true;
    }

    @Override
    public boolean add(Object o) {
        if(contains(o)){
            return false;
        }else{
            TElement t = (TElement) o;
            push(t);
            return true;
        }
    }

    @Override
    public boolean addAll(Collection c) {
        boolean result = false;
        for(Object o : c){
            if(add(o)) result = true;
        }
        return result;
    }

    @Override
    public boolean remove(Object o) {
        boolean result = false;
        for(int i = 0; i < index; i++){
            if(stack[i].equals(o)){
                for(int j = i; j < index - 1; j++){
                    stack[j] = stack[j + 1];
                }
                stack[--index] = null;
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean removeAll(Collection c) {
        boolean result = false;
        for(Object o : c){
            if(remove(o)) result = true;
        }
        return result;
    }




    @Override
    public boolean removeIf(Predicate filter) {
        return false;
    }

    @Override
    public Spliterator spliterator() {
        return null;
    }

    @Override
    public Stream stream() {
        return null;
    }

    @Override
    public Stream parallelStream() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }


    class Iterator<T> implements java.util.Iterator<T>{
        private int cursor;
        private int length;
        ArrayStack<T> arrStack;

        Iterator(ArrayStack arrStack){
            cursor = 0;
            length = arrStack.size();
            this.arrStack = arrStack;
        }

        @Override
        public void remove() {

        }

        @Override
        public void forEachRemaining(Consumer action) {

        }

        @Override
        public boolean hasNext() {
            return cursor < length;
        }

        @Override
        public T next() {
            T t = (T) arrStack.stack[cursor++];
            return t;
        }
    }
}