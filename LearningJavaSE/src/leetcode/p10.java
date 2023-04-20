package leetcode;
import java.util.Arrays;
public class p10 {
    public static void main(String[] args) {
        String s = new String ( "abacababacab");
        System.out.println(repeatedSubstringPattern(s));
    }
    public static boolean repeatedSubstringPattern(String s) {
       int [] primeNum  =  generatePrimeNumbers(s.length());
       for(int i = 0 ; i < primeNum.length ; i++){
           int success = 0 ;
           if(s.length()%primeNum[i] ==0 && s.length()!= primeNum[i] ){
               String sub1 = s.substring(0 , s.length()/primeNum[i]);
               int index = s.length()/primeNum[i] ;
               for(int j = 0 ; j < primeNum[i]-1;j ++){
                   String sub2 = s.substring(index,index+s.length()/primeNum[i]);
                   if(sub1.equals(sub2)){
//                       index+=primeNum[i] ;
                       index += (s.length()/primeNum[i]);
                       if(index==s.length()){
                           return true;
                       }
                   }
                   else{
                       break;
                   }
               }
           }
           else if(s.length()%primeNum[i]==0){
               char c = s.charAt(0);
               for(int j= 0 ; j< s.length();j++){
                   if(c!=s.charAt(j)){
                       return false;
                   }
               }
               return true;
           }
       }
      return false;
    }
    public static int[] generatePrimeNumbers(int n) {
        // 创建一个布尔类型的数组来记录每个数是否为质数
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true); // 将数组初始化为全部为true

        // 从2开始遍历到n，标记所有的合数
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) { // 如果i是质数
                for (int j = i * i; j <= n; j += i) { // 将i的倍数标记为合数
                    isPrime[j] = false;
                }
            }
        }

        // 计算质数的数量，创建一个数组来存储质数
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) count++;
        }
        int[] primes = new int[count];

        // 将所有质数存储在数组中
        int index = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes[index++] = i;
            }
        }
        return primes;
    }

}
