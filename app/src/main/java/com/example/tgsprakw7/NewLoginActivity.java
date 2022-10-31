package com.example.tgsprakw7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class NewLoginActivity extends AppCompatActivity {

    public static String EXTRA_USER = "extra_user";
    public static String EXTRA_LOGIN = "extra_login";
    public static String EXTRA_STATUS = "extra_status";

    EditText edtnama,edtemail,edtlok;
    Button btnsub;

    AppDatabase db;
    String tmpusername;
    int statuslogin = 0;

    ArrayList<User> listuser = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_login);

        db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"TugasW7").allowMainThreadQueries().build();

        edtnama = findViewById(R.id.edt_nama);
        edtemail = findViewById(R.id.edt_email);
        edtlok = findViewById(R.id.edt_lokasi);

        edtnama.setText("");
        edtemail.setText("");
        edtlok.setText("");

        btnsub = findViewById(R.id.btn_submit);

        if(getIntent().hasExtra(EXTRA_USER) && getIntent().getParcelableArrayListExtra(EXTRA_USER) != null){
            listuser = getIntent().getParcelableArrayListExtra(EXTRA_USER);
        }else{
            listuser = null;
        }

        if(getIntent().hasExtra(EXTRA_LOGIN) && getIntent().getStringExtra(EXTRA_LOGIN) != null){
            tmpusername = getIntent().getStringExtra(EXTRA_LOGIN);
        }else{
            tmpusername = "";
        }

        if(getIntent().hasExtra(EXTRA_STATUS) && getIntent().getIntExtra(EXTRA_STATUS,-1) != -1){
            statuslogin = getIntent().getIntExtra(EXTRA_STATUS,-1);
        }else{
            statuslogin = 0;
        }

        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = edtnama.getText().toString();
                String email = edtemail.getText().toString();
                String lokasi = edtlok.getText().toString();
                Intent i;
                if(!nama.equals("") && !email.equals("") && !lokasi.equals("")){
                    db.userDao().updateUser(nama, email, lokasi, tmpusername);
                    listuser.get(0).setNama(nama);
                    listuser.get(0).setEmail(email);
                    listuser.get(0).setLokasi(lokasi);
                    Toast.makeText(NewLoginActivity.this, "Berhasil update data user", Toast.LENGTH_SHORT).show();
                    if(statuslogin == 1){
                        i = new Intent(NewLoginActivity.this, UserActivity.class);
                        i.putExtra(UserActivity.EXTRA_USER, listuser);
                        startActivity(i);
                    }else{
                        i = new Intent(NewLoginActivity.this, TokoActivity.class);
                        i.putExtra(TokoActivity.EXTRA_USER, listuser);
                        startActivity(i);
                    }
                }else{
                    Toast.makeText(NewLoginActivity.this, "Terdapat isian yang kosong", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}