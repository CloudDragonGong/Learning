package fanxing;

public class p2 {
    public static void main(String[] args) {
        Integer  x=100,y=90,c=110;
        Integer max = maxinum(x,y,c);
        System.out.println(max);
    }

    public static <T extends Comparable<T>> T maxinum(T x, T y, T z) {
        T max = x;
        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }

}
