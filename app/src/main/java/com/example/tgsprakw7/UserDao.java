package com.example.tgsprakw7;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM USER")
    List<User> getAllUser();

    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

    @Query("UPDATE USER SET NAMA = :nama, EMAIL = :email, LOKASI = :lokasi WHERE USERNAME = :username")
    void updateUser(String nama, String email, String lokasi, String username);

    @Query("SELECT * FROM USER WHERE USERNAME = :username")
    User getUser(String username);

    @Query("SELECT count(*) FROM USER WHERE USERNAME = :username")
    int getCountUser(String username);
}
