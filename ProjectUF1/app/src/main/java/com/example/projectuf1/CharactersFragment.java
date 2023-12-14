package com.example.projectuf1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.projectuf1.databinding.FragmentCharactersBinding;
import com.example.projectuf1.databinding.ViewholderCharacterBinding;

import java.util.List;

public class CharactersFragment extends Fragment {
    private FragmentCharactersBinding binding;
    private CharactersViewModel charactersViewModel;
    private NavController navController;

    class ElementoViewHolder extends RecyclerView.ViewHolder {
        private final ViewholderCharacterBinding binding;

        public ElementoViewHolder(ViewholderCharacterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }

    class ElementosAdapter extends RecyclerView.Adapter<ElementoViewHolder> {

        List<Character> characters;

        @NonNull
        @Override
        public ElementoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ElementoViewHolder(ViewholderCharacterBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ElementoViewHolder holder, int position) {

            Character character = characters.get(position);

            holder.binding.nombre.setText(character.nombre);
            Glide.with(CharactersFragment.this).load(character.aspecto).into(holder.binding.aspecto);
            holder.binding.raza.setText("Raza: "+character.raza);
            holder.binding.clase.setText("Clase: "+character.clase);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    charactersViewModel.seleccionar(character);
                    navController.navigate(R.id.action_recyclerCampaingsFragment_to_mostrarCampaingFragment);
                }
            });
        }

        @Override
        public int getItemCount() {
            return characters != null ? characters.size() : 0;
        }

        public void establecerLista(List<Character> characters){
            this.characters = characters;
            notifyDataSetChanged();
        }

        public Character obtenerElemento(int posicion){
            return characters.get(posicion);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentCharactersBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        charactersViewModel = new ViewModelProvider(requireActivity()).get(CharactersViewModel.class);
        navController = Navigation.findNavController(view);

        binding.irANuevoElemento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_recyclerCampaingsFragment_to_nuevaCampaingFragment);
            }
        });

        ElementosAdapter elementosAdapter = new ElementosAdapter();
        binding.recyclerView.setAdapter(elementosAdapter);

        charactersViewModel.obtener().observe(getViewLifecycleOwner(), new Observer<List<Character>>() {
            @Override
            public void onChanged(List<Character> characters) {
                elementosAdapter.establecerLista(characters);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.UP | ItemTouchHelper.DOWN,
                ItemTouchHelper.RIGHT  | ItemTouchHelper.LEFT) {

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int posicion = viewHolder.getAdapterPosition();
                Character character = elementosAdapter.obtenerElemento(posicion);
                charactersViewModel.eliminar(character);

            }
        }).attachToRecyclerView(binding.recyclerView);

    }
 }