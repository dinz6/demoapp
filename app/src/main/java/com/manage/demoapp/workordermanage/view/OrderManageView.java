package com.manage.demoapp.workordermanage.view;

import com.manage.demoapp.workordermanage.model.Order;

import java.util.List;

public interface OrderManageView {
    public void onSearchResult(List<Order> result);
}
