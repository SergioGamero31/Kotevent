package com.example.kotevent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.io.File;

import Fragments.FragmentCotizacion;
import Fragments.FragmentMensaje;
import Fragments.FragmentServicios;
import Fragments.FragmentVideo;
import Fragments.MainFragment;
//Renzo Cuadros Salazar
//Sergio Gamero Calle
//Gricel Ramos Ramos
public class MainActivity extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener{
    String url1, url2;

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;

    private FirebaseAuth mAuth;

    //variables para cargar el fragment principal
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);

        mAuth = FirebaseAuth.getInstance();

        // EVENTO ONCLICK AL NAVIGATION VIEW
        navigationView.setNavigationItemSelectedListener(this);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar, R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();
        // Cargar fragment principal

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, new MainFragment());
        fragmentTransaction.commit();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        url1 = "https://www.facebook.com/PerueventSoft/";
        url2 = "https://twitter.com/PeruEventSoftSA";

        drawerLayout.closeDrawer(GravityCompat.START);

        if(menuItem.getItemId() == R.id.inicio){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, new MainFragment());
            fragmentTransaction.commit();
        }
        if(menuItem.getItemId() == R.id.servicios){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, new FragmentServicios());
            fragmentTransaction.commit();
        }
        if(menuItem.getItemId() == R.id.cotizacion) {
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, new FragmentCotizacion());
            fragmentTransaction.commit();
        }
        if(menuItem.getItemId() == R.id.mensaje){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, new FragmentMensaje());
            fragmentTransaction.commit();
        }
        if(menuItem.getItemId() == R.id.nosotros){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, new FragmentVideo());
            fragmentTransaction.commit();
        }
        if (menuItem.getItemId() == R.id.juego){
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage
                    ("com.NasheGames.SpaceTragedy");
            try {
                startActivity(launchIntent);
            }
            catch (ActivityNotFoundException e) {
                Toast.makeText(this,
                        "No se encontró la aplicación",
                        Toast.LENGTH_LONG).show();
            }
        }
        if(menuItem.getItemId() == R.id.face){
            Uri uri = Uri.parse(url1);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        if(menuItem.getItemId()== R.id.twi){
            Uri uri = Uri.parse(url2);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        if(menuItem.getItemId() == R.id.logout){
            mAuth.signOut();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        }
        return false;
    }
}
