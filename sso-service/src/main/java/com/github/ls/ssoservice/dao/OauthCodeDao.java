package com.github.ls.ssoservice.dao;

import com.github.ls.ssoservice.entity.OauthCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OauthCodeDao extends JpaRepository<OauthCode, String> {
}
