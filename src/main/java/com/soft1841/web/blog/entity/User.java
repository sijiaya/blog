package com.soft1841.web.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @ClassName User
 * @Description 用户实体类
 * @Author sj_yao
 * @Date 2019/11/25
 **/
//@Data是get,set,toString的综合
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String mobile;
    private String password;
    private String nickname;
    private String avatar;
    private String gender;
    private LocalDate birthday;
    private String introduction;
    private String email;
    private Integer fans;
    private Integer articles;
    private LocalDateTime createTime;
    private Short status;
    private String flag;

    public User(String mobile,String password){
        this.mobile = mobile;
        this.password = password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
