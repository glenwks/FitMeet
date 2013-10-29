package com.is306.fitmeet;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class EventAdapter extends ArrayAdapter<Event>{

    Context context; 
    int layoutResourceId;    
    ArrayList<Event> data;
    
    public EventAdapter(Context context, int layoutResourceId, ArrayList<Event> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        EventHolder holder = null;
        
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            
            holder = new EventHolder();
            holder.txtTitle = (TextView)row.findViewById(R.id.event_title_row);
            holder.txtDate = (TextView)row.findViewById(R.id.date_event_row);
            holder.txtTime = (TextView)row.findViewById(R.id.time_event_row);
            
            row.setTag(holder);
        }
        else
        {
            holder = (EventHolder)row.getTag();
        }
        
        Event event = data.get(position);
        holder.txtTitle.setText(event.getTitle());
        holder.txtDate.setText(event.getDate());
        holder.txtTime.setText(event.getStartTime());

        
        return row;
    }
    
    static class EventHolder
    {
        ImageView imgIcon;
        TextView txtTitle;
        TextView txtDate;
        TextView txtTime;
    }
}