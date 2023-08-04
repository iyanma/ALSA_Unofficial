package com.example.alsaunofficial.ViewModels;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.alsaunofficial.Models.Journey;
import com.example.alsaunofficial.Models.JourneyResponse;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListJourneysViewModel extends CustomViewModel {

    private final String TAG = getClass().getCanonicalName();
    private MutableLiveData<JourneyResponse> journeyResponse;

    public LiveData<JourneyResponse> getJourneyResponse() {
        if (journeyResponse==null) {
            journeyResponse = new MutableLiveData<JourneyResponse>();
        }
        return journeyResponse;
    }

    public void searchJourneys(Journey journey, int[] passengers) {
        lazyLoad();

        String retDate = journey.getReturnDate();

        int total_passengers = 0;
        for (int i: passengers) {
            total_passengers += i;
        }

        Call<Void> call = alsaService.searchJourneys(
                "PurchasePortlet_WAR_Alsaportlet",
                "1",
                "normal",
                "view",
                "searchJourneysAction",
                "t1ym5b9O",
                "",
                "",
                "0",
                journey.getOriginName(),
                journey.getOriginId(),
                journey.getOriginName(),
                "false",
                journey.getDestinationId(),
                journey.getDestinationName(),
                "false",
                journey.getDepartureDate(),
                journey.getDepartureDate(),
                "",
                "",
                "",
                String.valueOf(passengers[0]),
                String.valueOf(passengers[3]),
                String.valueOf(passengers[4]),
                String.valueOf(passengers[1]),
                String.valueOf(passengers[2]),
                "",
                "",
                "",
                "",
                String.valueOf(total_passengers),
                "",
                "OUTWARD",
                "false",
                "false",
                "false",
                ""
        );

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(@NonNull Call<Void> call,
                                   @NonNull Response<Void> response) {
                if (response.isSuccessful()) {
                    listJourneys();
                } else {
                    Log.i(TAG, INVALID_RESPONSE);
                    respuesta.setValue(ERROR_RED);
                }
            }

            @Override
            public void onFailure(@NonNull Call<Void> call,
                                  @NonNull Throwable t) {
                isLoading.setValue(false);
                Log.i(TAG,t.getMessage(),t);
                respuesta.setValue(ERROR_RED);
            }
        });
    }

    public void searchJourneys(Journey journey) {
        searchJourneys(journey, new int[]{1,0,0,0,0});
    }

    private void listJourneys() {
        lazyLoad();

        Call<JourneyResponse> call = alsaService.getJourneysList();

        call.enqueue(new Callback<JourneyResponse>() {
            @Override
            public void onResponse(@NonNull Call<JourneyResponse> call,
                                   @NonNull Response<JourneyResponse> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    journeyResponse.setValue(response.body());
                } else {
                    Log.i(TAG, INVALID_RESPONSE);
                    respuesta.setValue(ERROR_RED);
                }
            }

            @Override
            public void onFailure(@NonNull Call<JourneyResponse> call, @NonNull Throwable t) {
                isLoading.setValue(false);
                Log.i(TAG,t.getMessage(),t);
                respuesta.setValue(ERROR_RED);
            }
        });
    }

    private String joinQueryParams(List<String> input) {
        if (input==null)
            return "";

        StringBuilder res = new StringBuilder("{");
        for (String s: input) {
            res.append(s).append(',');
        }
        res = new StringBuilder(res.substring(0, res.length() - 1));
        return res + "}";
    }
}
