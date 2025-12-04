package ru.project.task7;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Недостатки:
 * Использование устаревшего API
 * SimpleDateFormat не потокобезопасен
 * Нет поддержки временных зон
 */
public class DateExample {
    public static void main(String[] args) {
        String dateString = "2024-05-13 14:30:00";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = format.parse(dateString);
            System.out.println("Date: " + date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
