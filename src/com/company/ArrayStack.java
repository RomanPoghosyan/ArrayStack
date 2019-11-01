package com.company;

class ArrayStack<TElement> extends Stack<TElement>
{
    private Object[] stack;
    private int capacity;
    private int index;

    ArrayStack(int capacity){
        stack = new Object[capacity];
        this.capacity = capacity;
        index = 0;
    }

    @Override
    void push(TElement tElement) throws StackOverflow {
        if(index == capacity) throw new StackOverflow("Stack is full");
        stack[index++] = tElement;
    }

    @Override
    TElement pop() throws StackOverflow {
        if(index == 0) throw new StackOverflow("Stack is empty");
        TElement t = (TElement) stack[--index];
        stack[index] = null;
        return t;
    }
}