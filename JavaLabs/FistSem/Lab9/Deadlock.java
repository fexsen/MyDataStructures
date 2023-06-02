package JavaLabs.FistSem.Lab9;


public class Deadlock {
    public static void main(String[] args) {
        final Object lock1 = new Object();
        final Object lock2 = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1 acquired lock1 at time " + System.currentTimeMillis() + " ms");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("Thread 1 acquired lock2 at time " + System.currentTimeMillis() + " ms");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2 acquired lock2 at time " + System.currentTimeMillis() + " ms");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("Thread 2 acquired lock1 at time " + System.currentTimeMillis() + " ms");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
