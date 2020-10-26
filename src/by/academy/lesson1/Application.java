package by.academy.lesson1;

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
        cat1.getInitials(cat1.nickname);
        cat1.setInitials();
        cat1.isHomeAnimal();
        cat1.setIsHomeAnimal();



    }


}
