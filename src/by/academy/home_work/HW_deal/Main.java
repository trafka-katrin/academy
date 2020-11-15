package by.academy.home_work.HW_deal;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Deal.fillInArDeals();
        Deal.fillInArGoodsTemp();
        Person.fillInArPersons();
        Good.fillInArGoods();

        Deal.createDeal();



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
    public static Integer isScanInt(){
        Integer i = -1;
        Scanner scan = new Scanner(System.in);
        if (scan.hasNextInt()) {
            i = scan.nextInt();
        } else {
            System.out.println("Введенные данные не являются целым числом, повторите ввод");
            isScanInt();
        }
        closeScan();
        return i;

    }


    public static void closeScan(){
        Scanner scan = new Scanner("");
        scan.close();
    }

}
