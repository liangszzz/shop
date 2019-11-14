package com.github.ls.ssoservice.dao;

import com.github.ls.sso.entity.OauthRefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OauthRefreshTokenDao extends JpaRepository<OauthRefreshToken, String> {
}
