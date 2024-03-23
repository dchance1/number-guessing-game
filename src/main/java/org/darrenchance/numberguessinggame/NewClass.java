package org.darrenchance.numberguessinggame;

import java.util.Scanner;

public class NewClass {
    public static boolean isNumber(String numString) {
        try {
            Integer.parseInt(numString);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static void main(String[] args) {

        Player player1 = new Player(1, "Darren", 0);
        Player player2 = new Player(2, "Kiara", 0);

        // create a game and add players
        Game gm = new Game();
        gm.addPlayer(player1);
        gm.addPlayer(player2);
        gm.setWinningScore(3);

        // configuring game
        gm.setMin(1);
        gm.setMax(2);
        gm.setWinningScore(2);
        gm.start();

        // Game intro
        System.out.println("Welcome to the number guessing game...");
        System.out.println("The first person to score " + gm.getWinningScore() + " wins.");
        System.out.println("Rules:");
        System.out.println("- Each correct guess earns 1 point\n" +
                "- Each player will have 1 guess per turn\n" +
                "- Players will switch turns after the other guesses\n");

        Scanner sc = new Scanner(System.in);
        String input = "";
        int randomInt;
        while (gm.isRunning()) {

            // Only run if user input is not 'q'[quit]
            if (input.equalsIgnoreCase("q")) {
                gm.stop();
            } else {
                randomInt = gm.nextRandom();

                // iterate through list of players and ask for random number
                for (Player player : gm.getPlayers()) {
                    // Request user input,
                    System.out.println(player.getName() + " pick a random number ['q' quit]");
                    input = sc.nextLine();

                    // Stops game and breaks out of for loop.
                    if (input.equalsIgnoreCase("q")) {
                        gm.stop();
                        break;
                    }

                    // Checking if the user entered a valid number
                    if (isNumber(input)) {

                        // Checking for the correct guess
                        if (Integer.parseInt(input) == randomInt) {
                            System.out.println(player.getName() + " guessed correctly, the random number was " + randomInt);
                            player.setPoints(player.getPoints() + 1);
                        } else {
                            System.out.println(player.getName() + " guessed incorrectly, the random number was " + randomInt);
                        }
                    }

                    // Asks for input until user enters valid input
                    while (!isNumber(input)) {
                        System.out.println("Invalid input [" + input + "] is not a number");
                        System.out.println(player.getName() + " try again: pick a random number");
                        input = sc.nextLine();

                        // Checking for the correct guess
                        if (Integer.parseInt(input) == randomInt) {
                            System.out.println(player.getName() + " guessed correctly, the random number was " + randomInt);
                            player.setPoints(player.getPoints() + 1);
                        } else {
                            System.out.println(player.getName() + " guessed incorrectly, the random number was " + randomInt);
                            player.setPoints(player.getPoints() + 1);
                        }


                    }

                    // Stopping game when the current player reaches the winning score
                    if (player.getPoints() == gm.getWinningScore()){
                        gm.stop();
                        break;
                    }
                }
            }

        }

        // End
        // printing results
        System.out.println("------------------------------------------------------");
        System.out.println("Final Score");
        System.out.println("------------------------------------------------------");
        Player winningPlayer = null;
        int highScore = 0;

        for (Player player : gm.getPlayers()) {
            if (player.getPoints() > highScore){
                winningPlayer = player;
                highScore = player.getPoints();
            }
            System.out.println(player.getName() + ": " + player.getPoints() + " points");
        }
        System.out.println("------------------------------------------------------");
        System.out.println(winningPlayer.getName() + " Won with " + winningPlayer.getPoints() + " points!");
        System.out.println("Thank you for playing!");
    }
}
