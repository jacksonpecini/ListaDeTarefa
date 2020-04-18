package com.example.listadetarefa;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.listadetarefa.adapter.TaskAdapter;
import com.example.listadetarefa.model.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Task> tasks = new ArrayList<>();
    private FloatingActionButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.floatingActionButton);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTaskActivity();
            }
        };

        btn.setOnClickListener(onClickListener);

        recyclerView = (RecyclerView) findViewById(R.id.task_list);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new TaskAdapter(tasks);
        recyclerView.setAdapter(mAdapter);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 999 && resultCode == RESULT_OK) {

            Task task = (Task) data.getSerializableExtra("task");
            tasks.add(task);
            mAdapter.notifyDataSetChanged();
        }
    }

    public void openTaskActivity() {
        Intent intent = new Intent(this, TaskActivity.class);
        startActivityForResult(intent, 999);
    }
}
