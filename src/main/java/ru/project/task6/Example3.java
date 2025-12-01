package ru.project.task6;

import java.util.concurrent.CyclicBarrier;

/**
 * Барьеры
 */
public class Example3 {
    public static void main(String[] args) {
        int threadsCount = 5;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        for (int i = 1; i <= threadsCount; i++) {
            Thread thread = new Thread(() -> {
                try {
                    mockRestTemplate();
                    System.out.println("Дошли до барьера в потоке " + Thread.currentThread().getName());
                    cyclicBarrier.await();
                    System.out.println("Перешли барьер в потоке " + Thread.currentThread().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
    }

    private static void mockRestTemplate() {
        System.out.println("Вызов mockRestTemplate в потоке - " + Thread.currentThread().getName());
    }
}
