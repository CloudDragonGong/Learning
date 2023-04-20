package LearningJava.Collection;

import java.util.ArrayList;
import java.util.List;
//示范List接口的使用
public class p1 {
    public static void main(String args[]){
        List <String> list = new ArrayList<>();


        list.add("a");
        list.add("b");
        list.add("c");

        System.out.println("List elements is :"+list);

        String secondElement = list.get(1);

        System.out.println("secondElement of list is "+secondElement);

        list.add(1,"d");
        System.out.println("List elements is :"+list);


        int index = list.indexOf("b");

        System.out.println(index);

        list.add("b");
        index = list.lastIndexOf("b");
        System.out.println(list);
        System.out.println(index);
        List<String> subList= list.subList(1,4);
        System.out.println(subList);

        String[]array=list.toArray(new String[list.size()]);
        for ( String array_ : array)
        System.out.println(array_);


        List<String>listE=new ArrayList<>();
        listE.addAll(list);

        System.out.println(listE);

        listE.addAll(2,list);

        System.out.println(listE);
    }
}
