package com.example.empleadoapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class EmpleadoAdapter extends RecyclerView.Adapter<EmpleadoAdapter.UserViewHolder> {

    private List<User> userList;

    public EmpleadoAdapter(List<User> userList) {
        this.userList = userList;
    }

    public void setUsers(List<User> userList) {
        this.userList = userList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_listado_empleados, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);

        // Actualizar los TextView con los datos del usuario
        holder.userCodigoEmpleadoTextView.setText("Código Empleado: " + user.getCodigoEmpleado());
        holder.userNombreTextView.setText("Nombre: " + user.getNombreEmpleado());
        holder.userNumeroTextView.setText("Número: " + user.getNumeroTelefono());
        holder.userDepartamentoTextView.setText("Departamento: " + user.getDepartamento());
        holder.userCorreoTextView.setText("Correo: " + user.getCorreo());
        holder.userDireccionTextView.setText("Dirección: " + user.getDireccion());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView userCodigoEmpleadoTextView;
        TextView userNombreTextView;
        TextView userNumeroTextView;
        TextView userDepartamentoTextView;
        TextView userCorreoTextView;
        TextView userDireccionTextView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            // Asociar las vistas con los identificadores correctos
            userCodigoEmpleadoTextView = itemView.findViewById(R.id.userCodigoEmpleado);
            userNombreTextView = itemView.findViewById(R.id.userNombre);
            userNumeroTextView = itemView.findViewById(R.id.userNumero);
            userDepartamentoTextView = itemView.findViewById(R.id.userDepartamento);
            userCorreoTextView = itemView.findViewById(R.id.userCorreo);
            userDireccionTextView = itemView.findViewById(R.id.userDireccion);
        }
    }
}
