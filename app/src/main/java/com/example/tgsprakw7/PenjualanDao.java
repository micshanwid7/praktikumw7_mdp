package com.example.tgsprakw7;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;


@Dao
public interface PenjualanDao {

    @Insert
    void insert(Penjualan penjualan);

    @Query("UPDATE PENJUALAN SET STATUS_BELI = :status WHERE TGL_WAKTU = :tgl")
    void updateStatus(int status, String tgl );

    @Query("SELECT NAMA_TOKO FROM TOKOBARANG WHERE NAMA_BARANG = :nabar")
    String getToko(String nabar);

    @Query("SELECT HARGA_BARANG FROM TOKOBARANG WHERE NAMA_BARANG = :nabar")
    int getHarga(String nabar);

    @Query("SELECT * FROM PENJUALAN WHERE NAMA_USER = :nuser")
    List<Penjualan> getPenjualan(String nuser);

    @Query("SELECT * FROM PENJUALAN WHERE NAMA_TOKO = :ntoko")
    List<Penjualan> getPembelian(String ntoko);

}
