package com.codvision.functiongather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.codvision.functiongather.broadcast.BroadcastActivity;
import com.codvision.functiongather.citychoice.CityChoiceActivity;
import com.codvision.functiongather.listview.ListViewActivity;
import com.codvision.functiongather.util.IntentUtil;

/**
 * Created by hdw on 2019/5/27 19:11
 * todo
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvCityChoice;
    private TextView tvListView;
    private TextView tvNetworkChange;

    private IntentUtil intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniView();
        initEvent();
    }


    private void iniView() {
        intent = new IntentUtil(this);
        tvCityChoice = findViewById(R.id.tv_city_choice);
        tvListView = findViewById(R.id.tv_list_view);
        tvNetworkChange = findViewById(R.id.tv_network_change);
    }

    private void initEvent() {
        tvCityChoice.setOnClickListener(this);
        tvListView.setOnClickListener(this);
        tvNetworkChange.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_city_choice:
                intent.Intent(CityChoiceActivity.class);
                break;
            case R.id.tv_list_view:
                intent.Intent(ListViewActivity.class);
                break;
            case R.id.tv_network_change:
                intent.Intent(BroadcastActivity.class);
                break;
            default:
                break;
        }
    }
}
