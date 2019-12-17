
<%@ page import="java.util.List" %>
<%@ page import="com.soft1841.web.blog.dao.ArticleDao" %>
<%@ page import="com.soft1841.web.blog.dao.Impl.ArticleDaoImpl" %>
<%@ page import="com.soft1841.web.blog.entity.Article" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String s_Id = (String) request.getParameter("id");
    Long id=Long.parseLong(s_Id);
    request.setCharacterEncoding("utf-8");
    ArticleDao articleDAO =new ArticleDaoImpl();
    List<Article> list=null;
    list=articleDAO.selectByTopicId(id);
    for (Article article:
         list) {%>
<tr>
    <td rowspan="2">
        <img src="<%=article.getThumbnail()%>" ></td>
    <td><%=article.getTitle()%></td>
</tr>
<tr>
    <td><%=article.getContent()%></td>
</tr>
<%}%>
</body>
</html>
