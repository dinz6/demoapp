package com.manage.demoapp.workordermanage.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.manage.demoapp.R;

import java.util.List;

public class OrderAdapter extends BaseAdapter {

    private List<Order> list;
    private LayoutInflater layoutInflater;

    public OrderAdapter(List<Order> list, Context context) {
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = layoutInflater.inflate(R.layout.order_item, null);

        return v;
    }
}
