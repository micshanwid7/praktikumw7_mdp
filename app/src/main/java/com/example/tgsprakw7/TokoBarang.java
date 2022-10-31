package com.example.tgsprakw7;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tokobarang")
public class TokoBarang {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    int id;

    @ColumnInfo(name="nama_toko")
    private String namatoko;

    @ColumnInfo(name="nama_barang")
    private String nbarang;

    @ColumnInfo(name="harga_barang")
    private int hbarang;

    @ColumnInfo(name="tipe_barang")
    private String tbarang;

    public TokoBarang(String namatoko, String nbarang, int hbarang, String tbarang) {
        this.namatoko = namatoko;
        this.nbarang = nbarang;
        this.hbarang = hbarang;
        this.tbarang = tbarang;
    }

    public String getNamatoko() {
        return namatoko;
    }

    public void setNamatoko(String namatoko) {
        this.namatoko = namatoko;
    }

    public String getNbarang() {
        return nbarang;
    }

    public void setNbarang(String nbarang) {
        this.nbarang = nbarang;
    }

    public int getHbarang() {
        return hbarang;
    }

    public void setHbarang(int hbarang) {
        this.hbarang = hbarang;
    }

    public String getTbarang() {
        return tbarang;
    }

    public void setTbarang(String tbarang) {
        this.tbarang = tbarang;
    }

    @Override
    public String toString() {
        return nbarang + " - " + tbarang;
    }
}
