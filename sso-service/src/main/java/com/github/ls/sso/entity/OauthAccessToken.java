package com.github.ls.sso.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "oauth_access_token")
public class OauthAccessToken {

    @Column(name = "token_id")
    private String tokenId;

    @Column(name = "token")
    private String token;

    @Id
    @Column(name = "authentication_id")
    private String authenticationId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "client_id")
    private String clientId;

    @Column(name = "authentication")
    private String authentication;

    @Column(name = "refresh_token")
    private String refreshToken;
}
