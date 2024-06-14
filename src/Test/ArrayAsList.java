package Test;


import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ArrayAsList {
    public static void main(String[] args) {
        List<String> list1 = List.of("a", "b", "c", "d");

        String[] arr = {"a", "b", "c", "d"};
        List<String> list2 = Arrays.asList(arr);

        System.out.println("list1 before = " + list1);
        System.out.println("list2 before = " + list2);

//         list1.add("e");
//        list2.add("e");
//        list1.set(1, "s");
//        list2.set(2, "r");
//        list1.remove(1);
        list2.remove(1);
        System.out.println("list1 get() = " + list1.get(1));
        System.out.println("list2 get() = " + list2.get(1));

        System.out.println("list1 after = " + list1);
        System.out.println("list2 after = " + list2);
    }
}

