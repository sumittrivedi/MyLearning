package com.epam;

public class ThreadImpl {
    private volatile boolean isOdd = true;

    private synchronized void printOdd() {
        for (int i = 1; i <= 9; i = i + 2) {
            while (!isOdd) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Thread 1 : " + i);
            isOdd = false;
            notify();
        }
    }

    private synchronized void printEven() {
        for (int i = 2; i <= 10; i = i + 2) {
            while (isOdd) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Thread 2 : " + i);
            isOdd = true;
            notify();
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ThreadImpl obj = new ThreadImpl();
        Thread odd = new Thread(obj::printOdd);
        Thread even = new Thread(obj::printEven);
        odd.start();
        even.start();
    }

}
