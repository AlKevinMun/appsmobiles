package com.example.reversestring;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ReverseStringViewModel extends AndroidViewModel {

    Executor executor;

    InvertirNombre invertirNombre;

    MutableLiveData<String> nombreRes = new MutableLiveData<>();

    public ReverseStringViewModel(@NonNull Application application) {
        super(application);

        executor = Executors.newSingleThreadExecutor();
        invertirNombre = new InvertirNombre();
    }

    public void invertir(String nombre) {

        final InvertirNombre.Solicitud solicitud = new InvertirNombre.Solicitud(nombre);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                invertirNombre.invertir(solicitud, new InvertirNombre.Callback() {
                    @Override
                    public void cuandoEsteInvirtiendoNombre(String nombreInverso) {
                        nombreRes.postValue(nombreInverso);
                    }
                });

            }
        });
    }
}
