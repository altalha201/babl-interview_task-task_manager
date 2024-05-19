package com.altalha.babl_interview_task_task_manager.repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.altalha.babl_interview_task_task_manager.models.UserModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDataRepository {
    private final ApiService apiService;
    private static final String TAG = "UserDataRepository";

    public UserDataRepository() {
        apiService = RetrofitClient.getRetrofitInstance()
                .create(ApiService.class);
    }

    public LiveData<UserModel> fetchData() {
        MutableLiveData<UserModel> data = new MutableLiveData<>();
        apiService.getUser().enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if(response.isSuccessful()) {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable throwable) {
                Log.e(TAG, "onFailure: " + throwable.getMessage());
            }
        });
        return data;
    }
}
