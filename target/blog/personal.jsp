<%@ page import="com.soft1841.web.blog.factory.DaoFactory" %>
<%@ page import="com.soft1841.web.blog.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="./css/personal.css" type="text/css">
<html>
<head>
    <meta charset="utf-8">
    <title></title>
<%--    <style>--%>
<%--        img {--%>
<%--            width: 10px;--%>
<%--            vertical-align: top;--%>
<%--            position: relative;--%>
<%--            margin-left: 70px;--%>
<%--        }--%>

<%--        body {--%>
<%--            background-image: url("./image/p1.png");--%>
<%--            background-repeat: no-repeat;--%>
<%--            background-size: 100%;--%>
<%--        }--%>
<%--        .invite-dialog {--%>
<%--            margin-left: -144px;--%>
<%--            position: fixed;--%>
<%--            left: 50%;--%>
<%--            width: 288px;--%>
<%--            min-height: 166px;--%>
<%--            background: white;--%>
<%--            border-radius: 3px;--%>
<%--            margin-top: 22px;--%>
<%--            z-index: 99;--%>
<%--        }--%>
<%--    </style>--%>
</head>


<body>
<div class="top">
    <img src="image/logo.png" alt="微博logo" class="logo">
    <input type="text" class="search_input" placeholder="请输入搜索词"/>
    <input type="button" class="search_btn" value="搜索" />
    <div id="navigation">
        <nav class="nav2">
            <ul>
                <li><a href="">首页</a></li>
                <li><a href="">视频</a></li>
                <li><a href="">发现</a></li>
                <li><a href="">游戏</a></li>
                <li>
                    <%String name = (String) session.getAttribute("nickname");%>
                    <%=name%>
                </li>
                <li><a href="">退出登录</a></li>
            </ul>
        </nav>
    </div>
</div>
<div class="card1">
    <%
        User user= DaoFactory.getUserDaoInstance().findUserByMobile((String)session.getAttribute("mobile"));
        String avatar = user.getAvatar();
        String in  = user.getIntroduction();
    %>
    <div>
        <img src="./image/pt.png" alt="背景图" style="width: 720px;height: 250px">
        <span style="font-size: 16px;"><%=in%></span>
    </div>
    <img src="<%=avatar%>" alt="头像" style="width: 100px;height:100px;border-radius: 50%;position: absolute;left: 330px;top: 40px">
</div>
<div class="card2">
        <span style="left: 80px">
            <%@ include file="upload-multiple.jsp"%>
        </span>
    <span>
        <a href="modify.jsp">
        <input type="button" value="修改信息"
               style="position: absolute;top: 10px;left: 220px;
               background: white;color: #333333;border: none;height: 38px;width: 150px;">
    </a>
    </span>
</div>
<div style="position: absolute;top: 400px;right: 440px;">
    <input type="text" class="search" placeholder="搜索我的微博"style="height: 27px;border: #7ec8ea"/>
    <input type="button" class="btn" value="搜索"
           style="background: white;color: #333333;border: none;width: 45px;height: 30px;"/>
</div>

<div style="position:absolute;top: 60px;left: 20px;">
    <jsp:include page="weather.jsp"/>
</div>
<div style="position: absolute; top: 490px;left:465px">
    <jsp:include page="article.jsp"/>
</div>







<%--<ul>--%>
<%--    <li>--%>
<%--        <img src="./image/p2.png" alt="">--%>
<%--    </li>--%>
<%--    <li>--%>
<%--        <img src="./image/p3.png" alt="">--%>
<%--    </li>--%>
<%--</ul>--%>
<%--<script>--%>
<%--    var imgs = document.querySelectorAll('image');--%>
<%--    for (var i = 0; i < imgs.length; i++) {--%>
<%--        imgs[i].onclick = function() {--%>
<%--            // document.body.style.backgroundImage = url('img/1_4.jpg');--%>
<%--            var src = this.src;--%>
<%--            //这样的话，src就成字符串了，而不是变量--%>
<%--            //document.body.style.backgroundImage = 'url("src")';--%>
<%--            document.body.style.backgroundImage = 'url(' + src + ')';--%>
<%--        }--%>
<%--    }--%>
<%--</script>--%>

</body>
</html>
