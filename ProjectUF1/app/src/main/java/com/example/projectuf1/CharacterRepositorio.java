package com.example.projectuf1;

import java.util.ArrayList;
import java.util.List;

public class CharacterRepositorio {
    List<Character> characters = new ArrayList<>();

    interface Callback {
        void cuandoFinalice(List<Character> characters);
    }

    CharacterRepositorio(){
        characters.add(new Character("Lydiel","36","Caotico Bueno","Half-Dead","azar","Mago","167","35","Mujer","0","10","10","10","10","10","10",R.drawable.lydiel));
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
