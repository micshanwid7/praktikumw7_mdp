package com.example.tgsprakw7;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ChatDao {

    @Insert
    void insert(Chat chat);

    @Query("SELECT * FROM CHAT WHERE PENGIRIM =:pengirim AND PENERIMA = :penerima")
    List<Chat> getChat(String pengirim, String penerima);



}
