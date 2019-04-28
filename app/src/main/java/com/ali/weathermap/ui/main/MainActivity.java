package com.ali.weathermap.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ali.weathermap.Enviroment;
import com.ali.weathermap.R;
import com.ali.weathermap.data.network.Queries;
import com.ali.weathermap.modle.Weather;
import com.ali.weathermap.utils.NetworkUtils;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements MainMvpView {
    private final static String TAG = "Main Activity";

    @BindView(R.id.tvTempId)
    TextView tvTemp;
    @BindView(R.id.tvCloudsId)
    TextView tvCloudes;
    @BindView(R.id.tvHumidityId)
    TextView tvHumidity;
    @BindView(R.id.tvWindId)
    TextView tvWind;
    @BindView(R.id.tvDateId)
    TextView tvDate;
    @BindView(R.id.tvMaxTempId)
    TextView tvMaxTemp;
    @BindView(R.id.tvMinTempId)
    TextView tvMinTemp;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.imgWeatherStateId)
    ImageView imageWeatherIcon;
    @BindView(R.id.toolBarId)
    Toolbar toolbar;

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
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        presenter = new MainPresenter(this);
        queries = Queries.getQueriesMap("London", "metric");
        presenter.requestWeatherFromServer(NetworkUtils.END_POINT_WEATHER, queries);
        presenter.requestForecastFromServer(NetworkUtils.END_POINT_FORECAST, queries);
    }

    @Override
    public void displayDataToView(Weather weather) {
        presenter.requestImageFromServer(imageWeatherIcon, progressBar);
        toolbar.setTitle(weather.getName());
        tvCloudes.setText(weather.getCloudiness());
        tvHumidity.setText(weather.getHumidity() + " %");
        tvTemp.setText(weather.getTemp() + " °C");
        tvWind.setText(weather.getWind() + " m/s");
        tvMaxTemp.setText(weather.getMax() );
        tvMinTemp.setText(weather.getMin() );
        tvDate.setText(weather.getDate());

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
