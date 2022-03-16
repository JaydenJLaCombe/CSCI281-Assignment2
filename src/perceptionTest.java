/*
 Assignment 2 - Perception Test
 Jayden LaCombe and Lance Hoffpauer
 3/14/2022
 */

import javax.swing.*;
import java.util.Objects;
import java.util.Random;

public class perceptionTest {

    public static void main(String[] args) {

        // String Values Used Throughout The Program

        String cardGenerated = ("Your card has been generated.");
        String whatSuit = (cardGenerated + "\nWhat suit do you perceive?");
        String whatColor = (cardGenerated + "\nWhat color do you perceive?");

        String[] colorList = {"red", "blue", "green", "yellow", "black"};
        String[] suitList = {"spade", "club", "diamond", "heart", "joker"};

        // Images

        ImageIcon welcomeIcon = new ImageIcon("psi_cards/welcome.png");
        ImageIcon questionIcon = new ImageIcon("psi_cards/all-suits.png");
        ImageIcon unknownIcon = new ImageIcon("psi_cards/unknown.png");

        // Welcome Screen

        String[] welcomeOptions = {"Play","Quit"};

        int play = JOptionPane.showOptionDialog(null, "Welcome to the Perception Game!", "Perception Test",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, welcomeIcon, welcomeOptions, welcomeOptions[0]);

        if (play != 0) System.exit(0);

        int colorRight = 0;
        int suitRight = 0;
        int bothRight = 0;

        // Play 5 More Loop

        int continueOrEndGame = 1;
        int roundCounter = 0;

        String scoreboard = "";

        while (continueOrEndGame == 1) {

            // Choose Test Screen

            String chooseTestString = ("Which perception test would you like to preform?");
            String testString = ("");
            String[] testButtons = {"Suit", "Color", "Both"};

            int testChosen = JOptionPane.showOptionDialog(null, chooseTestString, "Choose Test",
                    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, questionIcon, testButtons, testButtons[0]);

            switch (testChosen) {
                case 0 -> testString = "Suit";
                case 1 -> testString = "Color";
                case 2 -> testString = "Both";
            }

            int roundNumber = 1;

            while (roundNumber <= 5) {

                // Random Image Generator

                Random randGen = new Random();
                int randomColor = randGen.nextInt(5);
                int randomSuit = randGen.nextInt(5);

                String randomColorDialog = ("The color generated was -> " + colorList[randomColor]);
                String randomSuitDialog = ("The suit generated was -> " + suitList[randomSuit]);

                String randomFileName = "psi_cards/" + colorList[randomColor] + "AND" + suitList[randomSuit] + ".png";
                ImageIcon randomIcon = new ImageIcon(randomFileName);

                //

                String winningRound = ("Congrats! You were correct!");
                String losingRound = ("Sorry, better luck next time.");

                String[] next = {"Next"};

                String testPerception;

                switch (testString) {
                    case "Suit" -> {
                        testPerception = ("The suit you perceived -> ");

                        int suitRepeatInt = JOptionPane.showOptionDialog(null, whatSuit, "Choose suit",
                                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, unknownIcon, suitList, suitList[0]);

                        testPerception += (suitList[suitRepeatInt] + "\n" + randomSuitDialog + "\n");
                        if (Objects.equals(suitList[suitRepeatInt], suitList[randomSuit])) {
                            testPerception += winningRound;
                            suitRight += 1;
                        } else {
                            testPerception += losingRound;
                        }

                        int results = JOptionPane.showOptionDialog(null, testPerception, "Results",
                                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, randomIcon, next, next[0]);

                        if (results != 0) System.exit(0);

                        roundNumber += 1;
                        roundCounter++;

                    }
                    case "Color" -> {
                        testPerception = ("The color you perceived -> ");
                        int colorRepeatInt = JOptionPane.showOptionDialog(null, whatColor, "Choose Color",
                                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, unknownIcon, colorList, colorList[0]);

                        testPerception += (colorList[colorRepeatInt] + "\n" + randomColorDialog + "\n");
                        if (Objects.equals(colorList[colorRepeatInt], colorList[randomColor])) {
                            testPerception += winningRound;
                            colorRight += 1;
                        } else {
                            testPerception += losingRound;
                        }

                        int results = JOptionPane.showOptionDialog(null, testPerception, "Results",
                                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, randomIcon, next, next[0]);

                        if (results != 0) System.exit(0);

                        roundNumber += 1;
                        roundCounter++;

                    }

                    case "Both" -> {

                        String bothColorDialog = (cardGenerated + "\nYour first choice will be what color you perceive.");
                        String bothSuitDialog = ("Please enter your second choice. \nWhich suit do you perceive?");
                        String colorResults = ("The color you perceived -> ");
                        String suitResults = ("The suit you perceived -> ");

                        int colorRepeatInt = JOptionPane.showOptionDialog(null, bothColorDialog, "Choose Color",
                                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, unknownIcon, colorList, colorList[0]);

                        String repeatString = ("Your choice of color was " + "");
                        String bothSecDialog = (repeatString + colorList[colorRepeatInt] + "\n" + bothSuitDialog);

                        int suitRepeatInt = JOptionPane.showOptionDialog(null, bothSecDialog, "Choose suit",
                                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, unknownIcon, suitList, 0);

                        String bothIfString;

                        String colorChosenUser = colorList[colorRepeatInt];
                        String colorChosenRandom = colorList[randomColor];
                        String suitChosenUser = suitList[suitRepeatInt];
                        String suitChosenRandom = suitList[randomSuit];

                        if (Objects.equals(colorChosenUser, colorChosenRandom) && (!Objects.equals(suitChosenUser, suitChosenRandom))) {

                            bothIfString = (colorResults + colorChosenUser + "\n" + randomColorDialog + "\n" + "Good perception on color!\n\n");
                            colorRight++;
                            bothIfString += (suitResults + suitChosenUser + "\n" + randomSuitDialog + "\n" + "Not quite!");

                        } else if (!Objects.equals(colorChosenUser, colorChosenRandom) && (Objects.equals(suitChosenUser, suitChosenRandom))) {

                            bothIfString = (suitResults + suitChosenUser + "\n" + randomSuitDialog + "\n" + "Good perception on suit!\n\n");
                            suitRight++;
                            bothIfString += (colorResults + colorChosenUser + "\n" + randomColorDialog + "\n" + "Not quite!\n\n");

                        } else if (Objects.equals(colorChosenUser, colorChosenRandom) && (Objects.equals(suitChosenUser, suitChosenRandom))) {

                            bothIfString = (colorResults + colorChosenUser + "\n" + randomColorDialog + "\n"  + "Good perception on color!\n\n");
                            bothIfString += (suitResults + suitChosenUser + "\n" + randomSuitDialog + "\n" + "Good perception on suit!");
                            bothRight++;

                        } else {

                            bothIfString = (suitResults + suitChosenUser + "\n" + randomSuitDialog + "\n" + "Not quite!\n\n");
                            bothIfString += (colorResults + colorChosenUser + "\n" + randomColorDialog + "\n" + "Not quite!");

                        }

                        int results = JOptionPane.showOptionDialog(null, bothIfString, "Results",
                                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, randomIcon, next, 0);

                        if (results != 0) System.exit(0);

                        roundNumber += 1;
                        roundCounter++;

                    }

                }
            }

            String colorScore = "";
            String suitScore = "";
            String bothScore = "";
            String roundCount = "Total Rounds Played -> " + roundCounter;

            if (colorRight > 0 && suitRight == 0 && bothRight == 0) {
                colorScore = "Your Total Color Score -> " + colorRight;
                scoreboard = (roundCount + "\n" + colorScore +
                        "\nWould you like to play again?");
            } else if (colorRight == 0 && suitRight > 0 && bothRight == 0) {
                suitScore = "Your Total Suit Score ->  -> " + suitRight;
                scoreboard = (roundCount + "\n" + suitScore +
                        "\nWould you like to play again?");
            } else if (colorRight == 0 && suitRight == 0 && bothRight > 0) {
                bothScore = "You Total Both Score -> " + bothRight;
                scoreboard = (roundCount + "\n" + bothScore +
                        "\nWould you like to play again?");
            } else if (colorRight > 0 && suitRight > 0 && bothRight == 0) {
                colorScore = "Your Total Color Score -> " + colorRight;
                suitScore = "Your Total Suit Score ->  -> " + suitRight;
                scoreboard = (roundCount + "\n" + colorScore + "\n" + suitScore +
                        "\nWould you like to play again?");
            } else if (colorRight > 0 && suitRight == 0 && bothRight > 0) {
                colorScore = "Your Total Color Score -> " + colorRight;
                bothScore = "You Total Both Score -> " + bothRight;
                scoreboard = (roundCount + "\n" + colorScore + "\n" + bothScore +
                        "\nWould you like to play again?");
            } else if (colorRight == 0 && suitRight > 0 && bothRight > 0) {
                suitScore = "Your Total Suit Score ->  -> " + suitRight;
                bothScore = "You Total Both Score -> " + bothRight;
                scoreboard = (roundCount + "\n" + suitScore + "\n" + bothScore +
                        "\nWould you like to play again?");
            } else if (colorRight > 0 && suitRight > 0 && bothRight > 0) {
                colorScore = "Your Total Color Score -> " + colorRight;
                suitScore = "Your Total Suit Score ->  -> " + suitRight;
                bothScore = "You Total Both Score -> " + bothRight;
                scoreboard = (roundCount + "\n" + colorScore + "\n" + suitScore + "\n" + bothScore +
                        "\nWould you like to play again?");
            } else {
                scoreboard = (roundCount + "\n" + "You scored no points" +
                        "\nWould you like to play again?");
            }

            String[] endGame = {"Quit", "Play Another 5 Rounds"};
            continueOrEndGame = JOptionPane.showOptionDialog(null, scoreboard, "Game Over",
                    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, questionIcon, endGame, 0);
        }
    }
}


