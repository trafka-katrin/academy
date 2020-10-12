package by.academy.lesson2;

public class Application {
    public static void main(String[] args) {
        Cat cat = new Cat("Барсик");
        cat.eat();
        cat.sleep();
        cat.walk();
        System.out.println(cat.age);
        cat.grow(1);
        System.out.println(cat.age);
        cat.grow(3);
        System.out.println("Barsik age: " + cat.age + "года   ");
        cat.getMoney();
        cat.showMoney();




    }


}
