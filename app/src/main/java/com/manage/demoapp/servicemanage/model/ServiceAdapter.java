package com.manage.demoapp.servicemanage.model;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.manage.demoapp.R;

import java.util.List;

public class ServiceAdapter extends BaseAdapter {
    private List<PensionService> list;
    private LayoutInflater layoutInflater;

    public ServiceAdapter(List<PensionService> list, Context context) {
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
    }

    public List<PensionService> getList() {
        return list;
    }

    public void setList(List<PensionService> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public PensionService getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        @SuppressLint("ViewHolder") View v = layoutInflater.inflate(R.layout.service_item, null);
        TextView name = v.findViewById(R.id.serviceItem_name);
        TextView detail = v.findViewById(R.id.serviceItem_detail);
        TextView fee = v.findViewById(R.id.serviceItem_fee);
        PensionService pensionService = getItem(position);
        name.setText(pensionService.getName());
        detail.setText(pensionService.getDetail());
        fee.setText(pensionService.getFee());
        return v;
    }
}
