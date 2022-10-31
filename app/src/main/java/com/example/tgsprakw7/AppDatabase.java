package com.example.tgsprakw7;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, TokoBarang.class, Penjualan.class, Chat.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    public abstract TokoBarangDao tokoBarangDao();

    public abstract PenjualanDao penjualanDao();

    public abstract ChatDao chatDao();
}
