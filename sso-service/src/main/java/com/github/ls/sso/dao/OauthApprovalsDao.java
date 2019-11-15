package com.github.ls.sso.dao;

import com.github.ls.sso.entity.OauthApprovals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OauthApprovalsDao extends JpaRepository<OauthApprovals, String> {
}
