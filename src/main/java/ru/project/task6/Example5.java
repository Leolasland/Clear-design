package ru.project.task6;

import java.util.concurrent.Semaphore;

/**
 * Семафоры
 */
public class Example5 {
    private final Semaphore semaphore = new Semaphore(1);
    private static Integer sharedObject = 0;

    public void safeMethod() {
        try {
            System.out.println("Вызов safeMethod в потоке " + Thread.currentThread().getName());
            semaphore.acquire();
            System.out.println("Используем общие ресурсы, до изменения = " + sharedObject + " в потоке " + Thread.currentThread().getName());
            sharedObject++;
            System.out.println("Используем общие ресурсы, после изменения = " + sharedObject + " в потоке " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release();
            System.out.println("Завершение safeMethod в потоке " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Example5 example = new Example5();
        Thread thread = new Thread(() -> {
            try {
                example.safeMethod();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Thread thread1 = new Thread(() -> {
            try {
                example.safeMethod();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread.start();
        thread1.start();

        thread.join();
        thread1.join();

    }
}
