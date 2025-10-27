package ru.project.task4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GradeCalculatorTest {

    GradeCalculator calculator = new GradeCalculator();

    @Test
    void normalCase() {
        assertEquals(3.0, calculator.calculateAverage(List.of(2, 3, 4)));
    }

    @Test
    void emptyListReturnsZero() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateAverage(List.of()));
    }

    @Test
    void nullGradeThrowsException() {
        List<Integer> grades = new ArrayList<>();
        grades.add(2);
        grades.add(null);
        grades.add(3);
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateAverage(grades));
    }

    @Test
    void invalidGradeThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateAverage(List.of(5, 6)));
    }

    @Test
    void negativeGradeThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateAverage(List.of(-5)));
    }

    @Test
    void singleElementList() {
        assertEquals(4.0, calculator.calculateAverage(List.of(4)));
    }
}