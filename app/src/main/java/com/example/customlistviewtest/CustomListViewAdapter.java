package com.example.customlistviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomListViewAdapter extends BaseAdapter {
    LayoutInflater inflater = null;
    private ArrayList<CustomListViewItem> Data = new ArrayList<>();
    private int Cnt = Data.size();

    @Override
    public int getCount() {
        return Cnt;
    }
    @Override
    public Object getItem(int position) {
        return null;
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Context context = parent.getContext();
        final int pos = position;

        if (inflater == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        convertView = inflater.inflate(R.layout.customlistviewitem, parent, false);
        ImageView img = (ImageView) convertView.findViewById(R.id.Img);
        TextView name = (TextView) convertView.findViewById(R.id.Name);
        Button button = (Button) convertView.findViewById(R.id.button);

        CustomListViewItem listViewItem = Data.get(position);

        img.setImageDrawable(listViewItem.getImg());
        name.setText(listViewItem.getName());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data.remove(pos);
                Cnt--;
                Toast.makeText(context, pos+1 + "번째 아이템이 선택되었습니다.", Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();
            }
        });

        return convertView;
    }
    public void add(CustomListViewItem item){
        Data.add(item);
        Cnt++;
    }
}
