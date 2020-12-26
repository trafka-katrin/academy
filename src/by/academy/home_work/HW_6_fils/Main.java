package by.academy.home_work.HW_6_fils;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        FileInputStream fileInputStream = new FileInputStream(
            "src/by/academy/home_work/HW_6_fils/text.txt");
        PrintWriter pr = new PrintWriter(new BufferedWriter ( new FileWriter(
            "src/by/academy/home_work/HW_6_fils/text.txt", true)));
        for (int i = 0; i < text.length(); i++){
            pr.write(i);
        }

        int readText = fileInputStream.read();
        while (readText != -1){
            System.out.println((char) readText);
            readText = fileInputStream.read();
        }

    }



}
