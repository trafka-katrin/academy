package by.academy.home_work.HW_3__deal.builders;

import java.util.Scanner;

public class Builder {

    public static void showAr(String arName[][], String strinsBefor){

        for (int i = 0; i< Integer.parseInt(strinsBefor); i++){
            for (int j = 0; j< arName[i].length; j++){
                System.out.print(arName [i][j] + " | " );
            }
            System.out.println(" ");
        }

    }

    public static void showArItem(String m[][], Integer itemI){

        for (int i = 0; i< m[0].length; i++){

            System.out.print(m [0][i] + " | " );
        }

        System.out.println(" ");

        for (int i = 0; i< m[itemI].length; i++){

            System.out.print(m [itemI][i] + " | " );
        }
        System.out.println(" ");

    }

    public static void fillInAr(String m[][],String n[][]){

        for (int i = 0; i< n.length; i++){
            for (int j = 0; j < n[i].length; j++){
                m[i][j] = n[i][j];
            }
        }

    }

    public static Integer getFirstFreeArItem(String[][] m){
        Integer n = -1;
        for (int i = 0; i< m.length; i++){
            if (m [i][0]==null){
                n = i;
                break;
            }
        }
        return n;

    }

    public static String[][] chekArLength(String[][] ar){
        String tempAr[][] = new String[ar.length*2+1][ar[0].length];
        Builder.getFirstFreeArItem(tempAr);
        if(Builder.getFirstFreeArItem(ar) == -1){
            System.arraycopy(ar, 0, tempAr, 0, ar.length );
            ar = tempAr;
            System.out.println(ar.length);
        }
        return ar;

    }

    public static String scanNextLine(){
        Scanner scan = new Scanner(System.in);
        String l = scan.nextLine();
        return l;

    }

    public static String scanNext(){
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        return s;

    }

    public static Integer isScanNotNegativeInt(){
        Integer i = -1;

        do {
            Scanner scan = new Scanner(System.in);

            if (scan.hasNextInt()) {
                i = scan.nextInt();
                if (i < 0) {
                    System.out.println("Вы ввели отрицательное число, повторите ввод");
                    i=-1;
                } else {}
            } else {
                System.out.println("Введенные данные не являются целым числом, повторите ввод");
            }

        }while (i < 0);

        closeScan();
        return i;

    }

    public static void closeScan(){
        Scanner scan = new Scanner("");
        scan.close();

    }


}
