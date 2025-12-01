package ru.project.task6;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Фьючерсы
 */
public class Example1 {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(Example1::mockRestTemplate);

        future.thenAccept(result ->
                System.out.println("Результат mockRestTemplate() " + result));

        System.out.println("Другая работа");

        try {
            System.out.println("Не завершаем текущий поток пока не выполнится mockRestTemplate()");
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * Имитируем вызов внешнего сервиса с задержкой ответа
     */
    private static String mockRestTemplate() {
        System.out.println("Создаем mockRestTemplate()");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "success";
    }
}
