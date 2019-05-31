package com.example.mymusicplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mymusicplayer.adapter.MusicAdapter;
import com.example.mymusicplayer.adapter.ViewHolder;
import com.example.mymusicplayer.entity.Music;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.support.v4.os.LocaleListCompat.create;

public class MainActivity extends AppCompatActivity {
    private ListView listview;
    public static MediaPlayer mp;
    private ImageButton previous;
    private ImageButton pause;
    private ImageButton next;
    private List<Map<String,Object>> list;
    private Map<String,Object> map;
    private MusicAdapter adapter;
    private Intent intent1;
    private Intent intent2;
    public static String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=new ArrayList<Map<String, Object>>();
        bindID();
        addMusic();
        adapter=new MusicAdapter(list,MainActivity.this);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ViewHolder vh = (ViewHolder) view.getTag();
                name = (String) vh.musicName.getText();
                try {
                    int path = Music.getPath(name);
                    mp = MediaPlayer.create(MainActivity.this, path);
                } catch (Exception e){
                    System.out.println("播放失败");
                }
                intent1 = new Intent(MainActivity.this, MusicActivity.class);
                startActivity(intent1);
                //intent2 = new Intent(MainActivity.this, MusiService.class);
                //startActivity(intent2);

            }
        });
    }

    private void addMusic() {
        Music music=new Music("Shooting Stars","Bag Raider",R.drawable.shootingstars,R.raw.shootingstars);
        Map<String,Object> map=new HashMap<>();
        map.put("musicImg",music.image);
        map.put("musicName",music.name);
        map.put("musicAuther",music.auther);
        map.put("musicRs",music.path);
        list.add(map);
    }

    private void bindID() {
        listview=findViewById(R.id.listview);
        previous=findViewById(R.id.previous);
        pause=findViewById(R.id.btn_pause);
        next=findViewById(R.id.next);
    }
    protected void onDestroy() {
        super.onDestroy();
        if (mp != null) {
            mp.stop();
            mp.release();
        }
        Toast.makeText(getApplicationContext(), "退出啦", Toast.LENGTH_SHORT).show();
    }
}
