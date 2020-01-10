package com.example.customlistviewtest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<CustomListViewItem> listViewItems = new ArrayList<>();
    private ListView customListView = null;
    private Button createButton;
    private CustomListViewAdapter customListViewAdapter = new CustomListViewAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createButton = (Button)findViewById(R.id.Create);
        customListView = (ListView)findViewById(R.id.ListView);

        customListViewAdapter.add(new CustomListViewItem(getDrawable(R.drawable.man2), "김학생"));
        customListViewAdapter.add(new CustomListViewItem(getDrawable(R.drawable.man3), "이학생"));
        customListViewAdapter.add(new CustomListViewItem(getDrawable(R.drawable.woman1), "배학생"));
        customListViewAdapter.add(new CustomListViewItem(getDrawable(R.drawable.woman3), "도학생"));
        customListViewAdapter.add(new CustomListViewItem(getDrawable(R.drawable.woman2), "여학생"));

        customListView.setAdapter(customListViewAdapter);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customListViewAdapter.add(new CustomListViewItem(getDrawable(R.drawable.man2), "홍길동"));
                customListViewAdapter.notifyDataSetChanged();
            }
        });
    }
}
