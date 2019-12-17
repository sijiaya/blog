package com.soft1841.web.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName admin
 * @Description 管理员
 * @Author sj_yao
 * @Date 2019/12/4
 **/
//@Data是get,set,toString的综合
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private Long id;
    private Long account;
    private String password;
    private String avatar;
}
