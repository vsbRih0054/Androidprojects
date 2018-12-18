package com.example.jana.arenalikegame;

import java.io.Serializable;
import java.util.Random;

public class Dice implements Serializable {
    private Random random;
    private int numberOfWalls;

    Dice() {
        numberOfWalls =6;
        random = new Random();
    }

    Dice(int numberOfWalls) {
        this.numberOfWalls = numberOfWalls;
        random = new Random();
    }

    public int getNumberOfWalls() {
        return numberOfWalls;
    }

    public int throwDice() {
        return random.nextInt(numberOfWalls) + 1;
    }
}
