package com.example.listview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class NewsAdapter extends BaseAdapter {
    private String TAG=NewsAdapter.class.getSimpleName();
    private Context mContext;
    private List<News> mDataList;
    private final LayoutInflater mlnflater;


    public NewsAdapter(Context context,List<News> dataList){
        mContext=context;
        mDataList=dataList;

       mlnflater=LayoutInflater.from(mContext);
    }


    @Override
    public int getCount() {
        int count=(null==mDataList ? 0 :mDataList.size());
        Log.i(TAG, "----getCount()"+count);
        return count;
    }

    @Override
    public Object getItem(int position) {
        Log.i(TAG, "----getItem()"+position);
        return position;
    }

    @Override
    public long getItemId(int position) {
        Log.i(TAG, "----getItemId()"+position);
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Log.i(TAG, "-----getView() "+position+"convertView:"+convertView);
        ViewHolder holder;
        if (null==convertView){
            convertView=mlnflater.inflate(R.layout.item_news,null);
            holder=new ViewHolder();
            holder.iconIV=convertView.findViewById(R.id.iv_icon);
            holder.titTV=convertView.findViewById(R.id.tv_title);
            convertView.setTag(holder);
        }else {
            holder=(ViewHolder) convertView.getTag();
        }
        News news=mDataList.get(position);
        holder.iconIV.setImageResource(news.getPicId());
        holder.titTV.setText(news.getTitle());

        holder.iconIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"点了第"+position+"个新闻icon",Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
    private class ViewHolder{
        ImageView iconIV;
        TextView titTV;
    }
}
