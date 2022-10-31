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
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText user,pass;
    RadioButton rb1,rb2;
    Button regis;

    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"TugasW7").allowMainThreadQueries().build();

        user = findViewById(R.id.edr_user);
        pass = findViewById(R.id.edr_pass);
        rb1 = findViewById(R.id.rb_user);
        rb2 = findViewById(R.id.rb_toko);
        regis = findViewById(R.id.btn_regis);

        user.setText("");
        pass.setText("");
        rb1.isChecked();

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u = user.getText().toString();
                String p = pass.getText().toString();
                if(!user.getText().toString().equals("") && !pass.getText().toString().equals("")){
                    int status = 0;
                    int tmptot = 0;
                    if(rb1.isChecked() == true){
                        status = 1;
                        tmptot = db.userDao().getCountUser(u);
                        if(tmptot > 0){
                            Toast.makeText(RegisterActivity.this, "Username telah dipakai", Toast.LENGTH_SHORT).show();
                        }else{
                            db.userDao().insert(new User(u,"","", p, "", status));
                            Toast.makeText(RegisterActivity.this, "Berhasl insert user", Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        status = 2;
                        tmptot = db.userDao().getCountUser(u);
                        if(tmptot > 0){
                            Toast.makeText(RegisterActivity.this, "Username telah dipakai", Toast.LENGTH_SHORT).show();
                        }else{
                            db.userDao().insert(new User(u,"","", p, "", status));
                            Toast.makeText(RegisterActivity.this, "Berhasil insert user", Toast.LENGTH_SHORT).show();
                        }
                    }
                    user.setText("");
                    pass.setText("");
                }else{
                    Toast.makeText(RegisterActivity.this, "Terdapat isian yang kosong", Toast.LENGTH_SHORT).show();
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
        if(item.getItemId() == R.id.it_login){
            i = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(i);

        }
        return super.onOptionsItemSelected(item);
    }
}