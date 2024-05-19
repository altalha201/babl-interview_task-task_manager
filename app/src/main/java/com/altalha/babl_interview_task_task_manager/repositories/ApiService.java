package com.altalha.babl_interview_task_task_manager.repositories;

import com.altalha.babl_interview_task_task_manager.models.UserModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("api/")
    Call<UserModel> getUser();
}
