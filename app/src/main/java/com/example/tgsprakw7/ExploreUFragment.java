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

import java.util.ArrayList;

public class ExploreUFragment extends Fragment {

    UserActivity parent;

    Button ball, bun, bpro, bdon;
    RecyclerView rvuser;

    ExploreUserAdapter exploreUserAdapter;

    public ExploreUFragment(UserActivity parent) {
        // Required empty public constructor
        this.parent = parent;
    }

    public static ExploreUFragment newInstance(UserActivity parent) {
        ExploreUFragment fragment = new ExploreUFragment(parent);
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
        return inflater.inflate(R.layout.fragment_explore_u, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ball = view.findViewById(R.id.btn_all);
        bun = view.findViewById(R.id.btn_unc);
        bpro = view.findViewById(R.id.btn_pro);
        bdon = view.findViewById(R.id.btn_done);
        rvuser = view.findViewById(R.id.rv_user);

        parent.listpenjualanuser.clear();
        parent.listpenjualanuser.addAll(parent.db.penjualanDao().getPenjualan(parent.listuser.get(0).getNama()));

        ball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exploreUserAdapter = new ExploreUserAdapter(getActivity(),parent.listpenjualanuser);
                rvuser.setLayoutManager(new LinearLayoutManager(getActivity()));
                rvuser.setAdapter(exploreUserAdapter);
            }
        });


        bun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parent.tmprv.clear();
                for (int i = 0; i < parent.listpenjualanuser.size(); i++) {
                    if(parent.listpenjualanuser.get(i).getStatus() == 1){
                        parent.tmprv.add(parent.listpenjualanuser.get(i));
                    }
                }

                exploreUserAdapter = new ExploreUserAdapter(getActivity(),parent.tmprv);
                rvuser.setLayoutManager(new LinearLayoutManager(getActivity()));
                rvuser.setAdapter(exploreUserAdapter);
            }
        });

        bpro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parent.tmprv.clear();
                for (int i = 0; i < parent.listpenjualanuser.size(); i++) {
                    if(parent.listpenjualanuser.get(i).getStatus() == 2){
                        parent.tmprv.add(parent.listpenjualanuser.get(i));
                    }
                }

                exploreUserAdapter = new ExploreUserAdapter(getActivity(),parent.tmprv);
                rvuser.setLayoutManager(new LinearLayoutManager(getActivity()));
                rvuser.setAdapter(exploreUserAdapter);
            }
        });

        bdon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parent.tmprv.clear();
                for (int i = 0; i < parent.listpenjualanuser.size(); i++) {
                    if(parent.listpenjualanuser.get(i).getStatus() == 3){
                        parent.tmprv.add(parent.listpenjualanuser.get(i));
                    }
                }

                exploreUserAdapter = new ExploreUserAdapter(getActivity(),parent.tmprv);
                rvuser.setLayoutManager(new LinearLayoutManager(getActivity()));
                rvuser.setAdapter(exploreUserAdapter);
            }
        });

        rvuser.setHasFixedSize(true);
        exploreUserAdapter = new ExploreUserAdapter(getActivity(),parent.listpenjualanuser);
        rvuser.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvuser.setAdapter(exploreUserAdapter);
        exploreUserAdapter.notifyDataSetChanged();
    }
}