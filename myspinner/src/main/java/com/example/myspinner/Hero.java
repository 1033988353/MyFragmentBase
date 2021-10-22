package com.example.myspinner;


public class Hero {

    private int Icon;
    private String Name;

    public int getIcon() {
        return Icon;
    }

    public void setIcon(int icon) {
        Icon = icon;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Hero() {
    }

    public Hero(int hIcon, String hName) {
        this.Icon = hIcon;
        this.Name = hName;
    }

}
