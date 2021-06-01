/*

A number-guessing game.

*/

import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;


public class Game {
  public static void main(String[] args){

    Scanner input = new Scanner(System.in);
    
    // Greet player
    System.out.println("Howdy, what's your name?");
    String playerName = input.nextLine();
    int gameNumber = 0;
    int bestTries = 1000000;
    Boolean keepPlaying = true;

    while (keepPlaying == true) {
      gameNumber++;
      System.out.println("Hi, " + playerName + ", I'm thinking of a number from 1 to 100.");

      // Randomly pick a number from 1 - 100
      Random rand = new Random();
      int number = rand.nextInt(100);
      // System.out.println("****" + number + "****");

      // User guesses number, store # of tries, break loop when it's guessed
      System.out.println("Try to guess my number!");
      int tries = 0;

      while (true) {
        int guess;
        System.out.print("> ");
        tries++;

        try {
          guess = input.nextInt();
        } catch(InputMismatchException e) {
          String bad_input = input.next();
          System.out.println("Bad type, wolf, try again.");
          continue;
        }

        if (guess > 100 || guess < 1) {
          System.out.println("Bad guess, wolf, try again.");
        } else if (guess > number) {
          System.out.println("Your guess is too high, try again.");
        } else if (guess < number) {
          System.out.println("Your guess is too low, try again.");
        } else {
          break;
        }
      }

      System.out.println("Well done, " + playerName + "! You found my number in " + tries + " tries.");

      if (tries < bestTries) {
        System.out.println("Wow, you beat your best number of tries! Achievement unlocked!");
        bestTries = tries;
      } else {
        System.out.println("Your best number of tries is still " + bestTries + ".");
      }
    
      System.out.println("Do you want to play again?");
      System.out.print("> ");
      String answer = input.next();
      if (answer.toLowerCase().equals("no")) {
        keepPlaying = false;
      } 

    }

    System.out.println("Great game, " + playerName + "! You played my guessing game " + gameNumber + " times and your best number of tries was " + bestTries + ". See you next time!");

  }

}
