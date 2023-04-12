package org.example.strategy.turnsmoves;

import org.example.model.GMan;

public interface TurnsAndMovesCalculatorStrategy {
    int getTurnsCount(GMan game);
    int getMovesCount(GMan game);
}
