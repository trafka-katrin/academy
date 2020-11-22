package by.academy.home_work.HW_deal.goods;


import by.academy.home_work.HW_deal.Main;

public class Sale_in_lots extends Good{

    protected Sale_in_lots (){
        super();
        saleType = "in_lots";
        Integer n = 0;

        do {
            System.out.println("Введите размер партии товара");
            n = Main.isScanNotNegativeInt();
            if (n < 1){
                System.out.println("Число должно быть больше 0");
            }
        } while (n<1);

        lotSize = n.toString();

    }

    public static Double chekDiscount(String lotsSize, Integer goodsCount){
        Double discont = 0.0;
        Double lotCount = goodsCount / Double.parseDouble(lotsSize);

        if (lotCount > 10 ){
            discont = 4.0;
        }else {}

        return discont;

    }

    public static Integer chekGoodCount(Integer reqGoodCount, Integer goodID){
        Integer lotSize = Integer.parseInt(arGoods[goodID][5]);
        Integer respGoodCount = -1;

            if (reqGoodCount / lotSize > 0) {
                if (reqGoodCount % lotSize > 0) {
                    System.out.println("Товар \"" + arGoods[goodID][1] + " " + arGoods[goodID][2] +
                            "\" продается только партиями по " + arGoods[goodID][5] + " шт. \n" +
                            "Введите количество товара кратное партии или 0, " +
                            "если количества товара недостает до 1 партии");
                } else {
                    respGoodCount = reqGoodCount;
                }
            } else {
                System.out.println("Товар \"" + arGoods[goodID][1] + " " + arGoods[goodID][2] +
                        "\" продается только партиями по " + arGoods[goodID][5] + " шт. \n" +
                        "Введите количество товара кратное партии или 0, " +
                        "если количества товара недостает до 1 партии");
            }

        return respGoodCount;

    }


}


