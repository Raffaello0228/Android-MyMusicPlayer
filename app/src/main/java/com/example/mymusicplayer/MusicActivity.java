package com.example.mymusicplayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mymusicplayer.entity.Music;

public class MusicActivity extends Activity implements View.OnClickListener {
    private ImageButton btn_return;
    private ImageButton previous;
    private ImageButton pause;
    private ImageButton next;
    private TextView intent_name;
    private TextView intent_auther;
    private ImageView intent_img;
    public Intent intent1;
    public Intent intent2;
    public static String name;
    public static String auther;
    public static int image;
    public static int path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_activity_1);
        bindId();
        name=MainActivity.name;
        auther=Music.getAuther(name);
        image=Music.getImage(name);
        path=Music.getPath(name);
        intent_name.setText(name);
        intent_auther.setText(auther);
        intent_img.setImageResource(image);
        setListenner();

    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_return:
                intent1=new Intent(MusicActivity.this,MainActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn_pause:
                intent2=new Intent(MusicActivity.this,MusiService.class);
                startService(intent2);
                break;
        }
    }

    private void setListenner() {
        btn_return.setOnClickListener(this);
        previous.setOnClickListener(this);
        pause.setOnClickListener(this);
        next.setOnClickListener(this);
    }

    private void bindId() {
        btn_return=findViewById(R.id.btn_return);
        previous=findViewById(R.id.previous);
        pause=findViewById(R.id.btn_pause);
        next=findViewById(R.id.next);
        intent_name=findViewById(R.id.intent_name);
        intent_auther=findViewById(R.id.intent_auther);
        intent_img=findViewById(R.id.intent_img);
    }
}
