package com.github.ls.ssoservice.dao;

import com.github.ls.ssoservice.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserDao extends JpaRepository<SysUser, String> {
    SysUser findByUsername(String username);
}
