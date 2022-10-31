package com.example.tgsprakw7;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User implements Parcelable {

    @PrimaryKey @NonNull
    @ColumnInfo(name="username")
    private String username;

    @ColumnInfo(name="nama")
    private String nama;

    @ColumnInfo(name="email")
    private String email;

    @ColumnInfo(name="password")
    private String password;

    @ColumnInfo(name="lokasi")
    private String lokasi;

    @ColumnInfo(name="status")
    private int status;

    public User(@NonNull String username, String nama, String email, String password, String lokasi, int status) {
        this.username = username;
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.lokasi = lokasi;
        this.status = status;
    }

    protected User(Parcel in) {
        username = in.readString();
        nama = in.readString();
        email = in.readString();
        password = in.readString();
        lokasi = in.readString();
        status = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(nama);
        dest.writeString(email);
        dest.writeString(password);
        dest.writeString(lokasi);
        dest.writeInt(status);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
