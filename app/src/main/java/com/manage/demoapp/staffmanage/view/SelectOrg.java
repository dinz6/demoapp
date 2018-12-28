package com.manage.demoapp.staffmanage.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.manage.demoapp.R;
import com.manage.demoapp.staffmanage.model.OrgAdapter;
import com.manage.demoapp.staffmanage.model.OrgConstants;
import org.angmarch.views.NiceSpinner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SelectOrg extends AppCompatActivity {
    @BindView(R.id.selectOrg_type)
    NiceSpinner niceSpinner;

    private OrgAdapter orgAdapter;
    @BindView(R.id.selectOrg_list)
    ListView listView;
    @BindView(R.id.selectOrder_back)
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_org);
        ButterKnife.bind(this);

        List<String> dataset = new LinkedList<>(Arrays.asList("机构名称", "机构编码"));
        niceSpinner.attachDataSource(dataset);

        orgAdapter = new OrgAdapter(OrgConstants.orgs(), this);

        listView.setAdapter(orgAdapter);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
