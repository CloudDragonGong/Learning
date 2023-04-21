package leetcode;

import java.util.Stack;

public class p17 {
    public static void main(String[] args) {
        String[] tokens = {
                "10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN2(tokens));
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < tokens.length;i++){
            if(tokens[i].equals("*") || tokens[i] .equals( "/") || tokens[i].equals( "+") || tokens[i] .equals("-") ){
                if(stack.empty()){
                    System.out.println("error");
                    return -1;
                }
                else{
                    int b = stack.pop();
                    int a = stack.pop();
                    switch(tokens[i].charAt(0)){
                        case '*':
                            stack.push(a*b);
                            break;
                        case '/':
                            stack.push(a/b);
                            break;
                        case '+':
                            stack.push(a+b);
                            break;
                        case '-':
                            stack.push(a-b);
                            break;
                        default:
                            System.out.println("error");
                            return -1;
                    }
                }
            }
            else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.peek();
    }

    public static int evalRPN2(String[] tokens){
      //  "10","6","9","3","+","-11","*","/","*","17","+","5","+"};

        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < tokens.length;i++){
            switch(tokens[i].charAt(tokens[i].length()-1)){
                case '*':
                    int b1 = stack.pop();
                    int a1 = stack.pop();
                    stack.push(a1*b1);
                    break;
                case '/':
                    int b2 = stack.pop();
                    int a2 = stack.pop();
                    stack.push(a2/b2);
                    break;
                case '+':
                    int b3 = stack.pop();
                    int a3 = stack.pop();
                    stack.push(a3+b3);
                    break;
                case '-':
                    int b4 = stack.pop();
                    int a4 = stack.pop();
                    stack.push(a4-b4);
                    break;
                default:
                    stack.push(Integer.parseInt(tokens[i]));
                    break;
            }
        }
        return stack.peek();
    }
}
