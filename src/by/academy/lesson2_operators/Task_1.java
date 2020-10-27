package by.academy.lesson2_operators;

import java.util.Scanner;

public class Task_1 {
    double purchaseAmount;
    int buyersAge;
    double finalPrice;
    public Task_1 (){};
    public void getPurchaseAmount (){
        System.out.println("Введите сумму покупки");
        Scanner scan = new Scanner(System.in);
        purchaseAmount = scan.nextInt();
    }
    public void getBuyersAge (){
        System.out.println("Введите возраст покупателя");
        Scanner scan = new Scanner(System.in);
        buyersAge = scan.nextInt();
    }
    public void setfFinalPrice (){
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
            System.out.println("Введена некорректная сумма покупки. Сумма покупки должна быть больше 0");
        }
        System.out.println("Сумма покупки со скидкой " + finalPrice);
    }





}
