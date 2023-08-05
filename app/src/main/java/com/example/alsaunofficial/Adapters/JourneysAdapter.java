package com.example.alsaunofficial.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.alsaunofficial.Models.Fare;
import com.example.alsaunofficial.Models.Journey;
import com.example.alsaunofficial.R;

import java.util.List;

public class JourneysAdapter extends ArrayAdapter<Journey> {

    private static final String TAG = JourneysAdapter.class.getCanonicalName();

    static class JourneyHolder {
        TextView originName;
        TextView destinationName;
        TextView arrivalTime;
        TextView departureTime;
        TextView travelTime;
        TextView viewMore;
        TextView totalNumberOfStops;
        LinearLayout more;
        LinearLayout fares;
    }

    public JourneysAdapter(@NonNull Context context,
                           int resource,
                           @NonNull List<Journey> journeys) {
        super(context, resource, journeys);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        JourneyHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.journey_adapter_element,parent,false);

            viewHolder = new JourneyHolder();

            viewHolder.originName = convertView.findViewById(R.id.origin);
            viewHolder.destinationName = convertView.findViewById(R.id.destiny);
            viewHolder.departureTime = convertView.findViewById(R.id.departure_time);
            viewHolder.arrivalTime = convertView.findViewById(R.id.arrival_time);
            viewHolder.totalNumberOfStops = convertView.findViewById(R.id.total_number_of_stops);
            viewHolder.travelTime = convertView.findViewById(R.id.time);
            viewHolder.viewMore = convertView.findViewById(R.id.view_more);
            viewHolder.more = convertView.findViewById(R.id.more);
            viewHolder.fares = convertView.findViewById(R.id.fares);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (JourneyHolder) convertView.getTag();
            viewHolder.more.setVisibility(View.GONE); // This is necessary
            viewHolder.viewMore.setText(R.string.view_more);
        }

        Journey journey = getItem(position);
        assert journey != null;
        viewHolder.originName.setText(journey.getOriginName());
        viewHolder.destinationName.setText(journey.getDestinationName());
        viewHolder.departureTime.setText(journey.getDepartureTime());
        viewHolder.arrivalTime.setText(journey.getArrivalTime());
        viewHolder.totalNumberOfStops.setText(getContext().getResources().getString(
                R.string.stops_s, journey.getTotalNumberOfStops()
        ));
        viewHolder.travelTime.setText(getContext().getResources().getString(
                R.string.duration_s,
                journey.getTravelTime())
        );
        Log.i(TAG,journey.getTravelTime());

        viewHolder.viewMore.setOnClickListener(v -> {
            if (viewHolder.more.getVisibility() == View.GONE) {
                viewHolder.more.setVisibility(View.VISIBLE);
                viewHolder.viewMore.setText(R.string.view_less);
                if (viewHolder.fares.getChildCount()==0) {
                    fillFares(journey.getFares(), viewHolder.fares);
                }
            } else {
                viewHolder.more.setVisibility(View.GONE);
                viewHolder.viewMore.setText(R.string.view_more);
            }
        });

        return convertView;
    }

    public void updateData(List<Journey> journeys) {
        clear();
        addAll(journeys);
        notifyDataSetChanged();
    }

    static class FareHolder {
        TextView fareName;
        TextView fareTypeDescription;
        TextView farePrice;
    }

    private void fillFares(List<Fare> fares, ViewGroup parent) {
        for (Fare fare: fares) {
            View fareView = LayoutInflater.from(getContext()).inflate(
                    R.layout.fares_adapter_element,parent,false
            );
            FareHolder fareHolder;

            if (parent.getTag()==null) {
                fareHolder = new FareHolder();
                fareHolder.fareName = fareView.findViewById(R.id.fare_name);
                fareHolder.fareTypeDescription = fareView.findViewById(R.id.fare_type_description);
                fareHolder.farePrice = fareView.findViewById(R.id.fare_price);

                parent.setTag(fareHolder);
            } else {
                fareHolder = (FareHolder) parent.getTag();
            }

            fareHolder.fareName.setText(fare.getFareName());
            fareHolder.fareTypeDescription.setText(fare.getFareTypeDescription());
            fareHolder.farePrice.setText(getContext().getResources().getString(
                    R.string.price, fare.getPrice()
            ));

            parent.addView(fareView);
        }
    }

}
