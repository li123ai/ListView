package com.example.listview;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class senior_view extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_view);
        ListView listView=findViewById(R.id.iv);
        List<News> dataLIst=new ArrayList<>();
        for (int i=0;i<20;i++){
            News item=new News();
            item.setPicId(R.mipmap.ic_dd);
            item.setTitle(i+"同学们干的是人事吗");
            dataLIst.add(item);
        }
        NewsAdapter adapter=new NewsAdapter(senior_view.this,dataLIst);
        listView.setAdapter(adapter);
    }
}
