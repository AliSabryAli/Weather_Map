package com.ali.weathermap.data.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ali.weathermap.R;
import com.ali.weathermap.modle.Forecast;
import com.ali.weathermap.ui.main.MainPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ViewHolder> {
    private List<Forecast> forecasts;
    private MainPresenter presenter;

    public ForecastAdapter(List<Forecast> forecasts, MainPresenter presenter) {
        this.forecasts = forecasts;
        this.presenter = presenter;
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
        viewHolder.tvDateCard.setText(forecast.getDate());
        viewHolder.tvMaxTemp.setText(forecast.getMax());
        viewHolder.tvMinTemp.setText(forecast.getMin());
        viewHolder.tvDisc.setText(forecast.getDescription());
        presenter.requestImageFromServer(viewHolder.imgCard, viewHolder.progressCard, forecast.getIcon());
    }

    @Override
    public int getItemCount() {
        return forecasts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvCardDateId)
        TextView tvDateCard;
        @BindView(R.id.tvCardDiscId)
        TextView tvDisc;
        @BindView(R.id.progressBarCardId)
        ProgressBar progressCard;
        @BindView(R.id.tvCardMaxTempId)
        TextView tvMaxTemp;
        @BindView(R.id.tvCardMinTempId)
        TextView tvMinTemp;
        @BindView(R.id.imgCardImageId)
        ImageView imgCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
