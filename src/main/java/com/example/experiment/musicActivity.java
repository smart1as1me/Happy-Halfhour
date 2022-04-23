package com.example.experiment;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class musicActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView nextIv,playIv,lastIv;
    TextView singerTv,songTv;
    RecyclerView musicRv;
    List<LocalMusicBean> mDatas;
    private LocalMusicAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_main);
        mDatas=new ArrayList<>();
        //创建适配器对象
        new LocalMusicAdapter(this,mDatas);
        //设置适配器
        musicRv.setAdapter(adapter);
        //设置布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        musicRv.setLayoutManager(layoutManager);
        //加载本地数据源
        loadLocalMusicData();
    }

    private void loadLocalMusicData()
    {
        /*加载本地mp3文件到集合当中*/
        //1、获取ContentResolver对象
        ContentResolver resolver=getContentResolver();
        //2、获取本地音乐的uri地址
        Uri uri= MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        //3、开始查询地址
        Cursor cursor=resolver.query(uri,null,null,null,null);
        //4、遍历
        int id=0;
        while (cursor.moveToNext())
        {
            @SuppressLint("Range") String song=cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
            @SuppressLint("Range") String singer=cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
            @SuppressLint("Range") String album = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM));
            id++;
            String sid = String.valueOf(id);
            @SuppressLint("Range") String path = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
            @SuppressLint("Range") long duration=cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));
            SimpleDateFormat sdf=new SimpleDateFormat("mm:ss");
            sdf.format(new Date(duration));
            //将一行的数据封装到对象中
            LocalMusicBean bean = new LocalMusicBean(sid, song, singer, album, path);
            mDatas.add(bean);
        }
        //数据源变化,提示适配器更新
        adapter.notifyDataSetChanged();
    }


    private void initview()
    {
        nextIv=findViewById(R.id.local_music_bottom_iv_next);
        playIv=findViewById(R.id.local_music_bottom_iv_play);
        lastIv=findViewById(R.id.local_music_bottom_iv_last);
        singerTv=findViewById(R.id.local_music_bottom_tv_song);
        musicRv=findViewById(R.id.local_music_rv);
        //设置单击事件
        nextIv.setOnClickListener(this);
        lastIv.setOnClickListener(this);
        playIv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.local_music_bottom_iv_last:

                break;
            case R.id.local_music_bottom_iv_next:

                break;
            case R.id.local_music_bottom_iv_play:

                break;
        }
    }
}
