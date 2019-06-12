package constants;

/**
 * This are the Global Constants, the idea is to do Standardization of values and be able to use them across
 * the development. Be sure that variables and values can be re-usable everywhere in the application.
 * Created by: HUBERT ALFARO on April 28th 2019
 */
public interface Constants {

    //GENERAL
    String TIE_TEXT = "NOBODY WON! IT IS A TIE!";
    String TIE = "TIE";
    String HUMAN = "YOU";
    String COMPUTER = "COMPUTER";
    int OPTIONS_LIMIT = 3;
    String SECURE_ALGO = "SHA1PRNG";
    String ALGO_PROVIDER = "SUN";

    //USER INTERFACE
    String SHOW_MAIN_MENU =
            "==================================== \n" +
            "PLAY ROCK, PAPER, SCISSORS \n" +
            "=================================== \n\n" +
            "1. CHOOSE ROCK \n" +
            "2. CHOOSE PAPER \n" +
            "3. CHOOSE SCISSORS \n" +
            "4. EXIT GAME \n\n" +
            "=================================== \n" +
            "WRITE AN OPTION(1-4) AND DO ENTER: ";
    String RESULTS_HEADER = "\n"+
            "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n" +
            "MATCH RESULTS!!!! \n" +
            "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n\n";
    String YOU_CHOSE = "YOU CHOSE: ";
    String COMPUTER_CHOSE = "COMPUTER CHOSE: ";
    String RESULTS_FOOTER = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n\n";

    //ERROR MESSAGES
    String CHOOSE_VALID_OPTION = "Choose a valid option, please try again! if the problem persists, please contact support!";
    String ONLY_NUMBERS_1_TO_4_ALLOWED = "ONLY NUMBERS FROM 1 TO 4 ARE ALLOWED!";
    String THANK_YOU_MESSAGE = "Thank you for playing, see you soon!";
    String WON_THE_MATCH = " WON THE MATCH!!";
    String SELECTED_ELEMENT_NOT_FOUND = "Internal server error, selected element to play not found, contact support!";
    String ERROR_CALCULATING_WINNER = "Error Calculating the winner, please contact support!";
    String INVALID_OPTION_TRY_AGAIN = "INVALID OPTION CHOSEN, TRY AGAIN PLEASE:";
    String RANDOMNESS_NOT_POSSIBLE = "Can't assure you randomness, contact support!";
    String ERROR_CALCULATING_RESULT = "Error calculating the result, please try again. If happens again, contact support!";
}
