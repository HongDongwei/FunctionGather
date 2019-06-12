package com.codvision.functiongather.util;

import android.content.Context;
import android.content.Intent;

import com.codvision.functiongather.citychoice.CityChoiceActivity;

/**
 * Created by hdw on 2019/5/28 18:53
 * todo
 */
public class IntentUtil {
    private Context context;

    public IntentUtil(Context context) {
        this.context = context;
    }

    public void Intent(Class c) {
        Intent intent = new Intent(context, c);
        context.startActivity(intent);
    }
}
