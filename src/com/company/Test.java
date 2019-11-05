package com.company;

public class Test {
    public static void main(String args[]) throws Exception{
        ArrayStack<Integer> stack = new ArrayStack<>(4);
        stack.push(16);
        stack.push(5);
        stack.push(12);
        stack.push(1);
        stack.push(1);
        stack.push(1);


        ArrayStack<Integer> stack2 = new ArrayStack<>(4);
        stack2.push(5);
        stack2.push(12);
        stack.retainAll(stack2);

        for(Object o : stack){
            System.out.println(o);
        }
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());

//        System.out.println(stack.pop());
//        System.out.println(stack.size());
//        System.out.println(stack.contains(5));
//        for(Object i : stack){
//            System.out.println(i);
//        }
//
//        stack.remove(5);
//
//        for(Object i : stack){
//            System.out.println(i);
//        }

//        ArrayStack<Integer> stack2 = new ArrayStack<>(100);
//        stack2.push(16);
//        stack2.push(5);
//        stack2.push(12);
//        System.out.println(stack.containsAll(stack2));
    }
}
