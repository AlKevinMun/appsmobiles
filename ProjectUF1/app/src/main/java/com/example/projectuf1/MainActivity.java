package com.example.projectuf1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.projectuf1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        setContentView((binding = ActivityMainBinding.inflate(getLayoutInflater())).getRoot());

        setSupportActionBar(binding.toolbar);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                // Top-level destinations:
                R.id.homeFragment,R.id.charactersFragment, R.id.campaingFragment
        )
                .setOpenableLayout(binding.drawerLayout)
                .build();

        NavController navController = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment)).getNavController();
        NavigationUI.setupWithNavController(binding.navView, navController);


        // Configura la appbar solo para los fragments que no deben ocultarla

        NavController.OnDestinationChangedListener destinationChangedListener = (controller, destination, arguments) -> {
            if (destination.getId() == R.id.loginFragment || destination.getId() == R.id.registerFragment || destination.getId() == R.id.forgettPasswordFragment) {
                // Muestra la appbar en los fragments que deben tenerla visible
                getSupportActionBar().hide();
                disableDrawer();
            } else {
                // Oculta la appbar en los fragments restantes
                getSupportActionBar().show();
                enableDrawer();
                NavigationUI.setupWithNavController(binding.toolbar, navController, appBarConfiguration);
            }
        };

        navController.addOnDestinationChangedListener(destinationChangedListener);
    }
    private void enableDrawer() {
        binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }
    private void disableDrawer() {
        binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }
}
