package org.darrenchance.numberguessinggame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private List<Player> players = new ArrayList<Player>();
    private int winningScore;
    private int min;
    private int max;

    public int nextRandom(){
        int max = this.max;
        int min = this.min;
        int randomNumber;
        Random rand = new Random();

        // Getting random number between max and min inclusive
        randomNumber = rand.nextInt(max - min + 1) + 1;
        return randomNumber;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    private boolean isRunning = false;

    public int getWinningScore() {
        return winningScore;
    }

    public void setWinningScore(int winningScore) {
        this.winningScore = winningScore;
    }

    public boolean isRunning() {
        return isRunning;
    }



    private void setRunning(boolean running) {
        isRunning = running;
    }

    public Game() {
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getPlayerById(int playerId) {
        for (Player player : this.players) {
            if (player.getId() == playerId) return player;
        }
        return null;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void start() {
        this.setRunning(true);

    }

    public void stop() {
        this.setRunning(false);
    }
}
