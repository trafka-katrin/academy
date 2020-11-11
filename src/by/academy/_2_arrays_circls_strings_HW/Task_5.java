package by.academy._2_arrays_circls_strings_HW;

import java.util.Scanner;

public class Task_5 {
    private static Integer n;
    private static int nPlayers;
    public static void getPlayers(){
        do {
            do {
                Scanner scan = new Scanner(System.in);
                System.out.println("Введите количество игроков в покер от 2 до 10");
                if (scan.hasNextInt()){
                    n = scan.nextInt();
                }
            }while ( n == null);
        } while (n<2 || n >10);

    }
    public static void setCards(){

    }

}
