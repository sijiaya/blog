<%@ page import="com.soft1841.web.blog.entity.User" %>
<%@ page import="com.soft1841.web.blog.dao.UserDao" %><%--
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
    <link href="/blog/css/style.css" rel="stylesheet" />
    <title>微博</title>
</head>
<body>
<% request.setCharacterEncoding("utf-8");%>
<%
    HttpSession hs = request.getSession();
%>
    <div class="top">
        <img src="image/logo.png" alt="微博logo" class="logo">
        <input type="text" class="search_input" placeholder="请输入搜索词"/>
        <input type="button" class="search_btn" value="搜索" />
        <div id="navigation">
            <nav>
                <ul>
                    <li><a href="">首页</a></li>
                    <li><a href="">视频</a></li>
                    <li><a href="">发现</a></li>
                    <li><a href="">游戏</a></li>
                    <li>
                        <%String name =  (String) session.getAttribute("nickname");%>
                        <font size="4">用户：<%=name%></font>
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
        <textarea title="微博文章输入框" class="article"></textarea>
        <a href="javascript:;" class="file_btn">
            <input type="file" accept=".jpg,bmp,.gig,.png,.tif,.rgb,.dib,.eps,.jpe,.pcx,.bmp,.gif">
        </a>
        <input type="button" title="发布微博按钮" value="发布" class="pubish_btn"/>
    </div>

    <div class="card1">

    </div>

    <div class="card2">

    </div>
    <div class="card3">

    </div>

    <div class="card4">
        <%String a =  (String) session.getAttribute("avatar");%>
        <%=a%>
    </div>
    <div class="card5">
        <p>亚洲新歌榜</p>
    </div>

    <div class="card6">
        <p>热门话题</p>
    </div>

</body>
</html>
