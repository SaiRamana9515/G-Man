package org.example;

public class GMan {

    private Coordinates initialCord;
    private Direction initialDirection;
    private Power power;

    public GMan(int x_cord, int y_cord, String direction) {
        this.initialCord = new Coordinates(x_cord,y_cord);
        this.initialDirection = new Direction(direction);
        this.power = new Power();
    }


}
