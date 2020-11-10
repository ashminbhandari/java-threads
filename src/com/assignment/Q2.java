package com.assignment;

class Q2 {
    private int counter;

    public synchronized void printer(char character, int number) throws InterruptedException {
        for (int i = 0; i < 10;) {
            if (counter % 3 == number) {
                System.out.print(character);
                if (character == 'C') System.out.print(" ");
                i++;
                counter++;
                notifyAll(); //resume all threads
            }
            wait();
        }
    }
}

class Q2Thread extends Thread {
    private Q2 object;
    private int number;
    private char character;

    Q2Thread(Q2 object, char character, int number) {
        this.object = object;
        this.number = number;
        this.character = character;
    }

    @Override
    public void run() {
        try {
            object.printer(character, number);
        } catch (InterruptedException e) {
            System.out.println("INTERRUPT");
            e.printStackTrace();
        }
    }
}
