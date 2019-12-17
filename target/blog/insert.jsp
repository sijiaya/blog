<%@ page import="dao.KindDAO" %>
<%@ page import="factory.DAOFactory" %>
<%@ page import="java.util.List" %>
<%@ page import="vo.Kind" %><%--
  Created by IntelliJ IDEA.
  User: 戴尔
  Date: 2019/12/12
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>日志新增页面</title>
</head>
<body>
<%
    String userId=request.getParameter("userId");
    session.setAttribute("userId",userId);
%>
<form action="uploadImage.do" method="post" enctype="multipart/form-data">
    <input type="file"name="file1"size="30">
    <input type="submit" value="确认">
</form>
<form action="AIServlet" method="post">

    <input type="hidden" value="<%=userId%>" name="userId">
    <input type="hidden" value="1" name="topicId" id="topicId">
    <select name="kind" onchange="document.input['topicId'].value=options[selectedIndex].value">
        <%KindDAO kindDAO= DAOFactory.getkindDaoInstance();
            List<Kind> klist=kindDAO.queryAll();
            for (Kind kind: klist) {%>
             <option value="<%=kind.getId()%>"><%=kind.getKindName()%></option>
           <%}%>
    </select>
    <input type="text" value="请输入文章标题" name="title">
    <input type="text" value="请输入文章内容" name="content">
    <input type="submit"value="发表">
</form>
</body>
</html>
