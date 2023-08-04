package com.example.alsaunofficial.Models;

import static android.provider.Settings.System.DATE_FORMAT;

import android.content.Context;
import android.util.Log;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Journey implements Serializable {
    private final String TAG = getClass().getCanonicalName();

    private int index;
    private String arrivalDate;
    private String departureDate;
    private String returnDate;
    private String arrivalDataToFilter;
    private String departureDataToFilter;
    private String arrivalTime;
    private String departureTime;
    private String arrivalStrGeneral;
    private String departureStrGeneral;
    private String departureStrLong;
    private String destinationName;
    private String destinationId;
    private String originName;
    private String originId;
    private List<String> serviceTypeList;
    private List<String> serviceTypeDescList;
    private Integer numberPMRSeats;
    private String handicappedAvailability;
    private String petAvailability;
    private String sportAvailability;
    private String contiguousPaxAvailability;
    private Integer transfersNumber;
    private List<Fare> fares;
    private String warning;
    private String serviceCodes;
    private Boolean canBeSold;
    private String showShippingCompanyAlert;
    private String shippingCompanyCode;
    private String shippingCompanyName;
    private String observations;
    private BusCharacteristic busCharacteristic;
    private Integer takes;
    private List<Object> transfersTown; // Which object? (We don't know yet)
    private String totalNumberOfStops;
    private String companyService;
    private String product;
    private Boolean hideVoucherBONM;

    public Journey() {}

    public Journey(String departureDate, String destinationId, String originId) {
        this.departureDate = departureDate;
        this.destinationId = destinationId;
        this.originId = originId;
    }

    public Journey(Integer index, String arrivalDate, String departureDate, String returnDate,
                   String arrivalDataToFilter, String departureDataToFilter, String arrivalTime,
                   String departureTime, String arrivalStrGeneral, String departureStrGeneral,
                   String departureStrLong, String destinationName, String destinationId,
                   String originName, String originId, List<String> serviceTypeList,
                   List<String> serviceTypeDescList, Integer numberPMRSeats,
                   String handicappedAvailability, String petAvailability, String sportAvailability,
                   String contiguousPaxAvailability, Integer transfersNumber,List<Fare> fares,
                   String warning, String serviceCodes, Boolean canBeSold,
                   String showShippingCompanyAlert, String shippingCompanyCode,
                   String shippingCompanyName, String observations,
                   BusCharacteristic busCharacteristic, Integer takes, List<Object> transfersTown,
                   String totalNumberOfStops, String companyService, String product,
                   Boolean hideVoucherBONM) {
        this.index = index;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.arrivalDataToFilter = arrivalDataToFilter;
        this.departureDataToFilter = departureDataToFilter;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.arrivalStrGeneral = arrivalStrGeneral;
        this.departureStrGeneral = departureStrGeneral;
        this.departureStrLong = departureStrLong;
        this.destinationName = destinationName;
        this.destinationId = destinationId;
        this.originName = originName;
        this.originId = originId;
        this.serviceTypeList = serviceTypeList;
        this.serviceTypeDescList = serviceTypeDescList;
        this.numberPMRSeats = numberPMRSeats;
        this.handicappedAvailability = handicappedAvailability;
        this.petAvailability = petAvailability;
        this.sportAvailability = sportAvailability;
        this.contiguousPaxAvailability = contiguousPaxAvailability;
        this.transfersNumber = transfersNumber;
        this.fares = fares;
        this.warning = warning;
        this.serviceCodes = serviceCodes;
        this.canBeSold = canBeSold;
        this.showShippingCompanyAlert = showShippingCompanyAlert;
        this.shippingCompanyCode = shippingCompanyCode;
        this.shippingCompanyName = shippingCompanyName;
        this.observations = observations;
        this.busCharacteristic = busCharacteristic;
        this.takes = takes;
        this.transfersTown = transfersTown;
        this.totalNumberOfStops = totalNumberOfStops;
        this.companyService = companyService;
        this.product = product;
        this.hideVoucherBONM = hideVoucherBONM;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getArrivalDataToFilter() {
        return arrivalDataToFilter;
    }

    public void setArrivalDataToFilter(String arrivalDataToFilter) {
        this.arrivalDataToFilter = arrivalDataToFilter;
    }

    public String getDepartureDataToFilter() {
        return departureDataToFilter;
    }

    public void setDepartureDataToFilter(String departureDataToFilter) {
        this.departureDataToFilter = departureDataToFilter;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalStrGeneral() {
        return arrivalStrGeneral;
    }

    public void setArrivalStrGeneral(String arrivalStrGeneral) {
        this.arrivalStrGeneral = arrivalStrGeneral;
    }

    public String getDepartureStrGeneral() {
        return departureStrGeneral;
    }

    public void setDepartureStrGeneral(String departureStrGeneral) {
        this.departureStrGeneral = departureStrGeneral;
    }

    public String getDepartureStrLong() {
        return departureStrLong;
    }

    public void setDepartureStrLong(String departureStrLong) {
        this.departureStrLong = departureStrLong;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getOriginId() {
        return originId;
    }

    public void setOriginId(String originId) {
        this.originId = originId;
    }

    public List<String> getServiceTypeList() {
        return serviceTypeList;
    }

    public void setServiceTypeList(List<String> serviceTypeList) {
        this.serviceTypeList = serviceTypeList;
    }

    public List<String> getServiceTypeDescList() {
        return serviceTypeDescList;
    }

    public void setServiceTypeDescList(List<String> serviceTypeDescList) {
        this.serviceTypeDescList = serviceTypeDescList;
    }

    public Integer getNumberPMRSeats() {
        return numberPMRSeats;
    }

    public void setNumberPMRSeats(Integer numberPMRSeats) {
        this.numberPMRSeats = numberPMRSeats;
    }

    public String getHandicappedAvailability() {
        return handicappedAvailability;
    }

    public void setHandicappedAvailability(String handicappedAvailability) {
        this.handicappedAvailability = handicappedAvailability;
    }

    public String getPetAvailability() {
        return petAvailability;
    }

    public void setPetAvailability(String petAvailability) {
        this.petAvailability = petAvailability;
    }

    public String getSportAvailability() {
        return sportAvailability;
    }

    public void setSportAvailability(String sportAvailability) {
        this.sportAvailability = sportAvailability;
    }

    public String getContiguousPaxAvailability() {
        return contiguousPaxAvailability;
    }

    public void setContiguousPaxAvailability(String contiguousPaxAvailability) {
        this.contiguousPaxAvailability = contiguousPaxAvailability;
    }

    public Integer getTransfersNumber() {
        return transfersNumber;
    }

    public void setTransfersNumber(Integer transfersNumber) {
        this.transfersNumber = transfersNumber;
    }

    public List<Fare> getFares() {
        return fares;
    }

    public void setFares(List<Fare> fares) {
        this.fares = fares;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    public String getServiceCodes() {
        return serviceCodes;
    }

    public void setServiceCodes(String serviceCodes) {
        this.serviceCodes = serviceCodes;
    }

    public Boolean getCanBeSold() {
        return canBeSold;
    }

    public void setCanBeSold(Boolean canBeSold) {
        this.canBeSold = canBeSold;
    }

    public String getShowShippingCompanyAlert() {
        return showShippingCompanyAlert;
    }

    public void setShowShippingCompanyAlert(String showShippingCompanyAlert) {
        this.showShippingCompanyAlert = showShippingCompanyAlert;
    }

    public String getShippingCompanyCode() {
        return shippingCompanyCode;
    }

    public void setShippingCompanyCode(String shippingCompanyCode) {
        this.shippingCompanyCode = shippingCompanyCode;
    }

    public String getShippingCompanyName() {
        return shippingCompanyName;
    }

    public void setShippingCompanyName(String shippingCompanyName) {
        this.shippingCompanyName = shippingCompanyName;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public BusCharacteristic getBusCharacteristic() {
        return busCharacteristic;
    }

    public void setBusCharacteristic(BusCharacteristic busCharacteristic) {
        this.busCharacteristic = busCharacteristic;
    }

    public Integer getTakes() {
        return takes;
    }

    public void setTakes(Integer takes) {
        this.takes = takes;
    }

    public List<Object> getTransfersTown() {
        return transfersTown;
    }

    public void setTransfersTown(List<Object> transfersTown) {
        this.transfersTown = transfersTown;
    }

    public String getTotalNumberOfStops() {
        return totalNumberOfStops;
    }

    public void setTotalNumberOfStops(String totalNumberOfStops) {
        this.totalNumberOfStops = totalNumberOfStops;
    }

    public String getCompanyService() {
        return companyService;
    }

    public void setCompanyService(String companyService) {
        this.companyService = companyService;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Boolean isHideVoucherBONM() {
        return hideVoucherBONM;
    }

    public void setHideVoucherBONM(boolean hideVoucherBONM) {
        this.hideVoucherBONM = hideVoucherBONM;
    }

    public String getTravelTime() {
        Locale locale = new Locale("ES-es");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm", locale);
        try {
            Date date1 = dateFormat.parse(departureDataToFilter);
            Date date2 = dateFormat.parse(arrivalDataToFilter);

            assert date1 != null;
            assert date2 != null;
            long durationInMillis = date2.getTime() - date1.getTime();
            long hours = TimeUnit.MILLISECONDS.toHours(durationInMillis);
            long minutes = TimeUnit.MILLISECONDS.toMinutes(durationInMillis) % 60;

            return String.format(locale, "%02d:%02d", hours, minutes);
        } catch (ParseException e) {
            Log.e(TAG, e.getMessage(), e);
        }

        return "Error";
    }

    public boolean isValidRequest() {
        return originId!=null && originName!=null && destinationId!=null && departureDate!=null;
    }
}
