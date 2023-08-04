package com.example.alsaunofficial.Models;

public class Characteristic {
    private String code;
    private String description;
    private String additionalInfo;

    public Characteristic() {}

    public Characteristic(String code, String description, String addictionalInfo) {
        this.code = code;
        this.description = description;
        this.additionalInfo = addictionalInfo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}