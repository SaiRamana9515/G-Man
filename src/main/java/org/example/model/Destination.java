package org.example.model;


public class Destination {
    private final Coordinate dstCoordinates;

    public Destination(Coordinate c) {
        this.dstCoordinates = c;
    }

    public static Destination createDestinationObject(int x_cord, int y_cord) throws Exception {
        Coordinate c = Coordinate.builder().setX_coordinate(x_cord).setY_coordinate(y_cord).build();
        Destination d = new Destination(c);
        return d;
    }
}
