package com.worldline.interview;

public class SteamEngine implements Engine {
    private boolean running;
    private int fuelLevel;
    private FuelType requiredFuelType;
    private FuelType fuelType;

    public SteamEngine(FuelType requiredFuelType) {
        if (requiredFuelType != FuelType.WOOD && requiredFuelType != FuelType.COAL) {
            throw new IllegalArgumentException("SteamEngine only accepts WOOD or COAL.");
        }
        this.requiredFuelType = requiredFuelType;
        this.running = false;
        this.fuelLevel = 0;
    }

    @Override
    public void start() {
        if (fuelLevel > 0 && requiredFuelType == fuelType) {
            running = true;
        } else {
            throw new IllegalStateException("Cannot start SteamEngine without fuel or with incorrect fuel type.");
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
        if (fuelType != FuelType.WOOD && fuelType != FuelType.COAL) {
            throw new IllegalArgumentException("SteamEngine only accepts WOOD or COAL.");
        }
        this.fuelType = fuelType;
        this.fuelLevel = Math.max(0, Math.min(fuelLevel, 100));
    }

    @Override
    public FuelType getFuelType() {
        return requiredFuelType;
    }

    @Override
    public int getBatchSize() {
        return 2;
    }

    @Override
    public double getCostPerBatch() {
        return requiredFuelType == FuelType.WOOD ? 4.35 : 5.65;
    }
}
