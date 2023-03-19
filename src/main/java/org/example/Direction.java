package org.example;

import java.util.HashMap;

public class Direction {
    private String direction;

    public Direction(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }

    private final HashMap<String,Integer> directionValueMap = setDirectionValue();


    public int getDirectionValue(String d){

        return directionValueMap.get(d);
    }

    private HashMap<String,Integer> setDirectionValue(){

        HashMap<String,Integer> valueMap = new HashMap<>();

        valueMap.put("N",1);
        valueMap.put("E",2);
        valueMap.put("S",3);
        valueMap.put("W",4);

        return valueMap;
    }

}
