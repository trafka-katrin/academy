package by.academy.home_work.HW_deal;

import by.academy.home_work.HW_deal.goods.Good;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String menuItemI;
        String menuItemJ;

        fillInAr(Deal.arDeals,Deal.arDealsStub);
        fillInAr(Deal.arDealGoods,Deal.arDealGoodsStub);
        fillInAr(Person.arPersons, Person.arPersonsStub);
        fillInAr(Good.getArGoods(),Good.getArGoodsStub());

        do {
            System.out.println(
                                "ГЛАВНОЕ МЕНЮ \n" +
                                "Для создания новой сделки введите 1. " +
                                "Для просмотра информации по сделкам введите 2. " +
                                "Для просмотра данных массивов введите 3 .");
            menuItemI = scanNext();

            switch (menuItemI){
                case "1": Deal.createDeal();
                    break;

                case "2":
                    Deal.showDealInfo();
                    break;

                case "3":

                    do{
                        System.out.println("Выберите массив: " +
                                            "1 - Сделки, 2 - Клиенты, 3 - Товары, 4 - Связи сделок с товарами");
                        menuItemJ = scanNext();

                        switch (menuItemJ) {
                            case "1": showAr(Deal.arDeals, "10");
                                break;

                            case "2": showAr(Person.arPersons, "10");
                                break;

                            case "3": showAr(Good.getArGoods(), "10");
                                break;

                            case "4": showAr(Deal.arDealGoods, "10");
                                break;

                            default: break;
                        }
                    } while (menuItemJ.matches("[1-4]{1}"));

                    break;

                default: break;
            }
        } while (menuItemI.matches("[1-3]{1}"));

    }

    public static void showAr(String m[][], String n){

        for (int i = 0; i< Integer.parseInt(n); i++){
            for (int j = 0; j< m[i].length; j++){
                System.out.print(m [i][j] + " | " );
            }
            System.out.println(" ");
        }

    }

    static void fillInAr(String m[][],String n[][]){

        for (int i = 0; i< n.length; i++){
            for (int j = 0; j < n[i].length; j++){
                m[i][j] = n[i][j];
            }
        }

    }

    public static Integer getFirstFreeArItem(String[][] m){
        Integer n = null;
        for (int i = 0; i< m.length; i++){
            if (m [i][0]==null){
                n = i;
                break;
            }
        }
        return n;
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
