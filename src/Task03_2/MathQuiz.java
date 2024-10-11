package Task03_2;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class MathQuiz {

    public static void main(String[] args) {
        int score = 0;
        System.out.println("Answer with no more than 3 decimal points");
        generateQuestion(score);
    }

    public static void generateQuestion(int score) {
        Scanner keyboard = new Scanner(System.in);
        Random rand = new Random();
        double rand1 = rand.nextInt(101), rand2 = rand.nextInt(101);
        int randOp = rand.nextInt(4);
        String input;
        DecimalFormat round = new DecimalFormat("#.###");
        round.setRoundingMode(RoundingMode.CEILING);
        
        while (true) {
        try {
            switch (randOp) {
                case (0):
                    System.out.print(round.format(rand1) + " + " + round.format(rand2) + " = ");
                    input = keyboard.nextLine();

                    if (input.equals("x")) {
                        System.out.println("Score: " + score);
                        System.exit(0);
                    } 
                    else if (input.matches(".*[a-z].*")) {
                        System.out.println("Invalid input: re-enter answer.");
                    } 
                    else if (input.equals(round.format(rand1 + rand2))) {
                        System.out.println("Correct Answer");
                        generateQuestion(score + 10);
                    } 
                    else {
                        System.out.println("Wrong Answer");
                        generateQuestion(score - 10);
                    }
                    break;
                case (1):
                    System.out.print(round.format(rand1) + " - " + round.format(rand2) + " = ");
                    input = keyboard.nextLine();

                    if (input.equals("x")) {
                        System.out.println("Score: " + score);
                        System.exit(0);
                    } 
                    else if (input.matches(".*[a-z].*")) {
                        System.out.println("Invalid input: re-enter answer.");
                    } 
                    else if (input.equals(round.format(rand1 - rand2))) {
                        System.out.println("Correct Answer");
                        generateQuestion(score + 10);
                    } 
                    else {
                        System.out.println("Wrong Answer");
                        generateQuestion(score - 10);
                    }
                    break;
                case (2):
                    System.out.print(round.format(rand1) + " * " + round.format(rand2) + " = ");
                    input = keyboard.nextLine();

                    if (input.equals("x")) {
                        System.out.println("Score: " + score);
                        System.exit(0);
                    } 
                    else if (input.matches(".*[a-z].*")) {
                        System.out.println("Invalid input: re-enter answer.");
                    } 
                    else if (input.equals(round.format(rand1 * rand2))) {
                        System.out.println("Correct Answer");
                        generateQuestion(score + 10);
                    } 
                    else {
                        System.out.println("Wrong Answer");
                        generateQuestion(score - 10);
                    }
                    break;
                case (3):
                    while (rand2 == 0) {
                        rand2 = rand.nextInt(101);
                    }                    
                    System.out.print(round.format(rand1) + " / " + round.format(rand2) + " = ");
                    input = keyboard.nextLine();

                    if (input.equals("x")) {
                        System.out.println("Score: " + score);
                        System.exit(0);
                    } 
                    else if (input.matches(".*[a-z].*")) {
                        System.out.println("Invalid input: re-enter answer.");
                    } 
                    else if (round.format(rand1/rand2).equals(input)) {
                        System.out.println("Correct Answer");
                        generateQuestion(score + 10);
                    } 
                    else {
                        System.out.println("Wrong Answer");
                        generateQuestion(score - 10);
                    }
                    break;
                default:
                    System.out.println("Error: re-enter answer.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Error: re-enter answer.");
        }
        }
    }
}