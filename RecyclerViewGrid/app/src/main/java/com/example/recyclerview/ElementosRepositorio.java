package com.example.recyclerview;

import java.util.ArrayList;
import java.util.List;

public class ElementosRepositorio {

    List<Elemento> elementos = new ArrayList<>();

    interface Callback {
        void cuandoFinalice(List<Elemento> elementos);
    }

    ElementosRepositorio(){
        elementos.add(new Elemento("Humano", "La raza humana se caracteriza por no ser muy longeva",R.drawable.humano));
        elementos.add(new Elemento("Elfo", "La raza elfica destaca por su larga longevidad y su vida en los bosques",R.drawable.elfo));
        elementos.add(new Elemento("Enano", "La raza enana se caracteriza de subaja estatura y su gran habilidad metalurgica",R.drawable.enano));
        elementos.add(new Elemento("Gnomo", "Esta raza es una especie de fusion entre los humanos y los enanos",R.drawable.gnomo));
        elementos.add(new Elemento("Orco", "La raza de orcos se caracteriza por su poca inteligencia, y su gran habilidad en combates fisicos",R.drawable.orco));
        elementos.add(new Elemento("Kobol", "La raza de kobols es una raza monstruosa que normalmente atormenta a humanos y gnomos",R.drawable.kobol));

    }

    List<Elemento> obtener() {
        return elementos;
    }

    void insertar(Elemento elemento, Callback callback){
        elementos.add(elemento);
        callback.cuandoFinalice(elementos);
    }

    void eliminar(Elemento elemento, Callback callback) {
        elementos.remove(elemento);
        callback.cuandoFinalice(elementos);
    }
}
