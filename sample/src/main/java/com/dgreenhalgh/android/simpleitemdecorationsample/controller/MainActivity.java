package com.dgreenhalgh.android.simpleitemdecorationsample.controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.dgreenhalgh.android.simpleitemdecorationsample.R;


public class MainActivity extends AppCompatActivity {

    private Button mVerticalLinearLayoutManagerSampleButton;
    private Button mHorizontalLinearLayoutManagerSampleButton;
    private Button mGridLayoutManagerSampleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVerticalLinearLayoutManagerSampleButton = (Button) findViewById(R.id.activity_main_verticalLinearLayoutManagerButton);
        mVerticalLinearLayoutManagerSampleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();

                Intent verticalLinearLayoutManagerSampleIntent = VerticalLinearLayoutManagerSampleActivity.newIntent(context);
                context.startActivity(verticalLinearLayoutManagerSampleIntent);
            }
        });

        mHorizontalLinearLayoutManagerSampleButton = (Button) findViewById(R.id.activity_main_horizontalLinearLayoutManagerButton);
        mHorizontalLinearLayoutManagerSampleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();

                Intent horizontalLinearLayoutManagerSampleIntent = HorizontalLinearLayoutManagerSampleActivity.newIntent(context);
                context.startActivity(horizontalLinearLayoutManagerSampleIntent);
            }
        });

        mGridLayoutManagerSampleButton = (Button) findViewById(R.id.activity_main_gridLayoutManagerButton);
        mGridLayoutManagerSampleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();

                Intent gridLayoutManagerSampleIntent = GridLayoutManagerSampleActivity.newIntent(context);
                context.startActivity(gridLayoutManagerSampleIntent);
            }
        });
    }
}
