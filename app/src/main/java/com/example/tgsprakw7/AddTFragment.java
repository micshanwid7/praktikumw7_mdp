package com.example.tgsprakw7;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddTFragment extends Fragment {

    TokoActivity parent;

    EditText nama, harga, tipe;
    Button add;

    public AddTFragment(TokoActivity parent) {
        // Required empty public constructor
        this.parent = parent;
    }

    public static AddTFragment newInstance(TokoActivity parent) {
        AddTFragment fragment = new AddTFragment(parent);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_t, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nama = view.findViewById(R.id.edt_nbrg);
        harga = view.findViewById(R.id.edt_jbrg);
        tipe = view.findViewById(R.id.edt_tbrg);
        add = view.findViewById(R.id.btn_add);

        nama.setText("");
        tipe.setText("");
        harga.setText("");

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ntoko = parent.listuser.get(0).getNama();
                String n = nama.getText().toString();
                String tmp = harga.getText().toString();
                int h = Integer.parseInt(tmp);
                String t = tipe.getText().toString();

                if(!n.equals("") && !tmp.equals("") && !t.equals("")){
                    if(h > 0){
                        int count = 0;
                        count = parent.db.tokoBarangDao().getCountBarang(n);
                        if(count > 0) {
                            Toast.makeText(getActivity(), "Barang sudah ada di toko ini/toko lain", Toast.LENGTH_SHORT).show();
                        }else{
                            parent.db.tokoBarangDao().insert(new TokoBarang(ntoko, n, h, t));
                            Toast.makeText(getActivity(), ntoko, Toast.LENGTH_SHORT).show();
                            Toast.makeText(getActivity(), "Berhasil menambah barang", Toast.LENGTH_SHORT).show();
                            nama.setText("");
                            tipe.setText("");
                            harga.setText("");
                        }
                    }else{
                        Toast.makeText(getActivity(), "Harga harus lebih besar dari Rp 0", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getActivity(), "Terdapat isian yang kosong", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}