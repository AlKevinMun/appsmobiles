package com.example.livedatalunarciclo;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

public class LunarViewModel extends AndroidViewModel {
    FaseLunar faseLunar;

    LiveData<Integer> LunarLiveData;
    LiveData<String> repeticionLiveData;
    LiveData<String> sumaDias;

    public LunarViewModel(@NonNull Application application) {
        super(application);

        faseLunar = new FaseLunar();

        LunarLiveData = Transformations.switchMap(faseLunar.ordenLiveData, new Function<String, LiveData<Integer>>() {

            String faseAnterior;

            @Override
            public LiveData<Integer> apply(String orden) {

                String ejercicio = orden.split(":")[0];

                if(!ejercicio.equals(faseAnterior)){
                    faseAnterior = ejercicio;
                    int imagen;
                    switch (ejercicio) {
                        case "FASE1":
                        default:
                            imagen = R.drawable.l1;
                            break;
                        case "FASE2":
                            imagen = R.drawable.l2;
                            break;
                        case "FASE3":
                            imagen = R.drawable.l3;
                            break;
                        case "FASE4":
                            imagen = R.drawable.l4;
                            break;
                        case "FASE5":
                            imagen = R.drawable.l5;
                            break;
                        case "FASE6":
                            imagen = R.drawable.l6;
                            break;
                        case "FASE7":
                            imagen = R.drawable.l7;
                            break;
                    }

                    return new MutableLiveData<>(imagen);
                }
                return null;
            }
        });

        repeticionLiveData = Transformations.switchMap(faseLunar.ordenLiveData, new Function<String, LiveData<String>>() {
            @Override
            public LiveData<String> apply(String orden) {
                return new MutableLiveData<>(orden.split(":")[1]);
            }
        });
        sumaDias = Transformations.switchMap(faseLunar.ordenLiveData, new Function<String, LiveData<String>>() {
            @Override
            public LiveData<String> apply(String orden) {
                return new MutableLiveData<>(orden.split(":")[2]);
            }
        });
    }

    LiveData<Integer> obtenerEjercicio(){
        return LunarLiveData;
    }

    LiveData<String> obtenerRepeticion(){
        return repeticionLiveData;
    }

    LiveData<String> obtenerDias(){return sumaDias;}
}