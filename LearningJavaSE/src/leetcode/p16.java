package leetcode;

import java.util.Stack;

public class p16 {
    public static void main(String[] args) {
        String s = new String ("abbadadv");
        System.out.println(removeDuplicates(s));
    }
    public static String removeDuplicates(String s) {
        Stack<Character> stack= new Stack<>();
        for(int i = 0 ; i< s.length();i++){
            if(stack.empty()){
                stack.push(s.charAt(i));
                continue;
            }
            if(stack.peek()==s.charAt(i)){
                stack.pop();
            }
            else{
                stack.push(s.charAt(i));
            }
        }
        StringBuffer out = new StringBuffer();
        while(!stack.empty()){
            out.append(stack.pop());
        }
        out = out.reverse();
        return out.toString();
    }
}
