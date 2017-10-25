import java.util.Random;
import java.util.Scanner;

public class DiceGame {
    private static int playerScore;                 //field to hold player score
    private static int npcScore;                    //field to hold the computers score
    private static int draw;                        //field to hold the number of times there was a draw
    private static boolean keepRunning;             //bool to keep running the program
    private static Scanner keyboard =               //scanner to take in input
            new Scanner(System.in);


    public static void main(String[] args) {
        do{
            System.out.println("Welcome to the Dice Game!");        //greeting
            RunGame();                                              //run the game
            PrintResults();                                         //print the results
            DetermineWinner(playerScore, npcScore);                 //determine over all winner
            KeepRunning();                                          //check to keep running
            ResetScore();                                           //reset the score
        } while(keepRunning);

    }

    /**
     * Void method - runs the game
     */
    private static void RunGame(){
        for(int i = 0; i < 10; i++){

            int playerNumber = GenerateRandom();            //generating random dice rolls
            int npcNumber = GenerateRandom();

            if(playerNumber > npcNumber){                   //incrementing scores based on random outcome
                playerScore++;
            }
            else if (npcNumber > playerNumber){
                npcScore++;
            }
            else if(npcNumber == playerNumber)
            {
                draw++;
            }
        }
    }

    /**
     * Void method to determine the winner and print a msg
     * @param player The players score
     * @param computer  The computers score
     */
    private static void DetermineWinner(int player, int computer){
        if(player > computer){
            System.out.println("Congrats, the player has won!");
        }
        else if(computer > player){
            System.out.println("Too bad soo sad, you lost to a computer...");
        }
        else{
            System.out.println("Uhh.. Looks like you tied...");
        }
    }

    /**
     * This method prints the base score achieved by the player and the computer
     */
    private static void PrintResults(){
        System.out.println("The player won " + playerScore + " times.");
        System.out.println("The computer won " + npcScore + " times.");
        System.out.println("You tied " + draw + " times.");
    }

    /**
     * This method is responsible for generating all the random numbers
     * @return Returns the generated random number
     */
    private static int GenerateRandom(){
        Random r = new Random();
        return r.nextInt(6) + 1;
    }

    /**
     * Void method for checking if we want to keep running the program
     */
    private static void KeepRunning()
    {
        System.out.println("Do you want to try again? \n(Y/N)");
        String response = keyboard.next();
        if(response.equalsIgnoreCase("y"))
            keepRunning = true;
        else if(response.equalsIgnoreCase("n")){
            keepRunning = false;
            System.out.println("Shutting down...");
        }

    }

    /**
     * Void method to simply reset the score.
     */
    private static void ResetScore() {
        playerScore = 0;
        npcScore = 0;
        draw = 0;
    }
}
