package by.academy.home_work.HW_5__collections_exeptions;

import java.util.Iterator;

public class Iterato2X<T> implements Iterator {
    private int countStrings;
    private int countItems;
    private int indexString = 0;
    private int indexItem = 0;
    private T [][] array;

    Iterato2X(T [][] array){
        this.array = array;
        countStrings = array.length;
        countItems = array[indexString].length;
    }

    @Override
    public void remove() {

    }

    @Override
    public boolean hasNext() {
         if (indexString < countStrings){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object next() {
        if(indexString < countStrings && indexItem < countItems){
            return array[indexString][indexItem++];
        } else if (indexString<array.length){
            indexItem = 0;
            return array[++indexString][indexItem++];
        } else {
            return null;
        }

    }
}
