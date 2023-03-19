package org.example;

public class Destination {
    private Coordinates dstCoordinates;

    public Destination(int x_cord, int y_cord) {
        this.dstCoordinates = new Coordinates(x_cord,y_cord);
    }
    public int getDstX_cord(){
        return dstCoordinates.getX_coordinates();
    }

    public int getDstY_cord(){
        return dstCoordinates.getY_coordinates();
    }
}
