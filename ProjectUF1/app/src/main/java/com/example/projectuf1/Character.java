package com.example.projectuf1;

public class Character {
    String nombre;
    String edad;
    String alineacion;
    String raza;
    String deidad;
    String clase;

    String altura;
    String peso;
    String genero;
    String tamaño;

    String fuerza;
    String destreza;
    String constitucion;
    String sabiduria;
    String inteligencia;
    String  carisma;
    int aspecto;

    public Character(String nombre, String edad, String alineacion, String raza, String deidad, String clase, String altura, String peso, String genero, String tamaño, String fuerza, String destreza, String constitucion, String sabiduria, String inteligencia, String carisma, int aspecto) {
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
        this.aspecto = aspecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getAlineacion() {
        return alineacion;
    }

    public void setAlineacion(String alineacion) {
        this.alineacion = alineacion;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getDeidad() {
        return deidad;
    }

    public void setDeidad(String deidad) {
        this.deidad = deidad;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getFuerza() {
        return fuerza;
    }

    public void setFuerza(String fuerza) {
        this.fuerza = fuerza;
    }

    public String getDestreza() {
        return destreza;
    }

    public void setDestreza(String destreza) {
        this.destreza = destreza;
    }

    public String getConstitucion() {
        return constitucion;
    }

    public void setConstitucion(String constitucion) {
        this.constitucion = constitucion;
    }

    public String getSabiduria() {
        return sabiduria;
    }

    public void setSabiduria(String sabiduria) {
        this.sabiduria = sabiduria;
    }

    public String getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(String inteligencia) {
        this.inteligencia = inteligencia;
    }

    public String getCarisma() {
        return carisma;
    }

    public void setCarisma(String carisma) {
        this.carisma = carisma;
    }

    public int getAspecto() {
        return aspecto;
    }

    public void setAspecto(int aspecto) {
        this.aspecto = aspecto;
    }
}

