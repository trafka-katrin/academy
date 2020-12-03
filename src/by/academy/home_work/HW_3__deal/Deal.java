package by.academy.home_work.HW_3__deal;

public class Deal {
    private String dealDate;
    private Integer sellerId;
    private Integer buyerId;
    private Double dealSumm;
    private Boolean dealResult;


    public Deal(){
    }

    public String getDealDate() {
        return dealDate;
    }

    public void setDealDate(String dealDate) {
        this.dealDate = dealDate;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public Double getDealSumm() {
        return dealSumm;
    }

    public void setDealSumm(Double dealSumm) {
        this.dealSumm = dealSumm;
    }

    public Boolean getDealResult() {
        return dealResult;
    }

    public void setDealResult(Boolean dealResult) {
        this.dealResult = dealResult;
    }
}
