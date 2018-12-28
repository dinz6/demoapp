package com.manage.demoapp.staffmanage.model;

public class Org {
    private String name;
    private String id;

    public String getName() {
        return name;
    }

    Org(String id, String name) {
        this.name = name;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
