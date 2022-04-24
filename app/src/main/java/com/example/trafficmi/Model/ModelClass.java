package com.example.trafficmi.Model;

public class ModelClass {
    String  carNameTheft,carOwnerTheft,sexTheft,carRegNumTheft,carYearOfMakeTheft,colorOfCarTheft,locationTheft,detailsOfTheft;
    String vehicleTheftDescription;

    public ModelClass(String carNameTheft, String carOwnerTheft, String sexTheft, String carRegNumTheft, String carYearOfMakeTheft, String colorOfCarTheft, String locationTheft) {
        this.carNameTheft = carNameTheft;
        this.carOwnerTheft = carOwnerTheft;
        this.sexTheft = sexTheft;
        this.carRegNumTheft = carRegNumTheft;
        this.carYearOfMakeTheft = carYearOfMakeTheft;
        this.colorOfCarTheft = colorOfCarTheft;
        this.locationTheft = locationTheft;
        this.vehicleTheftDescription = vehicleTheftDescription;
    }

    public String getCarNameTheft() {
        return carNameTheft;
    }

    public void setCarNameTheft(String carNameTheft) {
        this.carNameTheft = carNameTheft;
    }

    public String getCarOwnerTheft() {
        return carOwnerTheft;
    }

    public void setCarOwnerTheft(String carOwnerTheft) {
        this.carOwnerTheft = carOwnerTheft;
    }

    public String getSexTheft() {
        return sexTheft;
    }

    public void setSexTheft(String sexTheft) {
        this.sexTheft = sexTheft;
    }

    public String getCarRegNumTheft() {
        return carRegNumTheft;
    }

    public void setCarRegNumTheft(String carRegNumTheft) {
        this.carRegNumTheft = carRegNumTheft;
    }

    public String getCarYearOfMakeTheft() {
        return carYearOfMakeTheft;
    }

    public void setCarYearOfMakeTheft(String carYearOfMakeTheft) {
        this.carYearOfMakeTheft = carYearOfMakeTheft;
    }

    public String getColorOfCarTheft() {
        return colorOfCarTheft;
    }



    public void setColorOfCarTheft(String colorOfCarTheft) {
        this.colorOfCarTheft = colorOfCarTheft;
    }
    public String getLocationTheft() {
        return locationTheft;
    }

    public void setLocationTheft(String locationTheft) {
        this.locationTheft = locationTheft;
    }

    public String getDetailsOfTheft() {
        return detailsOfTheft;
    }

    public void setDetailsOfTheft(String detailsOfTheft) {
        this.detailsOfTheft = detailsOfTheft;
    }


    public String getVehicleTheftDescription() {

        return vehicleTheftDescription;
    }

    public void setVehicleTheftDescription(String vehicleTheftDescription) {
        this.vehicleTheftDescription = vehicleTheftDescription;
    }
}
