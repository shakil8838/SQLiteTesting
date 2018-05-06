package com.example.sqlitetesting.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sqlitetesting.R;
import com.example.sqlitetesting.dataprovider.ListDataProvider;

import java.util.List;

/**
 * Created by Anonymous on 5/6/2018.
 */
public class TheListAdapter extends BaseAdapter {

    List<ListDataProvider> dataProviderList;
    Context context;

    public TheListAdapter() {}

    public TheListAdapter(Context context) {
        this.context = context;
    }

    public TheListAdapter(List<ListDataProvider> dataProviderList, Context context) {
        this.dataProviderList = dataProviderList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return dataProviderList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.single_items, parent, false);

            TextView titleView = (TextView) convertView.findViewById(R.id.titleView);
            TextView detailsView = (TextView) convertView.findViewById(R.id.detailsView);

            titleView.setText(dataProviderList.get(position).getTitles());
            detailsView.setText(dataProviderList.get(position).getDetails());
        }
        return convertView;
    }
}
