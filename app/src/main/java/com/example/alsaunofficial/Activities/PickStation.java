package com.example.alsaunofficial.Activities;

import androidx.activity.ComponentActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.alsaunofficial.Adapters.OriginsAdapter;
import com.example.alsaunofficial.Database.OriginsHelper;
import com.example.alsaunofficial.Models.Origin;
import com.example.alsaunofficial.R;

import java.util.ArrayList;
import java.util.List;

public class PickStation extends AppCompatActivity {

    public static final String TAG = PickStation.class.getCanonicalName();
    public static final String ORIGIN_RESULT = "origin";

    private OriginsAdapter originsAdapter;

    private EditText searchStation;
    private ListView listStations;
    private Button comeBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_station);

        originsAdapter = new OriginsAdapter(
                PickStation.this,
                R.layout.origin_adapter_element,
                getOriginsFromDatabase()
        );

        searchStation = this.findViewById(R.id.search_station);
        listStations = this.findViewById(R.id.list_stations);
        comeBack = this.findViewById(R.id.come_back);

        searchStation.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                originsAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        listStations.setAdapter(originsAdapter);
        listStations.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Origin origin = (Origin) parent.getItemAtPosition(position);
                Intent i = new Intent();
                i.putExtra(ORIGIN_RESULT, origin);
                setResult(RESULT_OK, i);
                onBackPressed();
            }
        });

        comeBack.setOnClickListener(v -> onBackPressed());
    }

    public List<Origin> getOriginsFromDatabase() {
        try {
            OriginsHelper originsHelper = new OriginsHelper(PickStation.this);
            List<Origin> origins = originsHelper.getOriginsFromDatabase();
            originsHelper.close();
            return origins;
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
        }
        return new ArrayList<Origin>();
    }

}