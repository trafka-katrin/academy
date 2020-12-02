package by.academy.home_work.HW_4__inner_class_generics.task_2;

import java.util.Arrays;

public class GenX <T> {
    public T[] arGen;
    private static int arItemsCounter = 0;

    public GenX(){
        arGen =  (T[]) new Object [16];
    }
    public GenX(int i){
        arGen =  (T[]) new Object [i];
    }

    public void addItemtoAr(T a){
        if(arItemsCounter == arGen.length-1){
            T[] arTemp = (T[]) new Object[arGen.length * 2 + 1];
            arTemp = Arrays.copyOf( arGen, arTemp.length);
            arGen = arTemp;
        }
        arGen[arItemsCounter] = a;
        arItemsCounter++;
    }

    public T getArGenItem(int i) {
        if (i>=arGen.length){
            System.out.println("Элемента с таким ID нет, введите число до " + arGen.length);
            return null;
        } else {
            System.out.println(arGen[i]);
            return arGen[i];
        }

    }

    public T getLastArGenItem() {
        return arGen[arGen.length -1];
    }

    public T getFirtstArGenItem() {
        System.out.println(arGen[0]);
        return arGen[0];
    }

    public void arGenLength() {
        System.out.println("Длина массива " + arGen.length);
    }

    public Integer getLastFullArGenItem() {
        Integer itemID = -1;
        for (int i = 0; i < arGen.length; i++){
            if (arGen[i] == null){
                itemID = i-1;
                System.out.println("Последний заполненный элемент с ID " + itemID);
                break;
            } else {}
        }
        if (itemID == -1) {
            System.out.println("Cвободных элементов в массиве нет");
            return null;
        } else {}

        return itemID;
    }

    public void removeItemByID (int i){
        if (i>= arGen.length){
            System.out.println("Такого ID нет в массиве");
        } else if (i > getLastFullArGenItem()){
            System.out.println("Элемент и так пустой");
        } else {
            arGen[i] = null;
            System.arraycopy(arGen,i+1,arGen,i,arGen.length - i - 1 );
        }

    }

    public void showArGen(){
        System.out.println(Arrays.toString(arGen));
    }


}
