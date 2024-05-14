package com.navanga.fuelmanager.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class AccessToken {

    @Id
    private long id;

    private String token;

    private LocalDateTime expires;

    public AccessToken() {
    }

    public AccessToken(long id, String token, LocalDateTime expires) {
        this.id = id;
        this.token = token;
        this.expires = expires;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getExpires() {
        return expires;
    }

    public void setExpires(LocalDateTime expires) {
        this.expires = expires;
    }
}
