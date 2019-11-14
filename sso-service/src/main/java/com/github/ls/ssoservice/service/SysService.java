package com.github.ls.ssoservice.service;

import com.github.ls.sso.dao.SysMenuDao;
import com.github.ls.sso.dao.SysRoleDao;
import com.github.ls.sso.dao.SysUserDao;
import com.github.ls.sso.entity.SysMenu;
import com.github.ls.sso.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysService {

    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private SysMenuDao sysMenuDao;

    @Autowired
    private SysRoleDao sysRoleDao;

    public SysUser findUserByUsername(String username) {
        return sysUserDao.findByUsername(username);
    }

    public List<SysMenu> findMenusByUsername(String username) {
        return sysMenuDao.findByUsername(username);
    }
}
