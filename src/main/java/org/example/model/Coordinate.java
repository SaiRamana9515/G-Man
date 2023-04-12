package org.example.model;

import org.example.exceptions.InvalidInputException;

public class Coordinate {
    private int x_coordinate;
    private int y_coordinate;

    private Coordinate(CoordinateBuilder cb) {
        x_coordinate = cb.getX_coordinate();
        y_coordinate = cb.getY_coordinate();
    }

    public static CoordinateBuilder builder(){
        return new CoordinateBuilder();
    }

    public static class CoordinateBuilder{
        private int x_coordinate;
        private int y_coordinate;

        public CoordinateBuilder setX_coordinate(int x_coordinate) {
            if(x_coordinate<0 || x_coordinate>6){
                throw new InvalidInputException("Invalid x-coordinate is given");
            }
            this.x_coordinate = x_coordinate;
            return this;
        }

        public CoordinateBuilder setY_coordinate(int y_coordinate) {
            if(y_coordinate<0 || y_coordinate>6){
                throw new InvalidInputException("Invalid y-coordinate is given");
            }
            this.y_coordinate = y_coordinate;
            return this;
        }

        public int getX_coordinate() {
            return x_coordinate;
        }

        public int getY_coordinate() {
            return y_coordinate;
        }

        public Coordinate build(){
            return new Coordinate(this);
        }
    }

    public void setX_coordinate(int x_coordinate) {
        if(x_coordinate<0 || x_coordinate>6){
            throw new InvalidInputException("Invalid x-coordinate is given");
        }
        this.x_coordinate = x_coordinate;
    }

    public void setY_coordinate(int y_coordinate) {
        if(y_coordinate<0 || y_coordinate>6){
            throw new InvalidInputException("Invalid y-coordinate is given");
        }
        this.y_coordinate = y_coordinate;
    }

    public int getX_coordinate() {
        return x_coordinate;
    }

    public int getY_coordinate() {
        return y_coordinate;
    }
}
