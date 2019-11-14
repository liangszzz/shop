package com.github.ls.ssoservice.dao;

import com.github.ls.sso.entity.OauthAccessToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OauthAccessTokenDao extends JpaRepository<OauthAccessToken, String> {
}
