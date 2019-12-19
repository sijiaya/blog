<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/10/28
  Time: 8:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%String name = (String) session.getAttribute("username");
  String id =request.getParameter("id1");%>
<center>
    <form action="uploadImage" method="post" enctype="multipart/form-data" >
        <br><br>
        <h1><font color="#00008b">修改头像</font></h1><br>
        <h2>用户ID：<%=session.getAttribute("id1")%></h2>
        <h2>用户名：<%=name%></h2>
        <br>
        <label for="file">上传头像图片：</label> <input type="file" id="file" name="file" multiple>
        <br>
        <h4><font color="#cd5c5c">注意文件大小不能超过10KB</font></h4><br>
        <input type="hidden" name="id" value="<%=session.getAttribute("id")%>">
        <input type="submit" value="提交">
    </form>
</center>
</body>
</html>
