package ru.project.task17;

import java.util.Map;

/**
 * Общий класс для разных типов внутренних помещений
 */
public class InternalStage extends Stage{

    private final String spaceName;
    private final Integer spaceArea;

    public InternalStage(String spaceName, Integer spaceArea) {
        if (spaceName == null || spaceArea == null || spaceArea < 0) {
            throw new IllegalArgumentException();
        }
        this.spaceName = spaceName;
        this.spaceArea = spaceArea;
    }

    @Override
    public Map<String, Integer> countSpace() {
        return Map.of(spaceName, spaceArea);
    }

    @Override
    public Map<String, Boolean> processingSpace() {
        boolean needProcessingSpace = spaceArea > 100;
        return Map.of(spaceName, needProcessingSpace);
    }
}
