package leetcode;

import com.sun.javafx.image.impl.IntArgb;

import java.util.Stack;

class MyQueue {
    private Stack<Integer> stack1 ;
    private Stack<Integer> stack2 ;
    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        int size = stack1.size();
        for(int i = 0 ; i < size; i++){
            stack2.push(stack1.pop());
        }
        int returnnum = stack2.pop();
        for(int i = 0; i < size-1; i++){
            stack1.push(stack2.pop());
        }
        return returnnum;
    }

    public int peek() {
        int size = stack1.size();
        for(int i = 0 ; i < size; i++){
            stack2.push(stack1.pop());
        }
        int returnnum = stack2.peek();
        for(int i = 0; i < size; i++){
            stack1.push(stack2.pop());
        }
        return returnnum;
    }

    public boolean empty() {
        return (stack1.size()==0);
    }
}



public class p12{
    public static void main(String[] args) {
        MyQueue queue  = new MyQueue();
        for(int i = 0 ; i < 10;i++){
            queue.push(i+1);
        }
        for(int i = 0 ; i< 5 ; i++){
            System.out.println(queue.pop());
        }
        System.out.println(queue.peek());
        if(queue.empty()){
            System.out.println("it is empty");
        }
        else{
            System.out.println("it not empty");
        }
    }
}