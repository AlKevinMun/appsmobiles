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
import com.example.projectuf1.databinding.FragmentMostrarPersonajeBinding;
import com.example.projectuf1.databinding.FragmentNuevoPersonajeBinding;


public class ShowCharacterFragment extends Fragment {

    private FragmentMostrarPersonajeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentMostrarPersonajeBinding.inflate(inflater,container,false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CharactersViewModel elementosViewModel = new ViewModelProvider(requireActivity()).get(CharactersViewModel.class);

        elementosViewModel.seleccionado().observe(getViewLifecycleOwner(), new Observer<Character>() {
            @Override
            public void onChanged(Character character) {
                binding.elegirNombre.setText(character.nombre);
                binding.elegirEdad.setText(character.edad);
                binding.spinnerAlineacion.setText(character.alineacion);
                binding.spinnerRaza.setText(character.raza);
                binding.spinnerDeidad.setText(character.deidad);
                binding.spinnerClase.setText(character.clase);
                binding.elegirAltura.setText(character.altura);
                binding.elegirPeso.setText(character.peso);
                binding.spinnerGenero.setText(character.genero);
                binding.elegirTamano.setText(character.tamaño);
                binding.elegirFuerza.setText(character.fuerza);
                binding.elegirDestreza.setText(character.destreza);
                binding.elegirConstitucion.setText(character.constitucion);
                binding.elegirSabiduria.setText(character.sabiduria);
                binding.elegirInteligencia.setText(character.inteligencia);
                binding.elegirCarisma.setText(character.carisma);
                Glide.with(ShowCharacterFragment.this).load(character.aspecto).into(binding.aspecto);

            }
        });


    }
}