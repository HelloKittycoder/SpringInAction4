package com.kittycoder.po;

/**
 * Created by shucheng on 2020/7/30 10:07
 */
public class Spitter {
    // 编号
    private Long id;
    // 用户名称
    private String username;
    // 用户密码
    private String password;
    // 发件人的名称
    private String fullName;
    // 收件人的邮箱
    private String email;
    // 判断是否带有附件
    private boolean updateByEmail;

    public Spitter(Long id, String username, String password, String fullName, String email, boolean updateByEmail) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.updateByEmail = updateByEmail;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public boolean isUpdateByEmail() {
        return updateByEmail;
    }
}
