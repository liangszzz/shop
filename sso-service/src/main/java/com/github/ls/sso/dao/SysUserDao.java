package com.github.ls.sso.dao;

import com.github.ls.sso.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserDao extends JpaRepository<SysUser, String> {
    SysUser findByUsername(String username);
}
