package com.example.tgsprakw7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    EditText user,pass;
    Button login;

    ArrayList<User> listuser = new ArrayList<>();

    AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"TugasW7").allowMainThreadQueries().build();

        user = findViewById(R.id.edl_user);
        pass = findViewById(R.id.edl_pass);
        login = findViewById(R.id.btn_login);

        user.setText("");
        pass.setText("");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u = user.getText().toString();
                String p = pass.getText().toString();
                if(!u.equals("") && !p.equals("")) {
                    int tmptot = db.userDao().getCountUser(u);
                    if (tmptot > 0) {
                        listuser.clear();
                        User tmp = db.userDao().getUser(u);
                        listuser.add(tmp);
                        int tmpstat = tmp.getStatus();
                        Intent i;
                        String tmpnama = tmp.getNama();
                        if(tmp.getPassword().equals(p)) {
                            if (tmpnama.equals("")) {
                                i = new Intent(LoginActivity.this, NewLoginActivity.class);
                                i.putExtra(NewLoginActivity.EXTRA_LOGIN, u);
                                i.putExtra(NewLoginActivity.EXTRA_USER, listuser);
                                i.putExtra(NewLoginActivity.EXTRA_STATUS, tmpstat);
                                startActivity(i);
                            } else {
                                if (tmpstat == 1) {
                                    i = new Intent(LoginActivity.this, UserActivity.class);
                                    i.putExtra(UserActivity.EXTRA_USER, listuser);
                                    startActivity(i);
                                } else {
                                    i = new Intent(LoginActivity.this, TokoActivity.class);
                                    i.putExtra(TokoActivity.EXTRA_USER, listuser);
                                    startActivity(i);
                                }
                            }
                        }else{
                            Toast.makeText(LoginActivity.this, "Password salah", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(LoginActivity.this, "Username tidak terdaftar", Toast.LENGTH_SHORT).show();
                        user.setText("");
                        pass.setText("");
                    }
                }else{
                    Toast.makeText(LoginActivity.this, "Terdapat isian yang kosong", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent i;
        if(item.getItemId() == R.id.it_register){
            i = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}