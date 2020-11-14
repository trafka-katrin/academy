package by.academy.home_work.HW_1__operators;

import java.util.Scanner;

public  class Task_1 {
    static double purchaseAmount;
    static int buyersAge;
    static double finalPrice;
    public Task_1 (){}
    public static void getPurchaseAmount () {
        System.out.println("Введите сумму покупки (больше 0)");
        Scanner scan = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        do {
            while (!scan.hasNextDouble()) {
                System.out.println("Пожалуйста, введите число" + builder.append("!"));
                scan = new Scanner(System.in);
            }
            purchaseAmount = scan.nextDouble();
            System.out.println("Пожалуйста, введите число > 0 " + builder.append("!"));
        } while (purchaseAmount <= 0);

        System.out.println("Введите возраст покупателя (целое число > 0)");
        builder.setLength(0);
        do {
            while (!scan.hasNextInt()) {
                System.out.println("Пожалуйста, введите целое число" + builder.append("!"));
                scan = new Scanner(System.in);
            }
            buyersAge = scan.nextInt();
            System.out.println("Пожалуйста, введите число > 0 " + builder.append("!"));
        } while (buyersAge <= 0);
    }

    public static void setfFinalPrice (){
        if (purchaseAmount > 0 && purchaseAmount < 100 ) {
            finalPrice =  purchaseAmount * 0.95;
        } else if (purchaseAmount >= 100 && purchaseAmount < 200 ) {
            finalPrice =  purchaseAmount * 0.93;
        } else if (purchaseAmount >= 200 && purchaseAmount < 300 ) {
            if (buyersAge >= 18 ){
                finalPrice = purchaseAmount * 0.82;
            } else {
                finalPrice = purchaseAmount * 0.82;
            }

        } else if (purchaseAmount >= 300 && purchaseAmount < 400 ) {
            finalPrice = purchaseAmount * 0.85;
        } else if (purchaseAmount >= 400 ) {
            finalPrice = purchaseAmount * 0.8;
        } else {
            System.out.println("Из-за того что сатурн находится в водолее произошла ошибка непредвиденная разработчиком");
        }
        System.out.println("Сумма покупки со скидкой " + finalPrice);
    }

}
