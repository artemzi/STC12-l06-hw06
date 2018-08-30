package com.github.artemzi.hw06;

public class Main {

    public static void main(String[] args) {
        Object monitor = new Object();

        TimeThread timeThread = new TimeThread();
        MessageThread messageThread = new MessageThread();

        timeThread.setMonitor(monitor);
        messageThread.setMonitor(monitor);
        timeThread.start();
        messageThread.start();

        try {
            timeThread.join();
            messageThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
