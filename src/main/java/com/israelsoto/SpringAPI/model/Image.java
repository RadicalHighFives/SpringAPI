package com.israelsoto.SpringAPI.model;

public class Image {

    private String imgPath;
    private String id;
    private String name;

    // ===== GET ID
    public String getId(){
        return id;
    }

    // ===== SET ID
    public void setId(String id){
        this.id = id;
    }

    // ===== GET Name
    public String getName(){
        return name;
    }

    // ===== SET Name
    public void setName(String name){
        this.name = name;
    }

    // ===== GET Name
    public String getImagePath(){
        return imgPath;
    }

    // ===== SET Image
    public void setImagePath(String imgPath){
        this.imgPath = imgPath;
    }
}
