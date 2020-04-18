package com.example.listadetarefa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.listadetarefa.adapter.TaskAdapter;
import com.example.listadetarefa.model.Task;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Task> tasks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Task task = new Task("Come o cu de quem ta lendo.");

        tasks.add(task);
        tasks.add(task);
        tasks.add(task);
        tasks.add(task);
        tasks.add(task);

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
}
