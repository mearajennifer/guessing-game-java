/*

A number-guessing game.

*/

import java.util.Scanner;
// import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.InputMismatchException;


public class Game {
  public static void main(String[] args){
    
    // Greet player & initialize variables
    Scanner input = new Scanner(System.in);
    System.out.println("\n***** BRIGHTICORN'S GUESSING GAME *****");
    System.out.println("Howdy, what's your name?");
    String playerName = input.nextLine();
    int gameNumber = 0;
    int bestTries = 10;
    int maxAttempts = 10;
    Boolean keepPlaying = true;

    // Individual game loop
    while (keepPlaying == true) {
      gameNumber++;
      System.out.println("\nHi, " + playerName + "icorn, would you like to set the range of numbers with a start number and end number?");
      int min;
      int max;

      // receive min and max for range
      while (true) {
        System.out.print("y/n: ");
        String setRange;

        try {
          setRange = input.next();
          if (setRange.toLowerCase().equals("y")) {
            System.out.println("What is the start number?");
            System.out.print("> ");
            min = input.nextInt();
  
            System.out.println("What is the end number?");
            System.out.print("> ");
            max = input.nextInt();
            break;
  
          } else if (setRange.toLowerCase().equals("n")) {
            min = 1;
            max = 100;
            break;
  
          } else {
            System.out.println("Please answer with 'y' or 'n' only!");
          }

        } catch(InputMismatchException ex) {
          String b_input = input.next();
          System.out.println("Please answer with 'y' or 'n' only!");
          continue;
        }
      }

      // Randomly pick a number between min and max
      // Random rand = new Random();
      // int number = rand.nextInt(100);
      int number = ThreadLocalRandom.current().nextInt(min, max + 1);
      System.out.println("****" + number + "****");

      // User guesses number, store # of tries, break loop when it's guessed
      System.out.println("Try to guess my number!");
      int tries = 0;

      while (true) {
        int guess;
        System.out.print("> ");
        tries++;
        if (tries > maxAttempts) {
          System.out.println("> > > Too many tries!");
          break;
        }

        try {
          guess = input.nextInt();
        } catch(InputMismatchException e) {
          String bad_input = input.next();
          System.out.println(playerName + "icorn, that's not an integer, try again.");
          continue;
        }

        if (guess > max || guess < min) {
          System.out.println(playerName + "icorn, that integer is out of range, try again.");
        } else if (guess > number) {
          System.out.println("Your guess is too high, try again.");
        } else if (guess < number) {
          System.out.println("Your guess is too low, try again.");
        } else if (guess == number) {
          break;
        }
      }

      if (tries > 10) {
        System.out.println("Sorry, " + playerName + "icorn, you couldn't find the number in 10 guesses or less.");
      } else {
        System.out.println("Well done, " + playerName + "icorn! You found my number in " + tries + " tries.");
      }

      if (tries < bestTries) {
        System.out.println("Wow, you beat your best number of tries! Achievement unlocked!");
        bestTries = tries;
      } else {
        System.out.println("Your best number of tries is still " + bestTries + ".");
      }
    
      System.out.println("Do you want to play again?");

      while (true) {
        System.out.print("y/n: ");
        String answer = input.next();
        if (answer.toLowerCase().equals("n")) {
          keepPlaying = false;
          break;
        } else if (answer.toLowerCase().equals("y")) {
          keepPlaying = true;
          break;
        } else {
          System.out.println("Please answer with 'y' or 'n' only!");
          continue;
        }
      }
    }

    System.out.println("Great game, " + playerName + "icorn! You played my guessing game " + gameNumber + " times and your best number of tries was " + bestTries + ". See you next time!");

  }

}
