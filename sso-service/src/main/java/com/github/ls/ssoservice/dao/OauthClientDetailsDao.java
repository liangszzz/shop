package com.github.ls.ssoservice.dao;

import com.github.ls.ssoservice.entity.OauthClientDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OauthClientDetailsDao extends JpaRepository<OauthClientDetails, String> {
}
