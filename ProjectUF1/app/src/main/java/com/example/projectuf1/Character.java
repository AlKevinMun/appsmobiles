package com.example.projectuf1;

public class Character {
    String nombre;
    int edad;
    String alineacion;
    int raza;
    int deidad;
    int clase;

    int altura;
    int peso;
    int genero;
    int tamaño;

    int fuerza;
    int destreza;
    int constitucion;
    int sabiduria;
    int inteligencia;
    int carisma;

    public Character(String nombre, int edad, String alineacion, int raza, int deidad, int clase, int altura, int peso, int genero, int tamaño, int fuerza, int destreza, int constitucion, int sabiduria, int inteligencia, int carisma) {
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
    }

    public int getRaza() {
        return raza;
    }

    public int getTamaño() {
        return tamaño;
    }

    public int getFuerza() {
        return fuerza;
    }

    public int getDestreza() {
        return destreza;
    }

    public int getConstitucion() {
        return constitucion;
    }

    public int getSabiduria() {
        return sabiduria;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getCarisma() {
        return carisma;
    }
}
