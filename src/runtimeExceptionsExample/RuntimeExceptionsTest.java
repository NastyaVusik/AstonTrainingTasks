package runtimeExceptionsExample;

import lombok.SneakyThrows;

import java.math.BigDecimal;
import java.util.*;

public class RuntimeExceptionsTest {

    //    NoSuchElementException example
    public int getMax(List<Integer> list) {

        return list.stream()
                .max(Comparator.comparingInt(a -> a))
                .orElseThrow();
    }


    //     IndexOutOfBoundsException example
    public int[] getArr() {
        int[] arr = new int[3];
        for (int i = 0; i <= arr.length; i++) {
            arr[i] = i + 1;
        }

        return arr;
    }


    //    ArithmeticException example
    public BigDecimal divideBigDecimal(String a, String b) {
        BigDecimal x = new BigDecimal(a);
        BigDecimal y = new BigDecimal(b);
//        return y.divide(x, 6, BigDecimal.ROUND_DOWN);
        return y.divide(x);
    }


    //    ClassCastException example
    public String getStringFromInt(double a) {
        Object x = Double.valueOf(a);
        String str = (String) x;

        return str;

//        if(str instanceof Integer){
//            System.out.println(str);
//        }
//        else {
//            System.out.println("It isn't Integer");
//        }
    }


    //    IllegalArgumentException example
    public void runThread(int time) {
        Thread thread1 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(time);
                System.out.println("Thread sleeps");
            }
        }, "thread1");

        System.out.println(thread1.getName() + "!!!");

        thread1.start();
    }

}




