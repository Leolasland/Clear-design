package ru.project.task2.task3;

public class AverageCalculator {

    public double calculateAverage(int[] numbers) {
        double sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum / numbers.length;
    }
}
