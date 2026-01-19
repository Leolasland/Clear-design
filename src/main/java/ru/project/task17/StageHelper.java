package ru.project.task17;

/**
 * В моем проекте есть такой паттерн - он помогает обрабатывать одни типы данных разным образом,
 * а также появляется единое место для внесения изменений.
 */
public class StageHelper {
    public static Stage createInternal(String name, int area) {
        InternalStage internal = new InternalStage(name, area);
        // Здесь отправка в другую систему информации о создании нового внутреннего помещения
        // Sender.send(internal);
        return internal;
    }

    public static Stage createTerritory(String name, int area, int buildings) {
        return new TerritoryStage(name, area, buildings);
    }

    public static void analyzeStages(Stage... stages) {
        System.out.println("Анализ " + stages.length + " этапов:");
        for (Stage stage : stages) {
            System.out.println("Результаты: " + stage.countSpace());
            System.out.println("Обработка: " + stage.processingSpace());
        }
    }
}
