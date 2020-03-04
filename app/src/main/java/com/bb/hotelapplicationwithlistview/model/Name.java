package com.bb.hotelapplicationwithlistview.model;

public class Name {

    private String prefix;
    private String name;

    public Name(String prefix, String name) {
        this.name = name;
        this.prefix = prefix;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
