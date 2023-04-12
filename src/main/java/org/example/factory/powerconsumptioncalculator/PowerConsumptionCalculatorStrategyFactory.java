package org.example.factory.powerconsumptioncalculator;

import org.example.strategy.powerconsumptionrate.PowerConsumptionRate;
import org.example.strategy.powerconsumptioncalculator.PowerConsumptionCalculatorStrategy;
import org.example.strategy.powerconsumptioncalculator.StandardPowerConsumptionCalculatorStrategy;
import org.example.strategy.powerconsumptionrate.StandardPowerConsumtionRate;
import org.example.strategy.turnsmoves.StandardTurnsAndMovesCalculatorStrategy;
import org.example.strategy.turnsmoves.TurnsAndMovesCalculatorStrategy;

public class PowerConsumptionCalculatorStrategyFactory {

    public static PowerConsumptionCalculatorStrategy getStandardStrategy(){
        PowerConsumptionRate standardPCR = new StandardPowerConsumtionRate();
        TurnsAndMovesCalculatorStrategy turnsMovesCalculator = new StandardTurnsAndMovesCalculatorStrategy();
        return new StandardPowerConsumptionCalculatorStrategy(standardPCR, turnsMovesCalculator);
    }
}
