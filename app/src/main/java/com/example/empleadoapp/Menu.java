package com.example.empleadoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void listado(View view) {
        ApiService apiService = Conexion.getApiService();
        Call<List<User>> call = apiService.getUsers();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<User> userList = response.body();
                    if (!userList.isEmpty()) {
                        Intent intent = new Intent(Menu.this, Listado.class);
                        intent.putParcelableArrayListExtra("userList", (ArrayList<User>) userList);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Menu.this, "La lista de usuarios está vacía", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Menu.this, "Error al obtener la lista de usuarios", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(Menu.this, "Error al realizar la solicitud GET: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}




