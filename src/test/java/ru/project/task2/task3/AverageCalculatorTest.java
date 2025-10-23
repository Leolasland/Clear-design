package ru.project.task2.task3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AverageCalculatorTest {

    @Test
    void calculateAverage() {
        AverageCalculator averageCalculator = new AverageCalculator();
        double result = averageCalculator.calculateAverage(new int[]{1, 2, 3, 4, 5});
        assertEquals(3.0, result);
    }

    @Test
    void calculateAverage_negative() {
        AverageCalculator averageCalculator = new AverageCalculator();
        double result = averageCalculator.calculateAverage(new int[]{-1, -2, -3, -4, -5});
        assertEquals(-3.0, result);
    }

    @Test
    void calculateAverage_zero() {
        AverageCalculator averageCalculator = new AverageCalculator();
        int[] numbers = new int[5];
        double result = averageCalculator.calculateAverage(numbers);
        assertEquals(0, result);
    }

    /**
     * Тест демонстирующий, что при неполном тестовом покрытии ошибки могут остаться.
     */
    @Test
    void calculateAverage_wrong() {
        AverageCalculator averageCalculator = new AverageCalculator();

        assertThrows(NullPointerException.class, () -> averageCalculator.calculateAverage(null));
    }
}