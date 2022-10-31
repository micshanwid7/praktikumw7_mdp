package com.example.tgsprakw7;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "chat")
public class Chat {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    int id;

    @ColumnInfo(name = "pengirim")
    private String npengirim;

    @ColumnInfo(name = "penerima")
    private String nterima;

    @ColumnInfo(name = "isi_chat")
    private String isi;


    public Chat(String npengirim, String nterima, String isi) {
        this.npengirim = npengirim;
        this.nterima = nterima;
        this.isi = isi;
    }

    public String getNpengirim() {
        return npengirim;
    }

    public void setNpengirim(String npengirim) {
        this.npengirim = npengirim;
    }

    public String getNterima() {
        return nterima;
    }

    public void setNterima(String nterima) {
        this.nterima = nterima;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }
}
