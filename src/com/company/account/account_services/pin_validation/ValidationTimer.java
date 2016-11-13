package com.company.account.account_services.pin_validation;

/**
 * Created by Maxim on 11/13/2016.
 */
public class ValidationTimer {
    private int time;
    private int waiting;
    private Thread timer;

    public ValidationTimer(int waiting) {
        time = 0;
        timer = new Thread(new Timer());
        this.waiting = waiting;
    }

    public int getTime() {
        return time;
    }

    public void start() {
        time = 0;
        timer = new Thread(new Timer());
        timer.start();
    }
    public void stop() {
        timer = null;
    }

    class Timer implements Runnable {
        @Override
        public void run() {
            try {
            while(time != waiting) {
                time = time + 1;
                Thread.sleep(1000);
            }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
