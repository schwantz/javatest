package com.worldline.interview;

import org.junit.Test;
import static org.junit.Assert.*;

public class WidgetMachineTest {

    @Test
    public void testInternalCombustionEngineWithPetrol() {
        InternalCombustionEngine engine = new InternalCombustionEngine(FuelType.PETROL);
        engine.fill(FuelType.PETROL, 50);
        WidgetMachine machine = new WidgetMachine(engine);
        double cost = machine.produceWidgets(10);
        assertEquals(18.0, cost, 0.001);
    }

    @Test
    public void testSteamEngineWithWood() {
        SteamEngine engine = new SteamEngine(FuelType.WOOD);
        engine.fill(FuelType.WOOD, 50);
        WidgetMachine machine = new WidgetMachine(engine);
        double cost = machine.produceWidgets(5);
        assertEquals(13.05, cost, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSteamEngineInvalidFuel() {
        SteamEngine engine = new SteamEngine(FuelType.WOOD);
        engine.fill(FuelType.DIESEL, 10);
    }
}
