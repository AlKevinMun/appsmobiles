package com.example.livedatalunarciclo;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.SECONDS;

import androidx.lifecycle.LiveData;

public class FaseLunar {

    LiveData<String> ordenLiveData = new LiveData<String>() {
        @Override
        protected void onActive() {
            super.onActive();

            iniciarCambioFase(new FaseLunarListener() {
                @Override
                public void cuandoDeLaOrden(String orden) {
                    postValue(orden);
                }
            });
        }

        @Override
        protected void onInactive() {
            super.onInactive();

            pararCambioFases();
        }
    };

    interface FaseLunarListener {
        void cuandoDeLaOrden(String orden);
    }

    Random random = new Random();
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    ScheduledFuture<?> FaseLunar;

    void iniciarCambioFase(FaseLunarListener faseLunarListener) {
        if (FaseLunar == null || FaseLunar.isCancelled()) {
            FaseLunar = scheduler.scheduleAtFixedRate(new Runnable() {
                int Fase;
                int repeticiones = -1;
                int dias = 1;

                @Override
                public void run() {
                    if (repeticiones < 0) {
                        repeticiones = 7;
                        Fase ++;
                    }
                    dias++;
                    faseLunarListener.cuandoDeLaOrden("FASE" + Fase + ":" + (repeticiones == 0 ? "CAMBIO" : repeticiones)+":"+dias);
                    repeticiones--;
                    if (Fase==7) Fase=1;
                }
            }, 0, 1, SECONDS);
        }
    }

    void pararCambioFases() {
        if (FaseLunar != null) {
            FaseLunar.cancel(true);
        }
    }
}