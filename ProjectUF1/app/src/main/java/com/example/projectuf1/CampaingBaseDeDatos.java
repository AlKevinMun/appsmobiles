package com.example.projectuf1;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.Update;

import java.util.List;

@Database(entities = {Campaing.class}, version = 1, exportSchema = false)
public abstract class CampaingBaseDeDatos extends RoomDatabase {

    private static volatile CampaingBaseDeDatos INSTANCIA;

    static CampaingBaseDeDatos obtenerInstancia(final Context context) {
        if (INSTANCIA == null) {
            synchronized (CampaingBaseDeDatos.class) {
                if (INSTANCIA == null) {
                    INSTANCIA = Room.databaseBuilder(context,
                                    CampaingBaseDeDatos.class, "campaing.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCIA;
    }
    public abstract CampaingDao obtenerElementosDao();
    @Dao
    interface CampaingDao {
        @Query("SELECT * FROM Campaing")
        LiveData<List<Campaing>> obtener();

        @Insert
        void insertar(Campaing campaing);

        @Update
        void actualizar(Campaing campaing);

        @Delete
        void eliminar(Campaing campaing);
    }
}
