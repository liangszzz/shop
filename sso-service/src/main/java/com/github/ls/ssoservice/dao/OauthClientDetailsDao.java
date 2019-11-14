package com.github.ls.ssoservice.dao;

import com.github.ls.sso.entity.OauthClientDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OauthClientDetailsDao extends JpaRepository<OauthClientDetails, String> {
}
