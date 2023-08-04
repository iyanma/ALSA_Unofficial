package com.example.alsaunofficial.Models;

import java.util.List;

public class JourneyResponse {
    private List<Journey> journeys;
    private int people;
    private boolean international;
    private String timestamp;
    private boolean isTrainTrip;
    private boolean isRoundTrip;
    private boolean isShipTrip;
    private int countCannotBeSold;
    private int countCanBeSold;
    private int carbonFootprint;
    private String redirectingMovelia;
    private boolean showMessageVoucherBONM;
    private List<Voucher> voucherList;

    // Getters and setters

    public List<Journey> getJourneys() {
        return journeys;
    }

    public void setJourneys(List<Journey> journeys) {
        this.journeys = journeys;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public boolean isInternational() {
        return international;
    }

    public void setInternational(boolean international) {
        this.international = international;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isTrainTrip() {
        return isTrainTrip;
    }

    public void setTrainTrip(boolean trainTrip) {
        isTrainTrip = trainTrip;
    }

    public boolean isRoundTrip() {
        return isRoundTrip;
    }

    public void setRoundTrip(boolean roundTrip) {
        isRoundTrip = roundTrip;
    }

    public boolean isShipTrip() {
        return isShipTrip;
    }

    public void setShipTrip(boolean shipTrip) {
        isShipTrip = shipTrip;
    }

    public int getCountCannotBeSold() {
        return countCannotBeSold;
    }

    public void setCountCannotBeSold(int countCannotBeSold) {
        this.countCannotBeSold = countCannotBeSold;
    }

    public int getCountCanBeSold() {
        return countCanBeSold;
    }

    public void setCountCanBeSold(int countCanBeSold) {
        this.countCanBeSold = countCanBeSold;
    }

    public int getCarbonFootprint() {
        return carbonFootprint;
    }

    public void setCarbonFootprint(int carbonFootprint) {
        this.carbonFootprint = carbonFootprint;
    }

    public String getRedirectingMovelia() {
        return redirectingMovelia;
    }

    public void setRedirectingMovelia(String redirectingMovelia) {
        this.redirectingMovelia = redirectingMovelia;
    }

    public boolean isShowMessageVoucherBONM() {
        return showMessageVoucherBONM;
    }

    public void setShowMessageVoucherBONM(boolean showMessageVoucherBONM) {
        this.showMessageVoucherBONM = showMessageVoucherBONM;
    }

    public List<Voucher> getVoucherList() {
        return voucherList;
    }

    public void setVoucherList(List<Voucher> voucherList) {
        this.voucherList = voucherList;
    }
}
