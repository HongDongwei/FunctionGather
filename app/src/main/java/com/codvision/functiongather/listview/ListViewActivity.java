package com.codvision.functiongather.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

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
    }


    private void initView() {
        ListView lvText = findViewById(R.id.lv_text);
        srlList = findViewById(R.id.srl_list);
        TextView tvNotice = findViewById(R.id.tv_notice_no_date);
        textList = new ArrayList<>();
        initDate();
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
}
