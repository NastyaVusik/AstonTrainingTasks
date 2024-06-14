package runtimeExceptionsExample;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Попробовать написать код, с ошибками, который будет выбрасывать все RuntimeException из презентации.
public class Main {
    public static void main(String[] args) {

        RuntimeExceptionsTest runtimeExceptionsTest = new RuntimeExceptionsTest();


        //  NoSuchElementException example
        List<Integer> integerList = Collections.emptyList();
        List<Integer> list1 = Arrays.asList(4, 6, 8, -5, 12, 3, 990, 43);
        System.out.println(runtimeExceptionsTest.getMax(integerList));


        //  IndexOutOfBoundsException example
//        System.out.println(Arrays.toString(runtimeExceptionsTest.getArr()));


        //  ArithmeticException example
//        System.out.println(runtimeExceptionsTest.divideBigDecimal("15", "4"));


        //  ClassCastException example
//        runtimeExceptionsTest.getStringFromInt(34);


        //   NullPointerException example
//        NullPointerExceptionTest man = new NullPointerExceptionTest("Tom", 25);
//        NullPointerExceptionTest nullPointerExceptionTest = null;
//        nullPointerExceptionTest.setAge(45);


        //    IllegalArgumentException example
//runtimeExceptionsTest.runThread(-5000);
    }
}
