package ru.project.task5;

/**
 * Здесь происходит deadlock.
 * thread1 захватывает lock1. thread2 захватывает lock2.
 * thread1 пытается захватить lock2, но он уже занят thread2 и происходит блокировка, а thread2 соответсвенно наоборот.
 * Каждый поток удерживает один ресурс и ждет другой поток.
 * При этом объекты lock1 и lock2 могут быть захвачены только одним потоком.
 * Решение - упорядочить блокировки. thread1 захватывает lock1. thread2 тоже захватывает lock1.
 */
public class DeadlockExample {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1 acquired lock1");

                try { Thread.sleep(50); }
                catch (InterruptedException e) { e.printStackTrace(); }

                synchronized (lock2) {
                    System.out.println("Thread 1 acquired lock2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2 acquired lock2");

                try { Thread.sleep(50); }
                catch (InterruptedException e) { e.printStackTrace(); }

                synchronized (lock1) {
                    System.out.println("Thread 2 acquired lock1");
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finished");
    }
}
