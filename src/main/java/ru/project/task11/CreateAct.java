package ru.project.task11;

import java.util.List;

interface Act {
    boolean sign();
}

class TechnicalAct implements Act {
    private final boolean done;
    private final List<String> executors;

    public TechnicalAct(boolean done, List<String> executors) {
        this.done = done;
        this.executors = executors;
    }

    @Override
    public boolean sign() {
        return !executors.isEmpty() && done;
    }
}

class CleaningAct implements Act {
    private final boolean done;
    private final boolean clean;

    public CleaningAct(boolean done, boolean clean) {
        this.done = done;
        this.clean = clean;
    }

    @Override
    public boolean sign() {
        return clean && done;
    }
}

/**
 * Используем полиморфизм для подписи разных типов актов.
 * Когда изменяться требования и появится новый тип акта, например закупка,
 * то мы просто создадим еще один класс имплементирующий интерфейс Act.
 */
public class CreateAct {
    public static void main(String[] args) {
        Act technicalAct = new TechnicalAct(true, List.of("Иванов И. И."));
        Act cleaningAct = new CleaningAct(false, true);

        System.out.println(technicalAct.sign());
        System.out.println(cleaningAct.sign());
    }
}
