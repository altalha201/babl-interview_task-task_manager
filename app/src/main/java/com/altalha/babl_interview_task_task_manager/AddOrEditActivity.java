package com.altalha.babl_interview_task_task_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.altalha.babl_interview_task_task_manager.databinding.ActivityAddOrEditBinding;
import com.altalha.babl_interview_task_task_manager.models.Task;
import com.altalha.babl_interview_task_task_manager.repositories.TaskDbHelper;

public class AddOrEditActivity extends AppCompatActivity {

    private ActivityAddOrEditBinding binding;
    private TaskDbHelper dbHelper;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddOrEditBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dbHelper = new TaskDbHelper(this);
        final boolean isEditable = getIntent().getBooleanExtra("editable", false);

        if (isEditable) {
            id = getIntent().getIntExtra("taskId", -1);
            setEditBinding(id);
        } else {
            setAddLayout();
        }

        binding.backButton.setOnClickListener(l ->
                finish()
        );

        binding.adOrEditButton.setOnClickListener(l -> {
            if (isEditable) {
                int success = dbHelper.updateTask(
                        id,
                        String.valueOf(binding.titleEditText.getText()),
                        String.valueOf(binding.descriptionEditText.getText()),
                        binding.completedCheckBox.isChecked()
                );
                if (success == id) {
                    Toast.makeText(getApplicationContext(), "Task Updated Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Task Updated Failed", Toast.LENGTH_SHORT).show();

                }
            } else {
                long newId = dbHelper.addTask(
                        String.valueOf(binding.titleEditText.getText()),
                        String.valueOf(binding.descriptionEditText.getText()),
                        false
                );
                if (newId != -1) {
                    Toast.makeText(getApplicationContext(), "Task Added Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Task Add Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void setAddLayout() {
        binding.pageTitle.setText("Add Task");
        binding.checkboxLayout.setVisibility(View.GONE);
        binding.adOrEditButton.setText("Add New Task");
    }

    @SuppressLint("SetTextI18n")
    private void setEditBinding(int id) {
        final Task task = dbHelper.getTaskByID(id);
        if (task != null) {
            binding.pageTitle.setText("Edit Task");
            binding.titleEditText.setText(task.getTitle());
            binding.descriptionEditText.setText(task.getDescription());
            binding.completedCheckBox.setChecked(task.isCompleted());
            binding.adOrEditButton.setText("Update Task");
        }
    }
}