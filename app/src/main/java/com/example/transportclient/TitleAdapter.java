package com.example.transportclient;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class TitleAdapter extends BaseAdapter {

    String[] itemNames;
    LayoutInflater inflater;

    public TitleAdapter(LayoutInflater _inflater, String[] names) {
        inflater = _inflater;
        itemNames = names.clone();
    }

    @Override
    public Object getItem(int i) {
        return itemNames[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getCount() {
        return itemNames.length;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            ViewHolder holder = new ViewHolder();
            if (view == null) {
                view = inflater.inflate(R.layout.item_layout_record, viewGroup, false);
                //    holder.title = (TextView) view.findViewById(R.id.item);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }

            if (holder != null && holder.title != null) {
                TextView tv = holder.title;
                tv.setText(itemNames[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    private class ViewHolder {
        TextView title;
    }
}

