package leetcode;

public class p8 {
    public static void main(String[] args) {
        String s = new String("hello world");
        System.out.println(reverseLeftWords(s,3));
    }
    public static String reverseLeftWords(String s, int n) {
        String s1 = s.substring(0,n);
        String s2 = s.substring(n);
        return s2+s1;
    }
}
