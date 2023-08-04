package com.example.alsaunofficial.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.alsaunofficial.Models.Fare;
import com.example.alsaunofficial.R;

import java.util.List;
import java.util.Locale;

public class FaresAdapter extends ArrayAdapter<Fare> {

    private static class ViewHolder {
        TextView fareName;
        TextView fareTypeDescription;
        TextView price;
    }

    public FaresAdapter(@NonNull Context context, int resource, @NonNull List<Fare> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView==null) {
            viewHolder = new ViewHolder();

            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.fares_adapter_element, parent, false);
            viewHolder.fareName = convertView.findViewById(R.id.fare_name);
            viewHolder.fareTypeDescription = convertView.findViewById(R.id.fare_type_description);
            viewHolder.price = convertView.findViewById(R.id.fare_price);

            parent.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) parent.getTag();
        }

        Fare fare = getItem(position);
        assert fare != null;
        viewHolder.fareName.setText(fare.getFareName());
        viewHolder.fareTypeDescription.setText(fare.getFareTypeDescription());
        viewHolder.price.setText(
                getContext().getResources().getString(R.string.price, fare.getPrice())
        );

        return convertView;
    }
}
