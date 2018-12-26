package com.manage.demoapp.workordermanage.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.manage.demoapp.R;
import org.angmarch.views.NiceSpinner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class WorkOrderManage extends AppCompatActivity {
    @BindView(R.id.order_searchType)
    NiceSpinner niceSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_order_manage);
        ButterKnife.bind(this);
        List<String> dataset = new LinkedList<>(Arrays.asList("One", "Two", "Three", "Four", "Five"));
        niceSpinner.attachDataSource(dataset);
    }
}
