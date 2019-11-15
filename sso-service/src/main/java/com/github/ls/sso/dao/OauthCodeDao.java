package com.github.ls.sso.dao;

import com.github.ls.sso.entity.OauthCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OauthCodeDao extends JpaRepository<OauthCode, String> {
}
