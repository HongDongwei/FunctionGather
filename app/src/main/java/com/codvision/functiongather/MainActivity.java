package com.codvision.functiongather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.codvision.functiongather.citychoice.CityChoiceActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvCityChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniView();
        initEvent();
    }


    private void iniView() {
        tvCityChoice = findViewById(R.id.tv_city_choice);
    }

    private void initEvent() {
        tvCityChoice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_city_choice:
                Intent intent=new Intent(this, CityChoiceActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
