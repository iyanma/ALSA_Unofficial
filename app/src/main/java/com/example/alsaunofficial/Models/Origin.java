package com.example.alsaunofficial.Models;

import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Origin implements Serializable {
    private String id;
    private String name;
    private String provincecountryName;
    private String nameAutocomplete;
    private String icon;
    private boolean isMoveliaStop;
    private String simplifiedName;
    private List<Origin> stopsList;
    private String priority;
    private String nomovelia;
    private String airportName;

    public Origin() {}

    public Origin(String id, String name, String provincecountryName, String nameAutocomplete,
                  String icon, boolean isMoveliaStop, String simplifiedName, List<Origin> stopsList,
                  String priority, String nomovelia, String airportName) {
        this.id = id;
        this.name = name;
        this.provincecountryName = provincecountryName;
        this.nameAutocomplete = nameAutocomplete;
        this.icon = icon;
        this.isMoveliaStop = isMoveliaStop;
        this.simplifiedName = simplifiedName;
        this.stopsList = (stopsList==null)?new ArrayList<Origin>():stopsList;
        this.priority = priority;
        this.nomovelia = nomovelia;
        this.airportName = airportName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvincecountryName() {
        return provincecountryName;
    }

    public void setProvincecountryName(String provincecountryName) {
        this.provincecountryName = provincecountryName;
    }

    public String getNameAutocomplete() {
        return nameAutocomplete;
    }

    public void setNameAutocomplete(String nameAutocomplete) {
        this.nameAutocomplete = nameAutocomplete;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isMoveliaStop() {
        return isMoveliaStop;
    }

    public void setMoveliaStop(boolean moveliaStop) {
        isMoveliaStop = moveliaStop;
    }

    public String getSimplifiedName() {
        return simplifiedName;
    }

    public void setSimplifiedName(String simplifiedName) {
        this.simplifiedName = simplifiedName;
    }

    public List<Origin> getStopsList() {
        return stopsList;
    }

    public void setStopsList(List<Origin> stopsList) {
        this.stopsList = stopsList;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getNomovelia() {
        return nomovelia;
    }

    public void setNomovelia(String nomovelia) {
        this.nomovelia = nomovelia;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }
}
