package com.github.ls.ssoservice.dao;

import com.github.ls.ssoservice.entity.OauthApprovals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OauthApprovalsDao extends JpaRepository<OauthApprovals, String> {
}
