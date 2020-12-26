package by.academy.test;

import javax.imageio.IIOException;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {
        String s = "qwdqdddq";
        try (PrintWriter pr = new PrintWriter("src/by/academy/test/text.txt")){
            pr.append(s,0,s.length());
            pr.append(s,0,s.length());

        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }







    }
}
