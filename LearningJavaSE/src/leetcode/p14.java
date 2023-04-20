package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class p14 {
    public static void main(String[] args) {
        String s= new String ("){");
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {
        if(s.length()%2!=0 || s.length()==0){
            return false ;
        }
        else{
            Stack<Character> stack = new Stack<>();
            //如果是左括号就是进栈，右括号就是出栈
            for(int i = 0 ; i < s.length();i++) {
                char s1= s.charAt(i);
                if (s1=='(' || s1 == '{' || s1 == '['){
                    stack.push(s1);
                }
                else{
                    if(stack.empty()){
                        return false;
                    }
                    char s2 = stack.peek();
                    switch (s1) {
                        case ')':
                            if(s2!='(')
                                return false;
                            else
                                stack.pop();
                            break;
                        case '}':
                            if(s2!='{')
                                return false;
                            else
                                stack.pop();
                            break;
                        case ']':
                            if(s2!='[')
                                return false;
                            else
                                stack.pop();
                            break;
                        default:
                            return false;
                    }
                }
            }
            if (stack.empty()) {
                return true;
            }
            else {
                return false;
            }
        }
    }
}
