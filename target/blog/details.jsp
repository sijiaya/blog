
<%@ page import="java.util.List" %>
<%@ page import="com.soft1841.web.blog.dao.ArticleDao" %>
<%@ page import="com.soft1841.web.blog.dao.Impl.ArticleDaoImpl" %>
<%@ page import="com.soft1841.web.blog.entity.Article" %>
<%@ page import="com.soft1841.web.blog.dao.CommentDao" %>
<%@ page import="com.soft1841.web.blog.factory.DaoFactory" %>
<%@ page import="com.soft1841.web.blog.entity.Comment" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table>
    <%
        String s_Id = (String) request.getParameter("id");
        Long id=Long.parseLong(s_Id);
        request.setCharacterEncoding("utf-8");
        ArticleDao articleDAO =new ArticleDaoImpl();
        Article article=new Article() ;
        article=articleDAO.getArticleById(id);
    %>
            <div>
                <img src="<%=article.getThumbnail()%>" style="width: 260px;height: 260px;">
            </div>
    <div style="position: absolute;top: 30px;left: 400px">
        <h2><%=article.getTitle()%></h2><br>
        <p style="width: 600px;"><%=article.getContent()%></p>
    </div>

</table>
<table>
    <tr>
        <td>评论</td>
        <td>作者</td>
    </tr>
<%
    CommentDao commentDAO= DaoFactory.getCommentDaoInstance();
    List<Comment> clist=null;
    clist=commentDAO.queryByArticleId(id);
    for (Comment comment: clist ) {
%>
    <tr>
     <td><%=comment.getContent()%></td><td><%=comment.getUserName()%></td>
     <td><a href="DeleteServlet?id=<%=comment.getId()%>">删除</a></td>
    </tr>
    <%}%>
</table>
<form action="InsertServlet?articleId=<%=s_Id%>&userId=1" method="post">
    <%=(s_Id)%>
    <input type="text" placeholder="请输入搜索词"name="content">
    <input type="submit" value="发表">
</form>
</body>
</html>
