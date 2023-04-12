package org.example.strategy.powerconsumptionrate;

public abstract class PowerConsumptionRate {
    protected final int moveRate;
    protected final int turnRate;

    public PowerConsumptionRate(int moveRate, int turnRate) {
        this.moveRate = moveRate;
        this.turnRate = turnRate;
    }

    public int getMoveRate() {
        return moveRate;
    }

    public int getTurnRate() {
        return turnRate;
    }
}
