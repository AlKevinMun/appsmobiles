package com.example.roomtemplate;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ElementosRepositorio {

    ElementosBaseDeDatos.ElementosDao elementosDao;

    ElementosRepositorio(Application application){
        elementosDao = ElementosBaseDeDatos.obtenerInstancia(application).obtenerElementosDao();
    }

    Executor executor = Executors.newSingleThreadExecutor();

    void insertar(Elemento elemento){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                elementosDao.insertar(elemento);
            }
        });
    }

    void eliminar(Elemento elemento) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                elementosDao.eliminar(elemento);
            }
        });
    }

    public void actualizar(Elemento elemento, float valoracion) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                elemento.valoracion = valoracion;
                elementosDao.actualizar(elemento);
            }
        });
    }
    LiveData<List<Elemento>> obtener(){
        return elementosDao.obtener();
    }


    LiveData<List<Elemento>> masValorados() {
        return elementosDao.masValorados();
    }

    LiveData<List<Elemento>> buscar(String t) {
        return elementosDao.buscar(t);
    }

}
