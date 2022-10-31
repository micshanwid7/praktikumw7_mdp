package com.example.tgsprakw7;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TokoBarangDao {

    @Query("SELECT * FROM TOKOBARANG")
    List<TokoBarang> getAll();

    @Insert
    void insert(TokoBarang tkbrng);

    @Update
    void update(User user);

    @Delete
    void delete(User user);


    @Query("SELECT count(*) FROM TOKOBARANG WHERE NAMA_BARANG = :nabar")
    int getCountBarang(String nabar);
}
