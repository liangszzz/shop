package com.github.ls.sso.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "oauth_approvals")
public class OauthApprovals {

    @Id
    @Column(name = "userId")
    private String userId;

    @Column(name = "clientId")
    private String clientId;

    @Column(name = "scope")
    private String scope;

    @Column(name = "status")
    private String status;

    @Column(name = "expiresAt")
    private java.sql.Timestamp expiresAt;

    @Column(name = "lastModifiedAt")
    private java.sql.Timestamp lastModifiedAt;
}
