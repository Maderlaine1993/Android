package com.example.empleadoapp;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Listado extends AppCompatActivity implements UserManager.OnUsersReceivedListener {

    private EmpleadoAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewUsers);
        adapter = new EmpleadoAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        UserManager userManager = new UserManager();
        userManager.getUsers(this);
    }

    @Override
    public void onUsersReceived(List<User> userList) {
        Log.d("Listado", "Número de empleados recibidos: " + userList.size());
        adapter.setUsers(userList);
    }

    @Override
    public void onFailure(String errorMessage) {
        // Manejar el error según tus necesidades
    }
}

