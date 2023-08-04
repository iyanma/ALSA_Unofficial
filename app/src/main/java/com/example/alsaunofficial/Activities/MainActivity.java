package com.example.alsaunofficial.Activities;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alsaunofficial.Database.OriginsHelper;
import com.example.alsaunofficial.Models.Journey;
import com.example.alsaunofficial.Models.Origin;
import com.example.alsaunofficial.R;
import com.example.alsaunofficial.ViewModels.ListJourneysViewModel;

import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getCanonicalName();
    public static final String PARAMS_JOURNEY = "paramsJourney";
    public static final String PASSENGERS = "passengers";

    private Button setDepartureDate;
    private Button viewMoreSettings;
    private LinearLayout moreSettings;
    private ImageView lessPassengerT1;
    private EditText passengerT1;
    private ImageView morePassengerT1;
    private ImageView lessPassengerT2;
    private EditText passengerT2;
    private ImageView morePassengerT2;
    private ImageView lessPassengerT3;
    private EditText passengerT3;
    private ImageView morePassengerT3;
    private ImageView lessPassengerT4;
    private EditText passengerT4;
    private ImageView morePassengerT4;
    private ImageView lessPassengerT5;
    private EditText passengerT5;
    private ImageView morePassengerT5;

    private ActivityResultLauncher<Intent> departureLauncher;
    private ActivityResultLauncher<Intent> destinationLauncher;

    private DatePickerDialog datePickerDialog = null;
    private final DatePickerDialog.OnDateSetListener onDepartureDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    paramsJourney.setDepartureDate(String.format(
                            new Locale("ES-es"),
                            "%02d/%02d/%d", dayOfMonth , ++month, year
                    ));
                    setDepartureDate.setText(paramsJourney.getDepartureDate());
                    setDepartureDate.setBackground(
                            AppCompatResources.getDrawable(
                                    MainActivity.this,
                                    R.drawable.tag_background
                            )
                    );
                }
            };

    private Journey paramsJourney;
    private int[] passengers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button departurePoint = this.findViewById(R.id.origin);
        Button destinationPoint = this.findViewById(R.id.destiny);
        setDepartureDate = this.findViewById(R.id.departure_date);
        Button searchJourneys = this.findViewById(R.id.search);
        viewMoreSettings = this.findViewById(R.id.view_more_settings);
        moreSettings = this.findViewById(R.id.more_settings);

        lessPassengerT1 = this.findViewById(R.id.less_passenger_t1);
        passengerT1 = this.findViewById(R.id.passenger_t1);
        morePassengerT1 = this.findViewById(R.id.more_passenger_t1);

        lessPassengerT2 = this.findViewById(R.id.less_passenger_t2);
        passengerT2 = this.findViewById(R.id.passenger_t2);
        morePassengerT2 = this.findViewById(R.id.more_passenger_t2);

        lessPassengerT3 = this.findViewById(R.id.less_passenger_t3);
        passengerT3 = this.findViewById(R.id.passenger_t3);
        morePassengerT3 = this.findViewById(R.id.more_passenger_t3);

        lessPassengerT4 = this.findViewById(R.id.less_passenger_t4);
        passengerT4 = this.findViewById(R.id.passenger_t4);
        morePassengerT4 = this.findViewById(R.id.more_passenger_t4);

        lessPassengerT5 = this.findViewById(R.id.less_passenger_t5);
        passengerT5 = this.findViewById(R.id.passenger_t5);
        morePassengerT5 = this.findViewById(R.id.more_passenger_t5);

        { // I need this to load the database the first time the app launches. I'm not sure why
            try {
                OriginsHelper originsHelper = new OriginsHelper(MainActivity.this);
                originsHelper.createDatabase();
            } catch (IOException ioe) {
                Log.e(TAG, "Could not create database.", ioe);
            }
        }

        if (savedInstanceState != null) {

            paramsJourney = (Journey) savedInstanceState
                    .getSerializable(PARAMS_JOURNEY);
            passengers = (int[]) savedInstanceState.getIntArray(PASSENGERS);

            assert paramsJourney != null;
            setDepartureDate.setText(paramsJourney.getDepartureDate());
            departurePoint.setText(paramsJourney.getOriginName());
            destinationPoint.setText(paramsJourney.getDestinationName());

            passengerT1.setText(passengers[0]);
            passengerT2.setText(passengers[1]);
            passengerT3.setText(passengers[2]);
            passengerT4.setText(passengers[3]);
            passengerT5.setText(passengers[4]);
        } else {
            paramsJourney = new Journey();
            passengers = new int[]{1,0,0,0,0};
        }

        departureLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent i = result.getData();
                        assert i != null;
                        Bundle b = i.getExtras();
                        assert b != null;
                        Origin o = (Origin) b.get(PickStation.ORIGIN_RESULT);
                        assert o != null;
                        paramsJourney.setOriginName(o.getName());
                        paramsJourney.setOriginId(o.getId());
                        departurePoint.setText(o.getName());
                    }
                }
        );
        destinationLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent i = result.getData();
                        assert i != null;
                        Bundle b = i.getExtras();
                        assert b != null;
                        Origin o = (Origin) b.get(PickStation.ORIGIN_RESULT);
                        assert o != null;
                        paramsJourney.setDestinationName(o.getName());
                        paramsJourney.setDestinationId(o.getId());
                        destinationPoint.setText(o.getName());
                    }
                }
        );

        datePickerDialog = new DatePickerDialog(
                MainActivity.this, onDepartureDateSetListener,
                2000,
                1,
                1
        );

        departurePoint.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, PickStation.class);
            departureLauncher.launch(i);
        });

        destinationPoint.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, PickStation.class);
            destinationLauncher.launch(i);
        });

        setDepartureDate.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            if (datePickerDialog!=null) {
                datePickerDialog.updateDate(
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                );
                datePickerDialog.setTitle(getString(R.string.choose_a_date));
                datePickerDialog.show();
            }
        });

        searchJourneys.setOnClickListener(v -> {
            if (!loadPassengers()) {
                Toast.makeText(
                        MainActivity.this,
                        R.string.no_customers,
                        Toast.LENGTH_SHORT
                ).show();
                return;
            }
            if (!paramsJourney.isValidRequest()) {
                Toast.makeText(
                        MainActivity.this,
                        R.string.missing_data,
                        Toast.LENGTH_SHORT
                ).show();
                return;
            }

            Intent i = new Intent(MainActivity.this, ListJourneys.class);
            i.putExtra(PARAMS_JOURNEY, paramsJourney);
            i.putExtra(PASSENGERS, passengers);
            startActivity(i);
        });

        viewMoreSettings.setOnClickListener(v -> {
            if (moreSettings.getVisibility()== View.VISIBLE) {
                moreSettings.setVisibility(View.GONE);
                ((TextView) v).setText(R.string.view_more);
            } else {
                moreSettings.setVisibility(View.VISIBLE);
                ((TextView) v).setText(R.string.view_less);
            }
        });

        lessPassengerT1.setOnClickListener(v -> increment(-1, passengerT1));
        lessPassengerT2.setOnClickListener(v -> increment(-1, passengerT2));
        lessPassengerT3.setOnClickListener(v -> increment(-1, passengerT3));
        lessPassengerT4.setOnClickListener(v -> increment(-1, passengerT4));
        lessPassengerT5.setOnClickListener(v -> increment(-1, passengerT5));

        morePassengerT1.setOnClickListener(v -> increment(1, passengerT1));
        morePassengerT2.setOnClickListener(v -> increment(1, passengerT2));
        morePassengerT3.setOnClickListener(v -> increment(1, passengerT3));
        morePassengerT4.setOnClickListener(v -> increment(1, passengerT4));
        morePassengerT5.setOnClickListener(v -> increment(1, passengerT5));
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putSerializable(PARAMS_JOURNEY, paramsJourney);
        outState.putIntArray(PASSENGERS, passengers);
        super.onSaveInstanceState(outState);
    }

    private int getEditTextNumber(EditText editText) {
        return Integer.parseInt(editText.getText().toString());
    }

    private void increment(int increment, EditText editText) {
        int number = getEditTextNumber(editText);
        int new_value = number + increment;
        editText.setText(String.valueOf(Math.max(new_value, 0)));
    }

    private boolean loadPassengers() {
        passengers[0] = getEditTextNumber(passengerT1);
        passengers[1] = getEditTextNumber(passengerT2);
        passengers[2] = getEditTextNumber(passengerT3);
        passengers[3] = getEditTextNumber(passengerT4);
        passengers[4] = getEditTextNumber(passengerT5);
        for (int i: passengers) { // Unfortunately I cant use streams here for compatibility reasons
            if (i>0) {
                return true;
            }
        }
        return false;
    }
}