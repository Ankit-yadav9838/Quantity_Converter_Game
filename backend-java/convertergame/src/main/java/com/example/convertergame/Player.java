package com.example.convertergame;

public class Player {
    private int score = 0;

    public int getScore() {
        return score;
    }

    public void addPoints(int points) {
        score += points;
    }
}
