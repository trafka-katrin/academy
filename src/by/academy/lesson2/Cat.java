package by.academy.lesson2;
import java.util.Scanner;

public class Cat {
    int age;
    String nickname;
    double money;
    char initials;
    boolean isHomeAnimal;
    public Cat(){};
    public Cat (String nicname){
        this.nickname = nicname;
    };
    public void grow(int addAge){
        System.out.println("Кот вырос на " + addAge + " год(а)");
        age = age + addAge;
    }
    public void sleep() {
        System.out.println("Кот спит");
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
        System.out.println("Введите количество денег для кота");
        Scanner scan = new Scanner(System.in);
        money = scan.nextInt();
    }
    public double setMoney(){
        System.out.println("У кота " + money + "рублей");
        return money;
    }

    public void getInitials(String nickname){
        initials = nickname.charAt(0);
    }

    public char setInitials(){
        System.out.println(initials);
        return initials;
    }

    public void isHomeAnimal(){
        String isYes;
        System.out.println("Является ли кот домашним животным? Если вы согласны напишите \"Да\"");
        Scanner scan = new Scanner(System.in);
        isYes = scan.next();
        if (isYes == "Да") {
            isHomeAnimal = true;
        } else {isHomeAnimal = false;}
    }

    public boolean setIsHomeAnimal(){
        if (isHomeAnimal == true) {
            System.out.println("Кот домашнее животное");
        } else {
            System.out.println("Кот не домашнне животное");}
        return isHomeAnimal;
    }



}
