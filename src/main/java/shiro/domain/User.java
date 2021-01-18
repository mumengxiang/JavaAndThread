package shiro.domain;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "user")
public class User {
    /**
     * 主键
     */
    @Id
    @Column(name = "ID")
    private String id;
    /**
     * 用户名
     */
    @Column(name = "USERNAME")
    private String username;
    /**
     * 密码
     */
    @Column(name = "PASSWORD")
    private String password;
    /**
     * 授权码
     */
    @Column(name = "PERMS")
    private String perms;
}
