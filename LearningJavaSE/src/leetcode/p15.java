package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

//默写一遍leetcode官方题解
//主要是为了代码美观好看
public class p15 {
    public boolean isValid(String s ){
        int n = s.length();
        if(n%2!=0){
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character,Character> hashMap = new HashMap<Character,Character>(){
            {
                put('}', '{');
                put(']','[');
                put(')','(');
            }
        };
        for(int i = 0 ; i < n ; i++){
            if(hashMap.containsKey(s.charAt(i))){
                if(stack.isEmpty()||hashMap.get(s.charAt(i))!=stack.peek()){
                    return false;
                }
                stack.pop();
            }
            else{
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
