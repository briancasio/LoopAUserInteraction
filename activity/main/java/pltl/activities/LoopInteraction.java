package pltl.activities;

import java.util.*;

/**
 * Loop Interaction
 *
 */
public class LoopInteraction{
    public static void main( String[] args ){
        Random rand = new Random();
        Scanner input = new Scanner(System.in);

        int randomNumber = rand.nextInt(10) + 1;
        System.out.println("Guess a number from 1 to 10");
        
        int playerNumber = input.nextInt();

        if(playerNumber == randomNumber){
            System.out.println("Correct!");
        }
        else if (playerNumber < randomNumber) {
            System.out.println("Number too low!");
        }
        else {
            System.out.println("Number too high!");
        }

        input.close();
    }

}
