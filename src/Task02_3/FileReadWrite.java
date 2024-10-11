package Task02_3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileReadWrite {
    public static void main(String[] args) {
        int lines = 0;
        ArrayList input = new ArrayList();
        
        try {
            BufferedReader inputStream = new BufferedReader(new FileReader("resources/T02_input.txt"));
            String line;
            
            while((line = inputStream.readLine()) != null) {
                //used ChatGPT to find how to do StringBuilder().reverse() and .replaceAll("[^a-zA-Z]", "")
                input.add(new StringBuilder(line.replaceAll("[^a-zA-Z]", "").toUpperCase()).reverse().toString());
                lines++;
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            System.out.println("Error reading from file: T02_input.txt");
        }
        
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream("resources/T02_output.txt"));
            
            for (int i = 0; i < lines; i++) {
                if (i != (lines - 1)) {
                    pw.println(input.get(i));
                }
                else
                {
                    pw.print(input.get(i));
                }
            }
            
            pw.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}