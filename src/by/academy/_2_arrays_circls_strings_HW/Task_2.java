package by.academy._2_arrays_circls_strings_HW;

import java.util.Scanner;

public class Task_2 {
    static private String s1;
    static private String s2;

    public static void getStrings(){
        System.out.println("Введите первую строку");
        Scanner scan = new Scanner(System.in);
        s1 = scan.nextLine();
        System.out.println("Введите вторую строку");
        s2 = scan.nextLine();
    }
    public static boolean compareStrings (){
        if (s1.length()==s2.length()){
            int arCountLet [] = new int[5000];
            char arS1 [] = s1.toCharArray();
            char arS2 [] = s2.toCharArray();
            for (int i : arS1){
                arCountLet[i]++;
            }
            for (int i : arS2){
                if (--arCountLet[i] < 0){
                System.out.println("Строки не являются перестановкой символов друг друга ");
                return false;
                } else {}
            }
            System.out.println("Строки являются перестановкой символов друг друга ");
            return true;

        } else {
            System.out.println("Строки не являются перестановкой символов друг друга ");
            return false;
        }
    }
}
