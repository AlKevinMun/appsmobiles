package com.example.projectuf1;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class CharactersViewModel {
    CharacterRepositorio characterRepositorio;

    MutableLiveData<List<Character>> listMutableLiveData = new MutableLiveData<>();

    public CharactersViewModel(@NonNull Application application){
        super();

        characterRepositorio = new CharacterRepositorio();

        listMutableLiveData.setValue(characterRepositorio.obtener());
    }

    MutableLiveData<List<Character>> obtener(){
        return listMutableLiveData;
    }

    void insertar(Character character){
        characterRepositorio.insertar(character, new CharacterRepositorio.Callback() {
            @Override
            public void cuandoFinalice(List<Character> characters) {
                listMutableLiveData.setValue(characters);
            }
        });
    }

    void eliminar(Character character){
        characterRepositorio.eliminar(character, new CharacterRepositorio.Callback() {
            @Override
            public void cuandoFinalice(List<Character> characters) {
                listMutableLiveData.setValue(characters);
            }
        });
    }

}
