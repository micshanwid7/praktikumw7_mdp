package com.example.tgsprakw7;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class ExploreTFragment extends Fragment {

    TokoActivity parent;

    Button ball, bun, bpro, bdon;
    RecyclerView rvtoko;

    ExploreTokoAdapter exploreTokoAdapter;

    public ExploreTFragment(TokoActivity parent) {
        // Required empty public constructor
        this.parent = parent;
    }

    public static ExploreTFragment newInstance(TokoActivity parent) {
        ExploreTFragment fragment = new ExploreTFragment(parent);
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
        return inflater.inflate(R.layout.fragment_explore_t, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ball = view.findViewById(R.id.btnt_all);
        bun = view.findViewById(R.id.btnt_unc);
        bpro = view.findViewById(R.id.btnt_pro);
        bdon = view.findViewById(R.id.btnt_done);
        rvtoko = view.findViewById(R.id.rv_toko);

        parent.listpembelian.clear();
        parent.listpembelian.addAll(parent.db.penjualanDao().getPembelian(parent.listuser.get(0).getNama()));

        ball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exploreTokoAdapter = new ExploreTokoAdapter(getActivity(),parent.listpembelian,parent);
                rvtoko.setLayoutManager(new LinearLayoutManager(getActivity()));
                rvtoko.setAdapter(exploreTokoAdapter);
            }
        });

        bun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parent.tmprv.clear();
                for (int i = 0; i < parent.listpembelian.size(); i++) {
                    if(parent.listpembelian.get(i).getStatus() == 1){
                        parent.tmprv.add(parent.listpembelian.get(i));
                    }
                }

                exploreTokoAdapter = new ExploreTokoAdapter(getActivity(),parent.tmprv,parent);
                rvtoko.setLayoutManager(new LinearLayoutManager(getActivity()));
                rvtoko.setAdapter(exploreTokoAdapter);
            }
        });

        bpro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parent.tmprv.clear();
                for (int i = 0; i < parent.listpembelian.size(); i++) {
                    if(parent.listpembelian.get(i).getStatus() == 2){
                        parent.tmprv.add(parent.listpembelian.get(i));
                    }
                }

                exploreTokoAdapter = new ExploreTokoAdapter(getActivity(),parent.tmprv,parent);
                rvtoko.setLayoutManager(new LinearLayoutManager(getActivity()));
                rvtoko.setAdapter(exploreTokoAdapter);
            }
        });

        bdon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parent.tmprv.clear();
                for (int i = 0; i < parent.listpembelian.size(); i++) {
                    if(parent.listpembelian.get(i).getStatus() == 3){
                        parent.tmprv.add(parent.listpembelian.get(i));
                    }
                }

                exploreTokoAdapter = new ExploreTokoAdapter(getActivity(),parent.tmprv,parent);
                rvtoko.setLayoutManager(new LinearLayoutManager(getActivity()));
                rvtoko.setAdapter(exploreTokoAdapter);
            }
        });

        rvtoko.setHasFixedSize(true);
        exploreTokoAdapter = new ExploreTokoAdapter(getActivity(),parent.listpembelian,parent);
        rvtoko.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvtoko.setAdapter(exploreTokoAdapter);
        exploreTokoAdapter.notifyDataSetChanged();
    }
}