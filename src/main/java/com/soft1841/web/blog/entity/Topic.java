package com.soft1841.web.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
/**
 * @ClassName Topic
 * @Description TODO
 * @Author sj_yao
 * @Date 2019/12/9
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topic {
    private Long id;
    private Long userId;
    private String topicName;
    private String logo;
    private String description;
    private Integer articles;
    private Integer follows;
    private LocalDateTime createTime;
}
