package by.academy.lesson2;
import java.util.Scanner;

public class Cat {
    int age;
    String nickname;
    double money;
    public Cat(){};
    public Cat (String nicname){
        this.nickname = nicname;
    };
    public void grow(int addAge){
        System.out.println("Кот вырос на " + addAge + " год(а)");
        age = age + addAge;
    }
    public void sleep() {
        System.out.println("Кот спипит");
    }
    public void eat() {
        System.out.println("Кот ест");
    }
    public void walk() {
        System.out.println("Кот гуляет");
    }
    public void setMoney(double money){
        System.out.println("У кота " + money + "рублей");
        this.money = money;

    }
    public void getMoney(){
        System.out.println("Введите количество денег");
        Scanner scan = new Scanner(System.in);
        money = scan.nextInt();
    }
    public double showMoney(){
        System.out.println("Кот проел " + money + "рублей");
        return money;
    }

}
