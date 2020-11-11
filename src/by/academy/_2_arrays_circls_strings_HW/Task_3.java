package by.academy._2_arrays_circls_strings_HW;

import java.util.Scanner;

public class Task_3 {
    static private String s;
    public static void getWords(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите строку из нескольких слов разделенных пробелами");
        s = scan.nextLine();
    }
    public static void setMinWord(){
        String arW[] = s.split(" ");
        String minW = arW[0];
        for (int i = 0; i < arW.length; i++){
            if (arW[i].length() < minW.length()){
                minW = arW[i];
            } else {}
        }
        System.out.println(minW);
    }
}
