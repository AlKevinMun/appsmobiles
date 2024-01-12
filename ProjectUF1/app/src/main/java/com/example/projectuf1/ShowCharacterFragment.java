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
                binding.elegirNombre.setText(String.valueOf(character.nombre));
                binding.elegirEdad.setText(String.valueOf(character.edad));
                binding.spinnerAlineacion.setText(character.alineacion);
                binding.spinnerRaza.setText(character.raza);
                binding.spinnerDeidad.setText(character.deidad);
                binding.spinnerClase.setText(character.clase);
                binding.elegirAltura.setText(String.valueOf(character.altura));
                binding.elegirPeso.setText(String.valueOf(character.peso));
                binding.spinnerGenero.setText(character.genero);
                binding.elegirTamano.setText(String.valueOf(character.tamaño));
                binding.elegirFuerza.setText(String.valueOf(character.fuerza));
                binding.elegirDestreza.setText(String.valueOf(character.destreza));
                binding.elegirConstitucion.setText(String.valueOf(character.constitucion));
                binding.elegirSabiduria.setText(String.valueOf(character.sabiduria));
                binding.elegirInteligencia.setText(String.valueOf(character.inteligencia));
                binding.elegirCarisma.setText(String.valueOf(character.carisma));
                binding.modFuerza.setText(String.valueOf(character.modFuerza));
                binding.modDestreza.setText(String.valueOf(character.modDestreza));
                binding.modConstitucion.setText(String.valueOf(character.modConstitucion));
                binding.modSabiduria.setText(String.valueOf(character.modSabiduria));
                binding.modInteligencia.setText(String.valueOf(character.modInteligencia));
                binding.modCarisma.setText(String.valueOf(character.modCarisma));
                Glide.with(ShowCharacterFragment.this).load(character.aspecto).into(binding.aspecto);

            }
        });


    }
}