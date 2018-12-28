package com.manage.demoapp.staffmanage.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.manage.demoapp.R;
import com.manage.demoapp.organizationmanage.model.Organization;

import java.util.List;

public class OrgAdapter extends BaseAdapter {
    private List<Org> list;
    private LayoutInflater layoutInflater;

    public OrgAdapter(List<Org> list, Context context) {
        this.layoutInflater = LayoutInflater.from(context);
        this.list = list;
    }

    public List<Org> getList() {
        return list;
    }

    public void setList(List<Org> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Org getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = layoutInflater.inflate(R.layout.org_item_select, null);
        TextView name = v.findViewById(R.id.orgItem_Name);
        name.setText(getItem(position).getName());
        return v;
    }
}
