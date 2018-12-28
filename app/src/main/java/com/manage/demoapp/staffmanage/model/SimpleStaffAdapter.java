package com.manage.demoapp.staffmanage.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.manage.demoapp.R;

import java.util.List;

public class SimpleStaffAdapter extends BaseAdapter {

    private List<SimpleStaff> list;
    private LayoutInflater layoutInflater;

    public SimpleStaffAdapter(List<SimpleStaff> list, Context context) {
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public SimpleStaff getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = layoutInflater.inflate(R.layout.staff_item_for_order, null);
        TextView name = v.findViewById(R.id.staff_item_name);
        TextView gender = v.findViewById(R.id.staff_item_gender);
        TextView positionText = v.findViewById(R.id.staff_item_position);
        TextView phone = v.findViewById(R.id.staff_item_phone);
        name.setText(getItem(position).getName());
        gender.setText(getItem(position).getGender());
        positionText.setText(getItem(position).getPosition());
        phone.setText(getItem(position).getPhone());
        return v;
    }
}
