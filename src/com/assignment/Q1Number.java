package com.assignment;

public class Q1Number implements Runnable {
    private Object object;

    public Q1Number(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        synchronized (object) {
            for (int i = 1; i < 53; i++) {
                if (i > 1 && i % 2 == 1) {
                    System.out.print("  ");
                }
                System.out.print(i);
                if (i % 2 == 0) {
                    object.notifyAll();
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
