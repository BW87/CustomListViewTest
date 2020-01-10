package com.example.customlistviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class CustomListViewAdapter extends BaseAdapter {

    private LayoutInflater inflater = null;
    private ImageView img;
    private TextView name;
    private Button button;
    private Switch onOffSwitch;
    private ArrayList<CustomListViewItem> Data = new ArrayList<>();
    private int Cnt = Data.size();

    @Override
    public int getCount() {
        return Cnt;
    }
    @Override
    public Object getItem(int position) {
        return Data.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Context context = parent.getContext();
        final int pos = position;

        if (inflater == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        convertView = inflater.inflate(R.layout.customlistviewitem, parent, false);

        img = (ImageView) convertView.findViewById(R.id.Img);
        name = (TextView) convertView.findViewById(R.id.Name);
        button = (Button) convertView.findViewById(R.id.button);
        onOffSwitch = (Switch)convertView.findViewById(R.id.Onoff);

        CustomListViewItem listViewItem = Data.get(position);

        img.setImageDrawable(listViewItem.getImg());
        name.setText(listViewItem.getName());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data.remove(pos);
                Cnt--;
                notifyDataSetChanged();
            }
        });

        onOffSwitch.setOnCheckedChangeListener(new OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton button, boolean isChecked){
                if(isChecked){
                    Toast.makeText(context, (pos+1)+"번째 아이템 " +"on",Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(context, (pos+1)+"번째 아이템 " +"off", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return convertView;
    }
    public void add(CustomListViewItem item){
        Data.add(item);
        Cnt++;
    }
}
