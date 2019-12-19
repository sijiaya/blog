package com.soft1841.web.blog.entity;

import java.util.Date;

/**
 * @ClassName Comment
 * @Description TODO
 * @Author mq_xu
 * @Date 2019/12/10
 **/
public class Comment {
    private Long id;
    private Long userId;
    private Long articleId;
    private String content;
    private Date creatTime;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Comment(Long id, Long userId, Long articleId, String content, Date creatTime, String userName) {
        this.id = id;
        this.userId = userId;
        this.articleId = articleId;
        this.content = content;
        this.creatTime = creatTime;
        this.userName = userName;
    }

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", userId=" + userId +
                ", articleId=" + articleId +
                ", content='" + content + '\'' +
                ", creatTime=" + creatTime +
                ", userName='" + userName + '\'' +
                '}';
    }
}
