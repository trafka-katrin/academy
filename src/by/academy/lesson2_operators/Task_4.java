package by.academy.lesson2_operators;

public class Task_4 {
    double power = 0;
    double prod;
    public void printPower(){
        while (prod <= 1_000_000){
            prod = Math.pow(2, power);
            System.out.println
                    ("2 в степени " + String.format("%.0f", power) + " (2 ^ " + String.format("%.0f", power) + " = " + String.format("%.0f", prod) + ")");
            power++;
        }
    }

}
