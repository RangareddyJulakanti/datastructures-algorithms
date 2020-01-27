package com.developer.algorithms.diningphiloshopers;

public class Philosopher implements Runnable {
    private Object left;
    private Object right;

    public Philosopher(Object left, Object right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        try {
            while (true) {
                doAction(System.nanoTime() + "thinking");
                synchronized (left) {
                    doAction(System.nanoTime() + "pickup left fork");
                    synchronized (right) {
                        doAction(System.nanoTime() + "pickup right fork");
                        doAction(System.nanoTime() + "eating");
                    }
                    doAction(System.nanoTime() + "put down left fork");
                }
                doAction(System.nanoTime() + "put down right fork");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void doAction(String action) throws InterruptedException {
        System.out.println(
                Thread.currentThread().getName() + " " + action);
        Thread.sleep(((int) (20 * 100)));
    }


}
 class DiningPhilosophers {
    public static void main(String[] args) throws Exception {
        Philosopher[] philosophers = new Philosopher[5];
        Object[] forks = new Object[philosophers.length];
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Object();
        }
        for (int i = 0; i < philosophers.length; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % forks.length];
            if (i == philosophers.length - 1) {
                // The last philosopher picks up the right fork first
                philosophers[i] = new Philosopher(rightFork, leftFork);
            } else {
                philosophers[i] = new Philosopher(leftFork, rightFork);
            }
            Thread t = new Thread(philosophers[i], "Philosopher " + (i + 1));
            t.start();
        }
    }
}

