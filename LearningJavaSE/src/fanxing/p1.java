package fanxing;


public class p1 {

    public static <E> void  print(E[] elements){
        for(E element : elements){
            System.out.println(element);
        }
    }

    public static void main(String[] args){
        Integer[] elements= { 1, 2, 3 };
        print(elements);
        String[] elements1={"yun","long"};
        print(elements1);
    }
}
