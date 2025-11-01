package ru.project.task5;

/**
 * В данном примере есть ошибка в реализации многопоточности. Возникает состояние гонки - каждый поток пытается
 * одновременно записать увлечение общего счетчика.
 * Операция counter++; не является атомарной и состоит из трех шагов:
 * чтение текущего значения, инкремент и запись нового значения.
 * Потоки не синхронизируют доступ к общему счетчику.
 * Также изменения одного потока могут быть не видны другим потокам из-за кэширования переменной.
 * Решение - заменить примитивный int на AtomicInteger из пакета concurrent. {@link RaceConditionFix}
 */
public class RaceConditionExample {
    private static int counter = 0;

    public static void main(String[] args) {
        int numberOfThreads = 10;
        Thread[] threads = new Thread[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    counter++;
                }
            });
            threads[i].start();
        }

        for (int i = 0; i < numberOfThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Final counter value: " + counter);
    }
}
