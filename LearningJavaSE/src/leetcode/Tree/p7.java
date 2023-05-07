package leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

public class p7 {
    public static void main(String[] args) {
        String s = new String(" asdasd df f");
        String ss = reverseWords(s);
        System.out.println(ss);
    }

    public static String reverseWords(String s) {
        char[] ss = s.toCharArray();
        List<String> list = new ArrayList<>();
        boolean loc = false;//j之前是否在空白处
        int i = 0, j = 0;
        for (; ss[i] == ' '; i++) ;
        j = i;
        while (j < ss.length) {

            if (ss[i] != ' ' && ss[j] != ' ' && loc) {
                i = j;
                loc = false;
            }
            if ((ss[i] != ' ' && ss[j] == ' ' && !loc)) {
                String x = new String(ss, i, j - i);
                list.add(0, x);
                loc = true;
                continue;
            }

            if ((ss[j] != ' ' && j == ss.length - 1)) {
                String x = new String(ss, i, j - i + 1);
                list.add(0, x);
            }
            j++;
        }
        String str = String.join(" ", list);
        return str;
    }
}
