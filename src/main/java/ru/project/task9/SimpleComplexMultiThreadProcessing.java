package ru.project.task9;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Здесь используется ForkJoinPool для того, чтобы не управлять потоками вручную и избежать избыточной синхронизации.
 */
public class SimpleComplexMultiThreadProcessing {
    private static final int SIZE = 100_000_000;
    private static final int THREADS = 4;
    private static final int[] data = new int[SIZE];
    private static final Random random = new Random();

    public static void main(String[] args) {
        initData();

        try (ForkJoinPool pool = new ForkJoinPool(THREADS)) {
            int sum = pool.invoke(new ParallelSumTask(data, 0, SIZE));
            System.out.println("Sum of all elements: " + sum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Инициализация массива в отдельном методе
     */
    private static void initData() {
        for (int i = 0; i < SIZE; i++) {
            data[i] = random.nextInt(100);
        }
    }

    /**
     * Задачи для ForkJoinPool, где мы делим задачу на рекурсивные подзадачи пополам, пока не достигнем chunkSize
     */
    static class ParallelSumTask extends RecursiveTask<Integer> {
        private final int[] array;
        private final int start;
        private final int end;
        private static final int chunkSize = SIZE / THREADS;

        ParallelSumTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            int currentChunkSize = end - start;
            if (currentChunkSize <= chunkSize) {
                int sum = 0;
                for (int i = start; i < end; i++) {
                    sum += array[i];
                }
                return sum;
            }
            int middle = (start + end) / 2;
            ParallelSumTask leftTask = new ParallelSumTask(array, start, middle);
            ParallelSumTask rightTask = new ParallelSumTask(array, middle, end);

            leftTask.fork();
            rightTask.fork();

            return leftTask.join() + rightTask.join();
        }
    }
}
