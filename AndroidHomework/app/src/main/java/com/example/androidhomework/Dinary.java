package com.example.androidhomework;

public class Dinary {
    private String title;
    private String miniInfo;
    private int imageResource;

    public Dinary(String title, String miniInfo,int imageResource){
        this.title = title;
        this.miniInfo = miniInfo;
        this.imageResource = imageResource;

    }


    public String getTitle(){return title;}

    public String getMiniInfo(){return miniInfo;}

    public int getImageResource(){return imageResource;}
}
