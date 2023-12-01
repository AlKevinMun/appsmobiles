package com.example.projectuf1;

import java.util.ArrayList;
import java.util.List;

public class CharacterRepositorio {
    List<Character> characters = new ArrayList<>();

    interface Callback {
        void cuandoFinalice(List<Character> characters);
    }

    CharacterRepositorio(){

    }

    List<Character> obtener() {
        return characters;
    }

    void insertar(Character character, Callback callback){
        characters.add(character);
        callback.cuandoFinalice(characters);
    }

    void eliminar(Character character, Callback callback) {
        characters.remove(character);
        callback.cuandoFinalice(characters);
    }
}
