package com.example.recyclerview;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Elemento {
    @PrimaryKey(autoGenerate = true)
    int id;
    String nombre;
    String descripcion;
    int imagen;

    public Elemento(String nombre, String descripcion, int imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }
}
