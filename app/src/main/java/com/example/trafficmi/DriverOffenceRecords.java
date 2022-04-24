package com.example.trafficmi;

import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class DriverOffenceRecords {

    String driverName,
            licenseNumber,
            driverOffenceLocation,
            driverOffenceDescription,
            selectedSex,
            lat,longt;


    public DriverOffenceRecords(String driverName,
                                String licenseNumber,
                                String driverOffenceLocation,
                                String driverOffenceDescription,
                                String selectedSex,
                                String lat,
                                String longt) {
        this.driverName = driverName;
        this.licenseNumber = licenseNumber;
        this.driverOffenceLocation = driverOffenceLocation;
        this.driverOffenceDescription = driverOffenceDescription;
        this.selectedSex = selectedSex;
        this.lat = lat;
        this.longt = longt;
    }

    public DriverOffenceRecords(String driverName,
                                String driverOffenceLocation,
                                String driverOffenceDescription,
                                String selectedSex,
                                String lat,
                                String longt) {
        this.driverName = driverName;
        this.driverOffenceLocation = driverOffenceLocation;
        this.driverOffenceDescription = driverOffenceDescription;
        this.selectedSex = selectedSex;
        this.lat = lat;
        this.longt = longt;
    }


    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getDriverOffenceLocation() {
        return driverOffenceLocation;
    }

    public void setDriverOffenceLocation(String driverOffenceLocation) {
        this.driverOffenceLocation = driverOffenceLocation;
    }

    public String getDriverOffenceDescription() {
        return driverOffenceDescription;
    }

    public void setDriverOffenceDescription(String driverOffenceDescription) {
        this.driverOffenceDescription = driverOffenceDescription;
    }

    public String getSelectedSex() {
        return selectedSex;
    }

    public void setSelectedSex(String selectedSex) {
        this.selectedSex = selectedSex;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLongt() {
        return longt;
    }

    public void setLongt(String longt) {
        this.longt = longt;
    }
}
