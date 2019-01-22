package com.example.kunwarviraj.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    ListView timeTableView;

    public void generateTable(int timesTable){

        ArrayList<String> tableContent = new ArrayList<String>(11);
        for (int i=1;i<11;i++)
        {
            tableContent.add(Integer.toString(i*timesTable));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,tableContent);
        timeTableView.setAdapter(arrayAdapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        timeTableView = (ListView) findViewById(R.id.tableList);

        seekBar.setMax(10);
        seekBar.setProgress(5);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                 int min=1;
                 int timesTable;
                 if (i<1)
                 {
                    timesTable =min;
                    seekBar.setProgress(timesTable);
                 }
                 else
                 {
                    timesTable=i;
                 }
                 Log.i("SeekBar Value",Integer.toString(timesTable));
                 generateTable(timesTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        generateTable(5);
    }


}
