package com.example.alsaunofficial.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.alsaunofficial.Adapters.JourneysAdapter;
import com.example.alsaunofficial.Models.Journey;
import com.example.alsaunofficial.R;
import com.example.alsaunofficial.ViewModels.ListJourneysViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListJourneys extends AppCompatActivity {

    private static final String TAG = ListJourneys.class.getCanonicalName();

    private ProgressBar progressBar;
    private ListView listJourneys;
    private TextView noJourneys;
    private Button goBack;

    private Journey paramsJourney;
    private int[] passengers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_journeys);

        ListJourneysViewModel listJourneysViewModel =
                new ViewModelProvider(ListJourneys.this).get(ListJourneysViewModel.class);
        
        progressBar = this.findViewById(R.id.progress_bar);
        listJourneys = this.findViewById(R.id.journey_list);
        noJourneys = this.findViewById(R.id.no_journeys);
        goBack = this.findViewById(R.id.go_back);

        JourneysAdapter journeysAdapter = new JourneysAdapter(
                ListJourneys.this,
                R.layout.journey_adapter_element,
                new ArrayList<Journey>()
        );
        listJourneys.setAdapter(journeysAdapter);
        goBack.setOnClickListener(v -> onBackPressed());

        listJourneysViewModel.getJourneyResponse().observe(
                ListJourneys.this,
                v -> {
                    List<Journey> journeys = v.getJourneys();
                    progressBar.setVisibility(View.GONE);
                    if (journeys.size()>0){
                        journeysAdapter.updateData(v.getJourneys());
                        listJourneys.setVisibility(View.VISIBLE);
                    } else {
                        this.findViewById(R.id.no_journeys).setVisibility(View.VISIBLE);
                    }
                }
        );

        if (savedInstanceState==null) {
            paramsJourney = (Journey) Objects.requireNonNull(
                    getIntent().getExtras()).get(MainActivity.PARAMS_JOURNEY
            );
            passengers = Objects.requireNonNull(
                    getIntent().getExtras().getIntArray(MainActivity.PASSENGERS)
            );
        } else{
            paramsJourney = (Journey) savedInstanceState.get(MainActivity.PARAMS_JOURNEY);
        }
        assert paramsJourney != null;
        listJourneysViewModel.searchJourneys(paramsJourney, passengers);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putSerializable(MainActivity.PARAMS_JOURNEY, paramsJourney);
    }
}