package com.example.a20230302gridview2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private GridView mGridView;
    private ImageView mImageView;
    private int[] mImageArrays = new int[]{
            R.drawable.test1c,R.drawable.test2c,
            R.drawable.test3c,R.drawable.test4c,
            R.drawable.test5c,R.drawable.test6c,
            R.drawable.test7c,R.drawable.test8c,
            R.drawable.test9c,R.drawable.test10c,
            R.drawable.test11c,R.drawable.test12,
            R.drawable.test13
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGridView = (GridView) findViewById(R.id.gridView);
        mImageView = (ImageView) findViewById(R.id.imageView);

        List<Map<String,Object>> cells = new ArrayList<Map<String ,Object>>();
        for(int i = 0;i < mImageArrays.length;i ++){
            Map<String ,Object> cell = new HashMap<String,Object>();
            cell.put("cellImageView",mImageArrays[i]);
            cells.add(cell);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,cells,
                R.layout.grid,new String[]{
                        "cellImageView"
        },new int[]{
                R.id.cellImageView
        });
        mGridView.setAdapter(simpleAdapter);
        mGridView.setOnItemClickListener(this);

        mImageView.setImageResource(mImageArrays[0]);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mImageView.setImageResource(mImageArrays[position]);
    }
}