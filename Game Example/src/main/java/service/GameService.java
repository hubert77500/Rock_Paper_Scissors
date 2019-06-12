package service;

import enumeration.PlayElement;
import exception.NotFoundException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Optional;

import static constants.Constants.*;

public class GameService {

    private static GameService instance;

    private GameService(){}

    public static GameService getInstance(){
        if (instance == null){ //if there is no instance available... create new one
            instance = new GameService();
        }
        return instance;
    }

    public String showMainMenu(){
        return SHOW_MAIN_MENU;
    }

    public String showResults(String computerElection, String userElection, String winner){
        String resultVerbose = winner + WON_THE_MATCH;
        if(winner.equals(TIE))
            resultVerbose = TIE_TEXT;

        return  RESULTS_HEADER +
                YOU_CHOSE + userElection.toUpperCase()+" \n" +
                COMPUTER_CHOSE +computerElection.toUpperCase()+" \n\n" +
                resultVerbose+"\n" +
                RESULTS_FOOTER;
    }

    public int readOption(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int line = 0;
        try {
            line = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            System.out.println(CHOOSE_VALID_OPTION);
            showMainMenu();
        }
        catch (NumberFormatException nfe){
            System.out.println(ONLY_NUMBERS_1_TO_4_ALLOWED);
            showMainMenu();
        }
        return line;
    }

    public void doMenuLoopUntilExitSignal(){
            do{
                System.out.println(showMainMenu());
                int option = readOption();
                if(option == 4) {
                    break;
                }
                System.out.println(simulateGamePlay(option));
            }while(true);
            System.out.println(THANK_YOU_MESSAGE);
    }

    public String simulateGamePlay(int userOption){

        // VALIDATE THAT THE OPTION IS ONLY FROM THE POSSIBLE TO CHOSE
        if(userOption != 0 && userOption <= OPTIONS_LIMIT) {
            //TAKE THE USER SELECTION AND COMPUTER SELECTION
            Optional<PlayElement> humanPlayedElement = getHumanPlayElement(userOption);
            Optional<PlayElement> systemPlayedElement = getRandomComputerPlayElement();
            try {
                PlayElement humanPlayedElementPerformed = humanPlayedElement.orElseThrow(NotFoundException::new);
                PlayElement computerPlayedElementPerformed = systemPlayedElement.orElseThrow(NotFoundException::new);
                //CALCULATE WHO WINS OR IF IT IS A TIE
                String resultOfMatch = calculateWinOrTie(humanPlayedElementPerformed, computerPlayedElementPerformed);
                return showResults(computerPlayedElementPerformed.toString(),
                        humanPlayedElementPerformed.toString(), resultOfMatch);
            } catch (NotFoundException e) {
                System.out.println(SELECTED_ELEMENT_NOT_FOUND);
                showMainMenu();
            }
            return ERROR_CALCULATING_WINNER;
        }
        else{
            return INVALID_OPTION_TRY_AGAIN;
        }

    }

    public Optional<PlayElement> getHumanPlayElement(int optionChosenUI){
        return PlayElement.valueOf(optionChosenUI-1);
    }

    public Optional<PlayElement> getRandomComputerPlayElement(){
        int randomOptionPlayed = 0;
        try {
            SecureRandom secureRandomGenerator = SecureRandom.getInstance(SECURE_ALGO, ALGO_PROVIDER);
            randomOptionPlayed = secureRandomGenerator.nextInt(OPTIONS_LIMIT);
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            System.out.println(RANDOMNESS_NOT_POSSIBLE);
        }
        return PlayElement.valueOf(randomOptionPlayed);
    }

    public String calculateWinOrTie(PlayElement humanElement, PlayElement computerElement){
        //CALCULATING THE TIE CASE FIRST AND THE OTHER PERMUTATIONS
        if(humanElement.equals(computerElement))
            return TIE;

        //CALCULATING OTHER  AGAINST ENUM
        switch (humanElement) {
            case ROCK:
                return (computerElement.equals(PlayElement.SCISSORS) ? HUMAN : COMPUTER);
            case PAPER:
                return (computerElement.equals(PlayElement.ROCK) ? HUMAN : COMPUTER);
            case SCISSORS:
                return (computerElement.equals(PlayElement.PAPER) ? HUMAN : COMPUTER);
        }
        return ERROR_CALCULATING_RESULT;
    }
}
