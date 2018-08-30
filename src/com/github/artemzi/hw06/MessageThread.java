package com.github.artemzi.hw06;

public class MessageThread extends Thread {
    Object monitor;

    public void setMonitor(Object monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        synchronized (monitor) {
            while(true) {
                System.out.println("Hi, I'm MessageThread.");
                monitor.notify();
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    System.err.println("Something wrong in MessageThread");
                }
            }
        }
    }
}
