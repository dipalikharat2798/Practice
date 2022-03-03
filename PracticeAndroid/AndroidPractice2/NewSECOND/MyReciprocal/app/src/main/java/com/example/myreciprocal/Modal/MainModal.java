package com.example.myreciprocal.Modal;

public class MainModal {
    String id,title,desc,image;

    public MainModal(){}
    public MainModal(String id, String title, String desc, String image) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
