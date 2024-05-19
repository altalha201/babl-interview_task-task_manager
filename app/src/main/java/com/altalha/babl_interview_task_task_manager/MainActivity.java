package com.altalha.babl_interview_task_task_manager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.altalha.babl_interview_task_task_manager.adapter.TaskViewAdapter;
import com.altalha.babl_interview_task_task_manager.databinding.ActivityMainBinding;
import com.altalha.babl_interview_task_task_manager.models.Task;
import com.altalha.babl_interview_task_task_manager.models.UserModel;
import com.altalha.babl_interview_task_task_manager.repositories.ApiService;
import com.altalha.babl_interview_task_task_manager.repositories.RetrofitClient;
import com.altalha.babl_interview_task_task_manager.repositories.TaskDbHelper;
import com.altalha.babl_interview_task_task_manager.utils.DownloadImageTask;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ActivityMainBinding binding;
    private ApiService apiService;
    //    private UserDataRepository userRepository;
    private TaskDbHelper dbHelper;

    private List<Task> taskList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new TaskDbHelper(this);
        taskList = dbHelper.getAllTask();
        Log.e(TAG, "setRecycleView: TaskListLength: " + taskList.size());
        setStatusBarColor();
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        userRepository = new UserDataRepository();
        apiService = RetrofitClient.getRetrofitInstance()
                .create(ApiService.class);
        setUserData();
        setRecycleView();

        binding.floatingButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddOrEditActivity.class);
            intent.putExtra("editable", false);
            this.startActivity(intent);
        });
    }

    private void setStatusBarColor() {
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(getResources().getColor(R.color.amber));
    }

    private void setUserData() {
        apiService.getUser().enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(@NonNull Call<UserModel> call, @NonNull Response<UserModel> response) {
                if(response.isSuccessful()) {
                    final UserModel userModel = response.body();
                    if (userModel != null) {
                        final UserModel.result currentUser = userModel.getResults().get(0);
                        Log.e(TAG, "setUserData: User Phone -> " + currentUser.getPhone());
                        binding.nameTextView.setText(currentUser.getName().getFullName());
                        binding.emailTextView.setText(currentUser.getEmail());
                        new DownloadImageTask(binding.profileImageView).execute(currentUser.getPicture().getThumbnail());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<UserModel> call, @NonNull Throwable throwable) {
                Log.e(TAG, "onFailure: " + throwable.getMessage());
            }
        });
    }

    private void setRecycleView() {
        binding.taskListView.setLayoutManager(new LinearLayoutManager(this));
        TaskViewAdapter taskViewAdapter = new TaskViewAdapter(this, taskList, dbHelper);
        binding.taskListView.setAdapter(taskViewAdapter);
    }

    /*
     * private void setUserView() {
     *       userRepository.fetchData().observe(this, userModel -> {
     *           if (userModel != null) {
     *               final UserModel.result currentUser = userModel.getResults().get(0);
     *               Log.e(TAG, "setUserData: User Phone -> " + currentUser.getPhone());
     *               binding.nameTextView.setText(currentUser.getName().getFullName());
     *               binding.emailTextView.setText(currentUser.getEmail());
     *               new DownloadImageTask(binding.profileImageView).execute(currentUser.getPicture().getThumbnail());
     *           }
     *       });
     * }
     * */

    /*
     * private void viewUser() {
     *   userDataViewModel.getData().observe(this, userModel -> {
     *       if (userModel != null) {
     *           final UserModel.result firstPerson = userModel.getResults().get(0);
     *           Log.e(TAG, "onCreate: Phone Number: " + firstPerson.getPhone());
     *           final String fullName = firstPerson.getName().getTitle() + " " + firstPerson.getName().getFirst() + " " + firstPerson.getName().getLast();
     *           binding.nameTextView.setText(fullName);
     *           binding.emailTextView.setText(firstPerson.getEmail());
     *           new DownloadImageTask(binding.profileImageView).execute(firstPerson.getPicture().thumbnail);
     *       }
     *   });
     * }
     * */
}