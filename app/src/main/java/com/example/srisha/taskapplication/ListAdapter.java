package com.example.srisha.taskapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter {

    static class ViewHolder {
        private LinearLayout linearLayout;
        private TextView productName;
        private TextView category;
    }
    private Context mContext;
    private Post mItems;
    private LayoutInflater mInflater;

    public ListAdapter(Context context, Post items) {
        mInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.mItems = items;
    }

    @Override
    public int getCount() {
        return mItems.getCategories().size();
    }

    @Override
    public Category getItem(int i) {
        return mItems.getCategories().get(i);
    }

    @Override
    public long getItemId(int i) {
        return mItems.getCategories().get(i).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.row_list, null);
            holder = new ViewHolder();
            holder.category = (TextView) convertView.findViewById(R.id.category);
            holder.productName = (TextView) convertView.findViewById(R.id.productName);
            holder.linearLayout = (LinearLayout) convertView.findViewById(R.id.ll);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        final Category category = getItem(position);

        holder.category.setText(category.getName());
        holder.productName.setText(""+category.getId());

        holder.linearLayout.setTag(category);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Category category1 = (Category) view.getTag();
                Intent intent = new Intent(mContext,Products.class);
                intent.putExtra("category", category1);
                mContext.startActivity(intent);
            }
        });

        return convertView;
    }
}
