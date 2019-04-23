package com.ali.weathermap.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ali.weathermap.Enviroment;
import com.ali.weathermap.R;
import com.ali.weathermap.data.network.ApiModel;
import com.ali.weathermap.data.network.ApiModelListener;
import com.ali.weathermap.data.network.Queries;
import com.ali.weathermap.data.network.entity.WeatherListResponse;
import com.ali.weathermap.modle.Weather;
import com.ali.weathermap.utils.NetworkUtils;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements MainMvpView {
    private final static String TAG = "Main Activity";

    @BindView(R.id.tvCityNameId)
    TextView tvCityName;
    @BindView(R.id.tvTempId)
    TextView tvTemp;
    @BindView(R.id.tvcloudsId)
    TextView tvCloudes;
    @BindView(R.id.tvHumidityId)
    TextView tvHumidity;
    @BindView(R.id.tvWindId)
    TextView tvWind;
    @BindView(R.id.tvPressureId)
    TextView tvPressure;
    @BindView(R.id.tvDateId)
    TextView tvDate;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.imgWeatherStateId)
    ImageView imageWeatherIcon;

    private MainPresenter presenter;
    private Map<String, Object> queries;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUi();
    }

    @Override
    public void setupUi() {
        ButterKnife.bind(this);
        Enviroment.configure();
        presenter = new MainPresenter(this);
        queries = Queries.getQueriesMap("London", "metric");
        presenter.requestDataFromServer(NetworkUtils.END_POINT_WEATHER, queries);
    }

    @Override
    public void displayDataToView(Weather weather) {
        presenter.requestImageFromServer(imageWeatherIcon, progressBar);
        tvCityName.setText(weather.getName());
        tvCloudes.setText(weather.getCloudiness());
        tvHumidity.setText(weather.getHumidity() + " %");
        tvPressure.setText(weather.getPressure() + " hpa");
        tvTemp.setText(weather.getTemp() + " °C");
        tvWind.setText(weather.getWind() + " m/s");
        tvDate.setText(weather.getDate());

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
