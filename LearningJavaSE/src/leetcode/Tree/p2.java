package leetcode.Tree;

public class p2 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int []cnt=new int[26] ;
        if(magazine.length()<ransomNote.length())
            return false;
        for(char a: magazine.toCharArray()){
            cnt[a-'a']++;
        }
        for(char a:ransomNote.toCharArray()){
            cnt[a-'a']--;
            if(cnt[a-'a']<0)
                return false;
        }
        return true;
    }
}
