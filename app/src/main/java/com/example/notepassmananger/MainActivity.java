package com.example.notepassmananger;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.notepassmananger.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavController navController;
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Initialize DrawerLayout and NavigationView
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        // Define top-level destinations
        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.FirstFragment, R.id.SecondFragment, R.id.Thirdfragement)
                .setOpenableLayout(drawerLayout)
                .build();

        // Set up NavController
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        // Set up ActionBar with NavController and DrawerLayout
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        // Set up NavigationView with NavController
        NavigationUI.setupWithNavController(navigationView, navController);

        // Handle navigation item clicks
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_notes) {
            navController.navigate(R.id.notesFragment);
        } else if (id == R.id.nav_password_manager) {
            navController.navigate(R.id.passwordManagerFragment);
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


}
