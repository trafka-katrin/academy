package by.academy.class_work.multithreading;

public class NewRunnable implements Runnable{
    @Override
    public void run() {
        for(int i = 1; i < 101; i++){
            if(i %10 == 0){
                System.out.println(i);
            }
            try {
                Thread.sleep(1000,1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
