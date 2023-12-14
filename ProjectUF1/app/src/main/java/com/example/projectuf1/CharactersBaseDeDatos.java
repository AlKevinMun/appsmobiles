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

@Database(entities = {Character.class}, version = 1, exportSchema = false)
public abstract class CharactersBaseDeDatos extends RoomDatabase {

    public abstract CharactersDao obtenerElementosDao();
    private static volatile CharactersBaseDeDatos INSTANCIA;

    static CharactersBaseDeDatos obtenerInstancia(final Context context) {
        if (INSTANCIA == null) {
            synchronized (CharactersBaseDeDatos.class) {
                if (INSTANCIA == null) {
                    INSTANCIA = Room.databaseBuilder(context,
                                    CharactersBaseDeDatos.class, "elementos.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCIA;
    }

    @Dao
    interface CharactersDao {
        @Query("SELECT * FROM Character")
        LiveData<List<Character>> obtener();

        @Insert
        void insertar(Character character);

        @Update
        void actualizar(Character character);

        @Delete
        void eliminar(Character character);
    }

}
