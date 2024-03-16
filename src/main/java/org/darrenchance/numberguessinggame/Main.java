package org.darrenchance.numberguessinggame;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Game started");
        Player player1 = new Player(1, "Darren", 0);
        Player player2 = new Player(2, "Kiara", 0);

        Random rand = new Random();

        //int randInt1 = rand.nextInt(10+1) + 1;

        System.out.println("Player " + player1.getId() + " " + player1.getName() + " Has entered the game.");
        System.out.println("Player " + player2.getId() + " " + player2.getName() + " Has entered the game.");

        int max = 3;
        int min = 1;
        Scanner sc = new Scanner(System.in);
        int currentPlayer = 1;
        String input = "";
        while (!input.equalsIgnoreCase("-1")) {
           if(currentPlayer == 1){
               System.out.println("It is " + player1.getName()+"'s turn.");
           }else {
               System.out.println("It is " + player2.getName()+"'s turn.");
           }


            int randInt = rand.nextInt(max - min + 1) + 1;
            System.out.println("Pick a number");
            input = sc.nextLine();
            if (randInt == Integer.valueOf(input)) {
                System.out.println("You picked the correct number: " + input + ", the answer was: " + randInt);
                break;
            } else {
                System.out.println("You picked wrong number: "+input+", the correct number was "+ randInt);
            }

            if (currentPlayer == 1){
                currentPlayer = 2;
            }else {
                currentPlayer = 1;
            }

        }


        System.out.println("Thanks for playing!");

    }
}
