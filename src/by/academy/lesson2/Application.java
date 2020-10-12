package by.academy.lesson2;

public class Application {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Cat cat1 = new Cat("Барсик");
        cat1.eat();
        cat1.sleep();
        cat1.walk();
        for (int i=0;i<3;i++) {
            cat.grow(1);
        }
        System.out.println("Коту " + cat.nickname + " " + cat.age + " года");





    }


}
