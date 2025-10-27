package ru.project.task4;

import java.util.List;

public class GradeCalculator {

    public double calculateAverage(List<Integer> grades) {
        if (grades == null || grades.isEmpty()) {
            throw new IllegalArgumentException("Grades must be notnull and not empty");
        }

        double sum = 0;
        for (Integer grade : grades) {
            if (grade == null || grade < 1 || grade > 5) {
                throw new IllegalArgumentException("Grades list contains null or invalid grade");
            }
            sum += grade;
        }

        return sum / grades.size();
    }
}
