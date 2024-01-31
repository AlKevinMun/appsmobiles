package com.example.socialdnd;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class profileFragment extends Fragment {

    ImageView photoImageView;
    TextView displayNameTextView, emailTextView;
    Button editProfile;
    private View rootView;


    public profileFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rootView = view; // Asigna la vista actual a rootView

        photoImageView = view.findViewById(R.id.photoImageView);
        displayNameTextView = view.findViewById(R.id.displayNameTextView);
        emailTextView = view.findViewById(R.id.emailTextView);
        editProfile = view.findViewById(R.id.editProfile);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


        if(user != null){
            String name = user.getEmail().split("@")[0].toString();
            if (user.getDisplayName() != null){
                displayNameTextView.setText(user.getDisplayName());
            }
            else {
                displayNameTextView.setText(name);
            }
            emailTextView.setText(user.getEmail());
            if (user.getPhotoUrl() == null){
                Glide.with(requireView()).load(R.drawable.pfp).circleCrop().into(photoImageView);
            } else {
                Glide.with(requireView()).load(user.getPhotoUrl()).circleCrop().into(photoImageView);
            }
        }
        else{

        }

    }

    private void mostrarSnackbar(String mensaje) {
        Snackbar.make(rootView, mensaje, Snackbar.LENGTH_LONG).show();
    }

}