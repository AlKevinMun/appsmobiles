package com.example.projectuf1;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class CampaingViewModel extends AndroidViewModel {

    CampaingRepositorio campaingRepositorio;

    public CampaingViewModel(@NonNull Application application) {
        super(application);

        campaingRepositorio = new CampaingRepositorio(application);
    }

    LiveData<List<Campaing>> obtener(){
        return campaingRepositorio.obtener();
    }
    void insertar(Campaing campaing){
        campaingRepositorio.insertar(campaing);
    }

    void eliminar(Campaing campaing){
        campaingRepositorio.eliminar(campaing);
    }

    MutableLiveData<Campaing> campaingSeleccionado = new MutableLiveData<>();

    void seleccionar(Campaing campaing){
        campaingSeleccionado.setValue(campaing);
    }

    MutableLiveData<Campaing> seleccionado(){
        return campaingSeleccionado;
    }

}
