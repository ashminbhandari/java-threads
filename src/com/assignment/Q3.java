/*
3. Assuming that the garage has 3 parking spaces
(the garage can be represented by the boolean[] array), write a program to simulate the
effect of multiple users driving away and parking into the garage.
Note: You cannot park when there is a car in the parking space.
(hint: each thread represents a car, and use main funciton
to create new threads and run them, you can limit the total number of cars to be created)
 */
package com.assignment;

import java.util.Random;


public class Q3 {
    private boolean[] parkingSpace = new boolean[3];

    public synchronized void tryToPark(String carName) throws InterruptedException {
        for (int i = 0; i < parkingSpace.length; i++) {
            if (parkingSpace[i] == false) { //if there is space
                //park
                System.out.println(carName + " has found a spot. The " + i + " spot was free.");
                parkingSpace[i] = true; //park

                //for some seconds
                Random rand = new Random();
                int parkTime = rand.nextInt(10000);
                System.out.println(carName + " bought a ticket for " + parkTime + " seconds.");

                //leave
                wait(parkTime); //for some millis
                parkingSpace[i] = false;
                System.out.println(carName + " finished their parking time and has now left the lot.");
                break;
            }
        }

        System.out.println("No spot right now for " + carName + ". They left.");
    }
}

class CarThread extends Thread {
    private Q3 object;
    private String carName;

    public  CarThread (Q3 object, String carName) {
        this.object = object;
        this.carName = carName;
    }

    @Override
    public void run() {
        try {
            object.tryToPark(carName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}