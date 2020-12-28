package by.academy.test;

import javax.imageio.IIOException;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char s1[] = s.toCharArray();
        Integer sLen = s.length();
        if (s.contains("stop")){
            sLen = s.indexOf("stop");
        } else {}
        try (
                PrintWriter out = new PrintWriter
                    ( new BufferedWriter(
                        new FileWriter("src/by/academy/test/text1_for_task1.txt",true) ))){
            for (int i = 0; i < sLen; i++) {

                out.write(s1[i]);
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }


    }
}
