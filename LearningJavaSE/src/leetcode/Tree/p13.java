package leetcode.Tree;

import java.sql.SQLOutput;
import java.util.LinkedList;

public class p13 {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        for(int i = 0 ; i < 10; i++){
            stack.push(i+1);
        }
        for(int i = 0 ; i < 5; i++){
            System.out.println(stack.pop());
        }
        System.out.println("the top is "+stack.top());
        if ( stack.empty())
            System.out.println("the stack is empty");
        else{
            System.out.println("the stack is not empty");
        }
    }
    static class  MyStack {
        private LinkedList<Integer> queue ;
        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            queue.add(x);
        }

        public int pop() {
            for(int i= 0 ; i < queue.size()-1;i++){
                queue.add(queue.pop());
            }
            return queue.pop();
        }

        public int top() {
            for(int i= 0 ; i < queue.size()-1;i++){
                queue.add(queue.pop());
            }
            int topnum = queue.peek();
            queue.add(queue.pop());
            return topnum;
        }

        public boolean empty() {
            return queue.size()==0;
        }
    }

}
