package com.worldline.interview;

public class WidgetMachine {
    private final Engine engine;

    public WidgetMachine(Engine engine) {
        this.engine = engine;
    }

    public double produceWidgets(int quantity) {
        engine.start();
        double cost = 0;

        if (engine.isRunning()) {
            int batch = 0;
            int batchCount = 0;
            int batchSize = engine.getBatchSize();
            double costPerBatch = engine.getCostPerBatch();

            while (batch < quantity) {
                batch += batchSize;
                batchCount++;
            }

            cost = batchCount * costPerBatch;
        }

        engine.stop();
        return cost;
    }
}
