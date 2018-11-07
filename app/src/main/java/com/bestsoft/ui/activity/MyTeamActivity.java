package com.bestsoft.ui.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bestsoft.R;
import com.bestsoft.base.BaseActivity;
import com.bestsoft.bean.PotentialFanModel;
import com.bestsoft.ui.adapter.PotentialFanAdapter;
import com.bestsoft.utils.ChartUtils;
import com.bestsoft.utils.RecyclerViewUtils;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的团队
 */
public class MyTeamActivity extends BaseActivity {


    @BindView(R.id.line_chart)
    LineChart lineChart;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private PotentialFanAdapter potentialFanAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_my_team;
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.titleBar(R.id.toolbar)
                .statusBarDarkFont(true, 0.2f)
                .init();
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        txtTitle.setText(mContext.getString(R.string.title_my_team));
        toolbar.setBackground(ContextCompat.getDrawable(mContext, R.drawable.bg_toolbar));
        ChartUtils.initChart(lineChart);
        ChartUtils.notifyDataSetChanged(lineChart, getData());
        potentialFanAdapter = new PotentialFanAdapter(R.layout.item_potential_fan);
        RecyclerViewUtils.initLinerLayoutRecyclerView(recyclerView, mContext);
        recyclerView.setAdapter(potentialFanAdapter);
        initData();
    }

    private void initData() {
        List<PotentialFanModel> modelList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            modelList.add(new PotentialFanModel());
        }
        potentialFanAdapter.setNewData(modelList);
    }

    private List<Entry> getData() {
        List<Entry> values = new ArrayList<>();
        values.add(new Entry(0, 15, "08-1"));
        values.add(new Entry(1, 15, "08-1"));
        values.add(new Entry(2, 15, "08-1"));
        values.add(new Entry(3, 20, "08-1"));
        values.add(new Entry(4, 25, "08-1"));
        values.add(new Entry(5, 20, "08-1"));
        values.add(new Entry(6, 20, "08-1"));
        return values;
    }


    @OnClick(R.id.img_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
