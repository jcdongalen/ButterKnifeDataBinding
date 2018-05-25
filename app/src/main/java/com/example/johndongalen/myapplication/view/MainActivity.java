package com.example.johndongalen.myapplication.view;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.johndongalen.myapplication.BR;
import com.example.johndongalen.myapplication.R;
import com.example.johndongalen.myapplication.base.BaseRecyclerViewAdapter;
import com.example.johndongalen.myapplication.model.TestModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private List<TestModel> testModels;
    private BaseRecyclerViewAdapter<TestModel> adapter;

    @BindView(R.id.recyclerViewList) RecyclerView recyclerViewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        recyclerViewList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerViewList.setHasFixedSize(true);
        recyclerViewList.setItemAnimator(new DefaultItemAnimator());

        testModels = new ArrayList<>();

        adapter = new BaseRecyclerViewAdapter<>(testModels,
                R.layout.item_recycler_view_test,
                BR.model,
                (v, item, position) -> {
                    Log.i("Clicked: %s", item.getText());
                });
        recyclerViewList.setAdapter(adapter);
        populateModel();
    }

    private void populateModel() {
        for (int i = 0; i < 3; i++) {
            TestModel testModel = new TestModel();
            testModel.setText("qwe " + i);
            testModel.setColor(Color.CYAN);
            testModels.add(testModel);
        }
        adapter.notifyDataSetChanged();
    }
}
