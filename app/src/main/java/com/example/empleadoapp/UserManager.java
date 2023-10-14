package com.example.empleadoapp;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class UserManager {

    private ApiService apiService;

    public UserManager() {
        apiService = RetrofitClient.getClient().create(ApiService.class);
    }

    public void getUsers(final OnUsersReceivedListener listener) {
        Call<List<User>> call = apiService.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<User> userList = response.body();
                    listener.onUsersReceived(userList);
                } else {
                    listener.onFailure("Error al obtener la lista de usuarios");
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                listener.onFailure("Error en la solicitud GET: " + t.getMessage());
            }
        });
    }

    public interface OnUsersReceivedListener {
        void onUsersReceived(List<User> userList);

        void onFailure(String errorMessage);
    }
}
