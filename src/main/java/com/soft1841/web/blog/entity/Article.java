package com.soft1841.web.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @ClassName article
 * @Description TODO
 * @Author mq_xu
 * @Date 2019/12/5
 **/
//@Data是get,set,toString的综合
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private Long id;
    private Long userId;
    private Long topicId;
    private String title;
    private String thumbnail;
    private String content;
    private Integer comments;
    private LocalDateTime creatTime;
    private String author;

    public void setArticle(Article article) {
    }

    public void setAuthor(User author) {
    }

    public void setTopic(Topic topic) {
    }
}
