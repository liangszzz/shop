package com.github.ls.sso.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@SqlResultSetMapping(
        name = "menus",
        classes = {
                @ConstructorResult(
                        targetClass = SysMenu.class,
                        columns = {
                                @ColumnResult(name = "id"),
                                @ColumnResult(name = "name"),
                                @ColumnResult(name = "type"),
                                @ColumnResult(name = "url"),
                                @ColumnResult(name = "permission"),
                        })
        })
@NamedNativeQuery(
        name = "SysMenu.findByUsername",
        query =
                "SELECT `menu`.* FROM "
                        + "s_user `user` "
                        + "LEFT JOIN s_user_role user_role ON user_role.username = `user`.username "
                        + "LEFT JOIN s_role role ON role.role_name = user_role.role_name "
                        + "LEFT JOIN s_role_menu role_menu ON role_menu.role_name = role.role_name "
                        + "LEFT JOIN s_menu menu ON menu.id = role_menu.menu_id "
                        + "WHERE "
                        + "`user`.`username` = :username",
        resultSetMapping = "menus")
@Getter
@Setter
@Entity
@Table(name = "s_menu")
@NoArgsConstructor
public class SysMenu implements Serializable {

    public SysMenu(Integer id, String name, String type, String url, String permission) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.url = url;
        this.permission = permission;
    }

    @Id
    @GeneratedValue
    @Column(name = "id", length = 11)
    private Integer id;

    @Column(name = "name", length = 50)
    private String name;

    /**
     * 0 菜单 1:按钮
     */
    @Column(name = "type", length = 1)
    private String type;

    @Column(name = "url", length = 50)
    private String url;

    @Column(name = "permission", length = 20)
    private String permission;

    /**
     * 父节点
     */
    @OneToOne
    private SysMenu menu;

    /**
     * 字节点
     */
    @Transient
    private List<SysMenu> children;
}
