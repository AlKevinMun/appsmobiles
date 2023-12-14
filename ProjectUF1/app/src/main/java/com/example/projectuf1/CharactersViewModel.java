package com.example.projectuf1;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class CharactersViewModel extends AndroidViewModel {
    CharacterRepositorio characterRepositorio;

    MutableLiveData<Character> characterSeleccionado = new MutableLiveData<>();



    public CharactersViewModel(@NonNull Application application){
        super(application);

        characterRepositorio = new CharacterRepositorio(application);

        //listMutableLiveData.setValue(characterRepositorio.obtener());
    }

    LiveData<List<Character>> obtener(){
        return characterRepositorio.obtener();
    }
    void insertar(Character character){
        characterRepositorio.insertar(character);
    }

    void eliminar(Character character){
        characterRepositorio.eliminar(character);
    }

    void seleccionar(Character character){
        characterSeleccionado.setValue(character);
    }

    MutableLiveData<Character> seleccionado(){
        return characterSeleccionado;
    }

}
