package com.example.mymusicplayer.entity;

import android.graphics.Bitmap;
import android.widget.TextView;

public class Music {
    //音乐名
    public static String name;
    //歌手
    public static String auther;
    //音乐配图
    public static int image;
    //路径
    public static int path;

    public boolean isPlaying;
    public Music(String name,String auther,int image,int path){
        this.name=name;
        this.auther=auther;
        this.image=image;
        this.path=path;
    }
    public static int getPath(String n){
        if(name==n){
            return path;
        }else{
            return 0;
        }
    }
    public static int getImage(String n){
        if(name==n){
            return image;
        }else{
            return 0;
        }
    }
    public static String getAuther(String n){
        if(name==n){
            return auther;
        }else{
            return null;
        }
    }
}

