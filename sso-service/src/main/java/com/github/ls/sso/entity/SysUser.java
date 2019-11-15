package com.github.ls.sso.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "s_user")
public class SysUser implements Serializable {

    @Id
    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "name", length = 50)
    private String name;

    @JsonIgnore
    @Column(name = "password", length = 150)
    private String password;

    @Column(name = "remember", length = 1)
    private Integer remember;

    @Column(name = "last_login_time")
    private LocalDateTime lastLoginTime;

    @Column(name = "last_login_ip", length = 17)
    private String lastLoginIp;

    @Column(name = "fail_count")
    private Integer failCount;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "s_user_role",
            joinColumns = {@JoinColumn(name = "username", foreignKey = @ForeignKey(name = "username"))},
            inverseJoinColumns = {
                    @JoinColumn(name = "role_name", foreignKey = @ForeignKey(name = "role_name"))
            })
    private Set<SysRole> sysRoles;
}
