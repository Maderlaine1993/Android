package com.example.empleadoapp;

import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

public interface ApiService {
    @GET("get-empleados")
    Call<List<User>> getUsers();
}
