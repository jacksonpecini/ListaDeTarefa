package com.example.listadetarefa.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.listadetarefa.R;
import com.example.listadetarefa.model.Task;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
    private ArrayList<Task> tasks;

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView taskItemTitle;
        public TaskViewHolder(View itemView) {
            super(itemView);
            taskItemTitle = itemView.findViewById(R.id.task_item_title);
        }
    }

    public TaskAdapter(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public TaskAdapter.TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_item, parent, false);
        TaskViewHolder vh = new TaskViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        Task task = tasks.get(position);
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.taskItemTitle.setText(task.getTitle());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return tasks.size();
    }

}
