package leetcode.backtrack;


import java.util.*;
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
//给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//来源：力扣（LeetCode）
//链接：https://leetcode.cn/problems/letter-combinations-of-a-phone-number
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

//执行结果：
//通过
//显示详情
//查看示例代码
//添加备注
//
//执行用时：
//2 ms
//, 在所有 Java 提交中击败了
//18.28%
//的用户
//内存消耗：
//40.2 MB
//, 在所有 Java 提交中击败了
//40.22%
//的用户
//通过测试用例：
//25 / 25
public class p1 {
    public static void main(String[] args) {
        List<String>  list = letterCombinations(new String(""));
        System.out.println(list);
    }
    public static List<String> letterCombinations(String digits) {
        char [] digitsArray = digits.toCharArray();
        List<String> array = new ArrayList<>();
        List<String> list = new ArrayList<>();
        Deque<Character> stack = new ArrayDeque<>();
        if(digits.isEmpty()){
            return list;
        }
        HashMap<Character,String> map = new HashMap<Character,String>(){
            {
                put('2',"abc");
                put('3',"def");
                put('4',"ghi");
                put('5',"jkl");
                put('6',"mno");
                put('7',"pqrs");
                put('8',"tuv");
                put('9',"wxyz");
            }
        };

        for(char index : digitsArray ){
            array.add(map.get(index));
        }
        dfs(array,list,0,stack);
        return list;
    }

    public static void  dfs(List<String> array,List<String> list,int arrayIndex , Deque<Character> stack ){
        if(stack.size() == array.size()){
            list.add(transform(stack));
            return;
        }
        for(int i = 0 ;i < array.get(arrayIndex).length();i++ ){
            stack.offerLast(array.get(arrayIndex).charAt(i));
            dfs(array,list,arrayIndex+1,stack);
            stack.pollLast();
        }
    }

    public static String transform(Deque<Character>stack){
        StringBuffer stringBuffer = new StringBuffer();
        Deque<Character> stack_copy = new ArrayDeque<>(stack);
        while(!stack_copy.isEmpty()){
            stringBuffer.append(stack_copy.pollFirst());
        }
        return  stringBuffer.toString();
    }
}