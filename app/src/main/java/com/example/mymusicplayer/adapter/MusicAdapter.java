package com.example.mymusicplayer.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mymusicplayer.R;

import java.util.List;
import java.util.Map;

public class MusicAdapter extends BaseAdapter {
        private List<Map<String,Object>> musiclist;
        private Context mContext;

        public MusicAdapter(List<Map<String, Object>> list, Context mContext) {
            this.musiclist = list;
            this.mContext = mContext;
        }

        /**
         * 返回item的个数
         * @return
         */
        @Override
        public int getCount() {
            return musiclist.size();
        }

        /**
         * 返回每一个item对象
         * @param i
         * @return
         */
        @Override
        public Object getItem(int i) {
            return musiclist.get(i);
        }

        /**
         * 返回每一个item的id
         * @param i
         * @return
         */
        @Override
        public long getItemId(int i) {
            return i;
        }

        /**
         * 暂时不做优化处理，后面会专门整理BaseAdapter的优化
         * @param i
         * @param view
         * @param viewGroup
         * @return
         */
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder holder=null;
            if(view==null) {
                holder=new ViewHolder();
                view = LayoutInflater.from(mContext).inflate(R.layout.vlist, viewGroup,false);
                holder.musicImg = (ImageView) view.findViewById(R.id.musicimg);
                holder.musicName = (TextView) view.findViewById(R.id.musicname);
                holder.musicAuther = (TextView) view.findViewById(R.id.musicauther);
                view.setTag(holder);
            }else{
                holder=(ViewHolder) view.getTag();
            }
            holder.musicImg.setImageResource((int)musiclist.get(i).get("musicImg"));
            holder.musicName.setText((String)musiclist.get(i).get("musicName"));
            holder.musicAuther.setText((String)musiclist.get(i).get("musicAuther"));
            return view;
        }
    }
