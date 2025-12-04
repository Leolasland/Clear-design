package ru.project.task7;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class FixDateExample {
    private static final DateTimeFormatter STRICT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        String dateString = "2024-05-13 14:30:00";

        try {
            LocalDateTime dateTime = LocalDateTime.parse(dateString, STRICT_FORMATTER);

            LocalDateTime now = LocalDateTime.now();
            if (dateTime.isBefore(now)) {
                System.out.println("Date is in the past");
            }
            ZonedDateTime zonedDateTime = dateTime.atZone(ZoneId.of("Europe/Moscow"));
            System.out.println("With time zone: " + zonedDateTime);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
