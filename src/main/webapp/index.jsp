<html>
<%@ page contentType="text/html; charset=gb2312"%>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="./css/first.css" type="text/css">
<%--    <link href="/weibo-blog/css/first.css" rel="stylesheet" />--%>
    <title>微博-随时随地发现新鲜事</title>
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
                <li><a href="register.jsp">注册</a></li>
                <li><a href="login.jsp">登录</a></li>
            </ul>
        </nav>
    </div>
</div>

<div class="left">
    <ul style="list-style-type:none">
        <li>热门</li>
        <li>头条</li>
        <li>视频</li>
        <li>榜单</li>
        <li>搞笑</li>
        <li>社会</li>
        <li>时尚</li>
        <li>电影</li>
        <li>美女</li>
        <li>体育</li>
        <li>动漫</li>
    </ul>
</div>

<div class="center">
    <%@ include file="lunbo.jsp"%>
    <img src="image/log.png" style="position: relative;top: 320px;">
</div>

<div>
    <img src="image/r1.png" style="position:relative;top: 60px;left: 1100px;">
    <img src="image/r2.png" style="position:relative;top: 560px;left: 745px;">

</div>


</body>
</html>
