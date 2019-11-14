package com.github.ls.ssoservice.dao;

import com.github.ls.sso.entity.OauthClientToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OauthClientTokenDao extends JpaRepository<OauthClientToken, String> {
}
