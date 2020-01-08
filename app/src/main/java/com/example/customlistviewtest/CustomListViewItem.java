package com.example.customlistviewtest;

import android.graphics.drawable.Drawable;

public class CustomListViewItem {
    private Drawable img;
    private String  name;

    public CustomListViewItem(Drawable _img, String _name){
        img = _img;
        name = _name;
    }
    public Drawable getImg() {
        return img;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setImg(Drawable img) {
        this.img = img;
    }
}
