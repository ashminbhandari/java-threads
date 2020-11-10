package com.assignment;

class Q1Alphabet implements Runnable {
    private Object object;

    public Q1Alphabet(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        synchronized (object) {
            for (char i = 'A'; i <= 'Z'; i++) {
                System.out.print(i);
                object.notifyAll();
                if (i < 'Z') {  // The last time the thread is executed, it can't be blocked, otherwise it will block.
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

