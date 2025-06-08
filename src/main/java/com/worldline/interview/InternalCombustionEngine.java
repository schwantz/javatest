package com.worldline.interview;

public class InternalCombustionEngine implements Engine {

    private boolean running;
    private int fuelLevel;
    private final FuelType requiredFuelType;
    private FuelType fuelType;

    public InternalCombustionEngine(FuelType requiredFuelType) {
        if (requiredFuelType != FuelType.PETROL && requiredFuelType != FuelType.DIESEL) {
            throw new IllegalArgumentException("InternalCombustionEngine only accepts PETROL or DIESEL.");
        }
        this.requiredFuelType = requiredFuelType;
        running = false;
        fuelLevel = 0;
    }

    @Override
    public void start() {
        if (fuelLevel > 0 && requiredFuelType.equals(fuelType)) {
            running = true;
        } else {
            throw new IllegalStateException("Not able to start engine.");
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
        if (fuelLevel >= 0 && fuelLevel <= 100) {
            this.fuelLevel = fuelLevel;
        }
        else if (fuelLevel > 100) {
            this.fuelLevel = 100;
        }
        else {
            this.fuelLevel = 0;
        }

        this.fuelType = fuelType;
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
