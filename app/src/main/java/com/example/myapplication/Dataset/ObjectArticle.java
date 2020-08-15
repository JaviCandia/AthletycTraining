package com.example.myapplication.Dataset;

public class ObjectArticle {

    int id;
    String title;
    String date;
    int img;
    String body;

    public ObjectArticle(int id, String title, String date, int img, String body) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.img = img;
        this.body = body;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public int getImg() {
        return img;
    }
    public void setImg(int img) {
        this.img = img;
    }

    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
}
