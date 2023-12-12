package com.example.projectuf1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.projectuf1.databinding.FragmentNuevoPersonajeBinding;


public class NewCharacterFragment extends Fragment {

    private FragmentNuevoPersonajeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentNuevoPersonajeBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CharactersViewModel elementosViewModel = new ViewModelProvider(requireActivity()).get(CharactersViewModel.class);
        NavController navController = Navigation.findNavController(view);


    }
}