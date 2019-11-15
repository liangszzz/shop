package com.github.ls.sso.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "oauth_refresh_token")
public class OauthRefreshToken {

    @Id
    @Column(name = "token_id")
    private String tokenId;

    @Column(name = "token")
    private String token;

    @Column(name = "authentication")
    private String authentication;
}
