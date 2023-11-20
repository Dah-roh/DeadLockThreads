package org.example;

import java.util.concurrent.atomic.AtomicInteger;

public class Main{


    interface FunctionMethod{
        void apply();
    }

    static int counter = 0;
    static FunctionMethod increment = ()-> counter++;

    public static void main(String[] args) throws InterruptedException {

        Runnable runOne =()->{
            for (int i = 0; i < 150; i++) {
                increment.apply();
            }
        };

        Thread threadTwo = new Thread(()->{
            for (int i = 0; i < 150; i++) {
                increment.apply();
            }
        });
        Thread threadOne = new Thread(runOne);
        Thread threadThree = new Thread(()->{
            for (int i = 0; i < 150; i++) {
                increment.apply();
            }
        });
        threadOne.start();
        threadTwo.start();
        threadThree.start();

        threadOne.join();
        threadTwo.join();
        threadThree.join();


        System.out.println(counter);
    }
}