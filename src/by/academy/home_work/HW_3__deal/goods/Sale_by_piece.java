package by.academy.home_work.HW_3__deal.goods;


public class Sale_by_piece extends Good{

    protected Sale_by_piece (){
        super();
        saleType = "by_piece";
        lotSize = "1";
    }

    public static Double chekDiscount(Double goodPrice, Integer goodCount){
        Double discount = 0.0;
        Double goodsPrice = goodPrice * goodCount;

        if (goodsPrice > 100 ){
            discount = discontByGoodsSumm;
        } else {}

        return discount;
    }

}
