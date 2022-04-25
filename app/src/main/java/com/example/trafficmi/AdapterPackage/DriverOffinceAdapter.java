package com.example.trafficmi.AdapterPackage;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trafficmi.DriverOffenceData;
import com.example.trafficmi.DriverOffenceRecords;
import com.example.trafficmi.R;

import java.util.ArrayList;

public class DriverOffinceAdapter extends RecyclerView.Adapter<DriverOffinceAdapter.ViewHolder> {
    ArrayList<DriverOffenceRecords> data;
    Context context;

    public DriverOffinceAdapter(Context context, ArrayList<DriverOffenceRecords> data ) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public DriverOffinceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.display_theft_cases_layout_model, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DriverOffinceAdapter.ViewHolder holder, int position) {
        DriverOffenceRecords driversOffenceModel= data.get(position);
        holder.disPayName.setText(driversOffenceModel.getDriverName());
        holder.lisenceNumber.setText(driversOffenceModel.getDriverOffenceDescription());
        holder.driverOffenceLocation.setText(driversOffenceModel.getDriverOffenceLocation());
        holder.lon.setText("Long: "+driversOffenceModel.getLongt());
        holder.lat.setText("Lat: "+driversOffenceModel.getLat());
        //getting driver offence data to cardView

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DriverOffenceData.class);
                intent.putExtra("driverName", driversOffenceModel.getDriverName().toString());
                intent.putExtra("driverSex", driversOffenceModel.getSelectedSex().toString());
                intent.putExtra("driverLicenseNumber", driversOffenceModel.getLicenseNumber());
                intent.putExtra("offenceDescription", driversOffenceModel.getDriverOffenceDescription().toString());
                //intent.putExtra("driverLatitude", driversOffenceModel.getLat().toString());
                intent.putExtra("driverLongitude", driversOffenceModel.getLongt().toString());
               // intent.putExtra("latitude", driversOffenceModel.getLat().toString());
                intent.putExtra("longitude", driversOffenceModel.getLongt().toString());

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public void filterList(ArrayList<DriverOffenceRecords> models){
        data = models;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView disPayName;
        TextView driverOffenceLocation, lat, lon;
        TextView lisenceNumber;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            disPayName = itemView.findViewById(R.id.year_of_make);
            driverOffenceLocation = itemView.findViewById(R.id.location_name);
            lisenceNumber = itemView.findViewById(R.id.car_name);
            lat = itemView.findViewById(R.id.tv_lat);
            lon = itemView.findViewById(R.id.tv_long);
        }
    }
}
