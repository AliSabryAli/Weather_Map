package com.ali.weathermap.ui.main;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ali.weathermap.Enviroment;
import com.ali.weathermap.R;
import com.ali.weathermap.data.adapter.ForecastAdapter;
import com.ali.weathermap.data.network.Queries;
import com.ali.weathermap.modle.Forecast;
import com.ali.weathermap.modle.Weather;
import com.ali.weathermap.utils.NetworkUtils;

import java.util.List;
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
    @BindView(R.id.recyclerViewId)
    RecyclerView recyclerView;
    private MainPresenter presenter;
    private Map<String, Object> queries;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private ForecastAdapter adapter;

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
        recyclerView.setHasFixedSize(true);

        staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.scrollToPosition(0);

        presenter = new MainPresenter(this);
        queries = Queries.getQueriesMap("london", "metric");
        presenter.requestWeatherFromServer(NetworkUtils.END_POINT_WEATHER, queries);
        presenter.requestForecastFromServer(NetworkUtils.END_POINT_FORECAST, queries);
    }

    @Override
    public void displayDataToView(Weather weather) {
        presenter.requestImageFromServer(imageWeatherIcon, progressBar, weather.getIcon());
        toolbar.setTitle(weather.getName());
        tvCloudes.setText(weather.getCloudiness());
        tvHumidity.setText(weather.getHumidity() + " %");
        tvTemp.setText(weather.getTemp() + " °C");
        tvWind.setText(weather.getWind() + " m/s");
        tvMaxTemp.setText(weather.getMax() + "°");
        tvMinTemp.setText(weather.getMin() + "°");
        tvDate.setText(weather.getDate());

    }

    @Override
    public void setDataToRecyclerView(List<Forecast> forecastList) {
        adapter = new ForecastAdapter(forecastList, presenter);
        recyclerView.setAdapter(adapter);
        Log.i(TAG, "setDataToRecyclerView: " + forecastList);
//            recyclerView.notify();
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

        final MenuItem searchItem = menu.findItem(R.id.miSearchId);
        final SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                searchView.clearFocus();
                searchItem.collapseActionView();
                queries = Queries.getQueriesMap(s, "metric");
                presenter.requestWeatherFromServer(NetworkUtils.END_POINT_WEATHER, queries);
                presenter.requestForecastFromServer(NetworkUtils.END_POINT_FORECAST, queries);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return true;
    }

    @Override
    public void showMsg(String msg) {
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
    }
}
