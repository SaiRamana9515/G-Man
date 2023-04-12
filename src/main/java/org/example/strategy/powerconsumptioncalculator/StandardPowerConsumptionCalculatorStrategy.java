package org.example.strategy.powerconsumptioncalculator;

import org.example.model.GMan;
import org.example.strategy.powerconsumptionrate.PowerConsumptionRate;
import org.example.strategy.turnsmoves.TurnsAndMovesCalculatorStrategy;

public class StandardPowerConsumptionCalculatorStrategy implements PowerConsumptionCalculatorStrategy{

    private PowerConsumptionRate pcrStrategy;
    private TurnsAndMovesCalculatorStrategy tamcStrategy;
    public StandardPowerConsumptionCalculatorStrategy(PowerConsumptionRate pcrStrategy, TurnsAndMovesCalculatorStrategy tamcStrategy){
        this.pcrStrategy = pcrStrategy;
        this.tamcStrategy = tamcStrategy;
    }
    @Override
    public int calculatePowerConsumed(GMan game) {
        int numOfTurns = tamcStrategy.getTurnsCount(game);
        int numOfMoves = tamcStrategy.getMovesCount(game);

        int powerConsumedForTurns = numOfTurns*(pcrStrategy.getTurnRate());
        int powerConsumedForMoves = numOfMoves*(pcrStrategy.getMoveRate());

        int totalPowerConsumed = powerConsumedForMoves+powerConsumedForTurns;
        return totalPowerConsumed;
    }
}
