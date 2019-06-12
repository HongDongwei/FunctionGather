package com.codvision.functiongather.util;

import android.content.Context;

/**
 * Created by hdw on 2019/5/28 18:42
 * todo
 */
public class ToastUtil {
    public int LONG = 1;
    public int SHORT = 0;
    private Context context;

    public ToastUtil(Context context) {
        this.context = context;
    }

    public void makeText(String str, int type) {
        if (type == 1) {
            android.widget.Toast.makeText(context, str, android.widget.Toast.LENGTH_LONG).show();
        } else {
            android.widget.Toast.makeText(context, str, android.widget.Toast.LENGTH_SHORT).show();
        }

    }
}
