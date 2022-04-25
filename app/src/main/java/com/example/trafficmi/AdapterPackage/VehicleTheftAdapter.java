package com.example.trafficmi.AdapterPackage;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trafficmi.Model.VehicleTheftReport;
import com.example.trafficmi.R;
import com.example.trafficmi.Views.VehicleTheftData;

import java.util.ArrayList;

public class VehicleTheftAdapter extends RecyclerView.Adapter<VehicleTheftAdapter.ViewHolder> {
    ArrayList<VehicleTheftReport>  arrayList;
    Context appContext;

    public VehicleTheftAdapter(Context appContext, ArrayList<VehicleTheftReport> arrayList) {
        this.arrayList = arrayList;
        this.appContext = appContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(appContext).inflate(R.layout.display_theft_cases_layout_model, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VehicleTheftReport vehicleTheftReport = arrayList.get(position);
        holder.carName.setText(vehicleTheftReport.getCarName());
        holder.locationName.setText(vehicleTheftReport.getLocation());
        holder.yearOfMake.setText(vehicleTheftReport.getCarMake());
        holder.lon.setText("Longitude: "+vehicleTheftReport.getLongitude());
        holder.lat.setText("Latitude : "+vehicleTheftReport.getLongitude());

        //Handling events to holder
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(appContext, VehicleTheftData.class);
                intent.putExtra("carNameTheft", vehicleTheftReport.getCarName());
                intent.putExtra("carOwnerTheft", vehicleTheftReport.getVehicle_blue_book());
                intent.putExtra("sexOfOwner", vehicleTheftReport.getSelectedSex());
                intent.putExtra("carYearOfMakeTheft", vehicleTheftReport.getCarMake());
                intent.putExtra("colorOfCarTheft", vehicleTheftReport.getCarColor());
                intent.putExtra("locationTheft", vehicleTheftReport.getLocation());
                intent.putExtra(" detailsOfTheft", vehicleTheftReport.getVehicleTheftDescription());
                intent.putExtra("regNumber", vehicleTheftReport.getVehicleRegNumber());

                appContext.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void filteredList(ArrayList<VehicleTheftReport> models){
        arrayList= models;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView yearOfMake;
        TextView locationName;
        TextView carName;
        TextView lat, lon;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            yearOfMake = itemView.findViewById(R.id.year_of_make);
            locationName = itemView.findViewById(R.id.location_name);
            carName = itemView.findViewById(R.id.car_name);
            lat = itemView.findViewById(R.id.tv_lat);
            lon = itemView.findViewById(R.id.tv_long);
        }
    }
}
