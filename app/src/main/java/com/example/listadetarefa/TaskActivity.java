package com.example.listadetarefa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.listadetarefa.model.Task;

public class TaskActivity extends AppCompatActivity {

    private EditText title;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        title = findViewById(R.id.title);
        button = findViewById(R.id.button);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        };
        button.setOnClickListener(clickListener);

    }

    private void save() {

        String taskTitle = title.getText().toString();

        if (taskTitle.isEmpty()) {
            return;
        }
        Toast.makeText(this, "Tarefa cadastrado com sucesso!", Toast.LENGTH_LONG).show();

        Task task = new Task(taskTitle);

        Intent intent = new Intent();
        intent.putExtra("task", task);

        setResult(RESULT_OK, intent);
        finish();
    }

}
