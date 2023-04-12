package org.example.strategy.turnsmoves;

import org.example.model.Direction;
import org.example.model.GMan;


public class StandardTurnsAndMovesCalculatorStrategy implements TurnsAndMovesCalculatorStrategy{

    @Override
    public int getTurnsCount(GMan game) {
        int pointA = game.getSourceDirection().numericValue;
        int pointB = getDestinationDirection1(game).numericValue;
        int pointC = getDestinationDirection2(game).numericValue;
        int path_1_Value = numberOfTurnsCalculator(pointA,pointB,pointC);
        int path_2_Value = numberOfTurnsCalculator(pointA,pointC,pointB);

        return Math.min(path_1_Value,path_2_Value);
    }

    @Override
    public int getMovesCount(GMan game) {
        int source_x_coordinate = game.getSourceCoordinate().getX_coordinate();
        int source_y_coordinate = game.getSourceCoordinate().getY_coordinate();
        int destination_x_coordinate = game.getDestinationCoordinate().getX_coordinate();
        int destination_y_coordinate = game.getDestinationCoordinate().getY_coordinate();
        int numOfHorizontalMoves = Math.abs(source_x_coordinate-destination_x_coordinate);
        int numOfVerticalMoves = Math.abs(source_y_coordinate-destination_y_coordinate);
        return numOfHorizontalMoves+numOfVerticalMoves;
    }

    private Direction getDestinationDirection1(GMan game){
        if(game.getSourceCoordinate().getX_coordinate() < game.getDestinationCoordinate().getX_coordinate()){
            return Direction.E;
        }else if(game.getSourceCoordinate().getX_coordinate() > game.getDestinationCoordinate().getX_coordinate()){
            return Direction.W;
        }
        return Direction.EMPTY;
    }

    private Direction getDestinationDirection2(GMan game){
        if(game.getSourceCoordinate().getY_coordinate() < game.getDestinationCoordinate().getY_coordinate()){
            return Direction.N;
        }else if(game.getSourceCoordinate().getY_coordinate() > game.getDestinationCoordinate().getY_coordinate()){
            return Direction.S;
        }
        return Direction.EMPTY;
    }

    private int numberOfTurnsCalculator(int initialDirection, int middleDirection, int finalDirection){

        int numOfTurns1 = 0;
        int numOfTurns2 = 0;
        if(middleDirection == 0 && finalDirection == 0){
            return 0;
        }else if(middleDirection == 0 || finalDirection == 0){
            int direction = Math.max(middleDirection,finalDirection);
            return Math.min(Math.abs(initialDirection-direction), 4-Math.abs(initialDirection-direction));
        }else{
            numOfTurns1 = Math.min(Math.abs(initialDirection-middleDirection), 4-Math.abs(initialDirection-middleDirection));
            numOfTurns2 = Math.min(Math.abs(middleDirection-finalDirection), 4-Math.abs(middleDirection-finalDirection));
        }
        return numOfTurns1+numOfTurns2;
    }
}
