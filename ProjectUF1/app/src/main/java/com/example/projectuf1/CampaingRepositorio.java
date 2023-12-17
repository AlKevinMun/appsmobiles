package com.example.projectuf1;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CampaingRepositorio {

    CampaingBaseDeDatos.CampaingDao campaingDao;
    Executor executor = Executors.newSingleThreadExecutor();

    CampaingRepositorio(Application application){
        campaingDao = CampaingBaseDeDatos.obtenerInstancia(application).obtenerElementosDao();
    }

    LiveData<List<Campaing>> obtener(){
        return campaingDao.obtener();
    }

    void insertar(Campaing campaing){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                campaingDao.insertar(campaing);
            }
        });
    }

    void eliminar(Campaing campaing) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                campaingDao.eliminar(campaing);
            }
        });
    }

}
