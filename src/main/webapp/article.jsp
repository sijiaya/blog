
<%@ page import="java.util.List" %>
<%@ page import="com.soft1841.web.blog.dao.ArticleDao" %>
<%@ page import="com.soft1841.web.blog.dao.Impl.ArticleDaoImpl" %>
<%@ page import="com.soft1841.web.blog.entity.Article" %>
<%@ page import="com.soft1841.web.blog.dao.Impl.UserDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: 戴尔
  Date: 2019/12/6
  Time: 8:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>微博之内容展示</title>
</head>
<body>

<table>
<%--    <a href="myarticle.jsp">我的日志</a>--%>
    <%
        request.setCharacterEncoding("utf-8");
        String keywords=request.getParameter("keys");
        ArticleDao articleDAO =new ArticleDaoImpl();
        List<Article> list=null;
        if (keywords==null||keywords==""||keywords.equals("null")){
            list=articleDAO.findAll();
        }else {
            list=articleDAO.selectByKeywords(keywords);
        }

        for (Article article: list ) {
    %>

    <div  style="position: absolute;left: -40px;margin: 30px 0 20px 10px;border-spacing: 50px;display:block;vertical-align:middle; ">
        <img src="<%=article.getThumbnail()%>" width="220px" height="133px" align="left"><br>
    </div>
    <div style="margin:0px 0 0 230px;padding:30px">
        <a href="details.jsp?id=<%=article.getId()%>"> <%=article.getTitle()%></a>
    </div>
    <div style="margin: -20px 0 0 230px;width: 370px;word-break: normal;height: auto;">
        <%=article.getContent()%>
    </div>
    <%}%>

</table>
</body>
</html>
