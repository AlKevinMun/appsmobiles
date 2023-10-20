package com.example.reversestring;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.reversestring.databinding.FragmentReverseNameBinding;

public class ReverseNameFragment extends Fragment {
    private FragmentReverseNameBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentReverseNameBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ReverseStringViewModel reverseStringViewModel = new ViewModelProvider(this).get(ReverseStringViewModel.class);

        binding.Invertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre = binding.Nombre.getText().toString();
                reverseStringViewModel.invertir(nombre);
            }
        });

        reverseStringViewModel.nombreRes.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String nombre) {
                binding.NombreInverso.setText(String.format("%s",nombre));
            }
        });
    }
}