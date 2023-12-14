package com.example.projectuf1;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Character {
    @PrimaryKey(autoGenerate = true)
    int id;
    String nombre;
    int edad;
    String alineacion;
    String raza;
    String deidad;
    String clase;

    int altura;
    int peso;
    String genero;
    int tamaño;

    int fuerza;
    int destreza;
    int constitucion;
    int sabiduria;
    int inteligencia;
    int carisma;

    String modFuerza;
    String modDestreza;
    String modConstitucion;
    String modSabiduria;
    String modInteligencia;
    String modCarisma;
    int aspecto;

    public Character(String nombre, int edad, String alineacion, String raza, String deidad, String clase, int altura, int peso, String genero, int tamaño, int fuerza, int destreza, int constitucion, int sabiduria, int inteligencia, int carisma, int aspecto) {
        this.nombre = nombre;
        this.edad = edad;
        this.alineacion = alineacion;
        this.raza = raza;
        this.deidad = deidad;
        this.clase = clase;
        this.altura = altura;
        this.peso = peso;
        this.genero = genero;
        this.tamaño = tamaño;
        this.fuerza = fuerza;
        this.destreza = destreza;
        this.constitucion = constitucion;
        this.sabiduria = sabiduria;
        this.inteligencia = inteligencia;
        this.carisma = carisma;
        this.modFuerza = calcularMod(fuerza);
        this.modDestreza = calcularMod(destreza);
        this.modConstitucion = calcularMod(constitucion);
        this.modSabiduria = calcularMod(sabiduria);
        this.modInteligencia = calcularMod(inteligencia);
        this.modCarisma = calcularMod(carisma);
        this.aspecto = aspecto;
    }

    public void setAspecto(int aspecto) {
        this.aspecto = aspecto;
    }

    public String calcularMod(int estadistica){
        String modificador = String.valueOf(0);
        if (estadistica == 1) modificador = "-5";
        else if (estadistica == 2||(estadistica == 3)) modificador = "-4";
        else if (estadistica == 4||(estadistica == 5)) modificador = "-3";
        else if (estadistica == 6||(estadistica == 7)) modificador = "-2";
        else if (estadistica == 8||(estadistica == 9)) modificador = "-1";
        else if (estadistica == 10||(estadistica == 11)) modificador = "0";
        else if (estadistica == 12||(estadistica == 13)) modificador = "1";
        else if (estadistica == 14||(estadistica == 15)) modificador = "2";
        else if (estadistica == 16||(estadistica == 17)) modificador = "3";
        else if (estadistica == 18||(estadistica == 19)) modificador = "4";
        else if (estadistica == 20||(estadistica == 21)) modificador = "5";
        return modificador;
    }

}
