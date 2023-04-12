package org.example.service;

import org.example.exceptions.InvalidInputException;
import org.example.model.Destination;
import org.example.model.GMan;

public class GManService {
    private GMan gMan;
    public GMan createGManWithSource(int x_coordinate, int y_coordinate, String direction) throws Exception {
        GMan game = GMan.builder().setCoordinate(x_coordinate, y_coordinate).setDirection(direction).build();
        this.gMan = game;
        return gMan;
    }

    public void setDestinationInGame(int x_coordinate, int y_coordinate) throws Exception {
        gMan.setDestinationCoordinate(x_coordinate, y_coordinate);
    }

    public int getRemainingPower(){
        return gMan.calculateRemainingPower();
    }
}
