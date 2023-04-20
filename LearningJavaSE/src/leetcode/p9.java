package leetcode;

public class p9 {
    public static void main(String[] args) {
        String needle = new String ("ababc");
        int [] next = nextFind(needle);
        for(int i = 0 ; i < next.length;i++)
            System.out.println(next[i]);
        System.out.println("finshed");

        String haystack  = new String("aaaaaaaab");
        System.out.println(strStr(haystack,needle));
    }
    public static int strStr(String haystack, String needle) {
        int [] next = nextFind(needle);
        int i= 0 , j = 0 ;
        while(j<needle.length()&& i < haystack.length()){
            if( haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }
            else{
                if(i== haystack.length() -1&& j ==0){
                    return -1;
                }
                else if(j==0){
                    i++;
                    continue;
                }
                j = next[j-1] ;
            }
        }
        if(j == needle.length() )
            return i - needle.length();
        else
            return -1;
    }
    public static int[] nextFind(String needle){
        int [] next = new int[needle.length()];
        char [] needlechar = needle.toCharArray();
        next[0] = 0 ;
        int i = 1;
        int p = i ;
        while(i < next.length){
           if(needlechar[i]==needlechar[next[p-1]]){
               next[i++] = next[p-1]+1;
               p = i ;
           }
           else{
               p = next[p-1];
               if(p == 0 ){
                   next[i++]=0;
                   p = i ;
               }
           }
        }
        return next;
    }
}



