package com.example.projectuf1;

import java.util.ArrayList;
import java.util.List;

public class CampaingRepositorio {

    List<Campaing> campaings = new ArrayList<>();

    interface Callback {
        void cuandoFinalice(List<Campaing> elementos);
    }

    CampaingRepositorio(){
    }

    List<Campaing> obtener() {
        return campaings;
    }

    void insertar(Campaing campaing, Callback callback){
        campaings.add(campaing);
        callback.cuandoFinalice(campaings);
    }

    void eliminar(Campaing campaing, Callback callback) {
        campaings.remove(campaing);
        callback.cuandoFinalice(campaings);
    }

}
