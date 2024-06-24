package concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        BigList bigList = new BigList();

//        long listSize = 1_000_000;
        long listSize = 10;


        //    Array for all required methods
        Runnable[] methods = new Runnable[]{
                new Runnable() {
                    @Override
                    public void run() {

                        System.out.println("Thread " + Thread.currentThread().getName() + " start.");
                        System.out.println("\nBigList:\n" + bigList.getBigList(listSize));
                        System.out.println("Thread " + Thread.currentThread().getName() + " end.");
                    }
                },

                new Runnable() {
                    @Override
                    public void run() {

                        System.out.println("Thread " + Thread.currentThread().getName() + " start.");
                        System.out.println("\nThe first part of BigList:\n" + bigList.getUpperCaseInFirstHalfOfList(listSize));
                        System.out.println("Thread " + Thread.currentThread().getName() + " end.");
                    }
                },

                new Runnable() {
                    @Override
                    public void run() {

                        System.out.println("Thread " + Thread.currentThread().getName() + " start.");
                        System.out.println("\nThe second part of BigList:\n" + bigList.getLowerCaseInSecondHalfOfList(listSize));
                        System.out.println("Thread " + Thread.currentThread().getName() + " end.");
                    }
                }
        };


        for (Runnable task : methods) {
            executor.submit(task);
        }
        executor.shutdown();

//
//
//
    }
}
