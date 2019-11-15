package com.github.ls.ssoservice.service;

import com.github.ls.ssoservice.dao.SysMenuDao;
import com.github.ls.ssoservice.dao.SysRoleDao;
import com.github.ls.ssoservice.dao.SysUserDao;
import com.github.ls.ssoservice.entity.SysMenu;
import com.github.ls.ssoservice.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysService {

    private final SysUserDao sysUserDao;

    private final SysMenuDao sysMenuDao;

    private final SysRoleDao sysRoleDao;

    @Autowired
    public SysService(SysUserDao sysUserDao, SysMenuDao sysMenuDao, SysRoleDao sysRoleDao) {
        this.sysUserDao = sysUserDao;
        this.sysMenuDao = sysMenuDao;
        this.sysRoleDao = sysRoleDao;
    }

    public SysUser findUserByUsername(String username) {
        return sysUserDao.findByUsername(username);
    }

    public List<SysMenu> findMenusByUsername(String username) {
        return sysMenuDao.findByUsername(username);
    }
}
