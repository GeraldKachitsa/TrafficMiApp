package com.example.trafficmi;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.trafficmi.Model.VehicleTheftReport;
import com.example.trafficmi.Views.BarcodeScanner;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ReportVehicleTheft extends AppCompatActivity {


    //Progress bar
    //    ProgressBar progressBar;
    //    int count = 0;
    //    Timer timer;
    private ProgressBar progressBar;
    private int i = 0;
    private Handler hdlr = new Handler();

    //toolBar
    Toolbar vehicleTheftToolBar;
    FusedLocationProviderClient fusedLocationProviderClient;

    TextInputEditText carName;
    TextInputEditText carMake;
    TextInputEditText carColor;
    // TextInputEditText vehicleRegNumber;
    TextInputEditText vehicle_blue_book;
    EditText locationTheft;
    EditText vehicleTheftDescription;
    Button reportTheftBtn;
    Button searchBtn;
    RadioGroup radioGroupSex;
    RadioButton radioSexButton;
    RecyclerView recyclerView;
    TextInputEditText edVehicleLicence;
    String lat, lon;


    //FirebaseDatabase
    FirebaseDatabase root;
    DatabaseReference referenci;

    @SuppressLint("VisibleForTests")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_vehicle_theft);

//        //Initializations
        carName = (TextInputEditText) findViewById(R.id.car_name);
        carMake = (TextInputEditText) findViewById(R.id.car_make);
        carColor = (TextInputEditText) findViewById(R.id.car_color);
        //vehicleRegNumber = (TextInputEditText) findViewById(R.id.reg_num);
        vehicle_blue_book = (TextInputEditText) findViewById(R.id.blue_book);
        vehicleTheftDescription = (EditText) findViewById(R.id.otherOffenceDetails);
        reportTheftBtn = (Button) findViewById(R.id.reportTheftBtn);
        locationTheft = findViewById(R.id.locationTheft);
        radioGroupSex = findViewById(R.id.radioGroupSex);
        edVehicleLicence = findViewById(R.id.car_reg);


        //ProgressBar

        progressBar = (ProgressBar) findViewById(R.id.progressBar);


//        searchBtn = findViewById(R.id.action_search);
        recyclerView = findViewById(R.id.recycler_view_id);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 100);
        } else {
            new FusedLocationProviderClient(this).getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    if (location != null) {
                        lat = location.getLatitude() + "";
                        lon = location.getLongitude() + "";
                    }
                }
            });
        }


        //Tool bar

        vehicleTheftToolBar = (Toolbar) findViewById(R.id.vehicleTheftToolBar);

        //vehicleTheftToolBar.setTitle("VEHICLE THEFT");
        setSupportActionBar(vehicleTheftToolBar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        reportTheftBtn.setOnClickListener(v -> goToViewVehicleTheft());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.vehicle_theft_menu, menu);
        return true;
    }

    // Handling menu items events

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.log_out:
                startActivity(new Intent(this, LogIn.class));
                return true;
            case R.id.help:
                startActivity(new Intent(this, HelpCenter.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Do you want to Exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // if yes,Exit
                finish();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if No, cancel and continue
                dialog.cancel();

            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void goToViewVehicleTheft() {

        //radio buttons
        // get selected radio button from radioGroup
        int selectedId = radioGroupSex.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        radioSexButton = (RadioButton) findViewById(selectedId);


        String selectedSex = radioSexButton.getText().toString();


        //firebase Database

        root = FirebaseDatabase.getInstance();
        referenci = root.getReference();
        referenci = root.getReference("VehicleTheftReport");


        String fullNameCar = carName.getText().toString().trim();
        String makeOfCar = carMake.getText().toString().trim();
        String colorOfVehicle = carColor.getText().toString().trim();
        String regNumberOfVehicle = edVehicleLicence.getText().toString().trim();
        String CarOwner = vehicle_blue_book.getText().toString().trim();
        String accidentDescription = vehicleTheftDescription.getText().toString().trim();
        String location = locationTheft.getText().toString().trim();


        if (fullNameCar.isEmpty() || makeOfCar.isEmpty()
                ||
                colorOfVehicle.isEmpty() || regNumberOfVehicle.isEmpty()
                || CarOwner.isEmpty() || accidentDescription.isEmpty() || location.isEmpty()

        ) {

            Toast.makeText(this, "Input validation error", Toast.LENGTH_SHORT).show();
        } else {

            if(lat == null && lon == null){
                lat = "";
                lon = "";
            }
            VehicleTheftReport vehicleTheftReport = new VehicleTheftReport(regNumberOfVehicle, fullNameCar, makeOfCar, colorOfVehicle, CarOwner, accidentDescription, selectedSex, location, lat, lon);
            referenci.child(String.valueOf(System.currentTimeMillis())).setValue(vehicleTheftReport);

            //ProgressBar
//
            progressBar.setVisibility(View.VISIBLE);

            i = progressBar.getProgress();
            new Thread(new Runnable() {
                public void run() {
                    while (i < 100) {
                        i += 1;
                        // Update the progress bar and display the current value in text view
                        hdlr.post(new Runnable() {
                            public void run() {
                                progressBar.setProgress(i);
                                //txtView.setText(i+"/"+ progressBar.getMax());

                            }
                        });
                        try {
                            // Sleep for 100 milliseconds to show the progress slowly.
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    progressBar.setVisibility(View.INVISIBLE);

                }
            }).start();


            Toast.makeText(getApplicationContext(), "Reported Successfully...", Toast.LENGTH_LONG).show();

            carName.setText("");
            carMake.setText("");
            carColor.setText("");
            edVehicleLicence.setText("");
            vehicle_blue_book.setText("");
            vehicleTheftDescription.setText("");


        }


    }


}
