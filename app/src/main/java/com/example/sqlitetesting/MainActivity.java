package com.example.sqlitetesting;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlitetesting.localdb.DBHelper;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button addBtn, viewAllBtn, exitBtn;
    EditText noteTitle, noteDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteTitle = (EditText) findViewById(R.id.noteTitle);
        noteDetails = (EditText) findViewById(R.id.noteDetails);

        addBtn = (Button) findViewById(R.id.addBtn);
        viewAllBtn = (Button) findViewById(R.id.viewAllBtn);
        exitBtn = (Button) findViewById(R.id.exitBtn);

        addBtn.setOnClickListener(this);
        viewAllBtn.setOnClickListener(this);
        exitBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.addBtn:

                if (noteTitle.getText().toString().isEmpty() || noteDetails.getText().toString().isEmpty()){

                    Toast.makeText(MainActivity.this, "Please enter values", Toast.LENGTH_SHORT).show();

                } else {

                    new DBHelper(this).insertDataIntoDB(

                            String.valueOf(noteTitle.getText()).trim(),     // adding title
                            String.valueOf(noteDetails.getText()).trim()    // adding details
                    );

                    Toast.makeText(MainActivity.this, "Note added successfully", Toast.LENGTH_SHORT).show();

                    noteTitle.setText("");      // clearing Title field
                    noteDetails.setText("");    // clearing details field
                }

                break;

            case R.id.viewAllBtn:

                Cursor cursor = new DBHelper(this).getDataFromDB();
                String titles = null;

                while (cursor.moveToNext()){
                    titles = cursor.getString(cursor.getColumnIndex("title_column"));
                }

                if (titles == null){

                    Toast.makeText(MainActivity.this, "There is no note found", Toast.LENGTH_SHORT).show();

                } else {

                    startActivity(new Intent(MainActivity.this, AllNotes.class));

                }

                break;

            case R.id.exitBtn:

                System.exit(0);
                break;
        }
    }
}
