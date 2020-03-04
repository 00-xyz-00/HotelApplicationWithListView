package com.bb.hotelapplicationwithlistview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bb.hotelapplicationwithlistview.R;
import com.bb.hotelapplicationwithlistview.model.Name;

import java.util.List;

public class NameAdapter extends BaseAdapter {

    private List<Name> names;

    public NameAdapter(List<Name> names) {
        this.names = names;
    }

    @Override
    public int getCount() {
        return this.names.size();
    }

    @Override
    public Object getItem(int position) {
        return this.names.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.guest_item_layout, parent, false);
        ((TextView) view.findViewById(R.id.prefix_textview)).setText(names.get(position).getPrefix());
        ((TextView) view.findViewById(R.id.name_textview)).setText(names.get(position).getName());
        return view;
    }
}
