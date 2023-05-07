package leetcode.Tree;

public class p6 {
    public static void main(String[] args) {
        char [] s  = { '2','3','4','5','6','7','7','8','9','0'};
        String ss = new String(s);

        String sss = reverseStr(ss ,3 );
        System.out.println(sss);
    }
    public static  String reverseStr(String s, int k) {
        char[] ss = s.toCharArray();
        int i = k -1 ;
        int j = 2 * k -1 ;

        while ( true ){
            if ( i < ss.length && j < ss.length) {
                reverseString(ss , i - k + 1 , i ) ;
                i +=2 * k ;
                j += 2 * k ;
            }
            else if ( i < ss.length){
                reverseString(ss , i - k + 1 , i ) ;
                return new String(ss);
            }
            else {
                reverseString(ss , i - k + 1 , ss.length-1 );
                return new String(ss);
            }
        }
    }
    public static void reverseString(char[] s ,int a , int b ) {
        char  c ;
        int i=a;
        int j=b;
        while(i < j ){
            c= s[i];
            s[i]= s[j];
            s[j]=c ;
            i++;
            j--;
        }
    }
}
