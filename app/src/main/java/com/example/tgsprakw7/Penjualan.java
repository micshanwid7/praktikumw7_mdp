package com.example.tgsprakw7;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "penjualan")
public class Penjualan {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    int id;

    @ColumnInfo(name="nama_user")
    private String nuser;

    @ColumnInfo(name="nama_toko")
    private String ntoko;

    @ColumnInfo(name="tgl_waktu")
    private String tglwaktu;

    @ColumnInfo(name="nama_barang")
    private String nbarang;

    @ColumnInfo(name="tipe_barang")
    private String tbarang;

    @ColumnInfo(name="jumlah_barang")
    private int jbrang;

    @ColumnInfo(name="total")
    private int total;

    @ColumnInfo(name="status_beli")
    private int status;

    public Penjualan(String nuser, String ntoko, String tglwaktu, String nbarang, String tbarang, int jbrang, int total, int status) {
        this.nuser = nuser;
        this.ntoko = ntoko;
        this.tglwaktu = tglwaktu;
        this.nbarang = nbarang;
        this.tbarang = tbarang;
        this.jbrang = jbrang;
        this.total = total;
        this.status = status;
    }

    public String getNuser() {
        return nuser;
    }

    public void setNuser(String nuser) {
        this.nuser = nuser;
    }

    public String getNtoko() {
        return ntoko;
    }

    public void setNtoko(String ntoko) {
        this.ntoko = ntoko;
    }

    public String getTglwaktu() {
        return tglwaktu;
    }

    public void setTglwaktu(String tglwaktu) {
        this.tglwaktu = tglwaktu;
    }

    public String getNbarang() {
        return nbarang;
    }

    public void setNbarang(String nbarang) {
        this.nbarang = nbarang;
    }

    public String getTbarang() {
        return tbarang;
    }

    public void setTbarang(String tbarang) {
        this.tbarang = tbarang;
    }

    public int getJbrang() {
        return jbrang;
    }

    public void setJbrang(int jbrang) {
        this.jbrang = jbrang;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
