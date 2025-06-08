package com.worldline.interview;

public class InternalCombustionEngine implements Engine {
    private boolean running;
    private int fuelLevel;
    private FuelType requiredFuelType;
    private FuelType fuelType;

    public InternalCombustionEngine(FuelType requiredFuelType) {
        this.requiredFuelType = requiredFuelType;
        this.running = false;
        this.fuelLevel = 0;
    }

    @Override
    public void start() {
        if (fuelLevel > 0 && requiredFuelType == fuelType) {
            running = true;
        } else {
            throw new IllegalStateException("Cannot start InternalCombustionEngine without fuel or with incorrect fuel type.");
        }
    }

    @Override
    public void stop() {
        running = false;
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    @Override
    public void fill(FuelType fuelType, int fuelLevel) {
        this.fuelType = fuelType;
        this.fuelLevel = Math.max(0, Math.min(fuelLevel, 100));
    }

    @Override
    public FuelType getFuelType() {
        return requiredFuelType;
    }

    @Override
    public int getBatchSize() {
        return 8;
    }

    @Override
    public double getCostPerBatch() {
        return requiredFuelType == FuelType.PETROL ? 9.0 : 12.0;
    }
}
