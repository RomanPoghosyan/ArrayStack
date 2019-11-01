package com.company;

public class Test {
    public static void main(String args[]) throws Exception{
        ArrayStack<Integer> stack = new ArrayStack<>(100);
        stack.push(16);
        stack.push(5);
        stack.push(12);
        stack.push(1);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
