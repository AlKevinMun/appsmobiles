package com.example.projectuf1;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Campaing {
    @PrimaryKey(autoGenerate = true)
    int id;
    String nombre;
    String descripcion;
    String master;
    int maxPlayers;
    String playersApuntados;
    String flexibilidad;
    String fechaInicio;
    String duracion;
    String intervaloEntreSesiones;
    String detallesExtra;
    int mapa;

    public Campaing(String nombre, String descripcion, String master, int maxPlayers, String playersApuntados, String flexibilidad, String fechaInicio, String duracion, String intervaloEntreSesiones, String detallesExtra, int mapa) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.master = master;
        this.maxPlayers = maxPlayers;
        this.playersApuntados = playersApuntados;
        this.flexibilidad = flexibilidad;
        this.fechaInicio = fechaInicio;
        this.duracion = duracion;
        this.intervaloEntreSesiones = intervaloEntreSesiones;
        this.detallesExtra = detallesExtra;
        this.mapa = mapa;
    }

    public String getPlayersApuntados() {
        return playersApuntados;
    }

    public void setPlayersApuntados(String playersApuntados) {
        this.playersApuntados = playersApuntados;
    }
}
