package fanxing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class p4 {
    public static void print1(List<? extends Number> x) {
        for (Number y : x) {
            System.out.println(y);
        }
    }

    public static void print2(List<? super Integer> x ){
        for( Object y:x){
            System.out.println(y);
        }
    }

    public static void main(String[] args ){
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Double> list2=  Arrays.asList(1.0,1.2,1.3);

        print1(list1);
        print1(list2);


        print2(list1);


    }
}
