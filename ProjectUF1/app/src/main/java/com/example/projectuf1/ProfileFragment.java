package com.example.projectuf1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;


public class ProfileFragment extends Fragment {
    private ImageView editar;

    private NavController navController;
    MaterialCalendarView calendarView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        calendarView = view.findViewById(R.id.calendarView);

        editar = view.findViewById(R.id.imageEdit);
        navController = Navigation.findNavController(view);

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.editProfileFragment);
            }
        });
        
        // Configuración adicional del calendario (opcional)
        calendarView.setTopbarVisible(true); // Mostrar la barra superior
        calendarView.setShowOtherDates(MaterialCalendarView.SHOW_ALL); // Mostrar todos los días

        // Manejo de eventos al seleccionar una fecha
        calendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(MaterialCalendarView widget, CalendarDay date, boolean selected) {
                // Manejar la fecha seleccionada (BackEnd que no voy a hacer porque no es necesario)
            }
        });

    }
}