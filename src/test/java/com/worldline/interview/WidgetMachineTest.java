package com.worldline.interview;

import org.junit.Test;
import static org.junit.Assert.*;

public class WidgetMachineTest {

    @Test
    public void testSteamEngineWithWood() {
        SteamEngine engine = new SteamEngine(FuelType.WOOD);
        engine.fill(FuelType.WOOD, 50);
        WidgetMachine machine = new WidgetMachine(engine);
        double cost = machine.produceWidgets(5);
        assertEquals(13.05, cost, 0.001);//4.35*3
    }

    @Test
    public void testInternalCombustionEngineWithDiesel() {
        Engine engine = new InternalCombustionEngine(FuelType.DIESEL);
        engine.fill(FuelType.DIESEL, 50);
        WidgetMachine machine = new WidgetMachine(engine);
        double cost = machine.produceWidgets(10);
        assertEquals(24.0, cost, 0.001); // 10 widgets => 2 batches * 12.0
    }
}
