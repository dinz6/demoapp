package com.manage.demoapp.staffmanage.model;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.manage.demoapp.R;

import java.util.List;

public class StaffDetailAdapter extends BaseAdapter {

    private List<StaffDetail> list;
    private LayoutInflater layoutInflater;

    public StaffDetailAdapter(List<StaffDetail> list, Context context) {
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
    }

    public List<StaffDetail> getList() {
        return list;
    }

    public void setList(List<StaffDetail> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public StaffDetail getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.staff_detail, null);
        TextView name = view.findViewById(R.id.staffDetail_name);
        TextView id = view.findViewById(R.id.staffDetail_id);
        TextView remark = view.findViewById(R.id.staffDetail_remark);
        TextView gender = view.findViewById(R.id.staffDetail_gender);
        TextView username = view.findViewById(R.id.staffDetail_username);
        TextView password = view.findViewById(R.id.staffDetail_password);
        ImageView show = view.findViewById(R.id.staffDetail_showPassword);
        TextView status = view.findViewById(R.id.staffDetail_status);
        StaffDetail detail = getItem(position);
        name.setText(detail.getName());
        id.setText("工号: " + detail.getId());
        remark.setText(detail.getRemark());
        username.setText(detail.getUsername());
        status.setText(detail.getStatus());
        gender.setText(detail.getGender());
        switch (detail.getStatus()) {
            case "审核通过":
                status.setTextColor(Color.rgb(60, 179, 113));
                break;
            case "待审核":
                status.setTextColor(Color.rgb(255, 127, 36));
        }
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (password.getText().toString().equals("******"))
                    password.setText(detail.getPassword());
                else
                    password.setText("******");
            }
        });

        return view;
    }
}
