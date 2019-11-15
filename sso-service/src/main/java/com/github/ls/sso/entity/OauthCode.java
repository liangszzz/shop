package com.github.ls.sso.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "oauth_code")
public class OauthCode {

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "authentication")
    private String authentication;
}
