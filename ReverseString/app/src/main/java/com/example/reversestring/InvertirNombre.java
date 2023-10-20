package com.example.reversestring;

public class InvertirNombre {

    public static class Solicitud {
        public String nombre;

        public Solicitud(String nombre) {
            this.nombre = nombre;
        }
    }

    interface Callback {
        void cuandoEsteInvirtiendoNombre(String nombreInverso);
    }

    public void invertir(Solicitud solicitud, Callback callback) {
        try {
            Thread.sleep(10000);   // simular operacion de larga duracion (10s)
        } catch (InterruptedException e) {}
        StringBuilder inverso = new StringBuilder();
        for (int i = solicitud.nombre.length() - 1; i >= 0; i--) {
            inverso.append(solicitud.nombre.charAt(i));
        }//from  w ww .j av a 2  s .  c  om
        callback.cuandoEsteInvirtiendoNombre(inverso.toString()); 
    }
}
