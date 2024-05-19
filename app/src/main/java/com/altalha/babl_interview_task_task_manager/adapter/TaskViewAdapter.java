package com.altalha.babl_interview_task_task_manager.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.altalha.babl_interview_task_task_manager.R;
import com.altalha.babl_interview_task_task_manager.TaskDetailsActivity;
import com.altalha.babl_interview_task_task_manager.models.Task;
import com.altalha.babl_interview_task_task_manager.repositories.TaskDbHelper;

import java.util.List;

public class TaskViewAdapter extends RecyclerView.Adapter<TaskViewAdapter.TaskViewHolder> {
    private Context context;
    private List<Task> list;
    private TaskDbHelper dbHelper;

    public TaskViewAdapter(Context context, List<Task> list, TaskDbHelper dbHelper) {
        this.context = context;
        this.list = list;
        this.dbHelper = dbHelper;
    }

    @NonNull
    @Override
    public TaskViewAdapter.TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.task_item_view, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewAdapter.TaskViewHolder holder, int position) {
        Task task = list.get(position);
        holder.taskTitle.setText(task.getTitle());
        holder.taskCheckbox.setChecked(task.isCompleted());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, TaskDetailsActivity.class);
            intent.putExtra("taskId", task.getId());
            context.startActivity(intent);
        });

        holder.taskCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            dbHelper.updateTaskCompleted(task.getId(), isChecked);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        CheckBox taskCheckbox;
        TextView taskTitle;
        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            taskCheckbox = itemView.findViewById(R.id.completedCheckBox);
            taskTitle = itemView.findViewById(R.id.taskTitleTextView);
        }
    }
}
