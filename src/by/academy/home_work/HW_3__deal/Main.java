package by.academy.home_work.HW_3__deal;

import by.academy.home_work.HW_3__deal.goods.Good;
import by.academy.home_work.HW_3__deal.validators.Validator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static class EmailValidator implements Validator {

        public Boolean validate(String email){
            Boolean chekEmail = false;
            if(email.matches( "^[-a-z0-9!#$%&'*+/=?^_`{|}~]+" +
                                    "(\\.[-a-z0-9!#$%&'*+/=?^_`{|}~]+)*" +
                                    "@([a-z0-9]([-a-z0-9]{0,61}[a-z0-9])?\\.)*" +
                                    "(aero|arpa|asia|biz|cat|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|" +
                                    "name|net|org|pro|tel|travel|[a-z][a-z])$"))
            {
                chekEmail = true;
            }
            return chekEmail;

        }


    }

    public static void main(String[] args) {
        String menuItemI;
        String menuItemJ;

        fillInAr(Deal.arDeals,Deal.arDealsStub);
        fillInAr(Deal.arDealGoods,Deal.arDealGoodsStub);
        fillInAr(Person.arPersons, Person.arPersonsStub);
        fillInAr(Good.getArGoods(),Good.getArGoodsStub());

        do {
            System.out.println(
                                "▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼\n"+
                                "ГЛАВНОЕ МЕНЮ \n" +
                                "▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲\n"+
                                "▶ Для создания новой сделки введите \"1\"    " +
                                "▶ Для просмотра информации по сделкам введите \"2\"    " +
                                "▶ Для просмотра данных массивов введите \"3\".");
            menuItemI = scanNext();

            switch (menuItemI){
                case "1": Deal.createDeal();
                    break;

                case "2":
                    String memuItem2;
                    do {
                        System.out.println ("▶ Для просмотра информации о сделке введите ее ID   " +
                                            "▶ Для просмотра всех сделок введите \"0\"   " +
                                            "▶ Для выхода из меню введите другой символ");
                        memuItem2 = Main.scanNext();
                        if (memuItem2.matches("[1-9]\\d*")){
                            Deal.showDealInfo(Integer.parseInt(memuItem2));
                        } else if (memuItem2.matches("0")){
                            Main.showAr(Deal.arDeals, "1");
                            Integer countDeals = Main.getFirstFreeArItem(Deal.arDeals);
                            for(int i = 1; i < countDeals; i++){
                                Deal.showDealInfo(i);
                            }
                        }else {}

                    }while (memuItem2.matches("(0(?=)|[1-9])\\d*"));

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

    public static String validateEmail(){
        Boolean isEmailValid = false;
        String email;
        EmailValidator eV = new EmailValidator();

        do {
            email = Main.scanNextLine();
            isEmailValid = eV.validate(email);

            if (!isEmailValid){
                System.out.println("Email введен в неверном формате, повторите ввод");
            } else {}

        } while (!isEmailValid);

        return email;
    }

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

    static void fillInAr(String m[][],String n[][]){

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
        getFirstFreeArItem(tempAr);
        if(getFirstFreeArItem(ar) == -1){
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
