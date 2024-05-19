package com.altalha.babl_interview_task_task_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.altalha.babl_interview_task_task_manager.databinding.ActivityTaskDetailsBinding;
import com.altalha.babl_interview_task_task_manager.models.Task;
import com.altalha.babl_interview_task_task_manager.repositories.TaskDbHelper;

public class TaskDetailsActivity extends AppCompatActivity {

    private TaskDbHelper dbHelper;
    private ActivityTaskDetailsBinding binding;
    private int taskId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTaskDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dbHelper = new TaskDbHelper(this);
        taskId = getIntent().getIntExtra("taskId", -1);
        setTaskDisplay();

        binding.backButton.setOnClickListener(l -> finish());

        binding.floatingButtonEdit.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddOrEditActivity.class);
            intent.putExtra("editable", true);
            intent.putExtra("taskId", taskId);
            this.startActivity(intent);
        });

        binding.floatingButtonDelete.setOnClickListener(v -> {
            dbHelper.deleteTask(taskId);
            Toast.makeText(this, "Task Deleted", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            this.startActivity(intent);
        });
    }

    private void setTaskDisplay() {
        Task task = dbHelper.getTaskByID(taskId);

        if (task != null) {
            binding.taskViewTitle.setText(task.getTitle());
            binding.taskViewDescription.setText(task.getDescription());
            binding.taskDetailsStatus.setText(task.isCompleted() ? "Completed" : "Not Completed");
        } else {
            binding.statusLayout.setVisibility(View.INVISIBLE);
        }
    }
}