package com.rmc.rmc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rmc.rmc.R;

import java.util.Map;



/**
 * Created by AnilU on 02-05-2015.
 */
public class ListAdapter extends BaseAdapter{

    Context con;
    Map<String,String> data;
    LayoutInflater inflater;

    public ListAdapter(Context con, Map<String, String> data) {
        this.con = con;
        this.data = data;
        inflater= LayoutInflater.from(con);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;
        if(view==null)
        {
            view=inflater.inflate(R.layout.list_item,null);
            holder=new ViewHolder();
            holder.name=(TextView) view.findViewById(R.id.name);
            holder.status=(ImageView)view.findViewById(R.id.status);
            view.setTag(holder);
        }
        else
        {
             holder=(ViewHolder) view.getTag();

        }

        holder.name.setText("ITEM NAME" + i);
        if(i%2==0)
        holder.status.setImageResource(android.R.drawable.presence_offline);
else
            holder.status.setImageResource(android.R.drawable.presence_online);
        return view;
    }


    class ViewHolder
    {

        TextView name;
        ImageView status;


    }
}
