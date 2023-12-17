package com.example.projectuf1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.projectuf1.databinding.FragmentMostrarCampanaBinding;
import com.example.projectuf1.databinding.FragmentMostrarPersonajeBinding;

public class MostrarCampanaFragment extends Fragment {
    private FragmentMostrarCampanaBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentMostrarCampanaBinding.inflate(inflater,container,false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CampaingViewModel campaingViewModel = new ViewModelProvider(requireActivity()).get(CampaingViewModel.class);

        campaingViewModel.seleccionado().observe(getViewLifecycleOwner(), new Observer<Campaing>() {
            @Override
            public void onChanged(Campaing campaing) {
                binding.editarNombre.setText(campaing.nombre);
                binding.editarDescripcion.setText(campaing.descripcion);
                binding.editarMaster.setText(campaing.master);
                binding.editarMaxPlayers.setText(campaing.maxPlayers+"");
                binding.editarFlexibilidad.setText(campaing.flexibilidad);
                binding.editarFecha.setText(campaing.fechaInicio);
                binding.editarTiempo.setText(campaing.duracion);
                binding.editarSesiones.setText(campaing.intervaloEntreSesiones);
                binding.editarDatos.setText(campaing.detallesExtra);
                Glide.with(MostrarCampanaFragment.this).load(campaing.mapa).into(binding.mapa);

            }
        });
    }
}