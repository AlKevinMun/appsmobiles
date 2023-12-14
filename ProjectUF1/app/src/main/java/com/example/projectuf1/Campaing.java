package com.example.projectuf1;

import java.util.Date;

public class Campaing {
    String nombre;
    String descripcion;
    String master;
    String maxPLayers;
    String playersApuntados;
    String flexibilidad;
    Date fechaInicio;
    String duracion;
    String intervaloEntreSesiones;
    String detallesExtra;
    int mapa;

    public Campaing(String nombre, String descripcion, String master, String maxPLayers, String playersApuntados, String flexibilidad, Date fechaInicio, String duracion, String intervaloEntreSesiones, String detallesExtra, int mapa) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.master = master;
        this.maxPLayers = maxPLayers;
        this.playersApuntados = playersApuntados;
        this.flexibilidad = flexibilidad;
        this.fechaInicio = fechaInicio;
        this.duracion = duracion;
        this.intervaloEntreSesiones = intervaloEntreSesiones;
        this.detallesExtra = detallesExtra;
        this.mapa = mapa;
    }
}
