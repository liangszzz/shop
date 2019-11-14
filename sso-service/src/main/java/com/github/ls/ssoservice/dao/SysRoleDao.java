package com.github.ls.ssoservice.dao;

import com.github.ls.sso.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysRoleDao extends JpaRepository<SysRole, String> {
}
