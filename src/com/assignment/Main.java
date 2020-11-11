package com.assignment;

import java.util.concurrent.TimeUnit;

public class Main {
    private boolean Q2Order;

    public static void main(String[] args) throws InterruptedException {
        //q1
        Object object = new Object();
        new Thread(new Q1Number(object)).start();
        new Thread(new Q1Alphabet(object)).start();

        TimeUnit.SECONDS.sleep(3);
        System.out.println();

        //q2
        Q2 x = new Q2();
        new Q2Thread(x, 'A', 0).start();
        new Q2Thread(x, 'B', 1).start();
        new Q2Thread(x, 'C', 2).start();

        TimeUnit.SECONDS.sleep(3);
        System.out.println();

        //q3
        Q3 y = new Q3();
        new CarThread(y, "Volvo").start();
        new CarThread(y, "Mercedes").start();
        new CarThread(y, "Hercules").start();
        TimeUnit.MILLISECONDS.sleep(200);
        new CarThread(y, "Ferrari").start();
        TimeUnit.MILLISECONDS.sleep(1000);
        new CarThread(y, "Mustang").start();
        TimeUnit.MILLISECONDS.sleep(3000);
        new CarThread(y, "Santro").start();
        new CarThread(y, "Hyundai AV").start();
        TimeUnit.MILLISECONDS.sleep(200);
        new CarThread(y, "Tesla").start();
        TimeUnit.MILLISECONDS.sleep(200);
        new CarThread(y, "Jeep").start();
    }
}
