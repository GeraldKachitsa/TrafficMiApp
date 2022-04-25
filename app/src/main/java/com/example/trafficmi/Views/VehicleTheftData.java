package com.example.trafficmi.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.trafficmi.R;

import static android.view.View.GONE;


public class VehicleTheftData extends AppCompatActivity {
    TextView carNameTheft,carOwnerTheft,sexTheft,carRegNumTheft,carYearOfMakeTheft,colorOfCarTheft,locationTheft,detailsOfTheft ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_theft_data);
        carNameTheft= findViewById(R.id.carNameTheft);
        carOwnerTheft= findViewById(R.id.carOwnerTheft);
        sexTheft= findViewById(R.id.sexTheft);
        carRegNumTheft= findViewById(R.id.carRegNumTheft);
        carYearOfMakeTheft = findViewById(R.id.carYearOfMakeTheft);
        colorOfCarTheft = findViewById(R.id.colorOfCarTheft);
        locationTheft = findViewById(R.id.locationTheft);
        detailsOfTheft = findViewById(R.id.detailsOfTheft);
        Intent intent = getIntent();

        String regNumber = intent.getStringExtra("regNumber");
        carNameTheft.setText("Car Name :" + " " + " " + intent.getStringExtra("carNameTheft"));
        carOwnerTheft.setText("Owner of Car :" + " " + " " + intent.getStringExtra("carOwnerTheft"));
        sexTheft.setText("Sex :" + " " + " " + intent.getStringExtra("sexOfOwner"));
        carRegNumTheft.setText("Car Registration Number :" + "  " + regNumber);
        carYearOfMakeTheft.setText("Car Year of Make :" + " " + " " + intent.getStringExtra("carYearOfMakeTheft"));
        colorOfCarTheft.setText("Colour of Car :" + " " + " " + intent.getStringExtra("colorOfCarTheft"));
        locationTheft.setText("Location:" + " " + " " + intent.getStringExtra("locationTheft"));
        String d = intent.getStringExtra("detailsOfTheft");
        if(d==null){
            detailsOfTheft.setVisibility(GONE);
        }else {
            detailsOfTheft.setText("Vehicle Theft Details :" + " " + " " + intent.getStringExtra("detailsOfTheft"));
        }
    }
}