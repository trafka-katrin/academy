package by.academy.class_work.multithreading;

public class Main {
    public static void main(String[] args) {
        NewThread nT = new NewThread();
        nT.run();
        NewRunnable nR = new NewRunnable();
        Thread nR1 = new Thread(nR);
        nR1.run();

    }
}
