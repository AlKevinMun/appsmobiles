package com.example.projectuf1;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CharacterRepositorio {

    CharactersBaseDeDatos.CharactersDao charactersDao;

    CharacterRepositorio(Application application){
        charactersDao = CharactersBaseDeDatos.obtenerInstancia(application).obtenerElementosDao();
    }

    Executor executor = Executors.newSingleThreadExecutor();


    LiveData<List<Character>> obtener(){
        return charactersDao.obtener();
    }


    void insertar(Character character){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                charactersDao.insertar(character);
            }
        });
    }

    void eliminar(Character character) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                charactersDao.eliminar(character);
            }
        });
    }
}
