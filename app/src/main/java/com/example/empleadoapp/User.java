package com.example.empleadoapp;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

public class User implements Serializable, Parcelable {

    @SerializedName("id")
    private int id;

    @SerializedName("codigo_empleado")
    private String codigoEmpleado;

    @SerializedName("nombre_empleado")
    private String nombreEmpleado;

    @SerializedName("numero_telefono")
    private String numeroTelefono;

    @SerializedName("correo")
    private String correo;

    @SerializedName("direccion")
    private String direccion;

    @SerializedName("departamento")
    private String departamento;

    // Constructor
    public User(int id, String codigoEmpleado, String nombreEmpleado, String numeroTelefono, String correo, String direccion, String departamento) {
        this.id = id;
        this.codigoEmpleado = codigoEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.numeroTelefono = numeroTelefono;
        this.correo = correo;
        this.direccion = direccion;
        this.departamento = departamento;
    }

    // Métodos getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    // Implementación de Parcelable
    protected User(Parcel in) {
        id = in.readInt();
        codigoEmpleado = in.readString();
        nombreEmpleado = in.readString();
        numeroTelefono = in.readString();
        correo = in.readString();
        direccion = in.readString();
        departamento = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(codigoEmpleado);
        dest.writeString(nombreEmpleado);
        dest.writeString(numeroTelefono);
        dest.writeString(correo);
        dest.writeString(direccion);
        dest.writeString(departamento);
    }
}
