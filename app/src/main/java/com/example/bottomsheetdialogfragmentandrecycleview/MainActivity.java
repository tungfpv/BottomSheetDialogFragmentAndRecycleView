package com.example.bottomsheetdialogfragmentandrecycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnShow = findViewById(R.id.btn_show_bottom_sheet);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                MyBottomSheetFragment myBottomSheetFragment = new MyBottomSheetFragment();

                myBottomSheetFragment.show(getSupportFragmentManager(), myBottomSheetFragment.getTag());


            }
        });
    }

}