package com.example.projectuf1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projectuf1.databinding.FragmentNuevaCampanaBinding;
import com.example.projectuf1.databinding.FragmentNuevoPersonajeBinding;

public class NuevaCampanaFragment extends Fragment {

    private FragmentNuevaCampanaBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentNuevaCampanaBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CampaingViewModel elementosViewModel = new ViewModelProvider(requireActivity()).get(CampaingViewModel.class);
        NavController navController = Navigation.findNavController(view);

        binding.crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = binding.editarNombre.getText().toString();
                String descripcion = binding.editarDescripcion.getText().toString();
                String master = binding.editarMaster.getText().toString();
                int maxPlayers = Integer.parseInt(binding.editarMaxPlayers.getText().toString());
                String playerApuntados = binding.jugadores.getText().toString();
                String flexibilidad = binding.editarFlexibilidad.getText().toString();
                String fechaInicio = binding.editarFecha.getText().toString();
                String duracion = binding.editarTiempo.getText().toString();
                String sesiones = binding.editarSesiones.getText().toString();
                String detallesExtra = binding.editarDatos.getText().toString();
                int mapa = R.drawable.mapa;

                elementosViewModel.insertar(new Campaing(nombre, descripcion, master, maxPlayers, playerApuntados, flexibilidad, fechaInicio, duracion, sesiones, detallesExtra, mapa));

                navController.popBackStack();
            }
        });


    }
}