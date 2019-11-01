package com.company;

abstract class Stack<TElement>
{
    abstract void push(TElement element) throws StackOverflow;

    abstract TElement pop() throws StackOverflow;
}