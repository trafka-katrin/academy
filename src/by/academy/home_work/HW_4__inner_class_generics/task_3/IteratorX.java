package by.academy.home_work.HW_4__inner_class_generics.task_3;

import java.util.NoSuchElementException;

public class IteratorX{

    public static class IteratorY<T>{
        private int count;
        private int index = 0;
        private T []array;

        IteratorY (T[] arr){
            count = arr.length;
            array = arr;
        }

        public boolean hasNext() {
            return index < count;
        }

        public T next() {
            if (index < count) {
                return array[index++];
            } else {
                throw new NoSuchElementException("No such element.");
            }
        }


        public void remove() {
            if (index < count) {
                array[index-1] = null;
                System.out.println("element with id " + (index-1) + " deleted");
            } else {
                throw new NoSuchElementException("Cannot remove item from array.");
            }
        }

    }


}
