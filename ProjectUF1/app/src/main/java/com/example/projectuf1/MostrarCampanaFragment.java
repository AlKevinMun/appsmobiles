package com.example.projectuf1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.bumptech.glide.Glide;
import com.example.projectuf1.databinding.FragmentMostrarCampanaBinding;

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

        binding.apuntarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(MostrarCampanaFragment.this);
            }
        });

    }

    private void showDialog(MostrarCampanaFragment fragment) {
        // Infla el diseño de la ventana de diálogo personalizada
        LayoutInflater inflater = LayoutInflater.from(fragment.getContext());
        View dialogView = inflater.inflate(R.layout.dialogo_insertar_nombre, null);

        // Encuentra el EditText en la vista del diálogo
        final EditText username = dialogView.findViewById(R.id.username);

        // Crea el cuadro de diálogo
        AlertDialog.Builder builder = new AlertDialog.Builder(fragment.getContext());
        builder.setView(dialogView)
                .setTitle("Apuntarse a la campaña")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Obtiene el texto del EditText al hacer clic en Aceptar
                        String enteredName = username.getText().toString();
                        binding.jugadores.setText(binding.jugadores.getText()+" "+enteredName+" -");
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Cancelar, no se realiza ninguna acción
                    }
                });

        // Muestra el cuadro de diálogo
        builder.create().show();
    }


}