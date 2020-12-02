package by.academy.home_work.HW_4__inner_class_generics.task_2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("yfy");
        Scanner scan = new Scanner(System.in);
        GenX <Integer> genX = new GenX<>();
        genX.addItemtoAr(5);
        genX.addItemtoAr(6);
        genX.addItemtoAr(7);
        genX.removeItemByID(1);
        genX.showArGen();

       genX.getArGenItem(4);



    }
}
