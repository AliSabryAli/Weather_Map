package com.ali.weathermap.data.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ali.weathermap.R;
import com.ali.weathermap.modle.Forecast;

import java.util.List;

import butterknife.BindView;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ViewHolder> {
    List<Forecast> forecasts;

    public ForecastAdapter(List<Forecast> forecasts) {
        this.forecasts = forecasts;
    }

    @Override
    public ForecastAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater
                .from(viewGroup.getContext()).inflate(R.layout.day_row, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ForecastAdapter.ViewHolder viewHolder, int i) {
        Forecast forecast = forecasts.get(i);

    }

    @Override
    public int getItemCount() {
        return forecasts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvCardDateId)
        TextView tvDate;
        @BindView(R.id.tvCardTempId)
        TextView tvTemp;
        @BindView(R.id.imgCardImageId)
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
