package com.example.alsaunofficial.Models;

public class Voucher {
    private String voucherName;
    private String voucherType;
    private int voucherTripsNumber;
    private int voucherAvailableTrips;
    private double amount;
    private String dateFrom;
    private String dateTo;
    private String serviceType;
    private String serviceNameType;
    private String voucherNormalizedName;
    private String digitalVoucherType;
    private String digitalVoucherName;
    private double miles;
    private String service;
    private String company;
    private String validDays;
    private String withoutVoucherPrice;
    private boolean displayWithoutVoucherPrice;
    private String discountApply;
    private boolean changeEnabled;
    private int priority;
    private String qrFormat;
    private double unitaryPrice;
    private double unitaryPriceWithVoucher;
    private String fareName;
    private String observations;
    private double depositAmount;
    private String depositDevMinTrips;
    private String info;
    private String descInfo;

    public Voucher() {}

    public Voucher(String voucherName, String voucherType, int voucherTripsNumber,
                   int voucherAvailableTrips, double amount, String dateFrom, String dateTo,
                   String serviceType, String serviceNameType, String voucherNormalizedName,
                   String digitalVoucherType, String digitalVoucherName, double miles,
                   String service, String company, String validDays, String withoutVoucherPrice,
                   boolean displayWithoutVoucherPrice, String discountApply, boolean changeEnabled,
                   int priority, String qrFormat, double unitaryPrice,
                   double unitaryPriceWithVoucher, String fareName, String observations,
                   double depositAmount, String depositDevMinTrips, String info, String descInfo) {
        this.voucherName = voucherName;
        this.voucherType = voucherType;
        this.voucherTripsNumber = voucherTripsNumber;
        this.voucherAvailableTrips = voucherAvailableTrips;
        this.amount = amount;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.serviceType = serviceType;
        this.serviceNameType = serviceNameType;
        this.voucherNormalizedName = voucherNormalizedName;
        this.digitalVoucherType = digitalVoucherType;
        this.digitalVoucherName = digitalVoucherName;
        this.miles = miles;
        this.service = service;
        this.company = company;
        this.validDays = validDays;
        this.withoutVoucherPrice = withoutVoucherPrice;
        this.displayWithoutVoucherPrice = displayWithoutVoucherPrice;
        this.discountApply = discountApply;
        this.changeEnabled = changeEnabled;
        this.priority = priority;
        this.qrFormat = qrFormat;
        this.unitaryPrice = unitaryPrice;
        this.unitaryPriceWithVoucher = unitaryPriceWithVoucher;
        this.fareName = fareName;
        this.observations = observations;
        this.depositAmount = depositAmount;
        this.depositDevMinTrips = depositDevMinTrips;
        this.info = info;
        this.descInfo = descInfo;
    }

    public String getVoucherName() {
        return voucherName;
    }

    public void setVoucherName(String voucherName) {
        this.voucherName = voucherName;
    }

    public String getVoucherType() {
        return voucherType;
    }

    public void setVoucherType(String voucherType) {
        this.voucherType = voucherType;
    }

    public int getVoucherTripsNumber() {
        return voucherTripsNumber;
    }

    public void setVoucherTripsNumber(int voucherTripsNumber) {
        this.voucherTripsNumber = voucherTripsNumber;
    }

    public int getVoucherAvailableTrips() {
        return voucherAvailableTrips;
    }

    public void setVoucherAvailableTrips(int voucherAvailableTrips) {
        this.voucherAvailableTrips = voucherAvailableTrips;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceNameType() {
        return serviceNameType;
    }

    public void setServiceNameType(String serviceNameType) {
        this.serviceNameType = serviceNameType;
    }

    public String getVoucherNormalizedName() {
        return voucherNormalizedName;
    }

    public void setVoucherNormalizedName(String voucherNormalizedName) {
        this.voucherNormalizedName = voucherNormalizedName;
    }

    public String getDigitalVoucherType() {
        return digitalVoucherType;
    }

    public void setDigitalVoucherType(String digitalVoucherType) {
        this.digitalVoucherType = digitalVoucherType;
    }

    public String getDigitalVoucherName() {
        return digitalVoucherName;
    }

    public void setDigitalVoucherName(String digitalVoucherName) {
        this.digitalVoucherName = digitalVoucherName;
    }

    public double getMiles() {
        return miles;
    }

    public void setMiles(double miles) {
        this.miles = miles;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getValidDays() {
        return validDays;
    }

    public void setValidDays(String validDays) {
        this.validDays = validDays;
    }

    public String getWithoutVoucherPrice() {
        return withoutVoucherPrice;
    }

    public void setWithoutVoucherPrice(String withoutVoucherPrice) {
        this.withoutVoucherPrice = withoutVoucherPrice;
    }

    public boolean isDisplayWithoutVoucherPrice() {
        return displayWithoutVoucherPrice;
    }

    public void setDisplayWithoutVoucherPrice(boolean displayWithoutVoucherPrice) {
        this.displayWithoutVoucherPrice = displayWithoutVoucherPrice;
    }

    public String getDiscountApply() {
        return discountApply;
    }

    public void setDiscountApply(String discountApply) {
        this.discountApply = discountApply;
    }

    public boolean isChangeEnabled() {
        return changeEnabled;
    }

    public void setChangeEnabled(boolean changeEnabled) {
        this.changeEnabled = changeEnabled;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getQrFormat() {
        return qrFormat;
    }

    public void setQrFormat(String qrFormat) {
        this.qrFormat = qrFormat;
    }

    public double getUnitaryPrice() {
        return unitaryPrice;
    }

    public void setUnitaryPrice(double unitaryPrice) {
        this.unitaryPrice = unitaryPrice;
    }

    public double getUnitaryPriceWithVoucher() {
        return unitaryPriceWithVoucher;
    }

    public void setUnitaryPriceWithVoucher(double unitaryPriceWithVoucher) {
        this.unitaryPriceWithVoucher = unitaryPriceWithVoucher;
    }

    public String getFareName() {
        return fareName;
    }

    public void setFareName(String fareName) {
        this.fareName = fareName;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public String getDepositDevMinTrips() {
        return depositDevMinTrips;
    }

    public void setDepositDevMinTrips(String depositDevMinTrips) {
        this.depositDevMinTrips = depositDevMinTrips;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDescInfo() {
        return descInfo;
    }

    public void setDescInfo(String descInfo) {
        this.descInfo = descInfo;
    }
}

