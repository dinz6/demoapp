package com.manage.demoapp.servicemanage.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.manage.demoapp.R;

public class ServiceAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;

    public ServiceAdapter(Context context) {
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = layoutInflater.inflate(R.layout.service_item, null);
        return v;
    }
}
