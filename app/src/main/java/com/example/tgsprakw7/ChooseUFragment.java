package com.example.tgsprakw7;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ChooseUFragment extends Fragment {

    UserActivity parent;

    Spinner barang;
    EditText jml;
    Button buy;

    String[] split;

    public ChooseUFragment(UserActivity parent) {
        // Required empty public constructor
        this.parent = parent;
    }

    public static ChooseUFragment newInstance(UserActivity parent) {
        ChooseUFragment fragment = new ChooseUFragment(parent);
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
        return inflater.inflate(R.layout.fragment_choose_u, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        barang = view.findViewById(R.id.sp_barang);
        jml = view.findViewById(R.id.edt_jml);
        buy = view.findViewById(R.id.btn_buy);

        jml.setText("");

        parent.barang.clear();
        parent.barangToString.clear();

        parent.barang.addAll(parent.db.tokoBarangDao().getAll());

        for (int i = 0; i < parent.barang.size(); i++) {
            parent.barangToString.add(parent.barang.get(i).toString());
        }

        ArrayAdapter<String> adapBarang = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item,parent.barangToString);


        adapBarang.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        barang.setAdapter(adapBarang);

        barang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedbarang = (String) adapterView.getItemAtPosition(i);
                split = selectedbarang.split(" - ");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jmlh = jml.getText().toString();
                int j = Integer.parseInt(jmlh);

                if(!jmlh.equals("")){
                    if(j > 0){
                        int tot = 0;
                        String user = parent.listuser.get(0).getNama();
                        int tmphar = parent.db.penjualanDao().getHarga(split[0]);
                        String tmp = parent.db.penjualanDao().getToko(split[0]);
                        tot = tmphar * j;

                        Calendar c1 = Calendar.getInstance();
                        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-M-d HH:mm:ss");
                        String strdate1 = sdf1.format(c1.getTime());

                        parent.db.penjualanDao().insert(new Penjualan(user,tmp,strdate1,split[0],split[1],j,tot,1));
                        Toast.makeText(getActivity(), "Berhasil membeli barang", Toast.LENGTH_SHORT).show();
                        jml.setText("");


                    }else{
                        Toast.makeText(getActivity(), "Jumlah barang harus lebih besar dari 0", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getActivity(), "Terdapat isian yang kosong", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}