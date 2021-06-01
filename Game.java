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
    System.out.println(playerName + ", I'm thinking of a number from 1 to 100.");

    // Randomly pick a number from 1 - 100
    Random rand = new Random();
    int number = rand.nextInt(100);

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

  }

}
