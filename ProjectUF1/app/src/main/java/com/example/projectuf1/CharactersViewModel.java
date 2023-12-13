package com.example.projectuf1;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class CharactersViewModel extends AndroidViewModel {
    CharacterRepositorio characterRepositorio;

    MutableLiveData<List<Character>> listMutableLiveData = new MutableLiveData<>();

    MutableLiveData<Character> characterSeleccionado = new MutableLiveData<>();

    public CharactersViewModel(@NonNull Application application){
        super(application);

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

    void seleccionar(Character character){
        characterSeleccionado.setValue(character);
    }

    MutableLiveData<Character> seleccionado(){
        return characterSeleccionado;
    }

}
