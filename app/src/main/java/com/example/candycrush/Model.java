package com.example.candycrush;

public class Model {
    private int image;
    private String title;
    private String desc;
    private int posizione;

    public Model(int image, String title, String desc,int pos) {
        this.image = image;
        this.title = title;
        this.desc = desc;
        this.posizione=pos;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
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

    public int getPosizione() {
        return posizione;
    }
}
