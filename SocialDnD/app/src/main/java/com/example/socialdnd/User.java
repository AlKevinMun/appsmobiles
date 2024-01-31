package com.example.socialdnd;

import android.net.Uri;
import com.google.firebase.firestore.PropertyName;

public class User {
    private String email;
    private String name;
    private String password;
    private Uri mediaUri;
    private String UID;

    public User() {
        // Necesario para la deserialización desde Firestore
    }

    public User(String email, String password, String UID) {
        this.email = email;
        this.name = getName(email);
        this.password = password;
        this.mediaUri = null;
        this.UID = UID;
    }

    @PropertyName("email")
    public String getEmail() {
        return email;
    }

    @PropertyName("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @PropertyName("name")
    public String getName() {
        return name;
    }

    @PropertyName("name")
    public void setName(String name) {
        this.name = name;
    }

    @PropertyName("password")
    public String getPassword() {
        return password;
    }

    @PropertyName("password")
    public void setPassword(String password) {
        this.password = password;
    }

    @PropertyName("mediaUri")
    public Uri getMediaUri() {
        return mediaUri;
    }

    @PropertyName("mediaUri")
    public void setMediaUri(Uri mediaUri) {
        this.mediaUri = mediaUri;
    }

    @PropertyName("UID")
    public String getUID() {
        return UID;
    }

    @PropertyName("UID")
    public void setUID(String UID) {
        this.UID = UID;
    }

    private String getName(String email) {
        String temp[] = email.split("@");
        String userName = temp[0];
        return userName;
    }
}
