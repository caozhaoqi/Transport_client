package com.example.SupportDecline;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by czq on 2020/9/1.
 * 适配器类
 */
public class MyAdapter extends BaseAdapter implements SwipeLayout.OnSwipeStateChangeListener {

    private Context context;
    private List<String> list;

    public MyAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCount() {
        return list.size();
    }

    /** {@inheritDoc} */
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    /** {@inheritDoc} */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /** {@inheritDoc} */
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_listview, null);
        }
        final ViewHolder holder = ViewHolder.getHolder(convertView);

//            holder.tvName.setText(list.get(position));

        holder.swipeLayout.setTag(position);

        holder.swipeLayout.setOnSwipeStateChangeListener(this);

        //删除
        holder.tvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(getItem(position));
                MyAdapter.this.notifyDataSetChanged();
                SwipeLayoutManager.getInstance().closeCurrentLayout();
                SwipeLayoutManager.getInstance().clearCurrentLayout();
                Toast.makeText(context, "第" + position + "个已删除", Toast.LENGTH_SHORT).show();
            }
        });


        return convertView;
    }

    /** {@inheritDoc} */
    @Override
    public void onOpen(Object tag) {
        Toast.makeText(context, "第" + tag + "个打开", Toast.LENGTH_SHORT).show();
    }

    /** {@inheritDoc} */
    @Override
    public void onClose(Object tag) {
        Toast.makeText(context, "第" + tag + "个关闭", Toast.LENGTH_SHORT).show();
    }

    private static class ViewHolder {
        private TextView tvName, tvDelete, tvZhiDing;
        private SwipeLayout swipeLayout;

        public ViewHolder(View convertView) {

            tvDelete = convertView.findViewById(R.id.tv_delete);

            swipeLayout = convertView.findViewById(R.id.swipelayout);
        }

        public static ViewHolder getHolder(View convertView) {
            ViewHolder holder = (ViewHolder) convertView.getTag();
            if (holder == null) {
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            }
            return holder;
        }
    }
}
