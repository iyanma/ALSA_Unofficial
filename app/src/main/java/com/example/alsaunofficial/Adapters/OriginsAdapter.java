package com.example.alsaunofficial.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.alsaunofficial.Models.Origin;
import com.example.alsaunofficial.R;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OriginsAdapter extends ArrayAdapter<Origin> {
    private final List<Origin> originList;
    private final Filter originFilter;

    static class ViewHolder {
        TextView name;
        TextView provinceCountryName;
    }

    public OriginsAdapter(@NonNull Context context, int resource, @NonNull List<Origin> objects) {
        super(context, resource, objects);
        originList = new ArrayList<Origin>(objects);
        originFilter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                List<Origin> suggestions = new ArrayList<>();
                String filter = normalizeText(constraint.toString());

                if (constraint.length() == 0) {
                    suggestions.addAll(originList);
                } else {
                    for (Origin o : originList) {
                        String name = normalizeText(o.getName());
                        if (name.contains(filter)) {
                            suggestions.add(o);
                        }
                    }
                }

                results.values = suggestions;
                results.count = suggestions.size();

                return results;
            }

            private String normalizeText(String text) {
                if (text==null) {
                    return null;
                }
                String normalized = Normalizer.normalize(text, Normalizer.Form.NFKD);
                return normalized.replaceAll("\\p{M}", "")
                        .toLowerCase(Locale.ROOT);
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                @SuppressWarnings("unchecked")
                ArrayList<Origin> filteredList = (ArrayList<Origin>) results.values;
                if (results.count > 0) {
                    clear();
                    addAll(filteredList);
                    notifyDataSetChanged();
                }
            }

            @Override
            public CharSequence convertResultToString(Object resultValue) {
                return ((Origin)resultValue).getName();
            }
        };
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return originFilter;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.origin_adapter_element, parent, false);
            //TODO
            viewHolder = new ViewHolder();
            viewHolder.name = convertView.findViewById(R.id.name);
            viewHolder.provinceCountryName = convertView.findViewById(R.id.province_country_name);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Origin origin = getItem(position);

        assert origin != null;
        viewHolder.name.setText(origin.getName());
        viewHolder.provinceCountryName.setText(origin.getProvincecountryName());

        return convertView;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Nullable
    @Override
    public Origin getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }
}
