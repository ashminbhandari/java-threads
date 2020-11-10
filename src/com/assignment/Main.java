package com.assignment;

public class Main {
    public static void main(String[] args) {
        Object object = new Object();
        new Thread(new Q1Number(object)).start();
        new Thread(new Q1Alphabet(object)).start();
    }
}
