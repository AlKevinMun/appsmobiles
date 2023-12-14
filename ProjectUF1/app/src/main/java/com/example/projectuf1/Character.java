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
    String carisma;

    String modFuerza;
    String modDestreza;
    String modConstitucion;
    String modSabiduria;
    String modInteligencia;
    String modCarisma;
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
        this.modFuerza = calcularMod(fuerza);
        this.modDestreza = calcularMod(destreza);
        this.modConstitucion = calcularMod(constitucion);
        this.modSabiduria = calcularMod(sabiduria);
        this.modInteligencia = calcularMod(inteligencia);
        this.modCarisma = calcularMod(carisma);
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

    public String getModFuerza() {
        return modFuerza;
    }

    public void setModFuerza(String modFuerza) {
        this.modFuerza = modFuerza;
    }

    public String getModDestreza() {
        return modDestreza;
    }

    public void setModDestreza(String modDestreza) {
        this.modDestreza = modDestreza;
    }

    public String getModConstitucion() {
        return modConstitucion;
    }

    public void setModConstitucion(String modConstitucion) {
        this.modConstitucion = modConstitucion;
    }

    public String getModSabiduria() {
        return modSabiduria;
    }

    public void setModSabiduria(String modSabiduria) {
        this.modSabiduria = modSabiduria;
    }

    public String getModInteligencia() {
        return modInteligencia;
    }

    public void setModInteligencia(String modInteligencia) {
        this.modInteligencia = modInteligencia;
    }

    public String getModCarisma() {
        return modCarisma;
    }

    public void setModCarisma(String modCarisma) {
        this.modCarisma = modCarisma;
    }

    public int getAspecto() {
        return aspecto;
    }

    public void setAspecto(int aspecto) {
        this.aspecto = aspecto;
    }

    public String calcularMod(String estadistica){
        String modificador = String.valueOf(0);
        if (estadistica.equals("1")) modificador = "-5";
        else if (estadistica.equals("2")||(estadistica.equals("3"))) modificador = "-4";
        else if (estadistica.equals("4")||(estadistica.equals("5"))) modificador = "-3";
        else if (estadistica.equals("6")||(estadistica.equals("7"))) modificador = "-2";
        else if (estadistica.equals("8")||(estadistica.equals("9"))) modificador = "-1";
        else if (estadistica.equals("10")||(estadistica.equals("11"))) modificador = "0";
        else if (estadistica.equals("12")||(estadistica.equals("13"))) modificador = "1";
        else if (estadistica.equals("14")||(estadistica.equals("15"))) modificador = "2";
        else if (estadistica.equals("16")||(estadistica.equals("17"))) modificador = "3";
        else if (estadistica.equals("18")||(estadistica.equals("19"))) modificador = "4";
        else if (estadistica.equals("20")||(estadistica.equals("21"))) modificador = "5";
        return modificador;
    }

}
