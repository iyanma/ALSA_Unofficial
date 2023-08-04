package com.example.alsaunofficial.Models;

import java.util.List;

public class BusCharacteristic {
    private List<Characteristic> characteristicList;
    private String guaranteedOwnBus;
    private boolean isDoubleDeckerBus;
    private boolean isComfortBus;
    private boolean isNightBus;
    private boolean isNonStopBus;
    private boolean isPMRSeatAvailable;
    private boolean isFreeVoucherApplyable;

    public BusCharacteristic() {}

    public BusCharacteristic(List<Characteristic> characteristicList, String guaranteedOwnBus,
                             boolean isDoubleDeckerBus, boolean isComfortBus, boolean isNightBus,
                             boolean isNonStopBus, boolean isPMRSeatAvailable,
                             boolean isFreeVoucherApplyable) {
        this.characteristicList = characteristicList;
        this.guaranteedOwnBus = guaranteedOwnBus;
        this.isDoubleDeckerBus = isDoubleDeckerBus;
        this.isComfortBus = isComfortBus;
        this.isNightBus = isNightBus;
        this.isNonStopBus = isNonStopBus;
        this.isPMRSeatAvailable = isPMRSeatAvailable;
        this.isFreeVoucherApplyable = isFreeVoucherApplyable;
    }

    public List<Characteristic> getCharacteristicList() {
        return characteristicList;
    }

    public void setCharacteristicList(List<Characteristic> characteristicList) {
        this.characteristicList = characteristicList;
    }

    public String getGuaranteedOwnBus() {
        return guaranteedOwnBus;
    }

    public void setGuaranteedOwnBus(String guaranteedOwnBus) {
        this.guaranteedOwnBus = guaranteedOwnBus;
    }

    public boolean isDoubleDeckerBus() {
        return isDoubleDeckerBus;
    }

    public void setDoubleDeckerBus(boolean doubleDeckerBus) {
        isDoubleDeckerBus = doubleDeckerBus;
    }

    public boolean isComfortBus() {
        return isComfortBus;
    }

    public void setComfortBus(boolean comfortBus) {
        isComfortBus = comfortBus;
    }

    public boolean isNightBus() {
        return isNightBus;
    }

    public void setNightBus(boolean nightBus) {
        isNightBus = nightBus;
    }

    public boolean isNonStopBus() {
        return isNonStopBus;
    }

    public void setNonStopBus(boolean nonStopBus) {
        isNonStopBus = nonStopBus;
    }

    public boolean isPMRSeatAvailable() {
        return isPMRSeatAvailable;
    }

    public void setPMRSeatAvailable(boolean PMRSeatAvailable) {
        isPMRSeatAvailable = PMRSeatAvailable;
    }

    public boolean isFreeVoucherApplyable() {
        return isFreeVoucherApplyable;
    }

    public void setFreeVoucherApplyable(boolean freeVoucherApplyable) {
        isFreeVoucherApplyable = freeVoucherApplyable;
    }
}
