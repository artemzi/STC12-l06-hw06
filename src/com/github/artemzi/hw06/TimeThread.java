package com.github.artemzi.hw06;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeThread extends Thread {
    Object monitor;

    public void setMonitor(Object monitor) {
        this.monitor = monitor;
}

    @Override
    public void run() {
        int counter = 0;
        synchronized (monitor) {
           while(true) {
                Date date = new Date(System.currentTimeMillis());
                DateFormat formatter = new SimpleDateFormat("ss.SSS");
                formatter.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"));

                System.out.println("Seconds from current time: " + formatter.format(date));
                try {
                    ++counter;
                    if ((counter % 5) == 0) {
                        monitor.notify();
                        monitor.wait();
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.err.println("Something wrong in TimeThread");
                }
            }
        }
    }
}
