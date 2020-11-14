package by.academy.home_work.HW_2__arrays_circls_strings;

public class Task_5 {

    private static Integer nPlayers;
    private static String playerCardSets[][];

    public static void getPlayers(){
        do {
            do {
                System.out.println("Введите количество игроков в покер от 2 до 10 ");
                String s = Main.scanL();
                boolean chek = s.matches("^[2-9]{1}0?");
                if (chek){
                    nPlayers = Integer.parseInt(s);
                } else {
                    continue;
                }
            } while ( nPlayers == null);
        } while (nPlayers<2 || nPlayers >10);
    }
    public static void setCards(){
        String cards [] = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        char suit[] = {9824,9827,9829,9830};
        int cardDeckSize = cards.length * suit.length;
        String cardDeck[]= new String[cardDeckSize] ;

        System.out.println("Создаем колоду из " + cardDeckSize + " карт");

            for (int i = 0; i < suit.length; i++) {
                int counterI = i;
                int counterIToCardsLength = ++counterI * cards.length;
                for (int j = i * (cards.length); j < counterIToCardsLength; j++) {
                    StringBuffer sb = new StringBuffer("\"").append(cards[j%cards.length]).append(suit[i]).append("\"");
                    cardDeck[j] = sb.toString();
                }
            }
        for (int i = 0; i < cardDeck.length;i++){
            System.out.print(cardDeck[i] +  " ");
        }

        System.out.println("\nПеремешиваем колоду");

        for (int i = 0; i < cardDeck.length;i++){
            System.out.print(+ i + " ");
        }

        System.out.println(" ");

        Integer shuffle[] = new Integer [cardDeckSize];
        for (int i = 0; i < shuffle.length;i++){
            boolean repitRandom = true;
            int arRandom;
                do {
                    arRandom = (int) (Math.random() * cardDeckSize);
                    for (int j = 0; j < shuffle.length; j++) {
                            if (shuffle[j]!=null) {
                                if(arRandom==shuffle[j]){
                                    repitRandom = true;
                                    break;
                                } else {
                                    repitRandom = false;}
                            } else {
                                repitRandom = false;
                            }
                        }
                } while (repitRandom == true);
            shuffle [i] = arRandom;
        }

        for (int i = 0; i < shuffle.length;i++){
            System.out.print(shuffle[i] + " ");
        }

        System.out.println("\nПеретасованная колода");

        String cardDeckshuffled[]= new String[cardDeckSize];
        for (int i = 0; i < cardDeckSize; i++){
            cardDeckshuffled[i] = cardDeck[shuffle[i]];
        }

        for (int i = 0; i < cardDeckshuffled.length;i++){
            System.out.print(cardDeckshuffled[i] + " ");
        }
        System.out.println("\nРаздача карт");
        int cardSetSize = 5;
        playerCardSets = new String[nPlayers][cardSetSize];
        for (int i = 0; i < nPlayers;i++){
            int counterI = i * cardSetSize;
            for (int j = 0 ; j < cardSetSize; j++) {
                int n = counterI + j;
                playerCardSets[i][j] = cardDeckshuffled[n];
            }
        }
        for (int i = 0; i<nPlayers;i++){
            int n = i;
            System.out.println("Игрок " + (n+1) +" : ");
            for (int j = 0 ; j < 5; j++) {
                System.out.print(playerCardSets[i][j] + " ");
            }
            System.out.println(" ");
        }


    }


}
