package org.example;

public class SyncExample {

        private static String lock1 = "LOCK 1";
        private static String lock2 = "LOCK 2";

    public static void main(String[] args) throws InterruptedException {

        Thread threadOne = new Thread(runnable1);
        Thread threadTwo = new Thread(runnable2);

        threadOne.start();
        threadTwo.start();
    }

            static Runnable runnable1 = () -> {
                synchronized (lock1) {
                    try {
                        System.out.println("Accessing user information...");
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }

                synchronized (lock2) {
                    System.out.println("Getting User paystack card details...");
                }
            };







            static Runnable runnable2 = () -> {
                synchronized (lock2) {
                    try {
                    System.out.println("Adding items to user payments...");
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (lock1) {
                        System.out.println("Finalizing user payment...");
                    }
                }
            };



}
