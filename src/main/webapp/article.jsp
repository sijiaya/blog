
<%@ page import="java.util.List" %>
<%@ page import="com.soft1841.web.blog.dao.ArticleDao" %>
<%@ page import="com.soft1841.web.blog.dao.Impl.ArticleDaoImpl" %>
<%@ page import="com.soft1841.web.blog.entity.Article" %><%--
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
<form>
    <input type="text" name="keys" >
    <input type="submit" value="搜索">
</form>
<table>
    <a href="myarticle.jsp">我的日志</a>
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
    <tr>
        <td rowspan="2"><img src="<%=article.getThumbnail()%>" width="80" height="60"></td>
        <td><a href="details.jsp?id=<%=article.getId()%>"><%=article.getTitle()%></a></td>
    </tr>
    <tr>
        <td>
<%--            <%=article.getAuthor()%>--%>
            <%=article.getId()%></td>
    </tr>
    <%}%>
</table>
</body>
</html>
