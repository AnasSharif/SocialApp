package com.example.anas.socialapp.UserActivities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.anas.socialapp.Databases.DataBaseHelperClass;
import com.example.anas.socialapp.R;
import com.example.anas.socialapp.UserActivities.RecyclerView.RecycleViewController;

import static com.example.anas.socialapp.R.id.fab;

public class ActivityUser extends AppCompatActivity {
    private RecyclerView recyclerView;
    RecycleViewController recycleViewController;
    DataBaseHelperClass dataBaseHelperClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
         //init the view from xml
        recyclerView = (RecyclerView) findViewById(R.id.user_activity_data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        dataBaseHelperClass = new DataBaseHelperClass(this);
        recycleViewController = new RecycleViewController(dataBaseHelperClass.getAllData());
        recyclerView.setAdapter(recycleViewController);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
