package com.worldline.interview;

public class WidgetMachine {
    private Engine engine;

    public WidgetMachine(Engine engine) {
        this.engine = engine;
    }

    public double produceWidgets(int quantity) {
        engine.start();
        double cost = 0;

        if (engine.isRunning()) {
            cost = produce(quantity);
        }

        engine.stop();
        return cost;
    }

    private double produce(int quantity) {
        int batch = 0;
        int batchCount = 0;

        while (batch < quantity) {
            batch += engine.getBatchSize();
            batchCount++;
        }

        return batchCount * engine.getCostPerBatch();
    }
}
