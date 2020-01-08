package com.example.customlistviewtest;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<CustomListViewItem> listViewItems = new ArrayList<>();
    private ListView customListView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customListView = (ListView)findViewById(R.id.ListView);

        listViewItems.add(new CustomListViewItem(getDrawable(R.drawable.man3), "서보원"));
        listViewItems.add(new CustomListViewItem(getDrawable(R.drawable.man2), "아무개"));
        listViewItems.add(new CustomListViewItem(getDrawable(R.drawable.woman1), "누군가"));
        listViewItems.add(new CustomListViewItem(getDrawable(R.drawable.woman2), "따라란"));
        CustomListViewAdapter customListViewAdapter = new CustomListViewAdapter(listViewItems);

        customListView.setAdapter(customListViewAdapter);
    }
}
