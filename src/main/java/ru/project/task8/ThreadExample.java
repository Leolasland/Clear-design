package ru.project.task8;

/**
 * Здесь возникает состояние гонки из-за доступа к общей переменной counter.
 * Например, поток 1 увеличивает считывает значение counter == 0, после чего увеличивает его на 1 и сохраняет.
 * Без блокировки поток 2 тоже может считать counter == 0 и увеличить его на 1 и тоже сохранить.
 * После этого значение counter будет равно 1, хотя в результате работы обоих потоков должно быть 2.
 * Исправить эту проблему можно с помощью AtomicInteger или synchronized.
 */
public class ThreadExample {
    private static int counter = 0;

    public static void main(String[] args) {
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter++;
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counter: " + counter);
    }
}
