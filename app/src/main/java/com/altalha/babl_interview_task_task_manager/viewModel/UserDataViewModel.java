package com.altalha.babl_interview_task_task_manager.viewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.altalha.babl_interview_task_task_manager.models.UserModel;
import com.altalha.babl_interview_task_task_manager.repositories.UserDataRepository;

import java.io.Closeable;

public class UserDataViewModel extends ViewModel {
    private final UserDataRepository repository;
    private LiveData<UserModel> data;

    public UserDataViewModel(UserDataRepository repository, LiveData<UserModel> data) {
        this.repository = repository;
        this.data = data;
    }

    public UserDataViewModel(UserDataRepository repository, LiveData<UserModel> data, @NonNull Closeable... closeables) {
        super(closeables);
        this.repository = repository;
        this.data = data;
    }

    public LiveData<UserModel> getData() {
        if (data == null) {
            data = repository.fetchData();
        }
        return data;
    }
}
