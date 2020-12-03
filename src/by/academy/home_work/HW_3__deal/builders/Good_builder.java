package by.academy.home_work.HW_3__deal.builders;

import by.academy.home_work.HW_3__deal.goods.Good;
import by.academy.home_work.HW_3__deal.goods.Sale_by_piece;
import by.academy.home_work.HW_3__deal.goods.Sale_by_volume;
import by.academy.home_work.HW_3__deal.goods.Sale_in_lots;

public class Good_builder extends Builder {
    protected static String arGoodsStub [][] = {
            {"GOOD_ID","GOOD_TYPE","GOOD_NAME","GOOD_PRICE","SALE_TYPE","GOOD_LOT_SIZE"},
            {"1","Чайник","императорский багряный", "10.00","by_piece","1"},
            {"2","Холодильник","фантазия снегурочки №2","20.00","by_piece","1"},
            {"3","Дрова","непослушный Буратино","1.00","in_lots","10"},
            {"4","Компот","аннигиляция сознания 76°","40.00","by_volume","1",}};
    protected static String arGoods [][] = new String[100][arGoodsStub[0].length];
    public static String[][] getArGoods() {
        return arGoods;
    }

    public static String[][] getArGoodsStub() {
        return arGoodsStub;
    }

    public static Integer createGood(){
        System.out.println("Внесите данные нового товара");
        System.out.println("Введите способ продажи товара: ▶ поштучно \"1\"    ▶ на разлив \"2\"    ▶ партиями \"3\"");

        Integer saleType = Builder.isScanNotNegativeInt();

        Good goodX = new Good();
        Good_builder good_builder = new Good_builder();

        do {

            if (saleType == 1) {
                goodX = new Sale_by_piece();
            } else if (saleType == 2) {
                goodX = new Sale_by_volume();
            } else if (saleType == 3) {
                goodX = new Sale_in_lots();
            } else {
                System.out.println("Число не входит в предложенный диапазон повторите ввод");
                saleType = Builder.isScanNotNegativeInt();
            }

        } while (saleType < 1 && saleType > 3);

        System.out.println("Введите тип товара ");
        goodX.setGoodType(Builder.scanNextLine());

        System.out.println("Введите модель");
        goodX.setGoodName(Builder.scanNextLine());

        System.out.println("Введите цену");
        goodX.setGoodPrice(Double.parseDouble(Builder.scanNextLine()));

        good_builder.setGoodsDataToAr(Builder.getFirstFreeArItem(arGoods), goodX.getGoodType(), goodX.getGoodName(),
                goodX.getGoodPrice().toString(), goodX.getSaleType(), goodX.getLotSize());

        System.out.println("Создан новый товар ");
        Builder.showArItem(arGoods, Builder.getFirstFreeArItem(arGoods)-1);

        return (Builder.getFirstFreeArItem(arGoods) - 1);

    }

    protected static void setGoodsDataToAr(Integer goodId, String goodType, String goodName, String goodPrice,
                                           String saleType, String lotSize) {
        arGoods[goodId][0] = goodId.toString();
        arGoods[goodId][1] = goodType;
        arGoods[goodId][2] = goodName;
        arGoods[goodId][3] = goodPrice;
        arGoods[goodId][4] = saleType;
        arGoods[goodId][5] = lotSize;

    }


}
