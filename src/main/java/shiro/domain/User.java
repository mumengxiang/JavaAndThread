package shiro.domain;


import lombok.Data;

@Data
@Table(name = "user")
public class User {

    @id
    private String id;

    private String username;

    private String password;
}
