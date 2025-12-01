package ru.project.task6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Планировщик задач
 */
public class Example2 {
    public static void main(String[] args) {
        try (ExecutorService executor = Executors.newFixedThreadPool(4)) {
            List<Callable<String>> tasks = new ArrayList<>(8);
            for (int i = 1; i <= 8; i++) {
                tasks.add(new MockRestTemplate(i));
            }
            System.out.println("Другая работа");
            // Выполняем задачи
            List<Future<String>> futures = executor.invokeAll(tasks);
            for (Future<String> future : futures) {
                try {
                    System.out.println(future.get());
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Имитируем вызов внешнего сервиса с задержкой ответа
     */
    static class MockRestTemplate implements Callable<String> {
        private final int i;

        public MockRestTemplate(int i) {
            System.out.println("Создаем MockRestTemplate - " + i);
            this.i = i;
        }

        @Override
        public String call() throws Exception {
            Thread.sleep(1000);
            return "Результат " + i + " MockRestTemplate";
        }
    }
}
