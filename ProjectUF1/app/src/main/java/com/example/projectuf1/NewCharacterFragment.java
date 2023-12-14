package com.example.projectuf1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.projectuf1.databinding.FragmentNuevoPersonajeBinding;


public class NewCharacterFragment extends Fragment {

    private FragmentNuevoPersonajeBinding binding;
    private String alineacion;
    private String raza;
    private String deidad;
    private String clase;
    private String genero;

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

        Spinner spinnerAlineacion = (Spinner) binding.spinnerAlineacion;
        Spinner spinnerRaza = (Spinner) binding.spinnerRaza;
        Spinner spinnerDeidad = (Spinner) binding.spinnerDeidad;
        Spinner spinnerClase = (Spinner) binding.spinnerClase;
        Spinner spinnerGenero = (Spinner) binding.spinnerGenero;
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterAlineacion = ArrayAdapter.createFromResource(requireContext(), R.array.alineaciones, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterRaza = ArrayAdapter.createFromResource(requireContext(), R.array.razas, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterDeidad = ArrayAdapter.createFromResource(requireContext(), R.array.deidades, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterClase = ArrayAdapter.createFromResource(requireContext(), R.array.clases, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterGenero = ArrayAdapter.createFromResource(requireContext(), R.array.generos, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterAlineacion.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterRaza.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterDeidad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterClase.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterGenero.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerAlineacion.setAdapter(adapterAlineacion);
        spinnerRaza.setAdapter(adapterRaza);
        spinnerDeidad.setAdapter(adapterDeidad);
        spinnerClase.setAdapter(adapterClase);
        spinnerGenero.setAdapter(adapterGenero);

        spinnerAlineacion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Obtener el texto del elemento seleccionado en el Spinner de Alineación
                alineacion = parentView.getItemAtPosition(position).toString();
                // Puedes usar 'selectedAlineacion' según tus necesidades
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Acciones a realizar cuando no se selecciona nada
            }
        });

        spinnerRaza.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Obtener el texto del elemento seleccionado en el Spinner de Alineación
                raza = parentView.getItemAtPosition(position).toString();
                // Puedes usar 'selectedAlineacion' según tus necesidades
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Acciones a realizar cuando no se selecciona nada
            }
        });

        spinnerDeidad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Obtener el texto del elemento seleccionado en el Spinner de Alineación
                deidad = parentView.getItemAtPosition(position).toString();
                // Puedes usar 'selectedAlineacion' según tus necesidades
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Acciones a realizar cuando no se selecciona nada
            }
        });

        spinnerClase.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Obtener el texto del elemento seleccionado en el Spinner de Alineación
                clase = parentView.getItemAtPosition(position).toString();
                // Puedes usar 'selectedAlineacion' según tus necesidades
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Acciones a realizar cuando no se selecciona nada
            }
        });

        spinnerGenero.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Obtener el texto del elemento seleccionado en el Spinner de Alineación
                genero = parentView.getItemAtPosition(position).toString();
                // Puedes usar 'selectedAlineacion' según tus necesidades
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Acciones a realizar cuando no se selecciona nada
            }
        });

        binding.crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = binding.elegirNombre.getText().toString();
                int edad = Integer.parseInt(binding.elegirEdad.getText().toString());
                int altura = Integer.parseInt(binding.elegirAltura.getText().toString());
                int peso = Integer.parseInt(binding.elegirPeso.getText().toString());
                int tamaño = Integer.parseInt(binding.elegirTamano.getText().toString());
                int fuerza = Integer.parseInt(binding.elegirFuerza.getText().toString());
                int destreza = Integer.parseInt(binding.elegirDestreza.getText().toString());
                int constitucion = Integer.parseInt(binding.elegirConstitucion.getText().toString());
                int sabiduria = Integer.parseInt(binding.elegirSabiduria.getText().toString());
                int inteligencia = Integer.parseInt(binding.elegirInteligencia.getText().toString());
                int carisma = Integer.parseInt(binding.elegirCarisma.getText().toString());
                int aspecto = R.drawable.lydiel;

                elementosViewModel.insertar(new Character(nombre,edad,alineacion,raza,deidad,clase,altura,peso,genero,tamaño,fuerza,destreza,constitucion,sabiduria,inteligencia,carisma,aspecto));

                navController.popBackStack();
            }
        });
    }
}