package Task04_1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Tyler Henderson
 */
public class MathQuiz2 {
    private String userName;
    private int score;

    public MathQuiz2(String userName, int score) {
        this.userName = userName;
        this.score = score;
    }
    public String getUserName() {
        return userName;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    
    public static void main(String[] args) {
        ArrayList<String> fileIn = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        
        // username
        System.out.print("Username: ");
        String user = s.nextLine();
        
        // check for existing user and apply score
        int scr = 0;
        try {
            BufferedReader inputStream = new BufferedReader(new FileReader("resources/T04_users.txt"));
            String line;
            
            while((line = inputStream.readLine()) != null) {
                if (line.contains(user)) {
                    scr = Integer.parseInt(line.replaceAll("[a-zA-Z\\s]", ""));
                }
            }
            inputStream.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        } 
        catch (IOException e) {
            System.out.println("Error reading from file: T04_users.txt");
            return;
        }
                
        MathQuiz2 mq = new MathQuiz2(user, scr);
        
        LinkedHashSet<String> qList = new LinkedHashSet<>();
        qList = mq.generateQuestions();
        
        for (String roundInfo : qList)
        {
            boolean answered = false;
            do {
                try {
                    String[] roundInfoSplit = roundInfo.split(" ", 2);
                    System.out.print(roundInfoSplit[0] + "= ");
                    
                    double input = s.nextDouble();
                    double correctAnswer = Double.parseDouble(roundInfoSplit[1].trim());
                    
                    int correctDecimalPlaces = getDecimalPlaces(correctAnswer);
                    int inDecimalPlaces = getDecimalPlaces(input);
                    
                    double factor = Math.pow(10, inDecimalPlaces);
                    
                    if (Math.round(input * factor) == Math.round(correctAnswer * factor) && inDecimalPlaces >= Math.round(correctDecimalPlaces * 0.25)) {
                        System.out.println("Correct!");
                        mq.setScore(mq.getScore() + 10);
                    } else {
                        System.out.println("Incorrect!");
                        mq.setScore(mq.getScore() - 10);
                    }
                    answered = true;
                } catch (Exception e) {
                    System.out.println("Error: re-enter answer.");
                    s.nextLine();
                }
            } while (!answered);
        }
        System.out.println("New Score: " + mq.getScore());
        
        try {
            BufferedReader inputStream = new BufferedReader(new FileReader("resources/T04_users.txt"));
            boolean found = false;
            String line;
            
            while((line = inputStream.readLine()) != null) {
                if (line.contains(user)) {
                    fileIn.add(mq.getUserName() + " " + mq.getScore());
                    found = true;
                } else {
                    fileIn.add(line);
                }
            }
            if (!found) {
                fileIn.add(mq.getUserName() + " " + mq.getScore());
            }
            inputStream.close();
            
            PrintWriter pw = new PrintWriter(new FileOutputStream("resources/T04_users.txt"));
            for(String ln: fileIn) {
                pw.println(ln);
            }
            pw.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } 
        catch (IOException e) {
            System.out.println("Error reading from file: T04_users.txt");
        }
    }

    public LinkedHashSet generateQuestions() {
        int round = 0;
        LinkedHashSet qList = new LinkedHashSet();
        
        while (round < 10) {
            boolean done = false;
            int num1 = this.generateNumber(100);
            int num2 = this.generateNumber(100);
            String operation = "";
            double result = 0d;
            
            switch (this.generateNumber(4)) {
                case 0:
                    operation = "+";
                    result = num1 + num2;
                    done = true;
                    break;
                case 1:
                    operation = "-";
                    result = num1 - num2;
                    done = true;
                    break;
                case 2:
                    operation = "*";
                    result = num1 * num2;
                    done = true;
                    break;
                case 3:
                    operation = "/";
                    //Keep assigning a new random number to num2 if num2 is 0.
                    while (num2 == 0) {
                        num2 = this.generateNumber(100);
                    }
                    // In java, the result of an integer divided by an integer is still an integer.
                    result = 1d * num1 / num2;
                    // Hence, we first let num1 times 1.0 to make num1 become a double type number.
                    done = true;
                    break;
                default:
                    break;
            }
            if (done) {
                qList.add(num1 + operation + num2 + " " + result);
                round++;
            }
        }
        return qList;
    }
    public int generateNumber(int range) {
        return (new Random()).nextInt(range);
    }
    public static int getDecimalPlaces(double number) {
        String numStr = Double.toString(number);
        int decimalIndex = numStr.indexOf('.');
        if(decimalIndex >= 0) {
            return numStr.length() - decimalIndex - 1;
        } else {
            return 0;
        }
    }
}