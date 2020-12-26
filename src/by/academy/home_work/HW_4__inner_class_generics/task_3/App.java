package by.academy.home_work.HW_4__inner_class_generics.task_3;

public class App {
    public static void main(String[] args) {
            String[] strings = new String[]{"1", "2", "3", "4", "5", "6", "7"};

            IteratorX.IteratorY<String> iteratorY = new IteratorX.IteratorY<>(strings);
            while (iteratorY.hasNext()){
                String el = iteratorY.next();
                System.out.println(el);
                if (el.equals("3")){
                    iteratorY.remove();
                }

            }

    }
}
