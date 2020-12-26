package by.academy.home_work.HW_5__collections_exeptions;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Task1
        ArrayList<Integer> listX = new ArrayList(Arrays.asList(1,2,3,4,2));


/*        Collection<?> listY = getUniqueCollection(listX);
        for (Object o: listY){
            System.out.println(o.toString());
        }*/

        //Task2


        /*ArrayList<Integer> listA = new ArrayList<>();
        LinkedList<Integer> listL = new LinkedList<>();

        long time = System.currentTimeMillis();
        addNewElements(listA);
        time = System.currentTimeMillis() - time;
        System.out.println("ArrayList Add " + time);

        time = System.currentTimeMillis();
        addNewElements(listL);
        time = System.currentTimeMillis() - time;
        System.out.println("LinkedList Add " + time);

        time = System.currentTimeMillis();
        get_10_000(listA);
        time = System.currentTimeMillis() - time;
        System.out.println("ArrayList get " + time);

        time = System.currentTimeMillis();
        get_10_000(listL);
        time = System.currentTimeMillis() - time;
        System.out.println("LinkedList get " + time);*/

        //Task3
/*        Integer arr2X[][] = {{1,2,3,4,5},{11,22,33,44,55,66}};
        Iterato2X iterato2X = new Iterato2X(arr2X);
        while (iterato2X.hasNext()){
            System.out.println(iterato2X.next());
        }*/

        //Task4
        /*ArrayList<Integer> marks = new ArrayList<>();
        for (int i= 0; i<30; i++){
            marks.add((int)(Math.random() * (11 - 2) + 2));
        }
        for (Integer i: marks){
            System.out.println(marks.get(i));
        }
        Iterator iterator = marks.iterator();
        Integer maxMark = 0;
        while (iterator.hasNext()){
            Integer tempMaxMark = (Integer) iterator.next();
            if(tempMaxMark > maxMark){
                maxMark = tempMaxMark;
            }
        }
        System.out.println("Максимальная оценка " + maxMark);*/

        //Task5
/*        String text = "Письмо из центра до Штиpлица не дошло... Пришлось читать во второй раз.";
        Map <Character, Integer> frequencyMap = new HashMap<>();
        char textCh[] = text.toCharArray();
        System.out.println(Arrays.toString(textCh));
        for(int i = 0; i< textCh.length; i++){
            if (!frequencyMap.containsKey(textCh[i])){
                frequencyMap.put(textCh[i],1);
            } else {
                Integer counter = frequencyMap.get(textCh[i]);
                counter++;
                frequencyMap.put(textCh[i],counter);
            }

        }

        for (Map.Entry<Character,Integer> item : frequencyMap.entrySet()){
            System.out.println(item.getKey() + " " + item.getValue());

        }*/

        //Task6

        try {
            Integer arrInt[] = new Integer[8];
            for(int i = 0; i < 10 ; i++){
                arrInt[i] = i;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array is to small, expand the array");
            //e.printStackTrace();
        }

        //Task7



    }

    public static <T>Collection<T> getUniqueCollection (Collection<T> coll){
        return new HashSet<>(coll);
    }

    public static void addNewElements(List<Integer> col){
        Integer addMln = 1_000_000;
        for (int i = 0; i < addMln; i++){
            col.add((int) (Math.random() * (1_000_000 ) + 1));
        }

    }

    public static void get_10_000(List<Integer> col){
        Integer randId = 100_000;
        for (int i = 0; i < randId; i++){
            col.get((int) (Math.random() * (100_000 ) + 1));
        }

    }


}
