package com.example.jana.arenalikegame;

import java.util.Random;

public class Dice {
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
