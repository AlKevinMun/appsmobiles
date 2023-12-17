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
import com.example.projectuf1.databinding.FragmentCampaingBinding;
import com.example.projectuf1.databinding.ViewholderCampaingBinding;

import java.util.List;


public class CampaingFragment extends Fragment {

    private FragmentCampaingBinding binding;
    private CampaingViewModel campaingViewModel;
    private NavController navController;



    class CampaingViewHolder extends RecyclerView.ViewHolder {
        private final ViewholderCampaingBinding binding;

        public CampaingViewHolder(ViewholderCampaingBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    class CampaingAdapter extends RecyclerView.Adapter<CampaingViewHolder> {

        List<Campaing> campaings;

        @NonNull
        @Override
        public CampaingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new CampaingViewHolder(ViewholderCampaingBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull CampaingViewHolder holder, int position) {

            Campaing campaing = campaings.get(position);

            holder.binding.nombre.setText(campaing.nombre);
            Glide.with(CampaingFragment.this).load(campaing.mapa).into(holder.binding.aspecto);
            holder.binding.master.setText("Mastrer: "+campaing.master);
            holder.binding.maxPlayers.setText("Maximo de jugadores: "+campaing.maxPlayers);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    campaingViewModel.seleccionar(campaing);
                    navController.navigate(R.id.action_recyclerCampaingsFragment_to_mostrarCampaingFragment);
                }
            });
        }

        @Override
        public int getItemCount() {
            return campaings != null ? campaings.size() : 0;
        }

        public void establecerLista(List<Campaing> campaings){
            this.campaings = campaings;
            notifyDataSetChanged();
        }


        public Campaing obtenerElemento(int posicion){
            return campaings.get(posicion);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentCampaingBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        campaingViewModel = new ViewModelProvider(requireActivity()).get(CampaingViewModel.class);
        navController = Navigation.findNavController(view);

        CampaingAdapter campaingAdapter = new CampaingAdapter();
        binding.recyclerView.setAdapter(campaingAdapter);

        campaingViewModel.obtener().observe(getViewLifecycleOwner(), new Observer<List<Campaing>>() {
            @Override
            public void onChanged(List<Campaing> campaings) {
                campaingAdapter.establecerLista(campaings);
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
                Campaing campaing = campaingAdapter.obtenerElemento(posicion);
                campaingViewModel.eliminar(campaing);

            }
        }).attachToRecyclerView(binding.recyclerView);

        binding.irANuevoElemento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_recyclerCampaingsFragment_to_nuevaCampaingFragment);
            }
        });
    }
}