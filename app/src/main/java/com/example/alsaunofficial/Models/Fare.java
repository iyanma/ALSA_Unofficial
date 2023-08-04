package com.example.alsaunofficial.Models;

import java.util.List;

public class Fare {
    private int index;
    private double openReturnPrice;
    private double price;
    private double grossPrice;
    private String fareType;
    private String fareName;
    private String fareTypeDescription;
    private String fareConditions;
    private String outwardReturnRequired;
    private boolean isPromoted;
    private boolean isAlsaPass;
    private boolean isVoucher;
    private List<Object> promotionCodeList;
    private List<Object> promotionCodeLadderList;
    private List<Object> promotionCodeConditionsShowList;
    private String involveChangeToNewTicket;
    private boolean isOriginal;
    private double priceOriginal;
    private boolean showConditions;
    private boolean promotionIsAppliedAllPassengers;

    public Fare() {}

    public Fare(int index, double openReturnPrice, double price, double grossPrice,
                String fareType, String fareName, String fareTypeDescription,
                String fareConditions, String outwardReturnRequired, boolean isPromoted,
                boolean isAlsaPass, boolean isVoucher, List<Object> promotionCodeList,
                List<Object> promotionCodeLadderList, List<Object> promotionCodeConditionsShowList,
                String involveChangeToNewTicket, boolean isOriginal, double priceOriginal,
                boolean showConditions, boolean promotionIsAppliedAllPassengers) {
        this.index = index;
        this.openReturnPrice = openReturnPrice;
        this.price = price;
        this.grossPrice = grossPrice;
        this.fareType = fareType;
        this.fareName = fareName;
        this.fareTypeDescription = fareTypeDescription;
        this.fareConditions = fareConditions;
        this.outwardReturnRequired = outwardReturnRequired;
        this.isPromoted = isPromoted;
        this.isAlsaPass = isAlsaPass;
        this.isVoucher = isVoucher;
        this.promotionCodeList = promotionCodeList;
        this.promotionCodeLadderList = promotionCodeLadderList;
        this.promotionCodeConditionsShowList = promotionCodeConditionsShowList;
        this.involveChangeToNewTicket = involveChangeToNewTicket;
        this.isOriginal = isOriginal;
        this.priceOriginal = priceOriginal;
        this.showConditions = showConditions;
        this.promotionIsAppliedAllPassengers = promotionIsAppliedAllPassengers;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public double getOpenReturnPrice() {
        return openReturnPrice;
    }

    public void setOpenReturnPrice(double openReturnPrice) {
        this.openReturnPrice = openReturnPrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getGrossPrice() {
        return grossPrice;
    }

    public void setGrossPrice(double grossPrice) {
        this.grossPrice = grossPrice;
    }

    public String getFareType() {
        return fareType;
    }

    public void setFareType(String fareType) {
        this.fareType = fareType;
    }

    public String getFareName() {
        return fareName;
    }

    public void setFareName(String fareName) {
        this.fareName = fareName;
    }

    public String getFareTypeDescription() {
        return fareTypeDescription;
    }

    public void setFareTypeDescription(String fareTypeDescription) {
        this.fareTypeDescription = fareTypeDescription;
    }

    public String getFareConditions() {
        return fareConditions;
    }

    public void setFareConditions(String fareConditions) {
        this.fareConditions = fareConditions;
    }

    public String getOutwardReturnRequired() {
        return outwardReturnRequired;
    }

    public void setOutwardReturnRequired(String outwardReturnRequired) {
        this.outwardReturnRequired = outwardReturnRequired;
    }

    public boolean isPromoted() {
        return isPromoted;
    }

    public void setPromoted(boolean promoted) {
        isPromoted = promoted;
    }

    public boolean isAlsaPass() {
        return isAlsaPass;
    }

    public void setAlsaPass(boolean alsaPass) {
        isAlsaPass = alsaPass;
    }

    public boolean isVoucher() {
        return isVoucher;
    }

    public void setVoucher(boolean voucher) {
        isVoucher = voucher;
    }

    public List<Object> getPromotionCodeList() {
        return promotionCodeList;
    }

    public void setPromotionCodeList(List<Object> promotionCodeList) {
        this.promotionCodeList = promotionCodeList;
    }

    public List<Object> getPromotionCodeLadderList() {
        return promotionCodeLadderList;
    }

    public void setPromotionCodeLadderList(List<Object> promotionCodeLadderList) {
        this.promotionCodeLadderList = promotionCodeLadderList;
    }

    public List<Object> getPromotionCodeConditionsShowList() {
        return promotionCodeConditionsShowList;
    }

    public void setPromotionCodeConditionsShowList(List<Object> promotionCodeConditionsShowList) {
        this.promotionCodeConditionsShowList = promotionCodeConditionsShowList;
    }

    public String getInvolveChangeToNewTicket() {
        return involveChangeToNewTicket;
    }

    public void setInvolveChangeToNewTicket(String involveChangeToNewTicket) {
        this.involveChangeToNewTicket = involveChangeToNewTicket;
    }

    public boolean isOriginal() {
        return isOriginal;
    }

    public void setOriginal(boolean original) {
        isOriginal = original;
    }

    public double getPriceOriginal() {
        return priceOriginal;
    }

    public void setPriceOriginal(double priceOriginal) {
        this.priceOriginal = priceOriginal;
    }

    public boolean isShowConditions() {
        return showConditions;
    }

    public void setShowConditions(boolean showConditions) {
        this.showConditions = showConditions;
    }

    public boolean isPromotionIsAppliedAllPassengers() {
        return promotionIsAppliedAllPassengers;
    }

    public void setPromotionIsAppliedAllPassengers(boolean promotionIsAppliedAllPassengers) {
        this.promotionIsAppliedAllPassengers = promotionIsAppliedAllPassengers;
    }
}
