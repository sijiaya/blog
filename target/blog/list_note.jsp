<%@ page import="com.entity.Note" %>
<%@ page import="com.dao.NoteDAO" %>
<%@ page import="com.dao.impl.NoteDAOImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.entity.SplitPage" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.dao.PersonDAO" %>
<%@ page import="com.entity.Person" %>
<%@ page import="com.factory.DAOFactory" %>
<%@ page import="com.dao.impl.PersonDAOImpl" %>
<%@ page import="com.soft1841.web.blog.dao.Impl.UserDaoImpl" %>
<%@ page import="com.soft1841.web.blog.dao.UserDao" %>
<%@ page import="com.soft1841.web.blog.factory.DaoFactory" %>
<%@ page import="com.soft1841.web.blog.entity.Note" %>
<%@ page import="com.soft1841.web.blog.dao.NoteDao" %>
<%@ page import="com.soft1841.web.blog.dao.Impl.NoteDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/10/28
  Time: 8:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%request.setCharacterEncoding("utf-8"); %>
<html>
<head>
    <title>显示留言页面</title>
    <script type="text/javascript">
        function go(){
            var goPage=document.all.selectpage.value;
            alert("我们将去页面:list_note.jsp?flag="+goPage);
            document.open("list_note.jsp?flag="+goPage,"_self","");
        }
    </script>
    <style>
        body{
            margin: 0;
            padding: 0;
            text-align: center;
        }
        a{
            font-size: 20px;
            color: indigo;

        }
        .img{
            width: 100%;
            height: 200px;
        }
        img{
            width: 100%;
            height: 100%;
        }
        .avatar{
            width: 50px;
            height: 50px;
        }
    </style>
</head>
<body >
<%
    UserDao userDao = DaoFactory.getUserDaoInstance();
    String img = userDao.selectById(Long.valueOf(session.getAttribute("id1"))).getImage();
%>
<div class="img"><img src="images/bg.png" alt="QQ空间留言板"/></div>
<span><div class="avatar"><a href="userInfo.jsp"><img src="<%=img%>" alt="图片"></a></div><h2>QQ空间留言板<a href="exit.jsp">退出登录</a></h2></span>
<hr>


<hr>
<p><a href="list_note.jsp"><strong>显示所有留言</strong></a></p>

<form action="list_note.jsp?flag=first" method="post">
    <tr>
        <td>
            <p>在
                <select name="item" id="item">
                    <option value="title">标题</option>
                    <option value="author">作者</option>
                    <option value="content">内容</option>
                </select>
                中查询：
                <input type="text" name="content">
                <input type="submit" name="submit" value="搜索">
            </p>
        </td>
    </tr>
</form>
<%if (session.getAttribute("username")!=null){%>
<jsp:useBean id="spage" class="com.entity.SplitPage" scope="session"></jsp:useBean>
<%
    NoteDao note = new NoteDaoImpl();
    String flag = request.getParameter("flag");
    int totalRows = 0;
    int currentPage = 0;
%>
<table width="80%" border="1" cellpadding="0">
        <td>留言id</td>
        <td>标题</td>
        <td>作者</td>
        <td>内容</td>
        <td>删除</td>
    </tr>
    <%
        request.setCharacterEncoding("utf-8");
        String strItem = request.getParameter("item");
        String strContent = request.getParameter("content");
        List<Note> list = null;
        HashMap<String ,String > tm = new HashMap<>();
        //判断是否使用了搜索
        if (strContent==null || strContent.equals("null") || strContent==""){
            totalRows = note.getRows(tm);//总的记录数
            spage.setTotalRows(totalRows);
            //重新计算确定当前要显示的页面值，实现翻页
            currentPage=spage.confirmPage(flag);
            list =note.findAll(spage);
        }else{
            tm.put(strItem,strContent);
            list =note.queryByLike(tm,spage);
        }
        for (Note n : list){%>
            <tr>
                <td ><%=n.getNoteId()%>
                <td><%=n.getTitle()%></td>
                <td><%=n.getAuthor()%></td>
                <td><%=n.getContent()%></td>
                <td>
                    <%{%>
                    <a href="NoteServlet?flag=delNote&note_id=<%=n.getNoteId()%>">删除</a>
                    <%}%>
                </td>
            </tr>
    <%}%>
    <tr>
        <td colspan="5" align="right">
            <a href="list_note.jsp?flag=<%=SplitPage.FIRSTPAGE%>&item=<%=strItem%>&content=<%=strContent%>">首页</a>
            <a href="list_note.jsp?flag=<%=SplitPage.PREVIOUSPAGE%>">上一页</a>
            <a href="list_note.jsp?flag=<%=SplitPage.NEXTPAGE%>" >下一页</a>
            <a href="list_note.jsp?flag=<%=SplitPage.LASTPAGE%>" >末页</a>
            <select id="selectpage" name="gsPage" onchange="javascript:go()">
                <%for (int i=1;i<=spage.getTotalPages();i++){%>
                    <option value=<%=i%>><%=i%>/<%=spage.getTotalPages()%></option>
                    <%=(spage.getCurrentPage()==i)?"selected='selected'":""%>
                <%}%>
            </select>
        </td>
    </tr>
</table>
<%}%>
<p><a href="insert.jsp"><strong>添加新留言</strong></a></p>
</body>
</html>
