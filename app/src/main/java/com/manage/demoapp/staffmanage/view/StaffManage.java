package com.manage.demoapp.staffmanage.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.qqtheme.framework.picker.OptionPicker;
import com.beardedhen.androidbootstrap.BootstrapButton;
import com.manage.demoapp.R;
import com.manage.demoapp.helper.PickerHelper;
import com.manage.demoapp.staffmanage.model.OrgAdapter;
import com.manage.demoapp.staffmanage.model.OrgConstants;
import com.manage.demoapp.staffmanage.model.SimpleStaffAdapter;
import com.manage.demoapp.staffmanage.model.StaffConstants;
import org.angmarch.views.NiceSpinner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StaffManage extends AppCompatActivity {
    @BindView(R.id.staffManage_back)
    ImageView back;
    @BindView(R.id.staffManage_list)
    ListView listView;
    @BindView(R.id.staffManage_type)
    NiceSpinner niceSpinner;
    @BindView(R.id.staffManage_new)
    BootstrapButton add;

    private boolean flag = true;

    private OrgAdapter orgAdapter;
    private SimpleStaffAdapter simpleStaffAdapter;
    private OptionPicker picker;
    private String[] itemOptions = {"编辑", "删除"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_manage);
        ButterKnife.bind(this);

        orgAdapter = new OrgAdapter(OrgConstants.orgs(), this);
        listView.setAdapter(orgAdapter);
        List<String> dataset = new LinkedList<>(Arrays.asList("机构名称", "机构编码"));
        niceSpinner.attachDataSource(dataset);
        picker = new OptionPicker(this, itemOptions);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        rebind(listView);
    }

    @Override
    public void onBackPressed() {
        if (flag) {
            finish();
        } else {
            listView.setAdapter(orgAdapter);
            add.setVisibility(View.INVISIBLE);
            flag = true;
            rebind(listView);
            List<String> dataset = new LinkedList<>(Arrays.asList("机构名称", "机构编码"));
            niceSpinner.attachDataSource(dataset);
            add.setVisibility(View.INVISIBLE);
        }
    }

    private void rebind(final ListView listView) {
        if (flag) {
            add.setVisibility(View.INVISIBLE);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    simpleStaffAdapter = new SimpleStaffAdapter(StaffConstants.simpleStaff(), StaffManage.this);
                    flag = false;
                    listView.setAdapter(simpleStaffAdapter);
                    rebind(listView);
                    List<String> dataset = new LinkedList<>(Arrays.asList("姓名", "工号"));
                    niceSpinner.attachDataSource(dataset);

                }
            });

        } else {
            add.setVisibility(View.VISIBLE);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    PickerHelper.show(picker, new PickerHelper.CallBack() {
                        @Override
                        public void onPicked(int position, String option) {

                        }
                    });
                }
            });
        }
    }
}
