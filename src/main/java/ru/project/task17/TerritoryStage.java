package ru.project.task17;

import java.util.Map;

/**
 * Общий класс для разных типов территорий
 */
public class TerritoryStage extends Stage {
    private final String territoryName;
    private final int territoryArea;
    private final int buildingCount;

    public TerritoryStage(String territoryName, int territoryArea, int buildingCount) {
        if (territoryName == null || territoryArea < 0 || buildingCount < 0) {
            throw new IllegalArgumentException();
        }
        this.territoryName = territoryName;
        this.territoryArea = territoryArea;
        this.buildingCount = buildingCount;
    }

    @Override
    public Map<String, Integer> countSpace() {
        return Map.of(
                territoryName + " площадь", territoryArea,
                territoryName + " зданий", buildingCount
        );
    }

    @Override
    public Map<String, Boolean> processingSpace() {
        boolean needsProcessing = territoryArea > 5000 || buildingCount > 50;
        return Map.of(territoryName, needsProcessing);
    }
}
