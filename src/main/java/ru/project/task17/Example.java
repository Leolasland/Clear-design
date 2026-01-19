package ru.project.task17;

public class Example {
    public static void main(String[] args) {
        Stage stageInteranl1 = StageHelper.createInternal("Офис", 50);
        Stage stageInteranl2 = StageHelper.createInternal("Спортзал", 50);
        Stage stageTerritory1 = StageHelper.createTerritory("Гараж", 8000, 30);
        Stage stageTerritory2 = StageHelper.createTerritory("Парковка", 8000, 30);

        StageHelper.analyzeStages(stageInteranl1, stageInteranl2, stageTerritory1, stageTerritory2);
    }
}
