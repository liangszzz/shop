package com.github.ls.sso.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "s_role")
public class SysRole implements Serializable {

    @Id
    @Column(name = "role_name", length = 50)
    private String roleName;

    @Column(name = "role_desc", length = 200)
    private String roleDesc;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "s_role_menu",
            joinColumns = {@JoinColumn(name = "role_name", foreignKey = @ForeignKey(name = "role_name"))},
            inverseJoinColumns = {@JoinColumn(name = "menu_id", foreignKey = @ForeignKey(name = "id"))})
    private Set<SysMenu> menus;
}
