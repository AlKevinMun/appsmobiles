package com.example.projectuf1;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class CampaingViewModel extends AndroidViewModel {

    CampaingRepositorio campaingRepositorio;

    MutableLiveData<List<Campaing>> listElementosMutableLiveData = new MutableLiveData<>();

    public CampaingViewModel(@NonNull Application application) {
        super(application);

        campaingRepositorio = new CampaingRepositorio();

        listElementosMutableLiveData.setValue(campaingRepositorio.obtener());
    }

    MutableLiveData<List<Campaing>> obtener(){
        return listElementosMutableLiveData;
    }

    void insertar(Campaing campaing){
        campaingRepositorio.insertar(campaing, new CampaingRepositorio.Callback() {
            @Override
            public void cuandoFinalice(List<Campaing> campaings) {
                listElementosMutableLiveData.setValue(campaings);
            }
        });
    }

    void eliminar(Campaing campaing){
        campaingRepositorio.eliminar(campaing, new CampaingRepositorio.Callback() {
            @Override
            public void cuandoFinalice(List<Campaing> campaings) {
                listElementosMutableLiveData.setValue(campaings);
            }
        });
    }

}
