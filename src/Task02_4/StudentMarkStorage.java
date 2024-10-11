package Task02_4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentMarkStorage {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);
        String name;
        int mark;
    
        try {
            BufferedReader inputStream = new BufferedReader(new FileReader("resources/T02_scores.txt"));
            String line;
          
            while((line = inputStream.readLine()) != null) {
                // found how to use .split() on ChatGPT
                String[] read = line.split(" ", 2);
                // found how to use Integer.parseInt() on ChatGPT
                students.add(new Student(read[0], Integer.parseInt(read[1])));
            }
        } 
        catch (FileNotFoundException e) {
        System.out.println(e.getMessage());
        }
        catch (IOException e) {
            System.out.println("Error reading from file: T02_scores.txt");
        }
        while (true) {
            String in;
            boolean exists = false;
            int place = 0;
            
            System.out.print("Enter student name: ");
            in = keyboard.nextLine();
            if(!"x".equals(in)) {
                name = in;
            }
            else
            {
                return;
            }
            System.out.print("Enter student mark: ");
            in = keyboard.nextLine();
            if(!"x".equals(in)) {
                mark = Integer.parseInt(in);
            }
            else
            {
                return;
            }
            for (Student s: students) {
                if (s.name.equals(name)) {
                    exists = true;
                    break;
                }
                place++;
            }
            if (exists) {
                System.out.print("Student record already exists/ Overwrite? y/n: ");
                String yn = keyboard.nextLine();
                if(yn.equals("y")) {
                students.set(place, new Student(name, mark));
                }
                else if (yn.equals("x")) {
                    return;
                }
            }
            else
            {
                students.add(new Student(name, mark));
            }
                try {
                    PrintWriter pw = new PrintWriter(new FileOutputStream("resources/T02_scores.txt"));
            
                    for (int i = 0; i < students.size(); i++) {
                        if (i != (students.size() - 1)) {
                        pw.println(students.get(i).name + " " + students.get(i).mark);
                    }
                    else
                    {
                        pw.print(students.get(i).name + " " + students.get(i).mark);
                    }
                }
            
                pw.close();
            } 
            catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
