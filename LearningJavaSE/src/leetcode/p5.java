package leetcode;

public class p5 {
    public static void main(String[] args) {
        char []s = { 'A',' ' ,'m'};
        reverseString(s);
        System.out.println(s);
    }
    public static void reverseString(char[] s) {
        char  c ;
        int i=0 ;

        while(i <s.length/2){
            c= s[i];
            s[i]= s[s.length-1-i];
            s[s.length-1-i]=c ;
            i++;
        }
    }
}
