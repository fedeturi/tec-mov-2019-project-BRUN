package com.theweatherguy;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.androdocs.httprequest.HttpRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class TodayWeatherFragment extends Fragment {

    String CITY = "cordoba,ar";
    String API = "ea5de5f1283375c9acd86e8c23d47f7d";
    private ProgressBar progressBar;
    private TextView minValueTextView;
    private TextView maxValueTextview;
    private TextView currentValueTextview;
    private TextView updatedAtTextview;
    private TextView todayConditiocnTextView;
    private TextView city;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Toast toast = Toast.makeText(getActivity(),getString(R.string.under_construction),Toast.LENGTH_SHORT);
        toast.show();

        View view = inflater.inflate(R.layout.fragment_today_weather, container, false);

        progressBar = view.findViewById(R.id.today_weather_progress_bar);
        minValueTextView = view.findViewById(R.id.today_min_value);
        maxValueTextview = view.findViewById(R.id.today_max_value);
        currentValueTextview = view.findViewById(R.id.today_current_value);
        updatedAtTextview = view.findViewById(R.id.updated_At_textview);
        todayConditiocnTextView = view.findViewById(R.id.location_textview_today_condition);
        city = view.findViewById(R.id.location_textview_city);


        new WeatherTask().execute();
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    class WeatherTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            /* Showing the ProgressBar, Making the main design GONE */
            progressBar.setVisibility(View.VISIBLE);
            minValueTextView.setText("-- ºC");
            maxValueTextview.setText("-- ºC");
            currentValueTextview.setText("-- ºC");
            updatedAtTextview.setText("Fetching data...");
            city.setText("--");
        }

        protected String doInBackground(String... args) {
            String response =
                    HttpRequest.excuteGet("https://api.openweathermap.org/data/2.5/weather?q=" + CITY + "&units=metric&appid=" + API);
            return response;
        }

        @Override
        protected void onPostExecute(String result) {


            try {
                JSONObject jsonObj = new JSONObject(result);
                JSONObject main = jsonObj.getJSONObject("main");
                JSONObject sys = jsonObj.getJSONObject("sys");
                JSONObject wind = jsonObj.getJSONObject("wind");
                JSONObject weather = jsonObj.getJSONArray("weather").getJSONObject(0);

                Long updatedAt = jsonObj.getLong("dt");
                String updatedAtText = "Updated at: " + new SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(new Date(updatedAt * 1000));
                String temp = main.getString("temp").subSequence(0, 2) + "°C";
                String tempMin = main.getString("temp_min").subSequence(0, 2) + "°C";
                String tempMax = main.getString("temp_max").subSequence(0, 2) + "°C";
                String weatherDescription = weather.getString("description");

                String address = jsonObj.getString("name") + ", " + sys.getString("country");


                /* Populating extracted data into our views */
                updatedAtTextview.setText(updatedAtText);
                todayConditiocnTextView.setText(weatherDescription.toUpperCase());
                currentValueTextview.setText(temp);
                minValueTextView.setText(tempMin);
                maxValueTextview.setText(tempMax);
                city.setText(address);

                /* Views populated, Hiding the loader, Showing the main design */
                progressBar.setVisibility(View.GONE);


            } catch (JSONException e) {
                progressBar.setVisibility(View.GONE);
                Toast toast = Toast.makeText(getActivity(), getString(R.string.couldnt_load_current), Toast.LENGTH_SHORT);
                toast.show();
            }

        }
    }

}
