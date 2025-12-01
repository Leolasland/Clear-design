package ru.project.task6;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Блокировки
 */
public class Example4 {

    public static void main(String[] args) throws InterruptedException {
        Example4 example = new Example4();

        Thread thread = new Thread(() -> {
            try {
                example.mockRestTemplate();
                Thread.sleep(1000);
                example.mockRestTemplate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread.start();
        Thread thread2 = new Thread(() -> {
            try {
                example.mockRestTemplate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread2.start();

        thread.join();
        thread2.join();

        System.out.println("Счетчик: " + example.getCounter());
    }

    private final ReentrantLock lock = new ReentrantLock();
    private int counter = 0;


    public void mockRestTemplate() {
        boolean acquired = false;
        try {
            System.out.println("Попытка блокировки " + Thread.currentThread().getName());
            acquired = lock.tryLock(1, TimeUnit.MILLISECONDS);
            if (acquired) {
                counter++;
                System.out.println("Счетчик " + counter + ", в потоке " + Thread.currentThread().getName());
            } else {
                System.out.println("Ошибка блокировки - таймаут  " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (acquired) {
                lock.unlock();
                System.out.println("Освобождение " + Thread.currentThread().getName());
            }
        }
    }

    public int getCounter() {
        System.out.println("Блокировка " + Thread.currentThread().getName());
        lock.lock();
        try {
            return counter;
        } finally {
            System.out.println("Разблокировка " + Thread.currentThread().getName());
            lock.unlock();
        }
    }


}
