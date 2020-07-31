package com.example.kpgoldtest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class KPgoldAdapter extends ArrayAdapter {
    List list = new ArrayList();
    public KPgoldAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(User object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row;
        row = convertView;
        UserHolder userHolder;
        if(row == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row =  layoutInflater.inflate(R.layout.user_row_layout, parent,false);
            userHolder = new UserHolder();
            userHolder.tx_username = (TextView) row.findViewById(R.id.tx_username);
            userHolder.tx_type = (TextView) row.findViewById(R.id.tx_type);
            userHolder.tx_date = (TextView) row.findViewById(R.id.tx_date);

            row.setTag(userHolder);

        } else {
            userHolder = (UserHolder)row.getTag();
        }

        User user = (User) this.getItem(position);
        if (user != null) {
            userHolder.tx_username.setText(user.getUsername());
            userHolder.tx_type.setText(user.getType());
            userHolder.tx_date.setText(user.getDate());
        }

        return row;
    }

    static class UserHolder {
        TextView tx_username,tx_type, tx_date;
    }
}
