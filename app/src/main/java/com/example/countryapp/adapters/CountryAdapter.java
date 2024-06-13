package com.example.countryapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.countryapp.R;
import com.example.countryapp.model.CountryModel;
import com.example.countryapp.model.Result;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private ArrayList<CountryModel> countries;

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycleritem, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.ID.setText(countries.get(position).getCode());
        holder.NAME.setText(countries.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    //  viewholder
    class CountryViewHolder extends RecyclerView.ViewHolder{

        TextView ID;
        TextView NAME;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);

            ID = itemView.findViewById(R.id.ID);
            NAME = itemView.findViewById(R.id.NAME);
        }
    }

    public CountryAdapter(ArrayList<CountryModel> countries) {
        this.countries = countries;
    }
}
