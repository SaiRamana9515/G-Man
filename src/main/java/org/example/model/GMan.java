package org.example.model;


import org.example.exceptions.InvalidInputException;
import org.example.factory.powerconsumptioncalculator.PowerConsumptionCalculatorStrategyFactory;
import org.example.strategy.powerconsumptioncalculator.PowerConsumptionCalculatorStrategy;

public class GMan {

    private Coordinate sourceCoordinate;
    private final Direction sourceDirection;
    private Coordinate destinationCoordinate;
    private int power;

    private GMan(GManBuilder builder) {
        this.sourceCoordinate = builder.sourceCoordinate;
        this.sourceDirection = builder.sourceDirection;
        this.power = 200;
    }

    public Coordinate getSourceCoordinate() {
        return sourceCoordinate;
    }

    public Coordinate getDestinationCoordinate() {
        return destinationCoordinate;
    }

    public int getPower() {
        return power;
    }

    public Direction getSourceDirection() {
        return sourceDirection;
    }

    public void setSourceCoordinate(Coordinate sourceCoordinate) {
        this.sourceCoordinate = sourceCoordinate;
    }

    public void setDestinationCoordinate(int x_coordinate, int y_coordinate) throws Exception {
        this.destinationCoordinate = Coordinate.builder().setX_coordinate(x_coordinate).setY_coordinate(y_coordinate).build();
    }

    public int calculateRemainingPower(){
        if(this.sourceCoordinate == null || this.destinationCoordinate == null || this.sourceDirection == null){
            throw new InvalidInputException("Incomplete inputs, one or more of source coordinate, " +
                    "destination coordinate and source direction are missing");
        }
        PowerConsumptionCalculatorStrategy powerConsumptionCalculator = PowerConsumptionCalculatorStrategyFactory.getStandardStrategy();
        return (this.power - powerConsumptionCalculator.calculatePowerConsumed(this));
    }

    public static GManBuilder builder(){
        return new GManBuilder();
    }
    public static class GManBuilder{
        private Coordinate sourceCoordinate;
        private Coordinate destinationCoordinate;
        private int power;
        private Direction sourceDirection;

        public GManBuilder setCoordinate(int x_coordinate, int y_coordinate) throws Exception {
          this.sourceCoordinate = Coordinate.builder().setX_coordinate(x_coordinate).setY_coordinate(y_coordinate).build();
          return this;
        }
        public GManBuilder setDirection(String direction){
            this.sourceDirection = Direction.valueOf(direction);
            return this;
        }

        public GMan build(){
            return new GMan(this);
        }
    }
}
