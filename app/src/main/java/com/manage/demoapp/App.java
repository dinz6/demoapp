package com.manage.demoapp;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.manage.demoapp.organizationmanage.model.OrganizationBuilder;

import java.lang.ref.WeakReference;

/**
 * Create by peter
 * Date 2018-12-26  21:30
 * Description: 全局的Context
 */
public class App extends Application {
    private static final String APP = "app";
    public static final String ORGANIZATION_ID = "org_id";
    private static WeakReference<Context> context;
    private static SharedPreferences sp;
    @Override
    public void onCreate() {
        super.onCreate();
        context = new WeakReference<>(this.getApplicationContext());
        sp = this.getSharedPreferences(APP, MODE_PRIVATE);
        initSharedPreferences();


    }
    public static SharedPreferences getSharedPreferences(){
        return sp;
    }



    private void initSharedPreferences() {
        sp.edit().putInt(ORGANIZATION_ID,OrganizationBuilder.ID_INDEX).apply();
    }

    public static Context getContext(){
        return context.get();
    }


}
