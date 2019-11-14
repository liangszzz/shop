package com.github.ls.ssoservice.config;

import com.github.ls.sso.entity.SysMenu;
import com.github.ls.sso.entity.SysUser;
import com.github.ls.sso.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysService sysService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sysService.findUserByUsername(username);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (user != null) {
            List<SysMenu> menus = sysService.findMenusByUsername(username);
            menus.forEach(
                    menu -> {
                        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(menu.getPermission());
                        grantedAuthorities.add(grantedAuthority);
                    });
        }

        return new User(username, user.getPassword(), grantedAuthorities);
    }
}
