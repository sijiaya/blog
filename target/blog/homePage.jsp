<%@ page import="com.soft1841.web.blog.entity.User" %>
<%@ page import="com.soft1841.web.blog.dao.UserDao" %>
<%@ page import="com.soft1841.web.blog.factory.DaoFactory" %>
<%@ page import="com.soft1841.web.blog.entity.Topic" %>
<%@ page import="com.soft1841.web.blog.dao.TopicDao" %><%--
  Created by IntelliJ IDEA.
  User: 23173
  Date: 2019/12/13
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="./css/style.css" type="text/css">
<%--    <link href="/weibo-blog/css/style.css" rel="stylesheet"  type="text/css"/>--%>
    <title>微博</title>
</head>
<body>
<% request.setCharacterEncoding("utf-8");%>
<%
    HttpSession hs = request.getSession();
%>
    <div class="top">
        <img src="image/logo.png" alt="微博logo" class="logo">
        <form action="homePage.jsp">
        <input type="text" name="keys" class="search_input" placeholder="请输入搜索词" autocomplete="off"/>
        <input type="submit" class="search_btn" value="搜索" />
        </form>
        <div id="navigation">
            <nav>
                <ul>
                    <li><a href="">首页</a></li>
                    <li><a href="">视频</a></li>
                    <li><a href="">发现</a></li>
                    <li><a href="">游戏</a></li>
                    <li>
                        <%String name = (String) session.getAttribute("nickname");%>
                        <%=name%>
                    </li>
                    <%System.out.println(hs.getAttribute("nickname"));%>

                    <li><a href="exit.jsp">退出登录</a></li>
                </ul>
            </nav>
        </div>
    </div>

    <div class="left">
        <p>首页</p>
        <p>我的收藏</p>
        <p>我的赞</p>
        <p>热门微博</p>
        <p>热门视频</p>
        <p>最新微博</p>
        <p>好友圈</p>
        <p>关注</p>
        <p>明星</p>
        <p>群微博</p>
    </div>
<div class="input">

    <p style="font-size: 12px;color: rgb(135,188,222);">有什么新鲜事</p>
    <form action="AIServlet" method="post">
    <input type="text" class="article1" name="title" autocomplete="off">
    <textarea title="微博文章输入框" class="article2" name="content"></textarea>

<%--    <a href="javascript:;" class="file_btn">--%>
<%--        <form action="uploadImage.do" method="post" enctype="multipart/form-data">--%>
<%--        <input type="file"name="file">--%>
<%--&lt;%&ndash;        <input type="submit" value="确认">&ndash;%&gt;--%>
<%--        </form>--%>
<%--    </a>--%>

    <hr style="height: 10px;border: none;">
    <input type="submit" title="发布微博按钮" value="发布" class="pubish_btn"/>
    </form>
</div>

    <div class="card1">
        <div style="width: 610px;height: auto;position: absolute;left: 40px">
            <%@ include file="article.jsp"%>
        </div>
    </div>

    <div class="card4">
        <%
            User user=DaoFactory.getUserDaoInstance().findUserByMobile((String)session.getAttribute("mobile"));
            String avatar = user.getAvatar();
            Integer fans = user.getFans();
            Integer article = user.getArticles();
        %>

        <a href="personal.jsp">
            <img src="<%=avatar%>" alt="头像" style="width: 57px;height: 57px;border-radius: 50%;position: absolute;left: 100px;top: 5px">
        </a>
        <div style="position: absolute;top:73px;left: 107px;">
            <%String name2 = (String) session.getAttribute("nickname");%>
            <%=name2%>
        </div>
        <div style="position: absolute;top:100px;left: 60px;">
            粉丝数<span><%=fans%></span>&nbsp;&nbsp;
            文章<span><%=article%></span>
        </div>

    </div>
    <div class="card5">
        <h3>亚洲新歌榜</h3>
        <a href="https://y.qq.com/n/yqq/song/001dPKD40OUxFz.html" οnclick="ssss('1')">耳朵.mp4</a>
    </div>

    <div class="card6">
        <h3>热门话题</h3>
        <%
            List<Topic> list1 =null;
            TopicDao topicDao= DaoFactory.getTopicDaoInstance();
            try{
                list1=topicDao.selectHotTopic();
            }catch (Exception e){
                e.printStackTrace();
            }
            for (Topic topic:
                    list1) {
        %>
        <a href="topic.jsp">
<%--            <a><%=topic.getTopicName()%></a>--%>
            <%=topic.getTopicName()%>
        </a>

        <br>
        <%}%>
    </div>

</body>
</html>
