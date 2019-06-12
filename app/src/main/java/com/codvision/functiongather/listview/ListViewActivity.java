package com.codvision.functiongather.listview;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.codvision.functiongather.R;
import com.codvision.functiongather.listview.adapter.TextAdapter;
import com.codvision.functiongather.listview.bean.TextBean;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hdw on 2019/5/27 19:11
 * todo
 */
public class ListViewActivity extends AppCompatActivity {

    private SmartRefreshLayout srlList;

    private List<TextBean> textList;
    private TextAdapter textAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initView();
        initEvent();
        initRefresh();
        initJurisdiction();
    }




    private void initView() {
        ListView lvText = findViewById(R.id.lv_text);
        srlList = findViewById(R.id.srl_list);
        TextView tvNotice = findViewById(R.id.tv_notice_no_date);
        textList = new ArrayList<>();
        // initDate();
        textAdapter = new TextAdapter(this, R.layout.item_text, textList);
        lvText.setAdapter(textAdapter);
        lvText.setEmptyView(tvNotice);
        textAdapter.notifyDataSetChanged();
    }

    private void initDate() {
        textList.clear();
        TextBean textModel = new TextBean(1);
        textList.add(textModel);
        textModel = new TextBean(2);
        textList.add(textModel);
        textModel = new TextBean(3);
        textList.add(textModel);
        textModel = new TextBean(4);
        textList.add(textModel);
        textModel = new TextBean(5);
        textList.add(textModel);
        textModel = new TextBean(6);
        textList.add(textModel);
        textModel = new TextBean(7);
        textList.add(textModel);
        textModel = new TextBean(8);
        textList.add(textModel);
        textModel = new TextBean(9);
        textList.add(textModel);
    }

    private void initEvent() {

    }

    //下拉刷新，上拉加载
    private void initRefresh() {

        //设置 Header
        srlList.setRefreshHeader(new ClassicsHeader(this).setEnableLastTime(false).setFinishDuration(0));
        //设置 Footer
        srlList.setRefreshFooter(new ClassicsFooter(this).setFinishDuration(0));

        srlList.setEnableRefresh(true);

        srlList.setEnableAutoLoadmore(true);

        srlList.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        RefreshList(false);
                    }
                }, 1000);
            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        RefreshList(true);
                    }
                }, 1000);
            }
        });
    }

    private void RefreshList(Boolean up) {
        if (up) {
            initDate();
            srlList.finishRefresh();
        } else {
            textList.clear();
            srlList.finishLoadmore();
        }
        textAdapter.notifyDataSetChanged();
    }

    private void initJurisdiction() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
        } else {
            readContacts();
        }
    }

    private void readContacts() {
        Cursor cursor = null;
        try {
            cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    TextBean textModel = new TextBean(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))));
                    textList.add(textModel);
                }
                textAdapter.notifyDataSetChanged();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    readContacts();
                } else {
                    Toast.makeText(this, "You denied the permission", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }
}
