package by.academy.home_work.HW_deal.goods;

public class Sale_by_volume extends Good{

    protected Sale_by_volume (){
        super();
        saleType = "by_volume";
        lotSize = "1";
    }

    public static Double[][] getTaraData (int goodCount) {

        int arTaraSize[] = {10,5,2}; //Варианты объема тары
        Double arTaraPrices[] = {1.1,0.5,0.2}; //Цена тары соответствующего объема
        Double taraCount2;
        Double taraCount1;
        Double taraCount0;
        int countStrWRToArSumm = 0;
        int maxCountTara2 = goodCount/arTaraSize[2] + 1;
        int maxCountTara1 = goodCount/arTaraSize[1] + 1;
        int maxCountTara0 = goodCount/arTaraSize[0] + 1;
        int countTaraSetsR0 =0;
        int countTaraSetsR1 =0;
        int arLenth = maxCountTara2 * maxCountTara1 * maxCountTara0;
        int taraSetOptions[][] = new int[arLenth][5];

        //Подбор количества тары для необходимого объема товара

        if (goodCount == 1){
            taraCount0 = 0.0;
            taraCount1 = 0.0;
            taraCount2 = 1.0;
        } else if (goodCount == 3){
            taraCount0 = 0.0;
            taraCount1 = 0.0;
            taraCount2 = 2.0;
        } else {
            for (int i = 0; i < maxCountTara0; i++) {
                for (int j = 0; j < maxCountTara1; j++) {
                    for (int k = 0; k < maxCountTara2; k++) {
                        int tempSumm = i * arTaraSize[0] + j * arTaraSize[1] + k * arTaraSize[2];
                        taraSetOptions[countStrWRToArSumm][0] = i;
                        taraSetOptions[countStrWRToArSumm][1] = j;
                        taraSetOptions[countStrWRToArSumm][2] = k;
                        taraSetOptions[countStrWRToArSumm][3] = tempSumm;
                        taraSetOptions[countStrWRToArSumm][4] = goodCount - tempSumm;

/*                       System.out.println(countStrWRToArSumm + " | " + taraSetOptions[countStrWRToArSumm][0] + " | " + taraSetOptions[countStrWRToArSumm][1] + " | "
                                + taraSetOptions[countStrWRToArSumm][2] + " | " + taraSetOptions[countStrWRToArSumm][3] + " | "
                                + taraSetOptions[countStrWRToArSumm][4]);*/

                        if (taraSetOptions[countStrWRToArSumm][4] == 0) {
                            countTaraSetsR0++;
                        } else if (taraSetOptions[countStrWRToArSumm][4] == -1) {
                            countTaraSetsR1++;
                        }
                        countStrWRToArSumm++;
                    }
                }
            }

            int lengthTaraSetOptionsR0 = 0;
            int n = -1;

            if (countTaraSetsR0 > 0) {
                lengthTaraSetOptionsR0 = countTaraSetsR0;
                n = 0;
            } else if (countTaraSetsR1 > 0) {
                lengthTaraSetOptionsR0 = countTaraSetsR1;
                n = 1;
            } else {
                System.out.println("Ooops");
            }

            int countStrTaraSetOptionsR0 = 0;
            int taraSetOptionsR0[][] = new int[lengthTaraSetOptionsR0][5];

            for (int i = 0; i < taraSetOptions.length; i++) {
                if (taraSetOptions[i][4] == n) {
                    taraSetOptionsR0[countStrTaraSetOptionsR0][0] = taraSetOptions[i][0];
                    taraSetOptionsR0[countStrTaraSetOptionsR0][1] = taraSetOptions[i][1];
                    taraSetOptionsR0[countStrTaraSetOptionsR0][2] = taraSetOptions[i][2];
                    taraSetOptionsR0[countStrTaraSetOptionsR0][3] = taraSetOptions[i][3];
                    taraSetOptionsR0[countStrTaraSetOptionsR0][4] = taraSetOptions[i][4];

/*                    System.out.println(countStrTaraSetOptionsR0 + " | " + taraSetOptionsR0[countStrTaraSetOptionsR0][0] +
                            " | " + taraSetOptionsR0[countStrTaraSetOptionsR0][1] + " | "
                            + taraSetOptionsR0[countStrTaraSetOptionsR0][2] + " | " + taraSetOptionsR0[countStrTaraSetOptionsR0][3] + " | "
                            + taraSetOptionsR0[countStrTaraSetOptionsR0][4]);*/

                    countStrTaraSetOptionsR0++;
                }
            }
            taraCount0 = (double) taraSetOptionsR0[taraSetOptionsR0.length -1][0];
            taraCount1 = (double) taraSetOptionsR0[taraSetOptionsR0.length -1][1];
            taraCount2 = (double) taraSetOptionsR0[taraSetOptionsR0.length -1][2];

        }

        Double taraData[][] = {{taraCount0, arTaraPrices[0],(double)arTaraSize[0]},
                                {taraCount1, arTaraPrices[1],(double)arTaraSize[1]},
                                {taraCount2, arTaraPrices[2],(double)arTaraSize[2]}};
        return taraData;

    }

     protected static Double chekDiscount(Double totalTaraPrice, Integer goodCount, Double goodPrice){
        Double discount = 0.0;
        Double goodsPrice = goodCount * goodPrice;
        Double taraPricePerсent = totalTaraPrice / goodsPrice * 100;

        if (goodsPrice > 100){
            discount = discontByGoodsSumm;
        } else if (goodCount > 5 && taraPricePerсent < 3){
            discount = 3.0;
        } else {}

        return discount;

    }


}
