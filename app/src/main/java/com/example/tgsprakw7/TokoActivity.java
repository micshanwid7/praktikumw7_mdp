package com.example.tgsprakw7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class TokoActivity extends AppCompatActivity {

    public static String EXTRA_USER = "extra_user";

    BottomNavigationView btmNav;
    TokoActivity selfs;

    AppDatabase db;

    ArrayList<User> listuser = new ArrayList<>();

    ArrayList<Penjualan> listpembelian = new ArrayList<>();

    ArrayList<Penjualan> tmprv = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toko);

        this.selfs = this;
        btmNav = findViewById(R.id.bottomNav2);

        db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"TugasW7").allowMainThreadQueries().build();

        if(getIntent().hasExtra(EXTRA_USER) && getIntent().getParcelableArrayListExtra(EXTRA_USER) != null){
            listuser = getIntent().getParcelableArrayListExtra(EXTRA_USER);
        }else{
            listuser = null;
        }

        showFragment(new ExploreTFragment(selfs));

        btmNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;

                switch (item.getItemId()){
                    case R.id.fragt_exp:
                        fragment = ExploreTFragment.newInstance(selfs);
                        getSupportFragmentManager().beginTransaction().replace(R.id.container2,fragment).commit();
                        return true;
                    case R.id.fragt_pilih:
                        fragment  = AddTFragment.newInstance(selfs);
                        getSupportFragmentManager().beginTransaction().replace(R.id.container2,fragment).commit();
                        return true;
                }
                return false;
            }
        });
    }

    public void showFragment(Fragment fragment){
        Bundle argument = new Bundle();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        fragment.setArguments(argument);
        transaction.replace(R.id.container2, fragment);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu_activity,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent i;
        if(item.getItemId() == R.id.it_logout){
            i = new Intent(TokoActivity.this, LoginActivity.class);
            startActivity(i);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}