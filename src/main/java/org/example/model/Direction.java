package org.example.model;

public enum Direction {
    N(1),E(2),S(3),W(4), EMPTY(0);
    public int numericValue;

    Direction(int value) {
        this.numericValue = value;
    }
}
