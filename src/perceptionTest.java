/*
 Assignment 2 - Perception Test
 Jayden LaCombe and Lance Hoffpauer
 3/14/2022
 */

import javax.swing.*;
import java.util.*;

public class perceptionTest {

    public static void main(String[] args) {

        // Local String Values

        String stringTitle = "Jayden LaCombe and Lance Hoffpauer                                             Perception Test";
        String cardGenerated = ("Your card has been generated.");
        String shapeQuestion = (cardGenerated + "\nWhat shape do you perceive?");
        String colorQuestion = (cardGenerated + "\nWhat color do you perceive?");

        String bothColorDialog = (cardGenerated + "\nYour first choice will be what color you perceive.");
        String bothShapeDialog = ("Please enter your second choice. \nWhich shape do you perceive?");

        String winningRound = ("Congrats! You were correct!");
        String losingRound = ("Sorry, better luck next time.");

        String[] colors = {"red", "blue", "green", "yellow", "black"};
        String[] shapes = {"square", "circle", "star", "wavy", "plus"};

        String[] next = {"Next"};

        // Images

        ImageIcon welcomeIcon = new ImageIcon("psi_cards/welcome.png");
        ImageIcon questionIcon = new ImageIcon("psi_cards/question.png");
        ImageIcon unknownIcon = new ImageIcon("psi_cards/unknown.png");

        // Welcome Screen

        String welcomeMessage = ("Welcome to the Perception Game!");
        String[] welcomeButtons = {"Play", "Quit"};

        int play = JOptionPane.showOptionDialog(null, welcomeMessage, stringTitle,
                0, 0, welcomeIcon, welcomeButtons, welcomeButtons[0]);

        System.out.println(play);

        if (play == 0) {

            int rightAnswers = 0;
            int wrongAnswers = 0;

            int roundNumber = 0;

            String[] endGame = {"Quit", "Play Another 5 Rounds"};
            int endGameInt = 1;

            while (Objects.equals(endGame[endGameInt], endGame[1])) {

                // Choose Test Screen

                String chooseTestString = ("Which perception test would you like to preform?");
                String testString = ("");
                String[] testButtons = {"Shape", "Color", "Both"};

                int testType = JOptionPane.showOptionDialog(null, chooseTestString, stringTitle,
                        0, 0, questionIcon, testButtons, testButtons[0]);

                switch (testType) {
                    case 0 -> testString = "Shape";
                    case 1 -> testString = "Color";
                    case 2 -> testString = "Both";
                }

                int placeholder = 0;



                    // Random Image Generator

                    Random randGen = new Random();
                    int color = randGen.nextInt(5);
                    int shape = randGen.nextInt(5);

                    String randomColor = ("The color generated was -> " + colors[color]);
                    String randomShape = ("The shape generated was -> " + shapes[shape]);

                    String randomFileName = "psi_cards/" + colors[color] + "AND" + shapes[shape] + ".png";
                    ImageIcon randomIcon = new ImageIcon(randomFileName);

                    switch (testString) {
                        case "Shape" -> {
                            String shapeResults = ("The shape you perceived -> ");
                            int shapeRepeatInt = JOptionPane.showOptionDialog(null, shapeQuestion, stringTitle,
                                    0, 0, unknownIcon, shapes, shapes[0]);

                            shapeResults += (shapes[shapeRepeatInt] + "\n" + randomShape + "\n");
                            if (Objects.equals(shapes[shapeRepeatInt], shapes[shape])) {
                                shapeResults += winningRound;
                                rightAnswers += 1;
                            } else {
                                shapeResults += losingRound;
                                wrongAnswers += 1;
                            }

                            JOptionPane.showOptionDialog(null, shapeResults, stringTitle,
                                    0, 0, randomIcon, next, next[0]);

                        }
                        case "Color" -> {
                            String colorResults = ("The color you perceived -> ");
                            int colorRepeatInt = JOptionPane.showOptionDialog(null, colorQuestion, stringTitle,
                                    0, 0, unknownIcon, colors, colors[0]);

                            colorResults += (colors[colorRepeatInt] + "\n" + randomColor + "\n");
                            if (Objects.equals(colors[colorRepeatInt], colors[color])) {
                                colorResults += winningRound;
                                rightAnswers += 1;
                            } else {
                                colorResults += losingRound;
                            }

                            JOptionPane.showOptionDialog(null, colorResults, stringTitle,
                                    0, 0, randomIcon, next, next[0]);

                        }

                        case "Both" -> {

                            color = randGen.nextInt(5);
                            shape = randGen.nextInt(5);

                            randomColor = ("The color generated was -> " + colors[color]);
                            randomShape = ("The shape generated was -> " + shapes[shape]);
                            randomFileName = "psi_cards/" + colors[color] + "AND" + shapes[shape] + ".png";
                            randomIcon = new ImageIcon(randomFileName);

                            String colorResults = ("The color you perceived -> ");
                            String shapeResults = ("The shape you perceived -> ");


                            int colorRepeatInt = JOptionPane.showOptionDialog(null, bothColorDialog, stringTitle,
                                    0, 0, unknownIcon, colors, colors[0]);

                            String repeatString = ("Your choice of color was " + "");
                            String bothSecDialog = (repeatString + colors[colorRepeatInt] + "\n" + bothShapeDialog);

                            int shapeRepeatInt = JOptionPane.showOptionDialog(null, bothSecDialog, stringTitle,
                                    0, 0, unknownIcon, shapes, shapes[0]);

                            String bothIfString = "";

                            if (Objects.equals(colors[colorRepeatInt], colors[color]) & !Objects.equals(shapes[shapeRepeatInt], shapes[shape])) {

                                bothIfString = (colorResults + colors[colorRepeatInt] + "\n" + randomColor + "\n" +
                                        winningRound + "\n" + "Good perception on color!");
                                rightAnswers += 1;
                                bothIfString += ("\n\n" + shapeResults + shapes[shapeRepeatInt] + "\n" + randomShape + "\n" + "Not quite!");

                            } else if (Objects.equals(shapes[shapeRepeatInt], shapes[shape]) & !Objects.equals(colors[colorRepeatInt], colors[color])) {

                                bothIfString = (shapeResults + shapes[shapeRepeatInt] + "\n" + randomShape + "\n" +
                                        winningRound + "\n" + "Good perception on shape!");
                                rightAnswers += 1;
                                bothIfString += ("\n\n" + colorResults + colors[colorRepeatInt] + "\n" + randomColor + "\n" + "Not quite!");

                            } else if (Objects.equals(colors[colorRepeatInt], colors[color]) & Objects.equals(shapes[shapeRepeatInt], shapes[shape])) {

                                bothIfString = (colorResults + colors[colorRepeatInt] + "\n" + randomColor + "\n" +
                                        winningRound + "\n" + "Good perception on color!");
                                rightAnswers += 1;
                                bothIfString = (shapeResults + shapes[shapeRepeatInt] + "\n" + randomShape + "\n" +
                                        winningRound + "\n" + "Good perception on shape!");
                                rightAnswers += 1;
                            } else {

                                bothIfString += (shapeResults + shapes[shapeRepeatInt] + "\n" + randomShape + "\n" + "Not quite!\n");
                                bothIfString += ("\n" + colorResults + colors[colorRepeatInt] + "\n" + randomColor + "\n" + "Not quite!");

                            }

                            JOptionPane.showOptionDialog(null, bothIfString, stringTitle,
                                    0, 0, randomIcon, next, next[0]);
                        }

                    }

                roundNumber += 1;

                if (roundNumber % 5 == 0) {

                    String correct = "Total Correct -> " + rightAnswers;
                    String incorrect = "Total Incorrect -> " + wrongAnswers;
                    String scoreboard = (correct + "\n" + incorrect + "\nWould you like to play again?");


                    endGameInt = JOptionPane.showOptionDialog(null, scoreboard, stringTitle,
                            0, 0, unknownIcon, endGame, endGame[0]);

                }
            }
        } else {

            System.exit(0);

        }
    }
}


