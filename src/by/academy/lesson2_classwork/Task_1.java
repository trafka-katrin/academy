package by.academy.lesson2_classwork;

public class Task_1 {
    public static void sqrt (){
        for (int i = 10; i < 21; i++){
            double n = i;
            n = Math.pow(n,2);
            System.out.println(String.format("%.0f", n));
        }
    }
}
