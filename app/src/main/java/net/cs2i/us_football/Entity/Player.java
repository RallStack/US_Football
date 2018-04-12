package net.cs2i.us_football.Entity;

import android.content.Context;

import net.cs2i.us_football.Utils.XmlHandler;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by mduchemin on 19/02/18.
 */

public class Player{

    private String name, birthdate, url_picture, height, weight, post, tee_num;

    /* ------------- Constructor ------------- */

    public Player(){

    }

    public Player(String name, String tee_num, String post){
        this.name = name;
        this.tee_num = tee_num;
        this.post = post;
    }

    /* ------------- Getters and Setters ------------- */


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getUrl_picture() {
        return url_picture;
    }

    public void setUrl_picture(String url_picture) {
        this.url_picture = url_picture;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getTee_num() {
        return tee_num;
    }

    public void setTee_num(String tee_num) {
        this.tee_num = tee_num;
    }
}