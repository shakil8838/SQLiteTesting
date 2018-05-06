package com.example.sqlitetesting;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sqlitetesting.adapter.TheListAdapter;
import com.example.sqlitetesting.dataprovider.ListDataProvider;
import com.example.sqlitetesting.localdb.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class AllNotes extends AppCompatActivity {

    ListView noteLists;
    List<ListDataProvider> dataProviderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_notes);

        noteLists = (ListView) findViewById(R.id.noteLists);

        dataProviderList = new ArrayList<>();

        Cursor cursor = new DBHelper(this).getDataFromDB();

        while (cursor.moveToNext()){

            ListDataProvider listDataProvider = new ListDataProvider(
                    cursor.getString(cursor.getColumnIndex("title_column")),    // retrieving all titles
                    cursor.getString(cursor.getColumnIndex("details_column"))   // retieving all details
            );

            dataProviderList.add(listDataProvider);     // adding into list
        }

        TheListAdapter listAdapter = new TheListAdapter(
                dataProviderList,
                this
        );
        noteLists.setAdapter(listAdapter);

    }
}
